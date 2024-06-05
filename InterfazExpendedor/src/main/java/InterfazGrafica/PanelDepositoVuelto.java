package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.*;
import java.io.*;

/**
 * PanelDepositoVuelto es una clase que representa el área de la interfaz gráfica
 * donde se muestran las monedas devueltas por el expendedor.
 */
public class PanelDepositoVuelto extends JPanel {
    private Expendedor expendedor;
    private final Image monedita100 = new ImageIcon(getClass().getClassLoader().getResource("Monedita100.png")).getImage();
    private final Image monedita500 = new ImageIcon(getClass().getClassLoader().getResource("Monedita500.png")).getImage();
    private final Image monedita1000 = new ImageIcon(getClass().getClassLoader().getResource("Monedita1000.png")).getImage();
    private final Image monedita1500 = new ImageIcon(getClass().getClassLoader().getResource("Monedita1500.png")).getImage();
    private Clip clip;

    /**
     * Constructor de la clase PanelDepositoVuelto.
     * Inicializa el panel y establece el expendedor asociado.
     * Configura el área de escucha de clics del ratón para procesar la devolución de monedas.
     * @param expendedor El objeto Expendedor asociado al panel.
     */
    public PanelDepositoVuelto(Expendedor expendedor) {
        super();
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(319, 418, 26, 104);

        // Cargar el archivo de sonido para la devolución
        try {
            File soundFile = new File("vuelto.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (expendedor.getDepositoVuelto().getNumeroProductos() != 0) {
                    PanelSuperior.setVuelto(expendedor.getVuelto().getValor());
                    repaint();
                    PanelPrincipal.getPanelSuperior().repaint();

                    // Reproducir el sonido de devolución
                    if (clip != null) {
                        clip.stop(); // Detiene el sonido si ya está reproduciéndose
                        clip.setFramePosition(0); // Vuelve al principio del sonido
                        clip.start(); // Reproduce el sonido
                    }
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Verificar si hay monedas en el depósito de vuelto y configurar el cursor en consecuencia
        if (expendedor.getDepositoVuelto().getNumeroProductos() > 0) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mano si hay monedas
        } else {
            this.setCursor(Cursor.getDefaultCursor()); // Cursor predeterminado si no hay monedas
        }

        // Dibujar las monedas devueltas en el depósito de vuelto
        for (int i = 0; i < expendedor.getDepositoVuelto().getNumeroProductos(); i++) {
            if (expendedor.getDepositoVuelto().seeObjeto(i).getClass() == Moneda100.class) {
                g.drawImage(monedita100, 3, 87 - i * 4, null);
            } else if (expendedor.getDepositoVuelto().seeObjeto(i).getClass() == Moneda500.class) {
                g.drawImage(monedita500, 3, 87 - i * 4, null);
            } else if (expendedor.getDepositoVuelto().seeObjeto(i).getClass() == Moneda1000.class) {
                g.drawImage(monedita1000, 3, 87 - i * 4, null);
            } else if (expendedor.getDepositoVuelto().seeObjeto(i).getClass() == Moneda1500.class) {
                g.drawImage(monedita1500, 3, 87 - i * 4, null);
            }
        }
    }
}
