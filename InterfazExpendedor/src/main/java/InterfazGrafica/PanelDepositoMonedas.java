package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelDepositoMonedas extends JPanel{
    private final Image monedita100 = new ImageIcon(getClass().getClassLoader().getResource("Monedita100.png")).getImage();
    private final Image monedita500 = new ImageIcon(getClass().getClassLoader().getResource("Monedita500.png")).getImage();
    private final Image monedita1000 = new ImageIcon(getClass().getClassLoader().getResource("Monedita1000.png")).getImage();
    private final Image monedita1500 = new ImageIcon(getClass().getClassLoader().getResource("Monedita1500.png")).getImage();
    private Expendedor expendedor;
    //Constructor
    public PanelDepositoMonedas(Expendedor expendedor){
        super();
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(351, 418, 26, 104);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < expendedor.getDepositoMonedas().getNumeroProductos(); i++){
            if(expendedor.getDepositoMonedas().seeObjeto(i).getClass() == Moneda100.class){
                g.drawImage(monedita100, 3, 87-i*4, null);
            }else if(expendedor.getDepositoMonedas().seeObjeto(i).getClass() == Moneda500.class){
                g.drawImage(monedita500, 3, 87-i*4, null);
            }else if(expendedor.getDepositoMonedas().seeObjeto(i).getClass() == Moneda1000.class){
                g.drawImage(monedita1000, 3, 87-i*4, null);
            }else if(expendedor.getDepositoMonedas().seeObjeto(i).getClass() == Moneda1500.class){
                g.drawImage(monedita1500, 3, 87-i*4, null);
            }
        }
    }
}
