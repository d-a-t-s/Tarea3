package Logica;
/**
 * Esta clase permite permite comprar un producto dado una moneda un entero y una referencia a un expendedor
 */
public class Comprador{
    private String sonido;
    private int vuelto;

    /**
     * Este metodo corresponde al constructor de Comprador, y es el responsable de realizar "la compra" dada una moneda, un entero y una referencia a un expendedor
     * @param m Corresponde a la moneda con la que se quiere comprar un producto del expendedor
     * @param producto Conrresponde a un objeto de tipo TipoProducto con el que se selecccion el tipo de producto que se quiere comprar
     * @param exp Corresponde al expendedor (referencia) en el que se realiza la compra
     * @throws PagoIncorrectoException Excepcion en el caso de que se intente comprar sin moneda (moneda nula)
     * @throws PagoInsuficienteException Excepcion en el caso de que el pago sea menor al precio del producto
     * @throws NoHayProductoException Excepcion en el caso de que el deposito del expendedor esté vacío o se ingrese un tipo de producto erroneo
     */
    public Comprador(Moneda m, TipoProducto producto, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto p = exp.comprarProducto(m, producto);
        sonido = p.sabor();
        while(true){
            Moneda monedita = exp.getVuelto();
            if(monedita == null){
                break;
            }else{
                vuelto = vuelto + monedita.getValor();
            }
        }
    }

    /**
     * Este metodo permite obtener el vuelto en el caso de que la compra se haya realizado correctamente
     * @return Retorna un entero que corresponde al total del vuelto del usuario
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    /**
     * Este metodo permite saber que es lo que el usuario a consumido si la compra de ha realizado correctamente
     * @return Retorna un string que corresponde al nombre del producto en letras minúsculas
     */
    public String queConsumiste(){
        return sonido;
    }
}
