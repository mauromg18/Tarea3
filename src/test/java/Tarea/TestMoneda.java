package Tarea;
import Tarea.Moneda100;
import Tarea.Moneda1000;
import Tarea.Moneda1500;
import Tarea.Moneda500;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMoneda {
    private Moneda100 m100;
    private Moneda500 m500;
    private Moneda1000 m1000;
    private Moneda1500 m1500;
    @BeforeEach
    void setUp() {
        this.m100 = new Moneda100();
        this.m500 = new Moneda500();
        this.m1000 = new Moneda1000();
        this.m1500 = new Moneda1500();
    }
    @Test
    @DisplayName("revisa que no sea nulo")
    void getSerieNotNull() {
        assertNotNull(this.m100.getSerie());
        assertNotNull(this.m500.getSerie());
        assertNotNull(this.m1000.getSerie());
        assertNotNull(this.m1500.getSerie());
    }
    @Test
    @DisplayName("Revisar que no es igual a otra ")
    void getSerieNotEqualsOther() {
        assertNotEquals(this.m100.getSerie(), this.m500.getSerie());
        assertNotEquals(this.m100.getSerie(), this.m1000.getSerie());
        assertNotEquals(this.m100.getSerie(), this.m1500.getSerie());
        assertNotEquals(this.m500.getSerie(), this.m1000.getSerie());
        assertNotEquals(this.m500.getSerie(), this.m1500.getSerie());
        assertNotEquals(this.m1000.getSerie(), this.m1500.getSerie());
    }
    @Test
    @DisplayName("Revisa el precio de la moneda")
    void getValor() {
        assertEquals(100, this.m100.getValor());
        assertEquals(500, this.m500.getValor());
        assertEquals(1000, this.m1000.getValor());
        assertEquals(1500, this.m1500.getValor());
    }
    @Test
    @DisplayName("Compara la moneda100 con las demas ")
    void m100CompareTo() {
        assertEquals(0, this.m100.compareTo(this.m100));
        assertTrue(this.m100.compareTo(this.m500) < 0);
        assertTrue(this.m100.compareTo(this.m1000) < 0);
        assertTrue(this.m100.compareTo(this.m1500) < 0);
    }
    @Test
    @DisplayName("Compara la moneda500 con las demas")
    void m500CompareTo() {
        assertTrue(this.m500.compareTo(this.m100) > 0);
        assertEquals(0, this.m500.compareTo(this.m500));
        assertTrue(this.m500.compareTo(this.m1000) < 0);
        assertTrue(this.m500.compareTo(this.m1500) < 0);
    }
    @Test
    @DisplayName("Compara la moneda1000 con las demas")
    void m1000CompareTo() {
        assertTrue(this.m1000.compareTo(this.m100) > 0);
        assertTrue(this.m1000.compareTo(this.m500) > 0);
        assertEquals(0, this.m1000.compareTo(this.m1000));
        assertTrue(this.m1000.compareTo(this.m1500) < 0);
    }
    @Test
    @DisplayName("Compara la moneda1500 con las demas")
    void m1500CompareTo() {
        assertTrue(this.m1500.compareTo(this.m100) > 0);
        assertTrue(this.m1500.compareTo(this.m500) > 0);
        assertTrue(this.m1500.compareTo(this.m1000) > 0);
        assertEquals(0, this.m1500.compareTo(this.m1500));
    }
}
