import java.util.List;

public class InsertionSort<T extends Comparable<T>> extends Sorter<T> {
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