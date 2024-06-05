package InterfazGrafica;

import InterfazGrafica.PanelesMonedas.GestorSeleccionMonedas;
import InterfazGrafica.PanelesSeleccionTipoProducto.GestorSeleccion;
import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.*;
import java.io.*;

/**
 * PanelBuy es una clase que representa un botón de compra en la interfaz gráfica.
 * Permite al usuario realizar una compra de productos seleccionados al presionarlo.
 */
public class PanelBuy extends JPanel {
    private boolean isPressed = false; // Variable para controlar el estado del botón
    private Clip clip;

    /**
     * Constructor de la clase PanelBuy.
     * Inicializa el botón de compra y configura sus propiedades.
     */
    public PanelBuy() {
        super();
        this.setOpaque(false);
        this.setBounds(311, 358, 74, 37);

        // Cambiar el cursor del mouse al estilo "hand"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Cargar el archivo de sonido
        try {
            File soundFile = new File("buy.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint(); // Vuelve a pintar el botón para reflejar el cambio de estado
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    // Realizar la compra y manejar posibles excepciones
                    PanelComprador.setComprador(new Comprador(PanelComprador.getMoneda(), PanelExpendedor.getProducto(), PanelExpendedor.getExpendedor()));
                    PanelComprador.setMoneda(null);
                    PanelPrincipal.getPanelExpendedor().repaint();
                    GestorSeleccion.deseleccionarTodos();
                    GestorSeleccionMonedas.deseleccionarTodos();

                    // Reproducir el sonido
                    if (clip != null) {
                        clip.stop(); // Detiene el sonido si ya está reproduciéndose
                        clip.setFramePosition(0); // Vuelve al principio del sonido
                        clip.start(); // Reproduce el sonido
                    }

                } catch (Logica.PagoIncorrectoException PagoIncorrectoException) {
                    JOptionPane.showMessageDialog(null, "Para comprar debe introducir una moneda primero", "Error de pago", JOptionPane.ERROR_MESSAGE);
                } catch (Logica.PagoInsuficienteException PagoInsuficienteException) {
                    JOptionPane.showMessageDialog(null, "El pago que ha ingresado es menor al precio del producto", "Error de pago", JOptionPane.ERROR_MESSAGE);
                } catch (NoHayProductoException NoHayProductoException) {
                    JOptionPane.showMessageDialog(null, "El depósito está vacío o no se ha ingresado un tipo de producto", "Error de producto", JOptionPane.ERROR_MESSAGE);
                } finally {
                    PanelComprador.setMoneda(null);
                    PanelPrincipal.getPanelExpendedor().repaint();
                }
                // Restablecer el estado del botón y repintar
                isPressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Llama al método de pintado original
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Cambiar el brillo del botón si está presionado
        if (isPressed) {
            g2d.setColor(new Color(0, 0, 0, 60));
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        g2d.dispose();
    }
}
