package game;

import board.Board;

import java.util.Map;

public class ChessGame {
    public static void main(String[] args) {
        Map<String, String> parameters = ParameterProcessor.processParameters(args);
        for(Map.Entry<String, String> entry : parameters.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        if (!Validator.validateParameters(parameters)) {
            System.out.println("Invalid input values.");
            return;
        }

        Board board = GameInitializer.initializeGame(parameters);

        BoardPrinter.printBoard(board, "\nInitial Board:");

        GameSorter.sortPieces(parameters, board);

        BoardPrinter.printBoard(board, "\nSorted Board:");
    }
}