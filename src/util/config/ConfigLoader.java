package util.config;

import java.util.List;

import util.file.FileLoader;

public class ConfigLoader extends FileLoader {

    private static final String DEFAULT_CONFIG_PATH = "src/resources/config/config.txt";
    private static final List<String> keys = List.of("initial ordering", "image files");
    private final IParser parser = new ConfigParser();
    private static ConfigLoader loader = null;
    private Config config;

    private ConfigLoader() {
        super(DEFAULT_CONFIG_PATH);
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
        config = new Config( parser.parse(keys, lines) );
    }
}