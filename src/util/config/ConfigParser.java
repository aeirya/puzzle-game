package util.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigParser implements IParser {

    public Map<String, List<String>> parse(List<String> keys, List<String> lines) {
        Map<String, List<String>> parsed = new HashMap<>();
        lines.forEach( line -> {
            Map<String ,List<String>> digested = splitLine(line);
            digested.keySet().forEach(k-> {
                //only adds the desired keys' values
                if (keys.contains(k)) parsed.put(k, digested.get(k));
            });
        });
        return parsed;
    }

    private Map<String, List <String>> splitLine (String line) {
        Map<String, String> entry = splitKeyValue(line);
        Map<String, List <String>> result = new HashMap<>();
        //it actually has one member. (k,v) are the key and value of the line
        entry.forEach( 
            (k, v) -> {
                List<String> split = new ArrayList<>();
                Arrays.asList(v.split(","))
                    .forEach(s -> split.add(s.strip()));
                result.put(k, split);
            }
        );
        return result;
    }

    private Map<String, String> splitKeyValue(String line) {
        String[] split = line.split(":");
        if (split.length == 2)
            return Collections.singletonMap(split[0].strip(), split[1].strip());
        else return Collections.singletonMap("", "");
    }
}