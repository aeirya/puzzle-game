package util.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    
    private Map <String, List <String> > map = new HashMap<>();

    public Config(Map<String, List<String>> map) {
        this.map = map;
        map.get("image files").forEach( s -> s = );
    }

    public List<String> getImageFiles() {
        return map.get("image files");
    }

    public List<String> getInitialOrdering() {
        return map.get("initial ordering");
    }
}