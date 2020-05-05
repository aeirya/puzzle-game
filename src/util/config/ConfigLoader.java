package util.config;

import java.util.List;
import java.util.Map;

import util.file.FileLoader;

public class ConfigLoader extends FileLoader {

    private static final List<String> keys = List.of("initial ordering", "image files");
    private final IParser parser = new ConfigParser();
    private static ConfigLoader loader = null;
    private Config config;

    private ConfigLoader() {
        this("src/resources/config/config.txt");
    }

    private ConfigLoader(String configPath) {
        super(configPath);
        loadConfig();
    }

    private static ConfigLoader getInstance() {
        if (loader == null) loader = new ConfigLoader();
        return loader;
    }

    public static Config getConfig() {
        return getInstance().config;
    }
    
    private void loadConfig() {
        List <String> lines = load();
        Map <String, List <String> > map = parser.parse(keys, lines);
        config = new ConfigFactory(map).generate();
    }
}