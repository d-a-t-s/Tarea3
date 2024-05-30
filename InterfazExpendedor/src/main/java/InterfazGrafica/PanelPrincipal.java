package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel{
    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;
    //Constructor
    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        panelExpendedor = new PanelExpendedor();
        this.add(panelExpendedor, BorderLayout.CENTER);
        panelComprador = new PanelComprador();
        this.add(panelComprador, BorderLayout.SOUTH);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExpendedor.paintComponent(g);
    }
}
