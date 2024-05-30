package InterfazGrafica.PanelesMonedas;

import javax.swing.*;
import java.awt.*;

public class PanelMoneda1000 extends JPanel{
    private Image imagenMoneda1000;
    //Constructor
    public PanelMoneda1000(){
        super();
        this.setOpaque(false);
        imagenMoneda1000 = new ImageIcon(getClass().getClassLoader().getResource("moneda1000.png")).getImage();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMoneda1000, 10, -4, null);
    }
}
