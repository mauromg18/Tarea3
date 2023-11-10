package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;
    public  PanelPrincipal(){
        super();
        comprador = new PanelComprador();
        expendedor = new PanelExpendedor(5);
        comprador.setExpendedor(expendedor);
        this.setBackground(new Color(0, 45, 234));
        this.setLayout(new GridLayout(2,1));
        this.add(comprador);
        this.add(expendedor);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                comprador.procesarClick(e.getX(),e.getY());
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
    }
}