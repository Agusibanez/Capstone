import java.util.Set;
import java.util.Map;

class Validator {
    private static final Set<String> VALID_ALGORITHMS = Set.of("s", "b", "i");
    private static final Set<String> VALID_TYPES = Set.of("n", "c");
    private static final Set<String> VALID_COLORS = Set.of("b", "w");
    private static final Set<Integer> VALID_R_VALUES = Set.of(1, 2, 4, 6, 8, 10, 16);

    public static boolean validateParameters(Map<String, String> parameters) {
        if (!parameters.containsKey("a")) {
            System.out.println("\u274C Error: Missing parameter a, or use message from evaluation 4.");
            return false;
        }
        if (!VALID_ALGORITHMS.contains(parameters.get("a"))) {
            System.out.println("\u274C Error: Invalid value for algorithm selection.");
            return false;
        }
        if (!parameters.containsKey("t")) {
            System.out.println("\u274C Error: Missing value for game type (t).");
            return false;
        }
        if (!VALID_TYPES.contains(parameters.get("t"))) {
            System.out.println("\u274C Error: Unrecognized type.");
            return false;
        }
        if (!parameters.containsKey("c")) {
            System.out.println("\u274C Error: Missing parameter c (piece color).");
            return false;
        }
        if (!VALID_COLORS.contains(parameters.get("c"))) {
            System.out.println("\u274C Error: Unrecognized color type.");
            return false;
        }
        if (!parameters.containsKey("r")) {
            System.out.println("\u274C Error: Missing parameter r (number of pieces).");
            return false;
        }
        if (!parameters.get("r").matches("\\d+") || !VALID_R_VALUES.contains(Integer.parseInt(parameters.get("r")))) {
            System.out.println("\u274C Error: Invalid number of pieces.");
            return false;
        }
        if (!parameters.containsKey("s")) {
            System.out.println("\u274C Error: Missing parameter s. A default value can be assigned if the user does not enter it.");
            return false;
        }
        if (!parameters.get("s").matches("\\d+") || Integer.parseInt(parameters.get("s")) < 100 || Integer.parseInt(parameters.get("s")) > 1000) {
            System.out.println("\u274C Error: Invalid value for delay pause.");
            return false;
        }
        return true;
    }
}
