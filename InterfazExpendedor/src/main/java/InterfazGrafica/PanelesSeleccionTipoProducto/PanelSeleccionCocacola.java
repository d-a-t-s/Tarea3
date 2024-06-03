package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionCocacola extends JPanel implements PanelSeleccionable {
    private final TipoProducto coca = TipoProducto.COCACOLA;
    private boolean isSelected = false;

    // Constructor
    public PanelSeleccionCocacola() {
        this.setOpaque(false);
        this.setBounds(241, 230, 37, 57);

        // Cambiar el cursor del mouse al estilo "hand"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isSelected) {
                    GestorSeleccion.deseleccionarTodos();
                } else {
                    GestorSeleccion.seleccionarPanel(PanelSeleccionCocacola.this);
                    PanelExpendedor.setProducto(coca);
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
