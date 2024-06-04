package InterfazGrafica;

import InterfazGrafica.PanelesMonedas.GestorSeleccionMonedas;
import InterfazGrafica.PanelesSeleccionTipoProducto.GestorSeleccion;
import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBuy extends JPanel {
    // Constructor
    public PanelBuy() {
        super();
        this.setOpaque(false);
        this.setBounds(311, 358, 74, 37);

        // Cambiar el cursor del mouse al estilo "hand"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    PanelComprador.setComprador(new Comprador(PanelComprador.getMoneda(), PanelExpendedor.getProducto(), PanelExpendedor.getExpendedor()));
                    //ACA SE PUEDE HACER NULL LA MONEDA DEL COMPRADOR PARA DAR LA IMPRESION DE QUE SU MONEDA SE LA LLAVO EL EXPENDEDOR Y POR TANTO SE QUEDA SIN MONEDA
                    PanelComprador.setMoneda(null);
                    PanelPrincipal.getPanelExpendedor().repaint();
                    GestorSeleccion.deseleccionarTodos();
                    GestorSeleccionMonedas.deseleccionarTodos();
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
            }
        });
    }
}
