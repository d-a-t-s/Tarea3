package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelDepositoCoca extends JPanel{
    public PanelDepositoCoca(){
        super();
        this.setOpaque(false);
        this.setBounds(103, 230, 130, 70);
    }
    //Incompleta
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image imagenCoca = new ImageIcon(getClass().getClassLoader().getResource("Cocacola.png")).getImage();
        for(int i = 0; i < 9; i++){
            //g.drawImage(imagenCoca, )
        }
    }
}
