package Tarea;
/** Un producto vendido por la maquina. */
public abstract class Producto {
    /** Número para identificar el producto.*/
    private final int serie;
    /** Un producto vendido por la maquina.
     * @param serie Número  para identificar el producto. */
    public Producto(int serie) {
        this.serie = serie;
    }
    /** da la serie del producto.
     * @return La serie del producto. */
    public int getSerie() {
        return this.serie;
    }
}