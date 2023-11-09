package Tarea;
/** Excepción arrojada cuando el valor pagado es inferior al del producto.*/
public class PagoInsuficienteException extends Exception {
    /** Excepción arrojada cuando el valor pagado es inferior al del producto.
     * @param mensaje Mensaje informando sobre el error. */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}