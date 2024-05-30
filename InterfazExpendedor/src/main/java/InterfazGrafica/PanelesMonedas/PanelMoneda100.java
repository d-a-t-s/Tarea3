package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import Logica.Moneda;
import Logica.Moneda100;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda100 extends JPanel{
    private Image imagenMoneda100;
    //Constructor
    public PanelMoneda100(){
        super();
        this.setOpaque(false);
        imagenMoneda100 = new ImageIcon(getClass().getClassLoader().getResource("moneda100.png")).getImage();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda100, 10, -4, null);
    }
}
