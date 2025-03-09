package sorting;

import java.util.List;

import Piece.Piece;
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
        int n = values.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(values.get(j), values.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }


            T temp = values.get(minIndex);
            values.set(minIndex, values.get(i));
            values.set(i, temp);


            board.placePieces((List<Piece>) values, color, values.size());
            board.printBoard();


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