package Logica;
/**
 * Subclase de Moneda
 */
public class Moneda100 extends Moneda{
    /**
     * Constructor de Moneda100, llama al metodo constructor de la superclase
     */
    public Moneda100(){
        super();
    }

    /**
     * Obtiene el valor de la moneda
     * @return Devuelve el valor de la moneda como un entero
     */
    public int getValor() {
        return 100;
    }
}
