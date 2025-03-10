package game;

import java.util.HashMap;
import java.util.Map;

public class ParameterProcessor {
    public static Map<String, String> processParameters(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    parameters.put(parts[0].toLowerCase(), parts[1].toLowerCase());
                }
            }
        }
        return parameters;
    }
}