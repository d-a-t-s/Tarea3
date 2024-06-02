package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionSnicker extends JPanel{
    private final TipoProducto snicker = TipoProducto.SNICKER;
    //Constructor
    public PanelSeleccionSnicker(){
        this.setOpaque(false);
        this.setBounds(241, 550, 37, 57);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelExpendedor.setProducto(snicker);
            }
        });
    }
}
