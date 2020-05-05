package model.board;

import util.config.Config;
import model.Location;

public class PuzzlePieceFactory {
    private final Config config;

    public PuzzlePieceFactory(final Config config) {
        this.config = config;
    }

    public PuzzlePiece build(final int loc, final int n) {
        return new PuzzlePiece(config.getImages().get(n), new Location(loc % 3, loc / 3), n);
    }

    public PuzzlePiece buildPuzzlePiece(final int loc) {
        final int n = config.getInitialOrdering().get(loc);
        return build(loc, n);
    }
}