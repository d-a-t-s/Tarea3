package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

class PanelExpendedor extends JPanel {
    private BufferedImage expendedorImage;

    public PanelExpendedor() {
        try {
            // Carga la imagen del expendedor
            expendedorImage = ImageIO.read(getClass().getClassLoader().getResource("Expendedor.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (expendedorImage != null) {
            // Calcular el nuevo tamaño para mantener la relación de aspecto
            int originalWidth = expendedorImage.getWidth();
            int originalHeight = expendedorImage.getHeight();
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double aspectRatio = (double) originalWidth / originalHeight;
            int newWidth, newHeight;

            if (panelWidth / aspectRatio <= panelHeight) {
                newWidth = panelWidth;
                newHeight = (int) (panelWidth / aspectRatio);
            } else {
                newWidth = (int) (panelHeight * aspectRatio);
                newHeight = panelHeight;
            }

            // Dibujar la imagen centrada
            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;
            g.drawImage(expendedorImage, x, y, newWidth, newHeight, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Ajustar el tamaño preferido del panel basado en la imagen
        if (expendedorImage != null) {
            return new Dimension(expendedorImage.getWidth(), expendedorImage.getHeight());
        } else {
            return super.getPreferredSize();
        }
    }
}