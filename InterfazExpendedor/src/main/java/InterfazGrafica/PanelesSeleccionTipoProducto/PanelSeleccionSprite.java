package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionSprite extends JPanel{
    private final TipoProducto sprite = TipoProducto.SPRITE;
    //Constructor
    public PanelSeleccionSprite(){
        this.setOpaque(false);
        this.setBounds(241, 310, 37, 57);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelExpendedor.setProducto(sprite);
            }
        });
    }
}
