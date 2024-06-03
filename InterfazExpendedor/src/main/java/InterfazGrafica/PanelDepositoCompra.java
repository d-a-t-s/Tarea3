package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDepositoCompra extends JPanel{
    private final Image imagenCoca = new ImageIcon(getClass().getClassLoader().getResource("Cocacola.png")).getImage();
    private final Image imagenSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
    private final Image imagenFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
    private final Image imagenSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();
    private final Image imagenSnicker = new ImageIcon(getClass().getClassLoader().getResource("Snicker.png")).getImage();
    private int producto;
    private Expendedor expendedor;
    //Constructor
    public PanelDepositoCompra(Expendedor expendedor){
        super();
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(319, 532, 58, 61);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e){
                expendedor.setProducto(null);
                repaint();
                PanelSuperior.getPanelProductoComprado().setProducto(producto);
                PanelSuperior.getPanelProductoComprado().repaint();

            }
        });


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
            if(expendedor.getProducto() == null){
                producto = 0;
            }else if(expendedor.getProducto().getClass() == CocaCola.class){
                g.drawImage(imagenCoca, 18, 15, null);
                producto = 1;
            }else if(expendedor.getProducto().getClass() == Sprite.class){
                g.drawImage(imagenSprite, 18, 15, null);
                producto = 2;
            }else if(expendedor.getProducto().getClass() == Fanta.class){
                g.drawImage(imagenFanta, 18, 15, null);
                producto = 3;
            }else if(expendedor.getProducto().getClass() == Super8.class){
                g.drawImage(imagenSuper8, 20, 15, null);
                producto = 4;
            }else if(expendedor.getProducto().getClass() == Snicker.class){
                g.drawImage(imagenSnicker, 20, 15, null);
                producto = 5;
            }
    }
}
