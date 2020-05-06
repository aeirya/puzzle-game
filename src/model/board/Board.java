package model.board;

import java.awt.Graphics;
import java.util.List;

import controller.BoardController;
import controller.IBoardController;
import model.interfaces.Drawable;

public class Board implements Drawable {
    
    private final List<PuzzlePiece> puzzlePieces;
    private final List<Integer> ordering;
    private final Checker checker;
    private final Drawable view;
    private final IBoardController controller;
    
    public Board(final List<PuzzlePiece> puzzlePieces, final List<Integer> ordering, final int missing) {
        this.puzzlePieces = puzzlePieces;
        this.ordering = ordering;
        controller = new BoardController(this, missing);
        view = new BoardView(puzzlePieces);
        checker = new Checker();
    }

    public void draw(final Graphics g) {
        view.draw(g);
    }

    public void logBoard() {
        for (int i = 0; i < 9; i++) {
            System.out.print(puzzlePieces.get(i).getPieceNumber());
            System.out.print(" ");
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
    }

    public PuzzlePiece locate(final int i) {
        for (final PuzzlePiece p : puzzlePieces) {
            if (p.isAt(i))
                return p;
        }
        return null;
    }

    public IBoardController getController() {
        return controller;
    }

    public boolean isGameFinished() {
        return checker.isGameFinished();
    }

    public boolean isSolvable() {
        return checker.isSolvable();
    }

    private class Checker {

        private boolean isSolvable() {
            final int missingPiece = getMissingPiece();
            int inversionCount = 0;
            for (int i = 0; i < ordering.size(); i++) {
                for (int j = i + 1; j < ordering.size(); j++) {
                    if (ordering.get(i) > ordering.get(j)) {
                        inversionCount += 1;
                    }
                }
            }
            int parity = inversionCount % 2;
            final int distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));
            parity ^= (distanceOfMissingPiece % 2);
            return (parity == 0);
        }

        private int getMissingPiece() {
            return controller.getMissingPiece();
        }

        private boolean isGameFinished() {
            for (int i = 0; i < 9; i++) {
                final int pieceIdentifier = puzzlePieces.get(i).getPieceNumber();
                if (pieceIdentifier == 0) {
                    continue;
                }
                if (pieceIdentifier != i+1) {
                    return false;
                }
            }
            return true;
        }
    }
}