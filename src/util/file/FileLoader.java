package util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileLoader implements IFileLoader<String> {

    private final String filename;

    public FileLoader(final String filename) {
        this.filename = filename;
    }

    public List<String> load() {
        final List<String> content = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(getReader())) {
            String line;
            while ((line = bf.readLine()) != null) {
                content.add(line);
            }
        } catch (final Exception ex) {
            Logger.getLogger(getClass().getName()).warning(ex.toString());
        }
        return content;
    }

    private Reader getReader() throws FileNotFoundException {
        return new FileReader(
            new File(filename)
            );
    }
}