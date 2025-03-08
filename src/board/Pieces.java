package board;

class King extends Piece {
    public King(String color) {
        super(color, PieceType.KING);
    }
}

class Queen extends Piece {
    public Queen(String color) {
        super(color, PieceType.QUEEN);
    }
}

class Rook extends Piece {
    public Rook(String color) {
        super(color, PieceType.ROOK);
    }
}

class Bishop extends Piece {
    public Bishop(String color) {
        super(color, PieceType.BISHOP);
    }
}

class Horse extends Piece {
    public Horse(String color) {
        super(color, PieceType.KNIGHT);
    }
}

class Pawn extends Piece {
    public Pawn(String color) {
        super(color, PieceType.PAWN);
    }
}