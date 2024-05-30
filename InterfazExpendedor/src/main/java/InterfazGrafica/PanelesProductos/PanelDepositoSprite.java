package InterfazGrafica.PanelesProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PanelDepositoSprite extends JPanel{
    private Expendedor expendedor;
    private int numSprite;
    Image imagenSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
    //Constructor
    public PanelDepositoSprite(Expendedor expendedor){
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(101,200);
        this.expendedor = expendedor;
        this.numSprite = expendedor.getDepositos().get(1).getNumeroProductos();
        this.setOpaque(false);
        this.setBounds(103, 310, 130, 70);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(numSprite < 9){
                    expendedor.getDepositos().get(1).addObjeto(TipoProducto.SPRITE.createProducto(randomNum));
                    numSprite = expendedor.getDepositos().get(1).getNumeroProductos();
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < numSprite; i++){
            g.drawImage(imagenSprite, 5+i*12, 16, null);
        }
    }
}

