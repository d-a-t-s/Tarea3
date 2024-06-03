package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBuy extends JPanel{
    //Constructor
    public PanelBuy(){
        super();
        this.setOpaque(false);
        this.setBounds(311, 358, 74, 37);

        // Cambiar el cursor del mouse al estilo "hand"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e){
                try{
                    PanelComprador.setComprador(new Comprador(PanelComprador.getMoneda(), PanelExpendedor.getProducto(), PanelExpendedor.getExpendedor()));
                    //ACA SE PUEDE HACER NULL LA MONEDA DEL COMPRADOR PARA DAR LA IMPRESION DE QUE SU MONEDA SE LA LLAVO EL EXPENDEDOR Y POR TANTO SE QUEDA SIN MONEDA
                    PanelComprador.setMoneda(null);
//                    PanelPrincipal.getPanelComprador().repaint();
                    PanelPrincipal.getPanelExpendedor().repaint();
//                    System.out.println("Producto: " + PanelComprador.getComprador().queConsumiste());
//                    System.out.println("VUELTO: " + PanelComprador.getComprador().cuantoVuelto());
                }catch(Logica.PagoIncorrectoException PagoIncorrectoException){
                    System.out.println("Para comprar debe introducir una moneda primero\n");
                }catch(Logica.PagoInsuficienteException PagoInsuficienteException){
                    System.out.println("El pago que a ingresado es menor al precio del producto\n");
                }catch(NoHayProductoException NoHayProductoException){
                    System.out.println("El deposito está vacio o no se ingreso un tipo de producto\n");
                }finally{
                    PanelComprador.setMoneda(null);
                    PanelPrincipal.getPanelExpendedor().repaint();
                }
            }
        });
    }
}
