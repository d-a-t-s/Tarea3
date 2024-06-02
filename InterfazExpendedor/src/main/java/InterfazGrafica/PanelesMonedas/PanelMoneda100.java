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
    private final Image imagenMoneda100;
    private final Moneda100 moneda100 = new Moneda100();
    //Constructor
    public PanelMoneda100(){
        super();
        this.setOpaque(false);
        imagenMoneda100 = new ImageIcon(getClass().getClassLoader().getResource("moneda100.png")).getImage();

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){ //Que tan bueno es instanciar de nuevo a "moneda" por cada click?
                PanelComprador.setMoneda(moneda100);
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda100, 10, -4, null);
    }
}
