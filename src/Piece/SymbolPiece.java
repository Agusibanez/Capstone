package Piece;

public class SymbolPiece extends Piece {
    private String symbol;

    public SymbolPiece(String symbol) {
        super("none", PieceType.PAWN);
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int compareTo(Piece other) {
        return this.symbol.compareTo(other.getSymbol());
    }
}