package Logica;
/**
 * Subclase de Producto, Define un producto en especifico
 */
public class Super8 extends Producto{
    /**
     * Constructor de Super8
     * @param serie, Define la serie del producto
     */
    public Super8(int serie) {
        super(serie);
    }

    /**
     * Metodo sabor Define el producto que hemos consumido/comprado
     * @return Producto
     */
    public String sabor() {
        return "Super8";
    }
}