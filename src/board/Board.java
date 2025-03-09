package board;

import Piece.Piece;

import java.util.List;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public void placePieces(List<Piece> pieces, String color, int numberOfPieces) {
        if (pieces.size() < numberOfPieces) {
            throw new IllegalArgumentException("No hay suficientes piezas en la lista.");
        }

        if (numberOfPieces == 1) {
            if (color.equalsIgnoreCase("w")) {
                board[7][0] = pieces.get(0);
            } else {
                board[0][0] = pieces.get(0);
            }
            System.out.println("Pieza colocada en posición correcta");

            return;
        }
        if (numberOfPieces == 4) {
            if (color.equalsIgnoreCase("w")) {
                board[7][0] = pieces.get(0);
                board[7][1] = pieces.get(1);
                board[7][2] = pieces.get(2);
                board[7][3] = pieces.get(3);
            } else {
                board[0][0] = pieces.get(0);
                board[0][1] = pieces.get(1);
                board[0][2] = pieces.get(2);
                board[0][3] = pieces.get(3);
            }
            System.out.println("Piezas colocadas en posición correcta");

            return;
        }

        if (numberOfPieces == 2) {
            if (color.equalsIgnoreCase("w")) {
                board[7][0] = pieces.get(0);
                board[7][1] = pieces.get(1);
            } else {
                board[0][0] = pieces.get(0);
                board[0][1] = pieces.get(1);
            }
            System.out.println("Piezas colocadas en posición correcta");

            return;
        }
        if (numberOfPieces == 6) {
            if (color.equalsIgnoreCase("w")) {
                board[7][0] = pieces.get(0);
                board[7][1] = pieces.get(1);
                board[7][2] = pieces.get(2);
                board[7][3] = pieces.get(3);
                board[7][4] = pieces.get(4);
                board[7][5] = pieces.get(5);
            } else {
                board[0][0] = pieces.get(0);
                board[0][1] = pieces.get(1);
                board[0][2] = pieces.get(2);
                board[0][3] = pieces.get(3);
                board[0][4] = pieces.get(4);
                board[0][5] = pieces.get(5);
            }
            System.out.println("Piezas colocadas en posición correcta"); // Mensaje de depuración

            return;
        }
        if (numberOfPieces == 8) {
            if (color.equalsIgnoreCase("w")) {
                board[7][0] = pieces.get(0);
                board[7][1] = pieces.get(1);
                board[7][2] = pieces.get(2);
                board[7][3] = pieces.get(3);
                board[7][4] = pieces.get(4);
                board[7][5] = pieces.get(5);
                board[7][6] = pieces.get(6);
                board[7][7] = pieces.get(7);
            } else {
                board[0][0] = pieces.get(0);
                board[0][1] = pieces.get(1);
                board[0][2] = pieces.get(2);
                board[0][3] = pieces.get(3);
                board[0][4] = pieces.get(4);
                board[0][5] = pieces.get(5);
                board[0][6] = pieces.get(6);
                board[0][7] = pieces.get(7);
            }
            System.out.println("Piezas colocadas en posición correcta"); // Mensaje de depuración

            return;
        }

        if (numberOfPieces == 10) {
            if (color.equalsIgnoreCase("w")) {
                board[6][7] = pieces.get(0);
                board[6][6] = pieces.get(1);
                board[6][0] = pieces.get(2);
                board[6][1] = pieces.get(3);
                board[6][2] = pieces.get(4);
                board[6][3] = pieces.get(5);
                board[6][4] = pieces.get(6);
                board[6][5] = pieces.get(7);
                board[7][0] = pieces.get(8);
                board[7][1] = pieces.get(9);
            } else {
                board[0][0] = pieces.get(0);
                board[0][1] = pieces.get(1);
                board[1][0] = pieces.get(2);
                board[1][1] = pieces.get(3);
                board[1][2] = pieces.get(4);
                board[1][3] = pieces.get(5);
                board[1][4] = pieces.get(6);
                board[1][5] = pieces.get(7);
                board[1][6] = pieces.get(8);
                board[1][7] = pieces.get(9);
            }
            System.out.println("Piezas colocadas en posición correcta"); // Mensaje de depuración

            return;
        }
        if (numberOfPieces == 16) {
            if (color.equalsIgnoreCase("w")) {
                board[6][0] = pieces.get(0);
                board[6][1] = pieces.get(1);
                board[6][2] = pieces.get(2);
                board[6][3] = pieces.get(3);
                board[6][4] = pieces.get(4);
                board[6][5] = pieces.get(5);
                board[6][6] = pieces.get(6);
                board[6][7] = pieces.get(7);
                for (int i = 0; i < 8; i++) {
                    board[7][i] = pieces.get(8 + i); // Peones
                }
            } else {
                board[0][0] = pieces.get(0);
                board[0][1] = pieces.get(1);
                board[0][2] = pieces.get(2);
                board[0][3] = pieces.get(3);
                board[0][4] = pieces.get(4);
                board[0][5] = pieces.get(5);
                board[0][6] = pieces.get(6);
                board[0][7] = pieces.get(7);
                for (int i = 0; i < 8; i++) {
                    board[1][i] = pieces.get(8 + i); // Peones
                }
            }
            System.out.println("Piezas colocadas en posición correcta"); // Mensaje de depuración

            return;
        }

        System.out.println("No se pudieron colocar las piezas en el tablero."); // Mensaje de depuración}
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}