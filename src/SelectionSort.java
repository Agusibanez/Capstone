import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends Sorter<T> {
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