package InterfazGrafica;

import InterfazGrafica.PanelesDepositosProductos.*;
import InterfazGrafica.PanelesSeleccionTipoProducto.*;
import Logica.*;
import javax.swing.*;
import java.awt.*;

/**
 * PanelExpendedor es una clase que representa el área de la interfaz gráfica
 * donde se muestra el expendedor y se interactúa con él.
 */
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
    private PanelBuy panelBuy;
    private PanelDepositoVuelto panelDepositoVuelto;
    private PanelDepositoMonedas panelDepositoMonedas;
    private PanelDepositoCompra panelDepositoCompra;
    private static Expendedor expendedor;
    private static TipoProducto producto;
    private JPanel test;

    /**
     * Constructor de la clase PanelExpendedor.
     * Inicializa el panel y todos sus componentes, incluyendo los paneles para
     * el depósito de productos, la selección de productos, la inserción de monedas,
     * la devolución de cambio y la compra.
     */
    public PanelExpendedor(){
        super();
        expendedor = new Expendedor(5);
        producto = null;
        imagenExpendedor = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        Dimension size = new Dimension(imagenExpendedor.getWidth(null), imagenExpendedor.getHeight(null));
        this.setPreferredSize(size);
        this.setLayout(null);

        // Añadir panel para el depósito del producto comprado
        panelDepositoCompra = new PanelDepositoCompra(expendedor);
        this.add(panelDepositoCompra);

        // Añadir paneles para devolución de cambio y compra
        panelDepositoVuelto = new PanelDepositoVuelto(expendedor);
        this.add(panelDepositoVuelto);
        panelDepositoMonedas = new PanelDepositoMonedas(expendedor);
        this.add(panelDepositoMonedas);

        // Añadir paneles para la selección de productos
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

        // Añadir paneles para los productos
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

        // Añadir panel para la compra
        panelBuy = new PanelBuy();
        this.add(panelBuy);
    }

    /**
     * Método para pintar los componentes del panel.
     * @param g El objeto Graphics usado para pintar los componentes.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
        panelDepositoCoca.repaint(); // Repintar el depósito de Coca-Cola
    }

    /**
     * Método estático para obtener el expendedor asociado al panel.
     * @return El expendedor asociado al panel.
     */
    public static Expendedor getExpendedor(){
        return expendedor;
    }

    /**
     * Método estático para establecer el expendedor asociado al panel.
     * @param exp El expendedor a establecer.
     */
    public static void setExpendedor(Expendedor exp){
        expendedor = exp;
    }

    /**
     * Método estático para obtener el tipo de producto seleccionado.
     * @return El tipo de producto seleccionado.
     */
    public static TipoProducto getProducto(){
        return producto;
    }

    /**
     * Método estático para establecer el tipo de producto seleccionado.
     * @param prod El tipo de producto a establecer.
     */
    public static void setProducto(TipoProducto prod){
        producto = prod;
    }
}
