package Tarea;
/** Tipo de producto que esta en el expendedor. */
public abstract class Bebida extends Producto {
    /** Tipo de producto que esta en el expendedor.
     *  @param serie Número para identificar el producto. */
    public Bebida(int serie) {
        super(serie);
    }
    /** lo que hace el cliente luego de recibir su bebida desde el expendedor.
     * @return El sabor de la bebida. */
    public abstract String beber();
}