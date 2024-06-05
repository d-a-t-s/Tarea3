package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;
import Logica.Moneda100;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.*;
import java.io.*;

public class PanelMoneda100 extends JPanel implements PanelSeleccionable {
    private final Image imagenMoneda100;
    private final int imageWidth;
    private final int imageHeight;
    private boolean isSelected = false;
    private boolean isMouseOver = false;
    private Clip clip;

    // Constructor
    public PanelMoneda100() {
        super();
        this.setOpaque(false);
        imagenMoneda100 = new ImageIcon(getClass().getClassLoader().getResource("moneda100.png")).getImage();
        imageWidth = imagenMoneda100.getWidth(null);
        imageHeight = imagenMoneda100.getHeight(null);

        // Cargar el archivo de sonido
        try {
            File soundFile = new File("monedas.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isSelected) {
                    PanelComprador.setMoneda(new Moneda100());
                }
                isSelected = !isSelected; // Invertir el estado de isSelected
                repaint();
                GestorSeleccionMonedas.seleccionarPanel(PanelMoneda100.this);

                // Reproducir el sonido
                if (clip != null) {
                    clip.stop(); // Detiene el sonido si ya está reproduciéndose
                    clip.setFramePosition(0); // Vuelve al principio del sonido
                    clip.start(); // Reproduce el sonido
                }
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
        g2d.drawImage(imagenMoneda100, x, y, drawWidth, drawHeight, null);

        // Efecto de sombra o reflejo
        g2d.setColor(new Color(255, 255, 255, 50)); // Color blanco semitransparente
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
