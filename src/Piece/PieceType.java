package Piece;

public enum PieceType {
    KING("K"), QUEEN("Q"), ROOK("R"), BISHOP("B"), HORSE("N"), PAWN("P");

    private final String symbolCode;

    PieceType(String symbolCode) {
        this.symbolCode = symbolCode;
    }

    public String getSymbolCode() {
        return symbolCode;
    }
}