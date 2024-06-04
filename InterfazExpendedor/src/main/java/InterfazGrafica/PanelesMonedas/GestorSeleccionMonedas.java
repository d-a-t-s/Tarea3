package InterfazGrafica.PanelesMonedas;

import InterfazGrafica.PanelesSeleccionTipoProducto.PanelSeleccionable;

public class GestorSeleccionMonedas {
    private static PanelSeleccionable ultimoPanelSeleccionado;

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

    public static void deseleccionarTodos() {
        if (ultimoPanelSeleccionado != null) {
            ultimoPanelSeleccionado.setSeleccionado(false);
            ultimoPanelSeleccionado = null;
        }
    }
}
