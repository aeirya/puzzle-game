package util.image;

import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import util.file.IFileLoader;

public class ImageLoader implements IFileLoader<Image> {

    private String prefix;
    private List<String> filenames;

    public ImageLoader() {
        this("src/resources/assets/");
    }

    public ImageLoader(String assetsPath) {
        this.prefix = assetsPath;
    }

    public ImageLoader provideImageNames(List<String> filenames) {
        this.filenames = filenames;
        return this;
    }

    public List<Image> load() {
        List<Image> result = new ArrayList<>();
        filenames.forEach(path -> result.add(readImage(prefix + path)));
        return result;
    }

    private Image readImage(String filename) {
        try {
            return ImageIO.read(
                new File(filename)
            );
        } catch(IOException ex) {
            return null;
        }
    }
}