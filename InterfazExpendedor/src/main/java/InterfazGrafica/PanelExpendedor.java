package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel{
    private Image imagenExpendedor;
    //Constructor
    public PanelExpendedor(){
        super();
        imagenExpendedor = new ImageIcon("Resources/test.jpg").getImage();
        Dimension size = new Dimension(imagenExpendedor.getWidth(null), imagenExpendedor.getHeight(null));
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
    }
}
