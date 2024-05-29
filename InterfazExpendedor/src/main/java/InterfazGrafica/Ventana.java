package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private PanelExpendedor panelExpendedor;
    //Constructor
    public Ventana(){
        super();
        this.setTitle("Expendedor");
        this.setLayout(new BorderLayout());

        panelExpendedor = new PanelExpendedor();
        this.add(panelExpendedor, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
