package Interfaz;
import Tarea.*;
import javax.swing.*;
import java.awt.*;

public class VistaProducto extends JLabel {
    private Producto producto;
    public VistaProducto(Producto p){
        super();
        this.producto = p;
    }
    public Producto getProducto(){
        return this.producto;}
}