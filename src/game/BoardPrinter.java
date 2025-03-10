package game;

import board.Board;

public class BoardPrinter {
    public static void printBoard(Board board, String message) {
        System.out.println(message);
        board.printBoard();
    }
}

