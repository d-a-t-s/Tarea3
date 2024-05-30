package InterfazGrafica.PanelesProductos;


import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PanelDepositoCoca extends JPanel{
    private Expendedor expendedor;
    private int numCoca;
    Image imagenCoca = new ImageIcon(getClass().getClassLoader().getResource("Cocacola.png")).getImage();
    //Constructor
    public PanelDepositoCoca(Expendedor expendedor){
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt(0,100);
        this.expendedor = expendedor;
        this.numCoca = expendedor.getDepositos().get(0).getNumeroProductos();
        this.setOpaque(false);
        this.setBounds(103, 230, 130, 70);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(numCoca < 9){
                    expendedor.getDepositos().get(0).addObjeto(TipoProducto.COCACOLA.createProducto(randomNum));
                    numCoca = expendedor.getDepositos().get(0).getNumeroProductos();
                    repaint();
                }
            }
        });

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < numCoca; i++){
            g.drawImage(imagenCoca, 5+i*12, 16, null);
        }
    }
}
