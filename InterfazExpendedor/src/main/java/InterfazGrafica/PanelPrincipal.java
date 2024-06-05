package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

/**
 * PanelPrincipal es una clase que representa el panel principal de la interfaz gráfica.
 * Contiene los subpaneles PanelExpendedor, PanelComprador y PanelSuperior.
 */
public class PanelPrincipal extends JPanel{
    private static PanelExpendedor panelExpendedor;
    private static PanelComprador panelComprador;
    public static PanelSuperior panelSuperior;

    /**
     * Constructor de la clase PanelPrincipal.
     * Inicializa el panel principal y agrega los subpaneles PanelExpendedor, PanelComprador
     * y PanelSuperior a este panel utilizando un BorderLayout.
     */
    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        panelExpendedor = new PanelExpendedor();
        this.add(panelExpendedor, BorderLayout.CENTER);
        panelComprador = new PanelComprador();
        this.add(panelComprador, BorderLayout.SOUTH);
        panelSuperior = new PanelSuperior();
        this.add(panelSuperior, BorderLayout.NORTH);
    }

    /**
     * Método para pintar los componentes del panel principal.
     * @param g El objeto Graphics usado para pintar los componentes.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExpendedor.paintComponent(g);
        panelComprador.paintComponents(g);
        panelSuperior.paintComponent(g);
    }

    /**
     * Método estático para obtener el panel expendedor.
     * @return El panel expendedor.
     */
    public static PanelExpendedor getPanelExpendedor(){
        return panelExpendedor;
    }

    /**
     * Método estático para obtener el panel comprador.
     * @return El panel comprador.
     */
    public static PanelComprador getPanelComprador(){
        return panelComprador;
    }

    /**
     * Método estático para obtener el panel superior.
     * @return El panel superior.
     */
    public static PanelSuperior getPanelSuperior(){
        return panelSuperior;
    }

}
