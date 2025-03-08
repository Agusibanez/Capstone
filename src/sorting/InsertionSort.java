package sorting;

import java.util.List;
import board.Board;

public class InsertionSort<T extends Comparable<T>> extends Sorter<T> {
    public InsertionSort(int pause, String color) {
        super(pause, color);
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }

    @Override
    public void sort(List<T> values, Board board) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < values.size(); i++) {
            T key = values.get(i);
            int j = i - 1;

            // Mueve los elementos mayores que `key` una posición adelante
            while (j >= 0 && compare(values.get(j), key) > 0) {
                values.set(j + 1, values.get(j));
                j--;
            }
            values.set(j + 1, key); // Coloca `key` en su posición correcta

            // Actualiza el tablero y muestra el estado actual
            board.placePieces((List<board.Piece>) values);
            board.printBoard();

            // Aplica el delay
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long sortingTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo transcurrido: " + sortingTime + " ms");
    }
}