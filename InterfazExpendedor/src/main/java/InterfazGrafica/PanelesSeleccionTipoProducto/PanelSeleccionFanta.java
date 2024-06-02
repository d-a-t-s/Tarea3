package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionFanta extends JPanel{
    private final TipoProducto fanta = TipoProducto.FANTA;
    //Constructor
    public PanelSeleccionFanta(){
        this.setOpaque(false);
        this.setBounds(241, 390, 37, 57);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelExpendedor.setProducto(fanta);
            }
        });
    }
}
