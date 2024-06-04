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

public class PanelBuy extends JPanel {
    private boolean isPressed = false; // Variable para controlar el estado del botón
    private Clip clip;

    // Constructor
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

                // Reproducir el sonido
                if (clip != null) {
                    clip.stop(); // Detiene el sonido si ya está reproduciéndose
                    clip.setFramePosition(0); // Vuelve al principio del sonido
                    clip.start(); // Reproduce el sonido
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint(); // Vuelve a pintar el botón para reflejar el cambio de estado
                try {
                    PanelComprador.setComprador(new Comprador(PanelComprador.getMoneda(), PanelExpendedor.getProducto(), PanelExpendedor.getExpendedor()));
                    //ACA SE PUEDE HACER NULL LA MONEDA DEL COMPRADOR PARA DAR LA IMPRESION DE QUE SU MONEDA SE LA LLAVO EL EXPENDEDOR Y POR TANTO SE QUEDA SIN MONEDA
                    PanelComprador.setMoneda(null);
                    PanelPrincipal.getPanelExpendedor().repaint();
                    GestorSeleccion.deseleccionarTodos();
                    GestorSeleccionMonedas.deseleccionarTodos();
                } catch (Logica.PagoIncorrectoException PagoIncorrectoException) {
                    System.out.println("Para comprar debe introducir una moneda primero\n");
                } catch (Logica.PagoInsuficienteException PagoInsuficienteException) {
                    System.out.println("El pago que a ingresado es menor al precio del producto\n");
                } catch (NoHayProductoException NoHayProductoException) {
                    System.out.println("El deposito está vacio o no se ingreso un tipo de producto\n");
                } finally {
                    PanelComprador.setMoneda(null);
                    PanelPrincipal.getPanelExpendedor().repaint();
                }
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("PanelBuy Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        PanelBuy panelBuy = new PanelBuy();
        frame.add(panelBuy, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}