package game;

import board.*;
import sorting.Sorter;
import sorting.SorterFactory;
import Piece.*;
import java.util.Map;

public class GameSorter {

    public static void sortPieces(Map<String, String> parameters, Board board) {
        String algorithm = parameters.get("a");
        String color = parameters.get("c");
        int s = Integer.parseInt(parameters.get("s"));

        Sorter<Piece> sorter = SorterFactory.getSorter(algorithm, s, color);

        sorter.sort(board.getPieces(), board);
    }
}