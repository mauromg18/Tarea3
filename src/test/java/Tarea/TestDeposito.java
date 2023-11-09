package Tarea;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDeposito {
    @Test
    @DisplayName("poner y sacar productos de un deposito")
    void addGetProducto() {
        Deposito<Producto> deposito = new Deposito<>();
        CocaCola pCocaCola = new CocaCola(1);
        Sprite pSprite = new Sprite(2);
        Fanta pFanta = new Fanta(3);
        Snickers pSnickers = new Snickers(4);
        SuperOcho pSuper8 = new SuperOcho(5);
        deposito.add(pCocaCola);
        deposito.add(pSprite);
        deposito.add(pFanta);
        deposito.add(pSnickers);
        deposito.add(pSuper8);
        assertEquals(pCocaCola, deposito.get());
        assertEquals(pSprite, deposito.get());
        assertEquals(pFanta, deposito.get());
        assertEquals(pSnickers, deposito.get());
        assertEquals(pSuper8, deposito.get());
        assertNull(deposito.get());
        deposito.add(pFanta);
        assertEquals(pFanta, deposito.get());
        assertNull(deposito.get());
    }
    @Test
    @DisplayName("poner y sacar monedas de un deposito")
    void addGetMoneda() {
        Deposito<Moneda> deposito = new Deposito<>();
        Moneda100 m100 = new Moneda100();
        Moneda500 m500 = new Moneda500();
        Moneda1000 m1000 = new Moneda1000();
        Moneda1500 m1500 = new Moneda1500();
        deposito.add(m100);
        deposito.add(m500);
        deposito.add(m1000);
        deposito.add(m1500);
        assertEquals(m100, deposito.get());
        assertEquals(m500, deposito.get());
        assertEquals(m1000, deposito.get());
        assertEquals(m1500, deposito.get());
        assertNull(deposito.get());
        deposito.add(m1500);
        assertEquals(m1500, deposito.get());
        assertNull(deposito.get());
    }
}
