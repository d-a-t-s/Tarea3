package InterfazGrafica;

import javax.swing.*;

/**
 * La clase Ventana representa la ventana principal de la aplicación.
 * Contiene el panel principal que organiza y muestra los componentes de la interfaz gráfica.
 */
public class Ventana extends JFrame{
    private PanelPrincipal panelPrincipal;

    /**
     * Constructor de la clase Ventana.
     * Inicializa la ventana y agrega el panel principal.
     */
    public Ventana(){
        super();
        this.setTitle("Expendedor");
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
