package Tarea;
import java.util.ArrayList;
/** Quien compra un producto desde el expendedor. */
public class Comprador {
    /** lo comprado.*/
    private final Producto productoComprado;
    /** Monedas recibidas del vuelto. */
    private final ArrayList<Moneda> monedasVuelto;
    /** Quien compra un desde el expendedor.
     * @param tipoProducto El tipo de producto que compra.
     * @param moneda Con lo que se compra el producto.
     * @param expendedor Máquina que vende los productos.
     * @throws NoHayProductoException Excepción arrojada cuando no quedan productos en el depósito.
     * @throws PagoIncorrectoException Excepción arrojada cuando el pago no es correcto.
     * @throws PagoInsuficienteException Excepción arrojada cuando el valor pagado es inferior al del producto. */
    public Comprador(TipoProductos tipoProducto, Moneda moneda, Expendedor expendedor)
            throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        expendedor.comprarProducto(tipoProducto, moneda);
        this.productoComprado = expendedor.getProductoComprado();
        this.monedasVuelto = new ArrayList<>();
        while (true) {
            Moneda vuelto = expendedor.getMonedaVuelto();
            if (vuelto == null) break;
            this.monedasVuelto.add(vuelto);
        }
    }
    /** El sabor de lo que se compró.
     * @return El sabor del producto. */
    public Producto getProductoComprado() {
        return this.productoComprado;
    }
    /** entrega las monedas del vuelto.
     * @return Las monedas del vuelto. */
    public ArrayList<Moneda> getMonedasVuelto() {
        return this.monedasVuelto;
    }
}