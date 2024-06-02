package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import Logica.Moneda1500;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda1500 extends JPanel{
    private final Image imagenMoneda1500;
    private final Moneda1500 moneda1500 = new Moneda1500();
    //Constructor
    public PanelMoneda1500(){
        super();
        this.setOpaque(false);
        imagenMoneda1500 = new ImageIcon(getClass().getClassLoader().getResource("moneda1500.png")).getImage();

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelComprador.setMoneda(moneda1500);
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda1500, 10, -4, null);
    }
}
