package model.board;

import java.util.ArrayList;
import java.util.List;

import util.config.Config;

public class BoardFactory {

    private Config config;
    private int missingPiece;
    private static BoardFactory factory;
    private BoardFactory() { }

    public static BoardFactory getInstance() {
        if (factory == null) factory = new BoardFactory();
        return factory;
    }

    public BoardFactory provide(final Config config) {
        this.config = config;
        this.missingPiece = findMissingPiece();
        return this;
    }

    public Board build() {
        final PuzzlePieceFactory pf = new PuzzlePieceFactory(config);
        final ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != missingPiece) {
                puzzlePieces.add(pf.buildPuzzlePiece(i));
            } else {
                puzzlePieces.add(pf.build(missingPiece, 0));
            }
        }
        final List<Integer> order = config.getInitialOrdering();
        return new Board(puzzlePieces, order, missingPiece);
    }

    private int findMissingPiece() {
        return config.getInitialOrdering().indexOf(0);
    }
}