package Logica;
/**
 * Subclase de Producto, define un producto en especifico
 */
public class Sprite extends Producto {
    /**
     * Constructor de Sprite
     * @param serie, Define la serie del producto
     */
    public Sprite(int serie) {
        super(serie);
    }

    /**
     * Metodo sabor, define el producto que hemos consumido
     * @return Producto
     */
    public String sabor() {
        return "Sprite";
    }
}