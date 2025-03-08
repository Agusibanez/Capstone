package board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PieceGenerator {
    public static List<Piece> generatePieces(String color, int r) {
        List<Piece> pieces = new ArrayList<>();

        // Verifica que el color sea válido
        if (!color.equalsIgnoreCase("black") && !color.equalsIgnoreCase("white")) {
            throw new IllegalArgumentException("Color no válido. Debe ser 'black' o 'white'.");
        }

        // Verifica que el número de piezas solicitado sea válido
        if (r < 1 || r > 16) {
            throw new IllegalArgumentException("El número de piezas debe estar entre 1 y 16.");
        }

        // Agrega las piezas especiales (1 rey, 1 reina, 2 torres, 2 alfiles, 2 caballos)
        pieces.add(new King(color));       // 1 rey
        pieces.add(new Queen(color));      // 1 reina
        pieces.add(new Rook(color));       // 1 torre
        pieces.add(new Rook(color));       // 1 torre
        pieces.add(new Bishop(color));     // 1 alfil
        pieces.add(new Bishop(color));     // 1 alfil
        pieces.add(new Horse(color));     // 1 caballo
        pieces.add(new Horse(color));     // 1 caballo

        // Agrega exactamente 8 peones
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(color));   // 8 peones
        }

        // Mezcla las piezas para que estén en un orden aleatorio
        Collections.shuffle(pieces);

        // Selecciona las primeras 'r' piezas
        List<Piece> selectedPieces = pieces.subList(0, r);

        // Mensaje de depuración: contar las piezas generadas
        System.out.println("Total de piezas generadas: " + selectedPieces.size());
        System.out.println("Piezas generadas: " + selectedPieces);

        return selectedPieces;
    }
}