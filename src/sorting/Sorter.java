package sorting;

import java.util.List;
import board.Board;

public abstract class Sorter<T extends Comparable<T>> {
    protected int pause;
    protected String color;

    public Sorter(int pause, String color) {
        this.pause = pause;
        this.color = color;
    }

    public abstract void sort(List<T> values, Board board);
    public abstract String getName();

    protected int compare(T a, T b) {
        if (color.equalsIgnoreCase("b")) {
            return a.compareTo(b);
        } else {
            return b.compareTo(a);
        }
    }
}