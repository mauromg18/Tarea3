package Tarea;
import java.util.ArrayList;
/** Depósito de articulos.
 * @param <T> Es el tipo del articulo. */
public class Deposito<T> {
    /** Si se pueden sacar articulos o no. */
    private final boolean puedeSacar;
    /** guarda los articulos. */
    private final ArrayList<T> articulos;
    /** Depósito de articulos. */
    public Deposito() {
        this.puedeSacar = true;
        this.articulos = new ArrayList<>();
    }
    public Deposito(boolean puedeSacar) {
        this.puedeSacar = puedeSacar;
        this.articulos = new ArrayList<>();
    }
    /** Almacena un articulo.
     * @param articulo Es el articulo. */
    public void add(T articulo) {
        this.articulos.add(articulo);
    }
    /** saca el primer articulo almacenado. Si puedeSacar es falso, no borra nada y arroja null.
     * @return El articulo. null si está vacío o si puedeSacar es falso. */
    public T get() {
        if (!this.puedeSacar || this.articulos.isEmpty()) return null;
        return this.articulos.remove(0);
    }
    /** Devuelve el número de elementos que hay dentro del depósito.
     * @return El número de elementos que hay dentro del depósito. */
    public int size() {
        return this.articulos.size();
    }
}
