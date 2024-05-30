package InterfazGrafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelMoneda extends JPanel {
    private List<Moneda> listaMonedas;

    public PanelMoneda() {
        listaMonedas = new ArrayList<>();

        // Panel para los botones (en la parte superior)
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 5, 5)); // Cuadrícula 2x2 con espacio entre componentes
        JButton btnMoneda100 = new JButton("Add 100");
        JButton btnMoneda500 = new JButton("Add 500");
        JButton btnMoneda1000 = new JButton("Add 1000");
        JButton btnMoneda1500 = new JButton("Add 1500");

        // Agregar ActionListener a cada botón
        btnMoneda100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarMoneda(new Moneda100());
            }
        });

        btnMoneda500.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarMoneda(new Moneda500());
            }
        });

        btnMoneda1000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarMoneda(new Moneda1000());
            }
        });

        btnMoneda1500.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarMoneda(new Moneda1500());
            }
        });

        panelBotones.add(btnMoneda100);
        panelBotones.add(btnMoneda500);
        panelBotones.add(btnMoneda1000);
        panelBotones.add(btnMoneda1500);

        // Panel para las monedas
        JPanel panelMonedas = new JPanel();
        panelMonedas.setLayout(new BoxLayout(panelMonedas, BoxLayout.Y_AXIS));

        // Agregar los botones y el panel de monedas al panel principal
        add(panelBotones, BorderLayout.NORTH);
        add(panelMonedas, BorderLayout.CENTER);
    }

    public void agregarMoneda(Moneda moneda) {
        VistaMoneda vistaMoneda = new VistaMoneda(moneda);
        JPanel panelMonedas = (JPanel) getComponent(1); // Obtener el panel de monedas

        if (listaMonedas.size() >= 5) {
            panelMonedas.remove(4);
        }

        // Agregar la moneda al principio de la lista y al panel de monedas
        listaMonedas.add(0, moneda);
        panelMonedas.add(vistaMoneda, 0); // Agregar la moneda al principio del panel
        revalidate();
        repaint();
    }
}
