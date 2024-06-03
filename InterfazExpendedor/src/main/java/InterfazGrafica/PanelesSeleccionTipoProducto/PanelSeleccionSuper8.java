package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionSuper8 extends JPanel implements PanelSeleccionable {
    private final TipoProducto super8 = TipoProducto.SUPER8;
    private boolean isSelected = false;

    // Constructor
    public PanelSeleccionSuper8() {
        this.setOpaque(false);
        this.setBounds(241, 470, 37, 57);

        // Cambiar el cursor del mouse al estilo "hand"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isSelected) {
                    GestorSeleccion.deseleccionarTodos();
                } else {
                    GestorSeleccion.seleccionarPanel(PanelSeleccionSuper8.this);
                    PanelExpendedor.setProducto(super8);
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
