package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;

/**
 * GestorSeleccionMonedas es una clase que gestiona la selección de paneles de monedas
 * en la interfaz gráfica.
 */
public class GestorSeleccionMonedas {
    private static PanelSeleccionable ultimoPanelSeleccionado;

    /**
     * Selecciona un panel de monedas. Si el panel ya estaba seleccionado, lo deselecciona.
     *
     * @param panel el panel de monedas que se va a seleccionar.
     */
    public static void seleccionarPanel(PanelSeleccionable panel) {
        if (ultimoPanelSeleccionado != null && ultimoPanelSeleccionado == panel) {
            ultimoPanelSeleccionado.setSeleccionado(false);
            ultimoPanelSeleccionado = null;
        } else {
            if (ultimoPanelSeleccionado != null) {
                ultimoPanelSeleccionado.setSeleccionado(false);
            }
            panel.setSeleccionado(true);
            ultimoPanelSeleccionado = panel;
        }
    }

    /**
     * Deselecciona todos los paneles de monedas.
     */
    public static void deseleccionarTodos() {
        if (ultimoPanelSeleccionado != null) {
            ultimoPanelSeleccionado.setSeleccionado(false);
            ultimoPanelSeleccionado = null;
        }
    }
}
