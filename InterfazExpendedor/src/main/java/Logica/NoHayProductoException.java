package Logica;
/**
 * Esta clase corresponde a la excepcion en el caso de que el tipo de producto ingresado por el usuario sea erroneo o el deposito esté vacio
 */
public class NoHayProductoException extends Exception{
    /**
     * Metodo constructor de la clase que crea una excepcion con un mensaje especificado
     * @param errorMessage mensaje de que se imprime en pantalla cuando dicha excepcion es lanzada
     */
    public NoHayProductoException(String errorMessage){
        super(errorMessage);
        System.out.println(errorMessage);
    }
}
