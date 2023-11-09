package Tarea;
/** Excepción arrojada cuando el pago no es correcto.*/
public class PagoIncorrectoException extends Exception {
    /** Excepción arrojada cuando el pago no es correcto.
     * @param mensaje Mensaje informando sobre el error.*/
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}