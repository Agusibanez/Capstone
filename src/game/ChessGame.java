package game;

import Piece.Piece;
import sorting.*;
import board.*;
import java.util.*;
import Piece.PieceGenerator;

public class ChessGame {

    public static void main(String[] args) {
        Map<String, String> parameters = processParameters(args);

        if (!Validator.validateParameters(parameters)) {
            System.out.println("Invalid input values.");
            return;
        }

        String algorithm = parameters.get("a");
        String type = parameters.get("t");
        String color = parameters.get("c");
        int r = Integer.parseInt(parameters.get("r"));
        int s = Integer.parseInt(parameters.get("s"));

        String fullColor = color.equalsIgnoreCase("b") ? "black" : "white";

        List<Piece> pieces = PieceGenerator.generatePieces(fullColor, type, r);

        Board board = new Board();
        board.placePieces(pieces, color, r);

        System.out.println("\nInitial Board:");
        board.printBoard();

        Sorter<Piece> sorter = SorterFactory.getSorter(algorithm, s, color);

        sorter.sort(pieces, board);

        System.out.println("\nSorted Board:");
        board.placePieces(pieces, color, r);
        board.printBoard();
    }

    private static Map<String, String> processParameters(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    parameters.put(parts[0].toLowerCase(), parts[1].toLowerCase());
                }
            }
        }
        return parameters;
    }
}