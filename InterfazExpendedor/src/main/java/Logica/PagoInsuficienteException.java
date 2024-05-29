package Logica;
/**
 * Esta clase corresponde a la excepcion en el caso de que se intente comprar con una moneda inferior al precion del producto
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Metodo constructor de la clase que crea una excepcion con un mensaje especificado
     * @param errorMessage mensaje de que se imprime en pantalla cuando dicha excepcion es lanzada
     */
    public PagoInsuficienteException(String errorMessage){
        super(errorMessage);
        System.out.println(errorMessage);
    }
}