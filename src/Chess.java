import java.util.*;

/**
 * Chess Sorting Program
 * This program sorts a list of values using different sorting algorithms.
 * The values can be characters or numbers, and the sorting order depends on the specified color.
 */
public class Chess {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> parameters = processParameters(args);

        if (!Validator.validateParameters(parameters)) {
            printInvalidParameters(parameters);
            return;
        }

        // Extract values from parameters
        String algorithm = parameters.get("a").toLowerCase();
        String type = parameters.get("t").toLowerCase();
        String color = parameters.get("c").toLowerCase();
        int r = Integer.parseInt(parameters.get("r"));
        int pause = Integer.parseInt(parameters.getOrDefault("s", "28"));

        // Generate initial values
        List<String> values = generateValues(type, r);
        System.out.println("Type: [" + (type.equals("n") ? "Numeric" : "Character") + "]");
        System.out.println("Values: " + values);

        // Measure execution time
        long startTime = System.nanoTime();
        Sorter<String> sorter = getSorter(algorithm, pause, color);
        sorter.sort(values);
        long totalTime = (System.nanoTime() - startTime) / 1_000_000 + ((long) (values.size() - 1) * pause);

        System.out.println("Sorted: " + values);
        System.out.println("Algorithm: " + sorter.getName());
        System.out.println("Total time: " + totalTime + " ms");
    }

    private static Map<String, String> processParameters(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    parameters.put(parts[0], parts[1]);
                }
            }
        }
        return parameters;
    }

    private static List<String> generateValues(String type, int r) {
        List<String> values = new ArrayList<>();
        if (type.equals("c")) {
            for (char ch = 'a'; ch < 'a' + Math.min(r, 16); ch++) {
                values.add(String.valueOf(ch));
            }
        } else {
            for (int i = 1; i <= Math.min(r, 16); i++) {
                values.add(String.valueOf(i));
            }
        }
        Collections.shuffle(values);
        return values;
    }

    private static Sorter<String> getSorter(String algorithm, int pause, String color) {
        return switch (algorithm) {
            case "s" -> new SelectionSort<>(pause, color);
            case "b" -> new BubbleSort<>(pause, color);
            case "i" -> new InsertionSort<>(pause, color);
            default -> throw new IllegalArgumentException("Unknown algorithm");
        };
    }

    private static void printInvalidParameters(Map<String, String> parameters) {
        System.out.println("Invalid parameters:");
        parameters.forEach((key, value) -> System.out.println(key + " = " + value));
        System.out.println("Check your input and try again.");
    }
}

abstract class Sorter<T extends Comparable<T>> {
    protected int pause;
    protected String color;

    public Sorter(int pause, String color) {
        this.pause = pause;
        this.color = color;
    }

    public abstract void sort(List<T> values) throws InterruptedException;
    public abstract String getName();

    protected int compare(T a, T b) {
        return color.equals("b") ? a.compareTo(b) : b.compareTo(a);
    }
}

class SelectionSort<T extends Comparable<T>> extends Sorter<T> {
    public SelectionSort(int pause, String color) { super(pause, color); }
    public String getName() { return "SelectionSort"; }

    public void sort(List<T> values) throws InterruptedException {
        for (int i = 0; i < values.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.size(); j++) {
                if (compare(values.get(j), values.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(values, i, minIndex);
            System.out.println(values);
            Thread.sleep(pause);
        }
    }
}

class BubbleSort<T extends Comparable<T>> extends Sorter<T> {
    public BubbleSort(int pause, String color) { super(pause, color); }
    public String getName() { return "BubbleSort"; }

    public void sort(List<T> values) throws InterruptedException {
        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(values.get(j), values.get(j + 1)) > 0) {
                    Collections.swap(values, j, j + 1);
                }
            }
            System.out.println(values);
            Thread.sleep(pause);
        }
    }
}

class InsertionSort<T extends Comparable<T>> extends Sorter<T> {
    public InsertionSort(int pause, String color) { super(pause, color); }
    public String getName() { return "InsertionSort"; }

    public void sort(List<T> values) throws InterruptedException {
        for (int i = 1; i < values.size(); i++) {
            T key = values.get(i);
            int j = i - 1;
            while (j >= 0 && compare(values.get(j), key) > 0) {
                values.set(j + 1, values.get(j));
                j--;
            }
            values.set(j + 1, key);
            System.out.println(values);
            Thread.sleep(pause);
        }
    }
}