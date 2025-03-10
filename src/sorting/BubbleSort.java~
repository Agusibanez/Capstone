package sorting;

import java.util.List;

import Piece.Piece;
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
        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(values.get(j), values.get(j + 1)) > 0) {
                    T temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, temp);

                    board.placePieces((List<Piece>) values, color, values.size()); // Ajusta los parámetros
                    board.printBoard();

                    try {
                        Thread.sleep(pause);
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