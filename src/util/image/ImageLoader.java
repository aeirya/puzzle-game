package util.image;

import util.file.IFileLoader;
import java.util.Arrays;
import java.util.List;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader implements IFileLoader<Image> {

    private final String prefix;
    private List<String> filenames;

    public ImageLoader() {
        this("src/resources/assets/");
    }

    public ImageLoader(final String assetsPath) {
        this.prefix = assetsPath;
    }

    public ImageLoader provideImageNames(final List<String> filenames) {
        this.filenames = filenames;
        return this;
    }

    public List<Image> load() {
        final Image[] result = new Image[9];
        filenames.forEach(path -> result[n(path)] = readImage(prefix + path));

        return Arrays.asList(result);
    }

    /** finds the number of the piece */
    private int n(final String path) {
        try {
            return Integer.parseInt(path.split("\\.")[0]);
        } catch (final Exception ex) {
            return 0;
        }
    }

    private Image readImage(final String filename) {
        try {
            final File file = new File(filename);
            return ImageIO.read(file);
        } catch (final IOException ex) {
            return null;
        }
    }
}