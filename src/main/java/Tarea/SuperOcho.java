package Tarea;
/** Un tipo de dulce. */
public class SuperOcho extends Dulce {
    /** Un tipo de dulce.
     * @param serie Número para identificar el producto. */
    public SuperOcho(int serie) {
        super(serie);
    }
    public String comer() {
        return "superOcho";
    }
}