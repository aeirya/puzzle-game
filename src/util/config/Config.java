package util.config;

import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

public class Config {
    
    private final List<Image> images;
    private final ArrayList<Integer> piecesOrdering;

    public Config(final List<Image> images, final List<Integer> piecesOrdering) {
        this.images = images;
        this.piecesOrdering = (ArrayList<Integer>) piecesOrdering;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Integer> getInitialOrdering() {
        return piecesOrdering;
    }
}