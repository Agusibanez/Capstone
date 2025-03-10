package Piece;

public enum PieceType {
    KING("K", 1, "a"),
    QUEEN("Q", 2, "b"),
    ROOK_I("R", 3, "c"),
    ROOK_II("R", 4, "d"),
    BISHOP_I("B", 5, "e"),
    BISHOP_II("B", 6, "f"),
    HORSE_I("N", 7, "g"),
    HORSE_II("N", 8, "h"),
    PAWN_1("P", 9, "i"),
    PAWN_2("P", 10, "j"),
    PAWN_3("P", 11, "k"),
    PAWN_4("P", 12, "l"),
    PAWN_5("P", 13, "m"),
    PAWN_6("P", 14, "n"),
    PAWN_7("P", 15, "o"),
    PAWN_8("P", 16, "p");

    private final String symbolCode;
    private final int value;
    private final String charValue;

    PieceType(String symbolCode, int value, String charValue) {
        this.symbolCode = symbolCode;
        this.value = value;
        this.charValue = charValue;
    }

    public String getSymbolCode() {
        return symbolCode;
    }

    public int getValue() {
        return value;
    }

    public String getCharValue() {
        return charValue;
    }

}