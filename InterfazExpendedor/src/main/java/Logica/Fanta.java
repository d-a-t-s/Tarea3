package Logica;
/**
 *  Subclase de Producto, define un producto en especifico
 */
public class Fanta extends Producto {
    /**
     * Constructor de Fanta
     * @param serie, define la serie de Fanta
     */
    public Fanta(int serie) {
        super(serie);
    }

    /**
     * Metodo sabor Define el producto que hemos consumido
     * @return Producto
     */

    public String sabor() {
        return "Fanta";
    }
}
