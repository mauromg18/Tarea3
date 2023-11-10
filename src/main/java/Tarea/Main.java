package Tarea;
import Interfaz.PanelPrincipal;
import Interfaz.Ventana;
public class Main{
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Ventana ventana = new Ventana();
        PanelPrincipal panel = new PanelPrincipal();
        ventana.add(panel);
        ventana.setVisible(true);