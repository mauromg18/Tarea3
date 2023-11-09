package Tarea;
/** Un tipo de bebida. */
public class Fanta extends Bebida {
    /** Un tipo de bebida.
     * @param serie Número para identificar el producto. */
    public Fanta(int serie) {
        super(serie);
    }
    public String beber() {
        return "fanta";
    }
}