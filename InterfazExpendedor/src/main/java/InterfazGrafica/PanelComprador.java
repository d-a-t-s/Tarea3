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

/**
 * PanelComprador es una clase que representa el área de la interfaz gráfica
 * donde se muestran las opciones para ingresar monedas y realizar compras.
 */
public class PanelComprador extends JPanel {
    private static Comprador comprador;
    private static Moneda moneda = null;
    private PanelMoneda100 panelMoneda100;
    private PanelMoneda500 panelMoneda500;
    private PanelMoneda1000 panelMoneda1000;
    private PanelMoneda1500 panelMoneda1500;
    private Color color;

    /**
     * Constructor de la clase PanelComprador.
     * Inicializa el panel y agrega los paneles de monedas disponibles.
     */
    public PanelComprador() {
        super();
        color = new Color(100, 149, 237);
        this.setBackground(color);
        this.setPreferredSize(new Dimension(500, 100));
        this.setLayout(new GridLayout(1, 4));
        color = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(color, 5);
        this.setBorder(border);

        // Agregar paneles de monedas
        panelMoneda100 = new PanelMoneda100();
        this.add(panelMoneda100);

        panelMoneda500 = new PanelMoneda500();
        this.add(panelMoneda500);

        panelMoneda1000 = new PanelMoneda1000();
        this.add(panelMoneda1000);

        panelMoneda1500 = new PanelMoneda1500();
        this.add(panelMoneda1500);
    }

    /**
     * Obtiene el comprador actual.
     * @return El objeto Comprador que representa al comprador.
     */
    public static Comprador getComprador() {
        return comprador;
    }

    /**
     * Establece el comprador actual.
     * @param comp El objeto Comprador que se va a establecer como comprador actual.
     */
    public static void setComprador(Comprador comp) {
        comprador = comp;
    }

    /**
     * Obtiene la moneda actualmente ingresada.
     * @return El objeto Moneda que representa la moneda ingresada.
     */
    public static Moneda getMoneda() {
        return moneda;
    }

    /**
     * Establece la moneda actualmente ingresada.
     * @param mon El objeto Moneda que se va a establecer como moneda actualmente ingresada.
     */
    public static void setMoneda(Moneda mon) {
        moneda = mon;
    }
}
