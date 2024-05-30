package InterfazGrafica;

import Logica.*;
import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel{
    private Image imagenExpendedor;
    private PanelDepositoCoca panelDepositoCoca;
    private Expendedor expendedor;
    //Constructor
    public PanelExpendedor(){
        super();
        imagenExpendedor = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        Dimension size = new Dimension(imagenExpendedor.getWidth(null), imagenExpendedor.getHeight(null));
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setLayout(null);

        panelDepositoCoca = new PanelDepositoCoca();
        this.add(panelDepositoCoca);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
    }
}
