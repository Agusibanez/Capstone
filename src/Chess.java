import java.util.*;

public class Chess {
    public static void main(String[] args) {
        Map<String, String> parameters = processParameters(args);
        System.out.println("\nTipo: [" + parameters.get("t") + "]");

        if (!Validator.validateParameters(parameters)) {
            System.out.println("Invalid input values.");
            return;
        }

        String algorithm = parameters.get("a");
        String type = parameters.get("t");
        String color = parameters.get("c");
        int r = Integer.parseInt(parameters.get("r"));
        int s = Integer.parseInt(parameters.get("s"));

        List<Integer> values = generateValues(type, r);
        System.out.println("\nValores:             " + values);

        long startTime = System.currentTimeMillis();

        Sorter<Integer> sorter = getSorter(algorithm, s, color);
        sorter.sort(values);

        long sortingTime = System.currentTimeMillis() - startTime;

        long remainingTime = s - sortingTime;

        if (remainingTime > 0) {
            try {
                Thread.sleep(remainingTime); //
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("\nOrdenamiento: " + values);
        System.out.println("\nAlgoritmo: " + sorter.getName());
        System.out.println("Tiempo total: " + totalTime + " ms");
    }

    // Processes command-line arguments into a key-value map
    private static Map<String, String> processParameters(String[] args) {
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

    // Generates values based on the specified type and range
    private static <T> List<T> generateValues(String type, int r) {
        List<T> values = new ArrayList<>();
        if (type.equals("c")) {
            for (char ch = 'a'; ch < 'a' + Math.min(r, 16); ch++) {
                values.add((T) Character.valueOf(ch));
            }
        } else {
            for (int i = 1; i <= Math.min(r, 16); i++) {
                values.add((T) Integer.valueOf(i));
            }
        }
        Collections.shuffle(values);
        return values;
    }

    private static Sorter<Integer> getSorter(String algorithm, int s, String color) {
        return switch (algorithm) {
            case "s" -> new SelectionSort<>(s, color);
            case "b" -> new BubbleSort<>(s, color);
            case "i" -> new InsertionSort<>(s, color);
            default -> throw new IllegalArgumentException("Unknown algorithm");
        };
    }
}

