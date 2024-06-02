package InterfazGrafica.PanelesSeleccionTipoProducto;

import InterfazGrafica.PanelComprador;
import InterfazGrafica.PanelExpendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionCocacola extends JPanel{
    private final TipoProducto coca = TipoProducto.COCACOLA;
    //Constructor
    public PanelSeleccionCocacola(){
        this.setOpaque(false);
        this.setBounds(241, 230, 37, 57);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelExpendedor.setProducto(coca);
            }
        });
    }
}
