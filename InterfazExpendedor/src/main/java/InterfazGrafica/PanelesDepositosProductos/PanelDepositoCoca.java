package InterfazGrafica.PanelesDepositosProductos;

import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * PanelDepositoCoca es una clase que extiende JPanel y representa un panel gráfico
 * que muestra los productos de Coca-Cola en un expendedor.
 * Permite agregar productos al expendedor al hacer clic en el panel.
 */
public class PanelDepositoCoca extends JPanel {
    private Expendedor expendedor;
    private final Image imagenCoca = new ImageIcon(getClass().getClassLoader().getResource("Cocacola.png")).getImage();

    /**
     * Constructor que crea un nuevo PanelDepositoCoca.
     *
     * @param expendedor el expendedor al que se agregarán los productos de Coca-Cola.
     */
    public PanelDepositoCoca(Expendedor expendedor) {
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(0, 100);
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(103, 230, 130, 70);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (expendedor.getDepositos().get(0).getNumeroProductos() < 9) {
                    expendedor.getDepositos().get(0).addObjeto(TipoProducto.COCACOLA.createProducto(randomNum));
                    repaint();
                }
            }
        });
    }

    /**
     * Sobrescribe el método paintComponent para dibujar los productos de Coca-Cola
     * en el panel.
     *
     * @param g el contexto gráfico en el que se debe dibujar el componente.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < expendedor.getDepositos().get(0).getNumeroProductos(); i++) {
            g.drawImage(imagenCoca, 5 + i * 12, 16, null);
        }
    }
}
