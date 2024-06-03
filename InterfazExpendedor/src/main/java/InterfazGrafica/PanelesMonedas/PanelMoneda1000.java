package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import Logica.Moneda1000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda1000 extends JPanel {
    private final Image imagenMoneda1000;
    private float opacity = 1.0f; // Opacidad inicial (1.0f = completamente opaco)
    private int imageWidth;
    private int imageHeight;
    private boolean isHovered = false;

    // Constructor
    public PanelMoneda1000() {
        super();
        this.setOpaque(false);
        imagenMoneda1000 = new ImageIcon(getClass().getClassLoader().getResource("moneda1000.png")).getImage();
        imageWidth = imagenMoneda1000.getWidth(null);
        imageHeight = imagenMoneda1000.getHeight(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PanelComprador.setMoneda(new Moneda1000());
                setOpacity(0.8f); // Reducir la opacidad al presionar el botón
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setOpacity(1.0f); // Restaurar la opacidad al soltar el botón
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                enlargeImage(); // Aumentar el tamaño de la imagen cuando el mouse está sobre el botón
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cambiar el cursor a una mano
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                restoreImageSize(); // Restaurar el tamaño original de la imagen cuando el mouse sale del botón
                setCursor(Cursor.getDefaultCursor()); // Restaurar el cursor predeterminado
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        int drawWidth = isHovered ? (int) (imageWidth * 1.05) : imageWidth;
        int drawHeight = isHovered ? (int) (imageHeight * 1.05) : imageHeight;
        g2d.drawImage(imagenMoneda1000, 10, -4, drawWidth, drawHeight, null);
    }

    private void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint(); // Volver a pintar el panel para reflejar el cambio de opacidad
    }

    private void enlargeImage() {
        repaint(); // Actualizar el panel para reflejar el cambio de tamaño de la imagen
    }

    private void restoreImageSize() {
        repaint(); // Actualizar el panel para reflejar el tamaño original de la imagen
    }
}
