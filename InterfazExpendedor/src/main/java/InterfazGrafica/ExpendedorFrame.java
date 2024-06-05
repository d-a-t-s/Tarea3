package InterfazGrafica;

import javax.swing.*;

/**
 * ExpendedorFrame es una clase que extiende JFrame y representa la ventana principal
 * de la aplicación Expendedor. Contiene un PanelExpendedor donde se muestra la interfaz
 * gráfica del expendedor de productos.
 */
public class ExpendedorFrame extends JFrame {
    /**
     * Constructor de la clase ExpendedorFrame.
     * Crea una nueva instancia de la ventana principal con el título "Expendedor"
     * y llama al método para inicializar la interfaz de usuario.
     */
    public ExpendedorFrame() {
        super("Expendedor");
        initUI();
    }

    /**
     * Inicializa la interfaz de usuario de la ventana.
     * Crea un PanelExpendedor y configura el JFrame con el tamaño, contenido y
     * posicionamiento adecuados.
     */
    private void initUI() {
        PanelExpendedor panelExpendedor = new PanelExpendedor();

        // Configurar el JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 800); // Establece el tamaño del JFrame a 500x800
        this.add(panelExpendedor);
        this.pack(); // Ajusta el tamaño del JFrame según el tamaño preferido de sus componentes
        this.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
    }

    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia de ExpendedorFrame y la muestra.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExpendedorFrame frame = new ExpendedorFrame();
                frame.setVisible(true); // Mostrar el JFrame
            }
        });
    }
}
