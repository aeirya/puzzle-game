package util.image;

import util.file.IFileLoader;
import java.util.Arrays;
import java.util.List;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
        Image[] result = new Image[9];
        filenames.forEach(
            path ->
                result [n(path)] = readImage(prefix + path)
            );

        return Arrays.asList(result);
    }

    /** finds the number of the piece */
    private int n(String path) {
        try {
            return Integer.parseInt( path.split("\\.")[0] );
        }
        catch(Exception ex) {
            return 0; //should be careful in case we want to change the missing piece *
        }
    }

    private Image readImage(String filename) {
        try {
            File file = new File(filename);
            return ImageIO.read(
                file
            );
        } catch(IOException ex) {
            return null;
        }
    }
}