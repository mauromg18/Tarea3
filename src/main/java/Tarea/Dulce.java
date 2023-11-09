package Tarea;
/** Tipo de producto que hay en el expendedor. */
public abstract class Dulce extends Producto {
    /** Tipo de producto que hay en el expendedor.
     * @param serie Número para identificar el producto. */
    public Dulce(int serie) {
        super(serie);
    }
    /** lo que hace el cliente luego de recibir su dulce.
     * @return El sabor del dulce. */
    public abstract String comer();
}
