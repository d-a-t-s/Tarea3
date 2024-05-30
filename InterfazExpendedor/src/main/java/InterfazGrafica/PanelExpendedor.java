package InterfazGrafica;

import InterfazGrafica.PanelesProductos.*;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelExpendedor extends JPanel{
    private Image imagenExpendedor;
    private PanelDepositoCoca panelDepositoCoca;
    private PanelDepositoSprite panelDepositoSprite;
    private PanelDepositoFanta panelDepositoFanta;
    private PanelDepositoSuper8 panelDepositoSuper8;
    private PanelDepositoSnicker panelDepositoSnicker;
    private PanelBuy panelBuy;
    private Expendedor expendedor;
    //Constructor
    public PanelExpendedor(){
        super();
        expendedor = new Expendedor(5);
        imagenExpendedor = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        Dimension size = new Dimension(imagenExpendedor.getWidth(null), imagenExpendedor.getHeight(null));
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setLayout(null);

        //Paneles productos
        panelDepositoCoca = new PanelDepositoCoca(expendedor);
        this.add(panelDepositoCoca);
        panelDepositoSprite = new PanelDepositoSprite(expendedor);
        this.add(panelDepositoSprite);
        panelDepositoFanta = new PanelDepositoFanta(expendedor);
        this.add(panelDepositoFanta);
        panelDepositoSuper8 = new PanelDepositoSuper8(expendedor);
        this.add(panelDepositoSuper8);
        panelDepositoSnicker = new PanelDepositoSnicker(expendedor);
        this.add(panelDepositoSnicker);

        //Panel BUY
        panelBuy = new PanelBuy();
        this.add(panelBuy);


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
    }
}
