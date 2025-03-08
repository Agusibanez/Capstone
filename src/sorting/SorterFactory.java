package sorting;

import board.Piece;

public class SorterFactory {
    public static Sorter<Piece> getSorter(String algorithm, int s, String color) {
        return switch (algorithm) {
            case "s" -> new SelectionSort<>(s, color);
            case "b" -> new BubbleSort<>(s, color);
            case "i" -> new InsertionSort<>(s, color);
            default -> throw new IllegalArgumentException("Unknown algorithm");
        };
    }
}
