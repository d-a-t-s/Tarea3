package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private PanelPrincipal panelPrincipal;
    //private PanelMoneda panelMonedas;
    //Constructor
    public Ventana(){
        super();
        this.setTitle("Expendedor");
        //Tests
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);

        /* Instanciar y agregar el panel de monedas
        panelMonedas = new PanelMoneda();
        this.add(panelMonedas, BorderLayout.SOUTH);*/

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }
}

