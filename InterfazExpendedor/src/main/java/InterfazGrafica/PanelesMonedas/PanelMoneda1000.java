package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;
import Logica.Moneda1000; // Cambio de Moneda100 a Moneda1000

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda1000 extends JPanel implements PanelSeleccionable { // Cambio de PanelMoneda100 a PanelMoneda1000
    private final Image imagenMoneda1000; // Cambio de imagenMoneda100 a imagenMoneda1000
    private final int imageWidth;
    private final int imageHeight;
    private boolean isSelected = false;
    private boolean isMouseOver = false;

    // Constructor
    public PanelMoneda1000() {
        super();
        this.setOpaque(false);
        imagenMoneda1000 = new ImageIcon(getClass().getClassLoader().getResource("moneda1000.png")).getImage(); // Cambio de moneda100.png a moneda1000.png
        imageWidth = imagenMoneda1000.getWidth(null);
        imageHeight = imagenMoneda1000.getHeight(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isSelected) {
                    PanelComprador.setMoneda(new Moneda1000()); // Cambio de Moneda100 a Moneda1000
                }
                isSelected = !isSelected; // Invertir el estado de isSelected
                repaint();
                GestorSeleccionMonedas.seleccionarPanel(PanelMoneda1000.this);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calcular la posición de dibujo para centrar la imagen
        int x = (getWidth() - imageWidth) / 2;
        int y = (getHeight() - imageHeight) / 2;

        // Ajustar el tamaño de la moneda
        int drawWidth = isSelected ? (int) (imageWidth * 1.05) : imageWidth;
        int drawHeight = isSelected ? (int) (imageHeight * 1.05) : imageHeight;

        // Dibujar rectángulo semitransparente detrás de la moneda si se pasa el ratón sobre ella
        if (isMouseOver) {
            g2d.setColor(new Color(255, 255, 255, 50)); // Color semitransparente
            g2d.fillRect(x, y, imageWidth, imageHeight);
        }

        // Dibujar imagen de la moneda
        g2d.drawImage(imagenMoneda1000, x, y, drawWidth, drawHeight, null); // Cambio de imagenMoneda100 a imagenMoneda1000

        // Efecto de sombra o reflejo
        g2d.setColor(new Color(255, 255, 255, 50)); // Color negro semitransparente
        g2d.fillRect(x, y + drawHeight, drawWidth, 0); // Dibujar una sombra debajo de la moneda
    }

    @Override
    public void setSeleccionado(boolean seleccionado) {
        isSelected = seleccionado;
        repaint();
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }
}
