package Tarea;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class TestExpendedor {
    private Expendedor expendedor;
    private Moneda100 m100;
    private Moneda500 m500;
    private Moneda1000 m1000;
    private Moneda1500 m1500;
    @BeforeEach
    void setUp() {
        this.expendedor = new Expendedor(1);
        this.m100 = new Moneda100();
        this.m500 = new Moneda500();
        this.m1000 = new Moneda1000();
        this.m1500 = new Moneda1500();
    }
    @Test
    @DisplayName("Comprar y ver el tipo del producto")
    void comprarProductoExitoso() {
        try {
            Producto cocaCola = this.comprar(TipoProductos.COCA_COLA, m1500);
            assertTrue(cocaCola instanceof CocaCola);
            Producto fanta = this.comprar(TipoProductos.FANTA, m1000);
            assertTrue(fanta instanceof Fanta);
            Producto sprite = this.comprar(TipoProductos.SPRITE, m1000);
            assertTrue(sprite instanceof Sprite);
            Producto snickers = this.comprar(TipoProductos.SNICKERS, m1000);
            assertTrue(snickers instanceof Snickers);
            Producto super8 = this.comprar(TipoProductos.SUPEROCHO, m500);
            assertTrue(super8 instanceof SuperOcho);
        } catch (Exception error) {
            fail("Obtuvo " + error.getClass().getName());
        }
    }
    @Test
    @DisplayName("Comprar sin plata")
    void comprarProductoSinMoneda() {
        try {
            this.comprar(TipoProductos.COCA_COLA, null);
            fail("Se espera PagoIncorrectoException");
            this.comprar(TipoProductos.FANTA, null);
            fail("Se espera PagoIncorrectoException");
            this.comprar(TipoProductos.SPRITE, null);
            fail("Se espera PagoIncorrectoException");
            this.comprar(TipoProductos.SNICKERS, null);
            fail("Se espera PagoIncorrectoException");
            this.comprar(TipoProductos.SUPEROCHO, null);
            fail("Se espera PagoIncorrectoException");
        } catch (Exception ignored) {
        }
    }
    @Test
    @DisplayName("Comprar sin plata suficiente")
    void comprarConInsuficiente() {
        try {
            this.comprar(TipoProductos.COCA_COLA, this.m100);
            fail("Se espera PagoInsuficienteException");
            this.comprar(TipoProductos.FANTA, this.m100);
            fail("Se espera PagoInsuficienteException");
            this.comprar(TipoProductos.SPRITE, this.m100);
            fail("Se espera PagoInsuficienteException");
            this.comprar(TipoProductos.SNICKERS, this.m100);
            fail("Se espera PagoInsuficienteException");
            this.comprar(TipoProductos.SUPEROCHO, this.m100);
            fail("Se espera PagoInsuficienteException");
        } catch (Exception ignored) {
        }
    }
    @Test
    @DisplayName("Comprar cuando no hay stock")
    void comprarSinStock() {
        expendedor = new Expendedor(0);
        try {
            this.comprar(TipoProductos.COCA_COLA, this.m1500);
            fail("Se espera NoHayProductoException");
            this.comprar(TipoProductos.FANTA, this.m1500);
            fail("Se espera NoHayProductoException");
            this.comprar(TipoProductos.SPRITE, this.m1500);
            fail("Se espera NoHayProductoException");
            this.comprar(TipoProductos.SNICKERS, this.m1500);
            fail("Se espera NoHayProductoException");
            this.comprar(TipoProductos.SUPEROCHO, this.m1500);
            fail("Se espera NoHayProductoException");
        } catch (Exception ignored) {
        }
    }
    @Test
    @DisplayName("Comprar y ver vuelto")
    void getVuelto() {
        try {
            this.comprar(TipoProductos.COCA_COLA, m1500);
            assertEquals(300, this.vuelto());
            this.comprar(TipoProductos.FANTA, m1000);
            assertEquals(0, this.vuelto());
            this.comprar(TipoProductos.SPRITE, m1000);
            assertEquals(0, this.vuelto());
            this.comprar(TipoProductos.SNICKERS, m1000);
            assertEquals(200, this.vuelto());
            this.comprar(TipoProductos.SUPEROCHO, m500);
            assertEquals(200, this.vuelto());
        } catch (Exception error) {
            fail("Obtuvo " + error.getClass().getName());
        }
    }
    private Producto comprar(TipoProductos producto, Moneda pago)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(producto, pago);
        return expendedor.getProductoComprado();
    }
    private int vuelto() {
        int vuelto = 0;
        while (true) {
            Moneda mVuelto = expendedor.getMonedaVuelto();
            if (mVuelto == null) break;
            assertEquals(100, mVuelto.getValor());
            vuelto += mVuelto.getValor();
        }
        return vuelto;
    }
}