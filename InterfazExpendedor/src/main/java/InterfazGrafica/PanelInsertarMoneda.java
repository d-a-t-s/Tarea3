package InterfazGrafica;

import Logica.Moneda100;
import Logica.Moneda1000;
import Logica.Moneda1500;
import Logica.Moneda500;

import javax.swing.*;
import java.awt.*;

public class PanelInsertarMoneda extends JPanel{
    private final Image moneda100chiquita = new ImageIcon(getClass().getClassLoader().getResource("moneda100chiquita.png")).getImage();
    private final Image moneda500chiquita = new ImageIcon(getClass().getClassLoader().getResource("moneda500chiquita.png")).getImage();
    private final Image moneda1000chiquita = new ImageIcon(getClass().getClassLoader().getResource("moneda1000chiquita.png")).getImage();
    private final Image moneda1500chiquita = new ImageIcon(getClass().getClassLoader().getResource("moneda1500chiquita.png")).getImage();
    //Constructor
    public PanelInsertarMoneda(){
        super();
        this.setOpaque(false);
        this.setBounds(307, 310, 33, 33);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}
