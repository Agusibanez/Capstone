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
                pieces.add(new Bishop1(color));
                pieces.add(new Bishop2(color));
                break;
            case 6:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop1(color));
                pieces.add(new Bishop2(color));
                pieces.add(new Horse1(color));
                pieces.add(new Horse2(color));
                break;
            case 8:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop1(color));
                pieces.add(new Bishop2(color));
                pieces.add(new Horse1(color));
                pieces.add(new Horse2(color));
                pieces.add(new Rook1(color));
                pieces.add(new Rook2(color));
                break;
            case 10:
                pieces.add(new Pawn1(color));
                pieces.add(new Pawn2(color));
                pieces.add(new Pawn3(color));
                pieces.add(new Pawn4(color));
                pieces.add(new Pawn5(color));
                pieces.add(new Pawn6(color));
                pieces.add(new Pawn7(color));
                pieces.add(new Pawn8(color));

                break;
            case 16:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop1(color));
                pieces.add(new Bishop2(color));
                pieces.add(new Horse1(color));
                pieces.add(new Horse2(color));
                pieces.add(new Rook1(color));
                pieces.add(new Rook2(color));
                pieces.add(new Pawn1(color));
                pieces.add(new Pawn2(color));
                pieces.add(new Pawn3(color));
                pieces.add(new Pawn4(color));
                pieces.add(new Pawn5(color));
                pieces.add(new Pawn6(color));
                pieces.add(new Pawn7(color));
                pieces.add(new Pawn8(color));
                break;
            default:
                throw new IllegalArgumentException("Valor de r no válido.");
        }

        if (listType.equalsIgnoreCase("C")) {
            List<Piece> symbolPieces = new ArrayList<>();
            for (Piece piece : pieces) {
                symbolPieces.add(piece);
            }
            pieces = symbolPieces;
        }
        Collections.shuffle(pieces);

        System.out.println("Total de piezas generadas: " + pieces.size());
        System.out.println("Piezas generadas: " + pieces);

        return pieces;
    }
}