package Logica;
/**
 * Subclase de Producto, define un producto en especifico
 */
public class Snicker extends Producto{
    /**
     * Constructor de Snickers
     * @param serie, Define la serie del producto
     */
    public Snicker(int serie) {
        super(serie);
    }

    /**
     * Metodo sabor, Nos brinda el producto que hemos consumido
     * @return Producto
     */
    public String sabor() {
        return "Snickers";
    }
}
