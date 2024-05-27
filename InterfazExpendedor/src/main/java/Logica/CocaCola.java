package Logica;
/**
 * Define un tipo en especifico de Producto
 */
public class CocaCola extends Producto{

    /**
     * Constructor de CocaCola
     * @param serie Define la serie de la Cocacola
     */
    public CocaCola(int serie) {
        super(serie);
    }

    /**
     *
     * Metodo sabor, Nos brinda que producto hemos consumido o comprado
     * @return Producto que hemos consumido
     */
    public String sabor() {
        return "CocaCola";
    }
}
