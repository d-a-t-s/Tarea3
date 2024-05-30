package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelExpendedor panelExpendedor;
    private PanelDepositoCoca panelDepositoCoca;
    private PanelMoneda panelMonedas;
    //Constructor
    public Ventana(){
        super();
        this.setTitle("Expendedor");
        this.setLayout(new BorderLayout());

        //Tests


        panelExpendedor = new PanelExpendedor();
        this.add(panelExpendedor, BorderLayout.CENTER);

        // Instanciar y agregar el panel de monedas
        panelMonedas = new PanelMoneda();
        this.add(panelMonedas, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(600, 400);
    }
}

