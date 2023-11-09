package Tarea;
import java.util.Collections;
import java.util.ArrayList;
/** Máquina que vende los productos. */
public class Expendedor {
    /** Array con los depósitos de todos los tipos de productos */
    private final ArrayList<Deposito<Producto>> productos;
    /** Depósito con todas las monedas de vuelto. */
    private final Deposito<Moneda> monedasVuelto;
    /** Almacena el producto que se compro. */
    private Producto productoComprado;
    /** Depósito con las monedas que se usaron para pagar. */
    public final Deposito<Moneda> monedasPagadas;
    /** Máquina que vende los productos.
     * @param numeroProductos Número de productos que son vendidos por la máquina. */
    public Expendedor(int numeroProductos) {
        this.productos = new ArrayList<>();
        this.monedasVuelto = new Deposito<>();
        this.monedasPagadas = new Deposito<>(false);
        for (TipoProductos tipo : TipoProductos.values()) {
            final Deposito<Producto> deposito = new Deposito<>();
            for (int i = 0; i < numeroProductos; i++) {
                deposito.add(tipo.crearProducto(i));
            }
            this.productos.add(deposito);
        }
    }
    /** Compra un producto de la máquina.
     * @param moneda para pagar el producto.
     * @param tipo Tipo del producto por comprar.
     * @throws NoHayProductoException arrojada cuando no quedan productos en el depósito.
     * @throws PagoIncorrectoException arrojada cuando el pago no es correcto.
     * @throws PagoInsuficienteException arrojada cuando el valor pagado es inferior al del producto. */
    public void comprarProducto(TipoProductos tipo, Moneda moneda)
            throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        if (moneda == null) {
            throw new PagoIncorrectoException("No metiste dinero.");
        }
        if (tipo == null) {
            throw new NoHayProductoException("No hay de este producto");
        }
        if (moneda.getValor() < tipo.getPrecio()) {
            this.monedasVuelto.add(moneda);
            throw new PagoInsuficienteException("al menos debes meter $"
                    + tipo.getPrecio()
                    + " (tu metiste $" + moneda.getValor() + ")");
        }
        Deposito<Producto> deposito = this.productos.get(tipo.o());
        Producto producto = deposito.get();
        if (producto == null) {
            this.monedasVuelto.add(moneda);
            throw new NoHayProductoException("No hay más " + tipo.getTipo());
        }
        int vuelto = moneda.getValor() - tipo.getPrecio();
        while (vuelto != 0) {
            this.monedasVuelto.add(new Moneda100());
            vuelto -= 100;
        }
        this.productoComprado = producto;
        this.monedasPagadas.add(moneda);
    }
    /** regresa el producto que se compro.
     * @return El producto que se compro, si es que no hubieron errores. */
    public Producto getProductoComprado() {
        return this.productoComprado;
    }
    /** da la cantidad de productos del tipo dicho.
     * @return La cantidad de productos del tipo dicho. */
    public int getProductoCantidad(TipoProductos tipo) {
        return this.productos.get(tipo.o()).size();
    }
    /** regresa una moneda del vuelto
     * @return Una moneda del vuelto. */
    public Moneda getMonedaVuelto() {
        return this.monedasVuelto.get();
    }
}