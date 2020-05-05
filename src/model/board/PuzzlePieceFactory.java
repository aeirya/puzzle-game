package model.board;

import util.config.Config;
import model.Location;

public class PuzzlePieceFactory {
    private final Config config;

    public PuzzlePieceFactory(Config config) {
        this.config = config;
    }
    
    private PuzzlePiece build(int loc, int n) {
        return new PuzzlePiece(
            config.getImages().get(n), new Location(loc % 3, loc / 3), n
        );
    }

    public PuzzlePiece buildPuzzlePiece(int loc) {
        final int n = config.getInitialOrdering().get(loc);
        return build(loc, n);
    }

    public PuzzlePiece buildMissingPuzzlePiece(int loc) {
        return build(loc, 8);
    }
}