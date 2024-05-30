package InterfazGrafica;

import InterfazGrafica.PanelesMonedas.PanelMoneda100;
import InterfazGrafica.PanelesMonedas.PanelMoneda1000;
import InterfazGrafica.PanelesMonedas.PanelMoneda1500;
import InterfazGrafica.PanelesMonedas.PanelMoneda500;
import Logica.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelComprador extends JPanel{
    private Comprador comprador;
    protected Moneda moneda;
    private PanelMoneda100 panelMoneda100;
    private PanelMoneda500 panelMoneda500;
    private PanelMoneda1000 panelMoneda1000;
    private PanelMoneda1500 panelMoneda1500;
    private Color color;
    //Constructor
    public PanelComprador(){
        super();
        color = new Color(100, 149, 237);
        this.setBackground(color);
        this.setPreferredSize(new Dimension(500,100));
        this.setLayout(new GridLayout(1,4));
        color = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(color, 5);
        this.setBorder(border);

        //PanelesMonedas
        panelMoneda100 = new PanelMoneda100();
        this.add(panelMoneda100);
        panelMoneda100.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){ //Que tan bueno es instanciar de nuevo a "moneda" por cada click?
                moneda = new Moneda100();
            }
        });
        panelMoneda500 = new PanelMoneda500();
        this.add(panelMoneda500);
        panelMoneda500.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                moneda = new Moneda500();
            }
        });
        panelMoneda1000 = new PanelMoneda1000();
        this.add(panelMoneda1000);
        panelMoneda1000.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                moneda = new Moneda1000();
            }
        });
        panelMoneda1500 = new PanelMoneda1500();
        this.add(panelMoneda1500);
        panelMoneda1500.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                moneda = new Moneda1500();
            }
        });
    }

}
