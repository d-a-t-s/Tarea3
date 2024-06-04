package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class PanelSeleccionSprite extends JPanel implements PanelSeleccionable {
    private final TipoProducto sprite = TipoProducto.SPRITE;
    private boolean isSelected = false;
    private Clip clip;

    // Constructor
    public PanelSeleccionSprite() {
        this.setOpaque(false);
        this.setBounds(241, 310, 37, 57);

        // Cambiar el cursor del mouse al estilo "hand"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    // Cargar el archivo de sonido
                    File soundFile = new File("seleccionarproductos.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    // Obtener un Clip de sonido
                    clip = AudioSystem.getClip();
                    // Abrir el archivo de sonido
                    clip.open(audioIn);
                    // Reproducir el sonido
                    clip.start();

                    if (isSelected) {
                        GestorSeleccion.deseleccionarTodos();
                    } else {
                        GestorSeleccion.seleccionarPanel(PanelSeleccionSprite.this);
                        PanelExpendedor.setProducto(sprite);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isSelected) {
            // Color semi-transparente para el fondo seleccionado
            Color semiTransparentBlack = new Color(0, 0, 0, 64);
            g.setColor(semiTransparentBlack);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        // Dibujar el borde del panel
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        // Dibujar la imagen del producto u otros componentes de la interfaz
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
