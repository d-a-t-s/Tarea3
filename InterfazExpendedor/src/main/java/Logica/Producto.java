package Logica;
/**
 * Clase abstrata Producto representa un Producto genérico.
 */
public abstract class Producto {
    /**
     * Serie del producto
     */
    protected int serieProducto;

    /**
     * Constructor del producto
     * @param serie Define que serie/codigo tendra el producto
     */
    public Producto (int serie) {
        this.serieProducto = serie;
    }

    /**
     * Metodo abstracto para el producto
     * @return Nos dirá el sabor del producto que hemos consumido
     */
    public abstract String sabor();
}
