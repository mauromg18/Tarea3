package Interfaz;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import Tarea.Deposito;
import Tarea.Producto;
import Tarea.Moneda;
    public class PanelDeposito<T> extends JPanel {
        private Deposito<T> deposito;
        public PanelDeposito(Deposito<T> deposito){
            super();
            this.deposito = deposito;
            Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
            setBorder(border);
        }
}