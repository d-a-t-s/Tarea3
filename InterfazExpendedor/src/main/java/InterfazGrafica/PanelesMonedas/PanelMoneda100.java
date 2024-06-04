package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import InterfazGrafica.PanelesSeleccionTipoProducto.GestorSeleccion;
import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;
import Logica.Moneda100;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda100 extends JPanel implements PanelSeleccionable {
    private final Image imagenMoneda100;
    private final int imageWidth;
    private final int imageHeight;
    private boolean isSelected = false;

    // Constructor
    public PanelMoneda100() {
        super();
        this.setOpaque(false);
        imagenMoneda100 = new ImageIcon(getClass().getClassLoader().getResource("moneda100.png")).getImage();
        imageWidth = imagenMoneda100.getWidth(null);
        imageHeight = imagenMoneda100.getHeight(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isSelected) {
                    // Si ya está seleccionado, deselecciona
                    setSeleccionado(false);
                } else {
                    // Si no está seleccionado, selecciona
                    PanelComprador.setMoneda(new Moneda100());
                    GestorSeleccion.deseleccionarTodos();
                    setSeleccionado(true);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int drawWidth = isSelected ? (int) (imageWidth * 1.05) : imageWidth;
        int drawHeight = isSelected ? (int) (imageHeight * 1.05) : imageHeight;
        g2d.drawImage(imagenMoneda100, 10, -4, drawWidth, drawHeight, null);
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
