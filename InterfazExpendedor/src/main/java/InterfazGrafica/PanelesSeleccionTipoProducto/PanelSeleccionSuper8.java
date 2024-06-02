package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionSuper8 extends JPanel{
    private final TipoProducto super8 = TipoProducto.SUPER8;
    //Constructor
    public PanelSeleccionSuper8(){
        this.setOpaque(false);
        this.setBounds(241, 470, 37, 57);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelExpendedor.setProducto(super8);
            }
        });
    }
}
