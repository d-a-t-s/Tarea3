package InterfazGrafica.PanelesDepositosProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * PanelDepositoFanta es una clase que extiende JPanel y representa un panel gráfico
 * que muestra los productos de Fanta en un expendedor.
 * Permite agregar productos al expendedor al hacer clic en el panel.
 */
public class PanelDepositoFanta extends JPanel {
    private Expendedor expendedor;
    private final Image imagenFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();

    /**
     * Constructor que crea un nuevo PanelDepositoFanta.
     *
     * @param expendedor el expendedor al que se agregarán los productos de Fanta.
     */
    public PanelDepositoFanta(Expendedor expendedor) {
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(201, 300);
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(103, 390, 130, 70);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (expendedor.getDepositos().get(2).getNumeroProductos() < 9) {
                    expendedor.getDepositos().get(2).addObjeto(TipoProducto.FANTA.createProducto(randomNum));
                    repaint();
                }
            }
        });
    }

    /**
     * Sobrescribe el método paintComponent para dibujar los productos de Fanta
     * en el panel.
     *
     * @param g el contexto gráfico en el que se debe dibujar el componente.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < expendedor.getDepositos().get(2).getNumeroProductos(); i++) {
            g.drawImage(imagenFanta, 5 + i * 12, 16, null);
        }
    }
}
