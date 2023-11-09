package Tarea;
/** Un tipo de bebida. */
public class Sprite extends Bebida {
    /** Un tipo de bebida.
     * @param serie Número para identificar el producto. */
    public Sprite(int serie) {
        super(serie);
    }
    public String beber() {
        return "sprite";
    }
}