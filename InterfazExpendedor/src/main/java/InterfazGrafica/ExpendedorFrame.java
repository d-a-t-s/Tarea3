package InterfazGrafica;

import javax.swing.*;

public class ExpendedorFrame extends JFrame {
    public ExpendedorFrame() {
        super("Expendedor");
        initUI();
    }

    private void initUI() {
        PanelExpendedor panelExpendedor = new PanelExpendedor();

        // Configurar el JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 800); // Establece el tamaño del JFrame a 500x800
        this.add(panelExpendedor);
        this.pack(); // Ajusta el tamaño del JFrame según el tamaño preferido de sus componentes
        this.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
    }

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
