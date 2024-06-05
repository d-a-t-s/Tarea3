package InterfazGrafica.PanelesDepositosProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * PanelDepositoSnicker es una clase que extiende JPanel y representa un panel gráfico
 * que muestra los productos de Snicker en un expendedor.
 * Permite agregar productos al expendedor al hacer clic en el panel.
 */
public class PanelDepositoSnicker extends JPanel {
    private Expendedor expendedor;
    private final Image imagenSnicker = new ImageIcon(getClass().getClassLoader().getResource("Snicker.png")).getImage();

    /**
     * Constructor que crea un nuevo PanelDepositoSnicker.
     *
     * @param expendedor el expendedor al que se agregarán los productos de Snicker.
     */
    public PanelDepositoSnicker(Expendedor expendedor) {
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(401, 500);
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(103, 550, 130, 70);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (expendedor.getDepositos().get(4).getNumeroProductos() < 9) {
                    expendedor.getDepositos().get(4).addObjeto(TipoProducto.SNICKER.createProducto(randomNum));
                    repaint();
                }
            }
        });
    }

    /**
     * Sobrescribe el método paintComponent para dibujar los productos de Snicker
     * en el panel.
     *
     * @param g el contexto gráfico en el que se debe dibujar el componente.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < expendedor.getDepositos().get(4).getNumeroProductos(); i++) {
            g.drawImage(imagenSnicker, 7 + i * 12, 16, null);
        }
    }
}
