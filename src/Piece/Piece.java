package Piece;

public class Piece implements Comparable<Piece> {
    protected String color;
    protected PieceType type;

    public Piece(String color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    public String getCharValue() {
        return type.getCharValue();
    }

    public int getValue() {
        return type.getValue();
    }

    public String getSymbol() {
        return type.getSymbolCode();
    }

    @Override
    public String toString() {
        return getSymbol();
    }

    @Override
    public int compareTo(Piece other) {
        int typeComparison = this.type.compareTo(other.type);
        if (typeComparison != 0) {
            return typeComparison;
        }
        return this.color.compareTo(other.color);
    }
}