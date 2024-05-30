package InterfazGrafica.PanelesMonedas;

import javax.swing.*;
import java.awt.*;

public class PanelMoneda1500 extends JPanel{
    private Image imagenMoneda1500;
    //Constructor
    public PanelMoneda1500(){
        super();
        this.setOpaque(false);
        imagenMoneda1500 = new ImageIcon(getClass().getClassLoader().getResource("moneda1500.png")).getImage();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda1500, 10, -4, null);
    }
}
