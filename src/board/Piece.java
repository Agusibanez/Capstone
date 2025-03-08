package board;

public abstract class Piece implements Comparable<Piece> {
    protected String color;
    protected PieceType type;

    public Piece(String color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    public String getSymbol() {
        return type.getSymbolCode();
    }

    public PieceType getType() {
        return type;
    }

    @Override
    public String toString() {
        return getSymbol();
    }

    @Override
    public int compareTo(Piece other) {
        // Ordenar primero por tipo de pieza y luego por color
        int typeComparison = this.type.compareTo(other.type);
        if (typeComparison != 0) {
            return typeComparison;
        }
        return this.color.compareTo(other.color);
    }
}