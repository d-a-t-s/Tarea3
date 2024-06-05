package InterfazGrafica;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * PanelSuperior es una clase que representa el panel superior de la interfaz gráfica.
 * Contiene la visualización del monedero, el vuelto y el producto comprado.
 */
public class PanelSuperior extends JPanel{
    private final Image imagenMonedero = new ImageIcon(getClass().getClassLoader().getResource("Monedero.png")).getImage();
    private static PanelProductoComprado panelProductoComprado;
    private Color color;
    private static int vuelto;

    /**
     * Constructor de la clase PanelSuperior.
     * Inicializa el panel y establece su diseño y apariencia.
     */
    public PanelSuperior(){
        super();
        this.setLayout(null);
        panelProductoComprado = new PanelProductoComprado();
        this.add(panelProductoComprado);
        vuelto = 0;
        color = new Color(100, 149, 237);
        this.setBackground(color);
        this.setPreferredSize(new Dimension(500,100));
        color = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(color, 5);
        this.setBorder(border);
    }

    /**
     * Método para pintar el componente.
     * @param g El objeto Graphics usado para pintar el componente.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMonedero, 30, 12, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Vuelto:", 130, 45);
        g.drawString(String.valueOf(vuelto), 130, 75);
        g.drawString("Producto", 355, 45);
        g.drawString("Comprado", 355, 70);
    }

    /**
     * Método estático para establecer el vuelto.
     * @param n El valor del vuelto a establecer.
     */
    public static void setVuelto(int n){
        vuelto = vuelto + n;
    }

    /**
     * Método estático para obtener el panel del producto comprado.
     * @return El panel del producto comprado.
     */
    public static PanelProductoComprado getPanelProductoComprado(){
        return panelProductoComprado;
    }
}
