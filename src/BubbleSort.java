import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> extends Sorter<T> {
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
