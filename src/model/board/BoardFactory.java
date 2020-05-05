package model.board;

import java.util.ArrayList;
import java.util.List;

import controller.IBoardController;
import util.config.Config;

public class BoardFactory {

    private Config config;
    private IBoardController bc;
    private static BoardFactory factory;
    private BoardFactory() { }

    public static BoardFactory getInstance() {
        if (factory == null) factory = new BoardFactory();
        return factory;
    }

    public BoardFactory provide(Config config, IBoardController controller) {
        this.config = config;
        this.bc = controller;
        return this;
    }
    
    public Board build() {
        PuzzlePieceFactory pf = new PuzzlePieceFactory(config);
        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (!bc.isMissing(i)) {
                puzzlePieces.add(pf.buildPuzzlePiece(i));
            } else {
                puzzlePieces.add(pf.buildMissingPuzzlePiece(i));
            }
        }
        List<Integer> order = config.getInitialOrdering();
        return new Board(puzzlePieces, order, bc);
    }

}