package game;

import sorting.*;
import board.*;
import java.util.*;

public class ChessGame {
    public static void main(String[] args) {
        // Procesar los parámetros de entrada
        Map<String, String> parameters = processParameters(args);

        // Validar los parámetros
        if (!Validator.validateParameters(parameters)) {
            System.out.println("Invalid input values.");
            return; // Detener la ejecución si los parámetros no son válidos
        }

        // Obtener los valores de los parámetros
        String algorithm = parameters.get("a");
        String type = parameters.get("t");
        String color = parameters.get("c");
        int r = Integer.parseInt(parameters.get("r"));
        int s = Integer.parseInt(parameters.get("s"));

        // Convertir el color de "b" o "w" a "black" o "white"
        String fullColor = color.equalsIgnoreCase("b") ? "black" : "white";

        // Generar las piezas según los parámetros
        List<Piece> pieces = PieceGenerator.generatePieces(fullColor, r);

        // Crear el tablero y colocar las piezas
        Board board = new Board();
        board.placePieces(pieces);

        // Mostrar el tablero inicial
        System.out.println("\nInitial Board:");
        board.printBoard();

        // Obtener el algoritmo de ordenamiento seleccionado
        Sorter<Piece> sorter = SorterFactory.getSorter(algorithm, s, color);

        // Ordenar las piezas y mostrar el tablero paso a paso
        sorter.sort(pieces, board);

        // Mostrar el tablero final
        System.out.println("\nSorted Board:");
        board.placePieces(pieces);
        board.printBoard();
    }

    private static Map<String, String> processParameters(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    parameters.put(parts[0].toLowerCase(), parts[1].toLowerCase());
                }
            }
        }
        return parameters;
    }
    private static void printAdditionalInfo(List<Piece> pieces, String algorithm, long startTime, long endTime) {
        // Obtener los valores de las piezas (asumiendo que Piece tiene un método getValue())
        List<Integer> values = new ArrayList<>();
        for (Piece piece : pieces) {
            values.add(piece.getValue());
        }

        // Mostrar el tipo de datos
        System.out.println("\nTipo: [Numérico]");

        // Mostrar los valores iniciales y los pasos del ordenamiento
        System.out.println("Valores: " + values);

        // Mostrar el ordenamiento final
        Collections.sort(values); // Ordenar los valores para mostrar el resultado final
        System.out.println("Ordenamiento: " + values);

        // Mostrar el algoritmo utilizado
        System.out.println("Algoritmo: " + algorithm);

        // Mostrar el tiempo total de ejecución
        long totalTime = endTime - startTime;
        System.out.println("Tiempo total: " + totalTime + " ms");
    }
}