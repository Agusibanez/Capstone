package Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PieceGenerator {
    public static List<Piece> generatePieces(String color, String listType, int r) {
        List<Piece> pieces = new ArrayList<>();

        switch (r) {
            case 1:
                pieces.add(new King(color));
                break;
            case 2:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                break;
            case 4:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color));
                pieces.add(new Bishop(color));
                break;
            case 6:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color));
                pieces.add(new Bishop(color));
                pieces.add(new Horse(color));
                pieces.add(new Horse(color));
                break;
            case 8:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color));
                pieces.add(new Bishop(color));
                pieces.add(new Horse(color));
                pieces.add(new Horse(color));
                pieces.add(new Rook(color));
                pieces.add(new Rook(color));
                break;
            case 10:

                for (int i = 0; i < 8; i++) {
                    pieces.add(new Pawn(color));
                }
                break;
            case 16:
                for (int i = 0; i < 8; i++) {
                    pieces.add(new Pawn(color));
                }
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color));
                pieces.add(new Bishop(color));
                pieces.add(new Horse(color));
                pieces.add(new Horse(color));
                pieces.add(new Rook(color));
                pieces.add(new Rook(color));
                break;
            default:
                throw new IllegalArgumentException("Valor de r no válido.");
        }

        if (listType.equalsIgnoreCase("C")) {
            List<Piece> symbolPieces = new ArrayList<>();
            for (Piece piece : pieces) {
                symbolPieces.add(new SymbolPiece(piece.getSymbol()));
            }
            pieces = symbolPieces;
        }
        Collections.shuffle(pieces);

        System.out.println("Total de piezas generadas: " + pieces.size());
        System.out.println("Piezas generadas: " + pieces);

        return pieces;
    }
}