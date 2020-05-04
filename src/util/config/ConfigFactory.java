package util.config;

import java.util.Map;

import util.image.ImageLoader;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class ConfigFactory {
    
    List<Image> images;
    ArrayList<Integer> piecesOrdering;

    public ConfigFactory(Map <String, List <String> > map) {
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