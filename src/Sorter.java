import java.util.List;

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