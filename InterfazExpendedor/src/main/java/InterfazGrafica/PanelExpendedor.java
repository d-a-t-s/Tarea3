package InterfazGrafica;

import InterfazGrafica.PanelesDepositosProductos.*;
import InterfazGrafica.PanelesSeleccionTipoProducto.*;
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
    private PanelSeleccionCocacola panelSeleccionCocacola;
    private PanelSeleccionSprite panelSeleccionSprite;
    private PanelSeleccionFanta panelSeleccionFanta;
    private PanelSeleccionSuper8 panelSeleccionSuper8;
    private PanelSeleccionSnicker panelSeleccionSnicker;
    private PanelInsertarMoneda panelInsertarMoneda;
    private PanelBuy panelBuy;
    private PanelDepositoVuelto panelDepositoVuelto;
    private PanelDepositoMonedas panelDepositoMonedas;
    private PanelDepositoCompra panelDepositoCompra;
    private static Expendedor expendedor;
    private static TipoProducto producto;
    private JPanel test;
    //Constructor
    public PanelExpendedor(){
        super();



        test = new JPanel();
        test.setBackground(Color.CYAN);
        test.setBounds(0,0,10,10);
        test.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                repaint();
            }
        });
        this.add(test);



        expendedor = new Expendedor(5);
        producto = null;
        imagenExpendedor = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        Dimension size = new Dimension(imagenExpendedor.getWidth(null), imagenExpendedor.getHeight(null));
        this.setPreferredSize(size);
        this.setLayout(null);
        //Panel insertar moneda
        panelInsertarMoneda = new PanelInsertarMoneda();
        this.add(panelInsertarMoneda);
        //Panel deposito del producto comprado
        panelDepositoCompra = new PanelDepositoCompra();
        this.add(panelDepositoCompra);
        //Paneles vuelto y compra
        panelDepositoVuelto = new PanelDepositoVuelto(expendedor);
        this.add(panelDepositoVuelto);
        panelDepositoMonedas = new PanelDepositoMonedas(expendedor);
        this.add(panelDepositoMonedas);
        //Paneles Seleccion de producto
        panelSeleccionCocacola = new PanelSeleccionCocacola();
        this.add(panelSeleccionCocacola);
        panelSeleccionSprite = new PanelSeleccionSprite();
        this.add(panelSeleccionSprite);
        panelSeleccionFanta = new PanelSeleccionFanta();
        this.add(panelSeleccionFanta);
        panelSeleccionSuper8 = new PanelSeleccionSuper8();
        this.add(panelSeleccionSuper8);
        panelSeleccionSnicker = new PanelSeleccionSnicker();
        this.add(panelSeleccionSnicker);
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
        panelDepositoCoca.repaint();
    }
    public static Expendedor getExpendedor(){
        return expendedor;
    }
    public static void setExpendedor(Expendedor exp){
        expendedor = exp;
    }
    public static TipoProducto getProducto(){
        return producto;
    }
    public static void setProducto(TipoProducto prod){
        producto = prod;
    }
}