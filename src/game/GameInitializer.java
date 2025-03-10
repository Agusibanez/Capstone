package game;

import board.Board;
import Piece.*;
import java.util.List;
import java.util.Map;

public class GameInitializer {

    public static Board initializeGame(Map<String, String> parameters) {
        String type = parameters.get("t");
        String color = parameters.get("c");
        int r = Integer.parseInt(parameters.get("r"));
        String t = parameters.get("t");

        String fullColor = color.equalsIgnoreCase("b") ? "black" : "white";

        List<Piece> pieces = PieceGenerator.generatePieces(fullColor, type, r);

        Board board = new Board(t);
        board.placePieces(pieces, color, r);

        return board;
    }
}