package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{
    private Comprador comprador;
    //Constructor
    public PanelComprador(){
        super();
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(500,100));
        this.setLayout(new GridLayout(1,4));
        JPanel p1 = new JPanel();
        p1.setBackground(Color.magenta);
        this.add(p1);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.BLUE);
        this.add(p2);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.GREEN);
        this.add(p3);
        JPanel p4 = new JPanel();
        p4.setBackground(Color.RED);
        this.add(p4);
    }
}
