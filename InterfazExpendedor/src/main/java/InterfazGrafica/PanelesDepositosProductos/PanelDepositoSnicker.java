package InterfazGrafica.PanelesDepositosProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PanelDepositoSnicker extends JPanel{
    private Expendedor expendedor;
    private final Image imagenSnicker = new ImageIcon(getClass().getClassLoader().getResource("Snicker.png")).getImage();
    //Constructor
    public PanelDepositoSnicker(Expendedor expendedor){
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(401,500);
        this.expendedor = expendedor;
        this.setOpaque(false);
        this.setBounds(103, 550, 130, 70);

        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(expendedor.getDepositos().get(4).getNumeroProductos() < 9){
                    expendedor.getDepositos().get(4).addObjeto(TipoProducto.SNICKER.createProducto(randomNum));
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < expendedor.getDepositos().get(4).getNumeroProductos(); i++){
            g.drawImage(imagenSnicker, 7+i*12, 16, null);
        }
    }
}
