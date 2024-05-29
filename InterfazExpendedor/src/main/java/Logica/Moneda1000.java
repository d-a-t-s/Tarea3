package Logica;
/**
 * Subclase de Moneda
 */
public class Moneda1000 extends Moneda{
    /**
     * Constructor de Moneda1000, llama al metodo constructor de la superclase
     */
    public Moneda1000(){
        super();
    }
    /**
     * Obtiene el valor de la moneda
     * @return Devuelve el valor de la moneda como un entero
     */
    public int getValor(){
        return 1000;
    }
}
