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

abstract class Sorter<T extends Comparable<T>> {
    protected int pause;
    protected String color;

    public Sorter(int pause, String color) {
        this.pause = pause;
        this.color = color;
    }

    public abstract void sort(List<T> values);
    public abstract String getName();

    // Compares two elements based on sorting order
    protected int compare(T a, T b) {
        if (color.equalsIgnoreCase("b")) {
            return a.compareTo(b);
        } else {
            return b.compareTo(a);
        }
    }
}

class SelectionSort<T extends Comparable<T>> extends Sorter<T> {
    public SelectionSort(int pause, String color) { super(pause, color); }

    public String getName() { return "SelectionSort"; }

    public void sort(List<T> values) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < values.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.size(); j++) {
                if (compare(values.get(j), values.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(values, i, minIndex);
            System.out.println(values);
        }
        long sortingTime = System.currentTimeMillis() - startTime;
        long remainingTime = pause - sortingTime;

        if (remainingTime > 0) {
            try {
                Thread.sleep(remainingTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class BubbleSort<T extends Comparable<T>> extends Sorter<T> {
    public BubbleSort(int pause, String color) { super(pause, color); }

    public String getName() { return "BubbleSort"; }

    public void sort(List<T> values) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - 1 - i; j++) {
                if (compare(values.get(j), values.get(j + 1)) > 0) {
                    Collections.swap(values, j, j + 1);
                }
            }
            System.out.println(values);
        }
        long sortingTime = System.currentTimeMillis() - startTime;
        long remainingTime = pause - sortingTime;

        if (remainingTime > 0) {
            try {
                Thread.sleep(remainingTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class InsertionSort<T extends Comparable<T>> extends Sorter<T> {
    public InsertionSort(int pause, String color) { super(pause, color); }

    public String getName() { return "InsertionSort"; }

    public void sort(List<T> values) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < values.size(); i++) {
            T key = values.get(i);
            int j = i - 1;
            while (j >= 0 && compare(values.get(j), key) > 0) {
                values.set(j + 1, values.get(j));
                j--;
            }
            values.set(j + 1, key);
            System.out.println(values);
        }
        long sortingTime = System.currentTimeMillis() - startTime;
        long remainingTime = pause - sortingTime;

        if (remainingTime > 0) {
            try {
                Thread.sleep(remainingTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

