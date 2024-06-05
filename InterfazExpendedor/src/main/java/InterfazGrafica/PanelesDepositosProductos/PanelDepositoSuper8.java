package InterfazGrafica.PanelesDepositosProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * PanelDepositoSuper8 es una clase que extiende JPanel y representa un panel gráfico
 * que muestra los productos de Super8 en un expendedor.
 * Permite agregar productos al expendedor al hacer clic en el panel.
 */
public class PanelDepositoSuper8 extends JPanel {
    private Expendedor expendedor;
    private final Image imagenSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();

    /**
     * Constructor que crea un nuevo PanelDepositoSuper8.
     *
     * @param expendedor el expendedor al que se agregarán los productos de Super8.
     */
    public PanelDepositoSuper8(Expendedor expendedor) {
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(301, 400);
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(103, 470, 130, 70);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (expendedor.getDepositos().get(3).getNumeroProductos() < 9) {
                    expendedor.getDepositos().get(3).addObjeto(TipoProducto.SUPER8.createProducto(randomNum));
                    repaint();
                }
            }
        });
    }

    /**
     * Sobrescribe el método paintComponent para dibujar los productos de Super8
     * en el panel.
     *
     * @param g el contexto gráfico en el que se debe dibujar el componente.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < expendedor.getDepositos().get(3).getNumeroProductos(); i++) {
            g.drawImage(imagenSuper8, 7 + i * 12, 16, null);
        }
    }
}
