package aaa.moc.TinyBox.utils;

import lombok.experimental.UtilityClass;

import java.text.MessageFormat;

@UtilityClass
public class ExceptionUtils {

    public static String processMessage(String message) {
        return processMessage(message, new String[]{});
    }

    /**
     * Procesar el mensaje de una excepcion formateandolo sustituyendo las variables
     * usando los argumentos pasados.
     * @param message Mensaje o clave
     * @param args Argumentos para usar en el formateo
     * @return Mensaje procesado
     */
    public static String processMessage(String message, String[] args) {
        return new MessageFormat(message).format(args);
    }
}
