package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;
import Logica.Moneda1000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda1000 extends JPanel implements PanelSeleccionable {
    private final Image imagenMoneda1000;
    private final int imageWidth;
    private final int imageHeight;
    private boolean isSelected = false;

    // Constructor
    public PanelMoneda1000() {
        super();
        this.setOpaque(false);
        imagenMoneda1000 = new ImageIcon(getClass().getClassLoader().getResource("Moneda1000.png")).getImage();
        imageWidth = imagenMoneda1000.getWidth(null);
        imageHeight = imagenMoneda1000.getHeight(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isSelected) {
                    PanelComprador.setMoneda(new Moneda1000());
                }
                GestorSeleccionMonedas.seleccionarPanel(PanelMoneda1000.this);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int drawWidth = isSelected ? (int) (imageWidth * 1.05) : imageWidth;
        int drawHeight = isSelected ? (int) (imageHeight * 1.05) : imageHeight;
        g2d.drawImage(imagenMoneda1000, 10, -4, drawWidth, drawHeight, null);
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
