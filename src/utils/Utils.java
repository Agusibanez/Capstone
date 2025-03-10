package utils;

import Piece.Piece;

import java.util.List;

public interface Utils {
    static void printList(List<Piece> list, String type) {

        switch (type) {
            case "c":
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i).getCharValue() + " ");
                }
                System.out.println( "\n");
                break;
            case "n":
                for (Piece piece : list) {
                    System.out.print(piece.getValue() + " ");
                }
                System.out.println( "\n");
                break;
        }
    }
}
