package board;

import java.util.List;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public void placePieces(List<Piece> pieces) {
        // Limpia el tablero antes de colocar las piezas
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

        // Coloca las piezas en el tablero en el orden de la lista
        int index = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (index < pieces.size()) {
                    board[i][j] = pieces.get(index);
                    index++;
                } else {
                    break; // Si no hay más piezas, salir del bucle
                }
            }
        }
    }

    public void printBoard() {
        System.out.println("  a b c d e f g h"); // Columnas
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " "); // Filas
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                System.out.print((piece != null ? piece.getSymbol() : ".") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}