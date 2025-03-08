package sorting;

import java.util.Collections;
import java.util.List;
import board.Board;

public class BubbleSort<T extends Comparable<T>> extends Sorter<T> {
    public BubbleSort(int pause, String color) {
        super(pause, color);
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }

    @Override
    public void sort(List<T> values, Board board) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - 1 - i; j++) {
                if (compare(values.get(j), values.get(j + 1)) > 0) {
                    Collections.swap(values, j, j + 1); // Intercambia elementos
                    board.placePieces((List<board.Piece>) values); // Actualiza el tablero
                    board.printBoard(); // Muestra el tablero
                    try {
                        Thread.sleep(pause); // Aplica el delay
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        long sortingTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo transcurrido: " + sortingTime + " ms");
    }
}