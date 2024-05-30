package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private PanelExpendedor panelExpendedor;
    private PanelDepositoCoca panelDepositoCoca;
    //Constructor
    public Ventana(){
        super();
        this.setTitle("Expendedor");
        this.setLayout(new BorderLayout());

        //Tests


        panelExpendedor = new PanelExpendedor();
        this.add(panelExpendedor, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
