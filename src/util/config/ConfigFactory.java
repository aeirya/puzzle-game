package util.config;

import util.image.ImageLoader;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigFactory {
    
    private final List<Image> images;
    private final ArrayList<Integer> piecesOrdering;

    public ConfigFactory(final Map<String, List<String>> map) {
        piecesOrdering = new ArrayList<>();
        map.get("initial ordering")
            .forEach( 
                i -> piecesOrdering.add(Integer.parseInt(i))
            );
        images = 
            new ImageLoader()
            .provideImageNames( map.get("image files") )
            .load();
    }

    public Config generate() {
        return new Config(images, piecesOrdering);
    }
}