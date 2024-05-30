package InterfazGrafica.PanelesProductos;

import Logica.Expendedor;
import Logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PanelDepositoFanta extends JPanel{
    private Expendedor expendedor;
    private int numFanta;
    Image imagenFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
    //Constructor
    public PanelDepositoFanta(Expendedor expendedor){
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(201,300);
        this.expendedor = expendedor;
        this.numFanta = expendedor.getDepositos().get(2).getNumeroProductos();
        this.setOpaque(false);
        this.setBounds(103, 390, 130, 70);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(numFanta < 9){
                    expendedor.getDepositos().get(2).addObjeto(TipoProducto.FANTA.createProducto(randomNum));
                    numFanta = expendedor.getDepositos().get(2).getNumeroProductos();
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < numFanta; i++){
            g.drawImage(imagenFanta, 5+i*12, 16, null);
        }
    }
}
