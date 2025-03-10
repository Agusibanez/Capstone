package sorting;

import java.util.List;
import board.Board;
    /**
     * Sorts the given list of values according to the specified order.
     * The sorting process may involve visualizing the sorting steps on the provided board.
     *
     * @param values the list of values to be sorted
     * @param board the board used for visualization of the sorting process
     */
public abstract class Sorter<T extends Comparable<T>> {
    protected int pause;
    protected String color;

    public Sorter(int pause, String color) {
        this.pause = pause;
        this.color = color;
    }

    /**
     * Sorts the given list of values according to the specified order.
     * The sorting process may involve visualizing the sorting steps on the provided board.
     *
     * @param values the list of values to be sorted
     * @param board the board used for visualization of the sorting process
     */
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