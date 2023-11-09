package Tarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestComprador {
    private Expendedor expendedor;
    private Moneda100 m100;
    private Moneda500 m500;
    private Moneda1000 m1000;
    private Moneda1500 m1500;
    private CocaCola cocaCola;
    private Fanta fanta;
    private Sprite sprite;
    private Snickers snickers;
    private SuperOcho super8;
    @BeforeEach
    void setUp() {
        this.expendedor = new Expendedor(1);
        this.m100 = new Moneda100();
        this.m500 = new Moneda500();
        this.m1000 = new Moneda1000();
        this.m1500 = new Moneda1500();
        this.cocaCola = new CocaCola(1);
        this.fanta = new Fanta(2);
        this.sprite = new Sprite(3);
        this.snickers = new Snickers(4);
        this.super8 = new SuperOcho(5);
    }
    @Test
    @DisplayName("Comprar y revisar el vuelto")
    void MonedasVuelto() {
        try {
            assertEquals(300, this.comprar(TipoProductos.COCA_COLA, this.m1500).getMonedasVuelto());
            assertEquals(0, this.comprar(TipoProductos.FANTA, this.m1000).getMonedasVuelto());
            assertEquals(0, this.comprar(TipoProductos.SPRITE, this.m1000).getMonedasVuelto());
            assertEquals(200, this.comprar(TipoProductos.SNICKERS, this.m1000).getMonedasVuelto());
            assertEquals(200, this.comprar(TipoProductos.SUPEROCHO, this.m500).getMonedasVuelto());
        } catch (Exception error) {
            fail("Obtuvo " + error.getClass().getName());
        }
    }

    @Test
    @DisplayName("Comprar  y revisar qué compró")
    void ProductoComprado() {
        try {
            assertEquals(this.cocaCola.beber(), this.comprar(TipoProductos.COCA_COLA, this.m1500).getProductoComprado());
            assertEquals(this.fanta.beber(), this.comprar(TipoProductos.FANTA, this.m1500).getProductoComprado());
            assertEquals(this.sprite.beber(), this.comprar(TipoProductos.SPRITE, this.m1500).getProductoComprado());
            assertEquals(this.snickers.comer(), this.comprar(TipoProductos.SNICKERS, this.m1500).getProductoComprado());
            assertEquals(this.super8.comer(), this.comprar(TipoProductos.SUPEROCHO, this.m1500).getProductoComprado());
        } catch (Exception error) {
            fail("Obtuvo " + error.getClass().getName());
        }
    }

    @Test
    @DisplayName("Comprar sin dinero")
    void comprarSinMoneda() {
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
    @DisplayName("Comprar sin dinero suficiente")
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
           fail("se espera PagoInsuficienteException");
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

    private Comprador comprar(TipoProductos producto, Moneda pago)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        return new Comprador(producto, pago, expendedor);
    }
}