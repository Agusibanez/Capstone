package sorting;

import java.util.Collections;
import java.util.List;
import board.Board;

public class SelectionSort<T extends Comparable<T>> extends Sorter<T> {
    public SelectionSort(int pause, String color) {
        super(pause, color);
    }

    @Override
    public String getName() {
        return "SelectionSort";
    }

    @Override
    public void sort(List<T> values, Board board) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < values.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.size(); j++) {
                if (compare(values.get(j), values.get(minIndex)) < 0) {
                    minIndex = j; // Encuentra el índice del mínimo
                }
            }
            Collections.swap(values, i, minIndex); // Intercambia elementos
            board.placePieces((List<board.Piece>) values); // Actualiza el tablero
            board.printBoard(); // Muestra el tablero
            try {
                Thread.sleep(pause); // Aplica el delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long sortingTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo transcurrido: " + sortingTime + " ms");
    }
}