package controller;

public class BoardController implements IBoardController {

    private int missingPiece;

    public BoardController(int missingPiece) {
        this.missingPiece = missingPiece;
    }

    public void moveHorizontally(int i) {
        missingPiece += i;
    }

    public void moveVertically(int i) {
        missingPiece += 3 * i;
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    public boolean isMissing(int i) {
        return missingPiece == i;
    }
}