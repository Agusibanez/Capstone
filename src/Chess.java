import java.util.*;

/**
 * Chess Sorting Program
 * Este programa ordena una lista de valores utilizando diferentes algoritmos de ordenamiento.
 * Los valores pueden ser caracteres o números y el orden depende del color especificado.
 */
public class Chess {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> parametros = procesarParametros(args);

        if (!Validator.validarParametros(parametros)) {
            imprimirParametrosInvalidos();
            return;
        }

        // Extraer valores de los parámetros
        String algoritmo = parametros.get("a").toLowerCase();
        String tipo = parametros.get("t").toLowerCase();
        String color = parametros.get("c").toLowerCase();
        int r = Integer.parseInt(parametros.get("r"));
        int pausa = Integer.parseInt(parametros.getOrDefault("s", "28"));

        // Generar valores iniciales
        List<String> valores = generarValores(tipo, r);
        System.out.println("Tipo: [" + (tipo.equals("n") ? "Numérico" : "Caracter") + "]");
        System.out.println("Valores: " + valores);

        // Medir tiempo de ejecución
        long tiempoInicio = System.nanoTime();
        ordenar(valores, algoritmo, pausa, color);
        long tiempoTotal = (System.nanoTime() - tiempoInicio) / 1_000_000 + ((valores.size() - 1) * pausa);

        System.out.println("Ordenamiento: " + valores);
        System.out.println("Algoritmo: " + obtenerNombreAlgoritmo(algoritmo));
        System.out.println("Tiempo total: " + tiempoTotal + " ms");
    }

    /**
     * Procesa los parámetros de entrada y los almacena en un Map.
     */
    private static Map<String, String> procesarParametros(String[] args) {
        Map<String, String> parametros = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    parametros.put(parts[0], parts[1]);
                }
            }
        }
        return parametros;
    }

    /**
     * Genera una lista de valores aleatorios basada en el tipo y la cantidad especificada.
     */
    private static List<String> generarValores(String tipo, int r) {
        List<String> valores;
        if (tipo.equals("c")) {
            valores = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p").subList(0, r);
        } else {
            valores = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16").subList(0, r);
        }
        Collections.shuffle(valores);
        return new ArrayList<>(valores);
    }

    /**
     * Ordena la lista de valores según el algoritmo especificado.
     */
    private static void ordenar(List<String> valores, String algoritmo, int pausa, String color) throws InterruptedException {
        switch (algoritmo) {
            case "s": selectionSort(valores, pausa, color); break;
            case "b": bubbleSort(valores, pausa, color); break;
            case "i": insertionSort(valores, pausa, color); break;
            default: System.out.println("Algoritmo desconocido");
        }
    }

    /**
     * Implementación del los algoritmos
     */
    private static void selectionSort(List<String> valores, int pausa, String color) throws InterruptedException {
        for (int i = 0; i < valores.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < valores.size(); j++) {
                if (comparar(valores.get(j), valores.get(minIndex), color) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(valores, i, minIndex);
            System.out.println(valores);
            Thread.sleep(pausa);
        }
    }

    private static void bubbleSort(List<String> valores, int pausa, String color) throws InterruptedException {
        int n = valores.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparar(valores.get(j), valores.get(j + 1), color) > 0) {
                    Collections.swap(valores, j, j + 1);
                }
            }
            System.out.println(valores);
            Thread.sleep(pausa);
        }
    }

    private static void insertionSort(List<String> valores, int pausaBase, String color) throws InterruptedException {
        for (int i = 1; i < valores.size(); i++) {
            String key = valores.get(i);
            int j = i - 1;

            while (j >= 0 && comparar(valores.get(j), key, color) > 0) {
                valores.set(j + 1, valores.get(j));
                j--;
            }
            valores.set(j + 1, key);

            int pausa = (int) (pausaBase * Math.pow(valores.size() / 8.0, 1.215));
            System.out.println("Esperando " + pausa + "ms...");
            Thread.sleep(pausa);
            System.out.println(valores);
        }
    }

    /**
     * Compara dos valores considerando el tipo de dato y el color.
     */
    private static int comparar(String a, String b, String color) {
        try {
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            return color.equals("b") ? Integer.compare(numA, numB) : Integer.compare(numB, numA);
        } catch (NumberFormatException e) {
            return color.equals("b") ? a.compareTo(b) : b.compareTo(a);
        }
    }

    private static void imprimirParametrosInvalidos() {
        System.out.println("Ordenamiento: Inválido");
        System.out.println("Tipo: Inválido");
        System.out.println("Valores: []");
        System.out.println("Valores Inválidos");
    }

    private static String obtenerNombreAlgoritmo(String algoritmo) {
        return Map.of("s", "SelectionSort", "b", "BubbleSort", "i", "InsertionSort").getOrDefault(algoritmo, "Desconocido");
    }
}