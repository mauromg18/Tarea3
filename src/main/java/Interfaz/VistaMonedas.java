package Interfaz;
import javax.swing.*;
import javax.swing.border.Border;
import Tarea.Moneda;
import Tarea.Moneda100;
import Tarea.Moneda500;
import Tarea.Moneda1000;
import Tarea.Moneda1500;
import java.awt.*;
public class VistaMonedas extends JLabel {
    private Moneda moneda;
    public VistaMonedas(Moneda m){
        super();
        this.moneda = m;
    }
    public Moneda getMoneda(){return this.moneda;}
}