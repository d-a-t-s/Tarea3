package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import Logica.Moneda1000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda1000 extends JPanel{
    private final Image imagenMoneda1000;
    private final Moneda1000 moneda1000 = new Moneda1000();
    //Constructor
    public PanelMoneda1000(){
        super();
        this.setOpaque(false);
        imagenMoneda1000 = new ImageIcon(getClass().getClassLoader().getResource("moneda1000.png")).getImage();

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelComprador.setMoneda(moneda1000);
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda1000, 10, -4, null);
    }
}
