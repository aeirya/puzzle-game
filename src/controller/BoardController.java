package controller;

import model.board.Board;
import model.board.PuzzlePiece;

public class BoardController implements IBoardController {

    private final Board board;
    private int missingPiece;

    public BoardController(Board board, int missingPiece) {
        this.missingPiece = missingPiece;
        this.board = board;
    }

    public void move(int i) {
        final int newLoc = missingPiece + i;
        if (newLoc < 0 || newLoc > 8) return;
        if ((newLoc + missingPiece) % 3 ==2 && missingPiece % 3 != 1) return;

        swapPieces(missingPiece, missingPiece+i);
        missingPiece += i;
        board.logBoard();
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    private void swapPieces(int i, int j) {
        PuzzlePiece pi = board.locate(i);
        PuzzlePiece pj = board.locate(j);
        PuzzlePiece co = pi.getClone();
        pi.swap(pj);
        pj.swap(co);
    }
}