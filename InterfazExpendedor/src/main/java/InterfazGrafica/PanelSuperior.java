package InterfazGrafica;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelSuperior extends JPanel{
    private final Image imagenMonedero = new ImageIcon(getClass().getClassLoader().getResource("Monedero.png")).getImage();
    private static PanelProductoComprado panelProductoComprado;
    private Color color;
    private static int vuelto;
    //Constructor
    public PanelSuperior(){
        super();
        this.setLayout(null);
        panelProductoComprado = new PanelProductoComprado();
        this.add(panelProductoComprado);
        vuelto = 0;
        color = new Color(100, 149, 237);
        this.setBackground(color);
        this.setPreferredSize(new Dimension(500,100));
//        this.setLayout(new GridLayout(1,4));
        color = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(color, 5);
        this.setBorder(border);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenMonedero, 30, 12, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Vuelto:", 130, 45);
        g.drawString(String.valueOf(vuelto), 130, 75);
//        g.drawRect(250, 10, 80, 80);
//        g.drawRect(251, 11, 78, 78);
        g.drawString("Producto", 355, 45);
        g.drawString("Comprado", 355, 70);
    }
    public static void setVuelto(int n){
        vuelto = vuelto + n;
    }
    public static PanelProductoComprado getPanelProductoComprado(){
        return panelProductoComprado;
    }
}
