package InterfazGrafica;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * PanelProductoComprado es una clase que representa el panel que muestra el producto comprado.
 * Muestra una imagen del producto comprado dentro de un borde.
 */
public class PanelProductoComprado extends JPanel{
    private Color color;
    private int producto = 0;
    private final Image cocaCompra = new ImageIcon(getClass().getClassLoader().getResource("CocacolaCompra.png")).getImage();
    private final Image spriteCompra = new ImageIcon(getClass().getClassLoader().getResource("SpriteCompra.png")).getImage();
    private final Image fantaCompra = new ImageIcon(getClass().getClassLoader().getResource("FantaCompra.png")).getImage();
    private final Image super8Compra = new ImageIcon(getClass().getClassLoader().getResource("Super8Compra.png")).getImage();
    private final Image snickerCompra = new ImageIcon(getClass().getClassLoader().getResource("SnickerCompra.png")).getImage();

    /**
     * Constructor de la clase PanelProductoComprado.
     * Inicializa el panel y lo configura como no opaco. Establece el tamaño y la ubicación del panel.
     */
    public PanelProductoComprado(){
        super();
        this.setOpaque(false);
        this.setBounds(250, 10, 80, 80);
    }

    /**
     * Método para pintar el componente.
     * @param g El objeto Graphics usado para pintar el componente.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        color = new Color(0,0,0);
        Border border = BorderFactory.createLineBorder(color, 3);
        this.setBorder(border);
        if(producto == 0){
            // No se muestra ninguna imagen si no hay producto seleccionado
        }else if(producto == 1){
            g.drawImage(cocaCompra, 5,7, null);
        }else if(producto == 2){
            g.drawImage(spriteCompra, 5,7, null);
        }else if(producto == 3){
            g.drawImage(fantaCompra, 5,7, null);
        }else if(producto == 4){
            g.drawImage(super8Compra, 5,7, null);
        }else if(producto == 5){
            g.drawImage(snickerCompra, 5,7, null);
        }
    }

    /**
     * Método para establecer el producto que se muestra en el panel.
     * @param n El número del producto.
     */
    public void setProducto(int n){
        producto = n;
    }
}
