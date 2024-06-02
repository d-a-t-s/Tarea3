package InterfazGrafica;

import InterfazGrafica.PanelesMonedas.PanelMoneda100;
import InterfazGrafica.PanelesMonedas.PanelMoneda1000;
import InterfazGrafica.PanelesMonedas.PanelMoneda1500;
import InterfazGrafica.PanelesMonedas.PanelMoneda500;
import Logica.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelComprador extends JPanel{
    private static Comprador comprador;
    private static Moneda moneda = null;
    private PanelMoneda100 panelMoneda100;
    private PanelMoneda500 panelMoneda500;
    private PanelMoneda1000 panelMoneda1000;
    private PanelMoneda1500 panelMoneda1500;
    private Color color;
    //Constructor
    public PanelComprador(){
        super();
        color = new Color(100, 149, 237);
        this.setBackground(color);
        this.setPreferredSize(new Dimension(500,100));
        this.setLayout(new GridLayout(1,4));
        color = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(color, 5);
        this.setBorder(border);

        //PanelesMonedas
        panelMoneda100 = new PanelMoneda100();
        this.add(panelMoneda100);

        panelMoneda500 = new PanelMoneda500();
        this.add(panelMoneda500);

        panelMoneda1000 = new PanelMoneda1000();
        this.add(panelMoneda1000);

        panelMoneda1500 = new PanelMoneda1500();
        this.add(panelMoneda1500);
    }

    public static Comprador getComprador(){
        return comprador;
    }
    public static void setComprador(Comprador comp){
        comprador = comp;
    }
    public static Moneda getMoneda(){
        return moneda;
    }
    public static void setMoneda(Moneda mon){
        moneda = mon;
    }
}
