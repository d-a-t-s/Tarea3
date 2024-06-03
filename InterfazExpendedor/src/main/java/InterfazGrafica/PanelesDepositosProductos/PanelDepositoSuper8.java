package InterfazGrafica.PanelesDepositosProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PanelDepositoSuper8 extends JPanel{
    private Expendedor expendedor;
    private int numSuper8;
    private final Image imagenSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();
    //Constructor
    public PanelDepositoSuper8(Expendedor expendedor){
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(301,400);
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(103, 470, 130, 70);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(expendedor.getDepositos().get(3).getNumeroProductos() < 9){
                    expendedor.getDepositos().get(3).addObjeto(TipoProducto.SUPER8.createProducto(randomNum));
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < expendedor.getDepositos().get(3).getNumeroProductos(); i++){
            g.drawImage(imagenSuper8, 7+i*12, 16, null);
        }
    }
}
