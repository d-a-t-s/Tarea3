package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;
import Logica.Moneda1500;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda1500 extends JPanel implements PanelSeleccionable {
    private final Image imagenMoneda1500;
    private final int imageWidth;
    private final int imageHeight;
    private boolean isSelected = false;

    // Constructor
    public PanelMoneda1500() {
        super();
        this.setOpaque(false);
        imagenMoneda1500 = new ImageIcon(getClass().getClassLoader().getResource("moneda1500.png")).getImage();
        imageWidth = imagenMoneda1500.getWidth(null);
        imageHeight = imagenMoneda1500.getHeight(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isSelected) {
                    PanelComprador.setMoneda(new Moneda1500());
                }
                GestorSeleccionMonedas.seleccionarPanel(PanelMoneda1500.this);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int drawWidth = isSelected ? (int) (imageWidth * 1.05) : imageWidth;
        int drawHeight = isSelected ? (int) (imageHeight * 1.05) : imageHeight;
        g2d.drawImage(imagenMoneda1500, 10, -4, drawWidth, drawHeight, null);
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
