package model.board;

import java.awt.Graphics;
import java.util.List;

import controller.IBoardController;
import model.interfaces.Drawable;

public class Board implements Drawable {
    
    private final List<PuzzlePiece> puzzlePieces;
    private final List<Integer> ordering;
    private final Checker checker;
    private final Drawable view;
    private final IBoardController controller;
    
    public Board(List<PuzzlePiece> puzzlePieces, List<Integer> ordering, IBoardController controller) {
        this.puzzlePieces = puzzlePieces;
        this.ordering = ordering;
        this.controller = controller;
        view = new BoardView(puzzlePieces);
        checker = new Checker();
    }

    public IBoardController getController() {
        return controller;
    }

    public void swapPieces(int i, int j) {
        PuzzlePiece pi = this.puzzlePieces.get(i);
        PuzzlePiece pj = this.puzzlePieces.get(j);
        PuzzlePiece copy = pi.getClone();
        pi.swap(pj);
        pj.swap(copy);
    }

    public void draw(Graphics g) {
        view.draw(g);
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
            int  distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));
            parity ^= (distanceOfMissingPiece % 2);
            return (parity == 0);
        }

        private int getMissingPiece() {
            return controller.getMissingPiece();
        }

        private boolean isGameFinished() {
            for (int i = 0; i < 9; i++) {
                final int pieceIdentifier = puzzlePieces.get(i).getPieceNumber();
                System.out.println(i+ ", "+ "holding: "+pieceIdentifier);
                if (pieceIdentifier == 8) {
                    continue;
                }
                if (pieceIdentifier != i) {
                    return false;
                }
            }
            return true;
        }
    }
}