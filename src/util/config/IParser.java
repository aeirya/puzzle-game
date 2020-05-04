package util.config;

import java.util.List;
import java.util.Map;

public interface IParser {

    Map <String, List <String> > parse (List <String> keys, List <String> lines);
}