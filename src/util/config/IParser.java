package util.config;

import java.util.List;
import java.util.Map;

public interface IParser {

    /** finds the desired keys in the text (lines) and maps them to their value in it */
    Map <String, List <String> > parse (List <String> keys, List <String> lines);
}