package Tarea;
/** Excepción arrojada cuando no quedan productos en el depósito. */
public class NoHayProductoException extends Exception {
    /** Excepción arrojada cuando no quedan productos en el depósito.
     * @param mensaje Mensaje que informa el error. */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}