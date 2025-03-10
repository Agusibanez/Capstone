package board;

import Piece.Piece;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Piece[][] board = new Piece[8][8];
    private String type;

    public Board(String type) {
        this.type = type;
    }

    public void placePieces(List<Piece> pieces, String color, int numberOfPieces) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

        int backRow = color.equals("w") ? 7 : 0;
        int pawnRow = color.equals("w") ? 6 : 1;
        switch (numberOfPieces) {
            case 1 -> board[backRow][0] = pieces.get(0);
            case 2 -> {
                board[backRow][0] = pieces.get(0);
                board[backRow][1] = pieces.get(1);
            }
            case 4 -> {
                for (int i = 0; i < 4; i++) {
                    board[backRow][i] = pieces.get(i);
                }
            }
            case 6 -> {
                for (int i = 0; i < 6; i++) {
                    board[backRow][i] = pieces.get(i);
                }
            }
            case 8 -> {
                for (int i = 0; i < 8; i++) {
                    board[backRow][i] = pieces.get(i);
                }
            }
            case 10 -> {
                for (int i = 0; i < 8; i++) {
                    board[pawnRow][i] = pieces.get(i);
                }
            }
            case 16 -> {
                if (color.equalsIgnoreCase("b")) {
                    for (int i = 0; i < 8; i++) {
                        board[1][i] = pieces.get(8 + i);
                        board[0][i] = pieces.get(i);
                    }
                } else {
                    for (int i = 0; i < 8; i++) {
                        board[7][i] = pieces.get(8 + i);
                        board[6][i] = pieces.get(i);
                    }
                }
            }
            default -> throw new IllegalArgumentException("Número de piezas no soportado.");
        }

    }

    public List<Piece> getPieces() {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    pieces.add(board[i][j]);
                }
            }
        }
        return pieces;
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
        System.out.println("  a b c d e f g h\n");
        Utils.printList(getPieces(), type);

    }

}