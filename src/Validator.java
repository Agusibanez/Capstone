import java.util.Map;

public class Validator {
    public static boolean validarParametros(Map<String, String> parametros) {
        return parametros.containsKey("t") && parametros.containsKey("c") && parametros.containsKey("r")
                && (parametros.get("t").equals("c") || parametros.get("t").equals("n"))
                && (parametros.get("c").equals("b") || parametros.get("c").equals("w"))
                && parametros.get("r").matches("\\d+");
    }
}
