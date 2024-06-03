package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel{
    private static PanelExpendedor panelExpendedor;
    private static PanelComprador panelComprador;
    public static PanelSuperior panelSuperior;
    //Constructor
    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        panelExpendedor = new PanelExpendedor();
        this.add(panelExpendedor, BorderLayout.CENTER);
        panelComprador = new PanelComprador();
        this.add(panelComprador, BorderLayout.SOUTH);
        panelSuperior = new PanelSuperior();
        this.add(panelSuperior, BorderLayout.NORTH);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExpendedor.paintComponent(g);
        panelComprador.paintComponents(g);
        panelSuperior.paintComponent(g);
    }
    public static PanelExpendedor getPanelExpendedor(){
        return panelExpendedor;
    }
    public static PanelComprador getPanelComprador(){
        return panelComprador;
    }
    public static PanelSuperior getPanelSuperior(){
        return panelSuperior;
    }

}
