package InterfazGrafica;

import Logica.Moneda100;
import Logica.Moneda1000;
import Logica.Moneda1500;
import Logica.Moneda500;

import javax.swing.*;
import java.awt.*;

/**
 * PanelInsertarMoneda es una clase que representa el área de la interfaz gráfica
 * donde se muestran las imágenes de las monedas disponibles para ser insertadas.
 */
public class PanelInsertarMoneda extends JPanel{


    /**
     * Constructor de la clase PanelInsertarMoneda.
     * Inicializa el panel y lo configura para que sea transparente y tenga un tamaño específico.
     */
    public PanelInsertarMoneda(){
        super();
        this.setOpaque(false);
        this.setBounds(307, 310, 33, 33);
    }

    /**
     * Método para pintar los componentes del panel.
     * @param g El objeto Graphics usado para pintar los componentes.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
