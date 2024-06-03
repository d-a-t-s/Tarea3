package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelComprador;
import Logica.Moneda;
import Logica.Moneda500;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMoneda500 extends JPanel{
    private final Image imagenMoneda500;
    //Constructor
    public PanelMoneda500(){
        super();
        this.setOpaque(false);
        imagenMoneda500 = new ImageIcon(getClass().getClassLoader().getResource("moneda500.png")).getImage();

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                PanelComprador.setMoneda(new Moneda500());
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda500, 10, -4, null);
    }
}
