package util.config;

import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

public class Config {
    
    List<Image> images;
    ArrayList<Integer> piecesOrdering;

    public Config(List<Image> images, List<Integer> piecesOrdering) {
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