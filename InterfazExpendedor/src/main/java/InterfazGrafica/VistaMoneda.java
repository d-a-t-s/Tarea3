package InterfazGrafica;

import java.awt.*;
import javax.swing.JPanel;
import Logica.Moneda;

public class VistaMoneda extends JPanel {
    private Moneda moneda;

    public VistaMoneda(Moneda moneda) {
        this.moneda = moneda;

        // Establecer el tamaño de la vista de la moneda
        setPreferredSize(new Dimension(20, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la moneda en el panel
        g.setColor(obtenerColorMoneda(moneda));
        g.fillOval(0, 0, getWidth(), getHeight());
    }

    private Color obtenerColorMoneda(Moneda moneda) {
        if (moneda.getValor() == 100) {
            return Color.YELLOW;
        } else if (moneda.getValor() == 500) {
            return Color.BLUE;
        } else if (moneda.getValor() == 1000) {
            return Color.GREEN;
        } else {
            return Color.RED;
        }
    }
}
