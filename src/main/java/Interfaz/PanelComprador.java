package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Tarea.Moneda100;
import Tarea.Moneda500;
import Tarea.Moneda1000;
import Tarea.Moneda1500;
import Tarea.Expendedor;
public class PanelComprador extends JPanel {
    private JPanel panelBilletera;
    private PanelExpendedor expendedor;
    public PanelComprador(){
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        public void setExpendedor(PanelExpendedor expendedor) {
            this.expendedor = expendedor;
        }
    public void procesarClick(int x, int y) {
        for (Component c : panelBilletera.getComponents()) {
            if (!(c instanceof VistaMonedas)) continue;
            VistaMonedas secMon = (VistaMonedas) c;
            int mx = secMon.getX() + panelBilletera.getX();
            int my = secMon.getY() + panelBilletera.getY();
            boolean clickEnLaMoneda = (x >= mx && x < mx + secMon.getWidth() && y >= my && y < my + secMon.getHeight());
        }
