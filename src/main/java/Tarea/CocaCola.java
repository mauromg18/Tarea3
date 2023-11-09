package Tarea;
/** Un tipo de bebida. */
public class CocaCola extends Bebida {
    /** Un tipo de bebida.
     * @param serie Número para identificar el producto. */
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return "cocacola";
    }
}