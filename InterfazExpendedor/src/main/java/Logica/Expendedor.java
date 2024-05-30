package Logica;

import java.util.ArrayList;

/**
 * La clase Expendedor proporciona metodos para realizar compras a una maquina expendedora, y obtener el vuelto si el pago excedio el precio
 */
public class Expendedor{
    private ArrayList<Deposito<Producto>> depositos;
    /*private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snicker;*/
    private Deposito<Moneda> vuelto;

    /**
     * Este metodo corresponde al metodo constructor del expendedor y permite la instancia del mismo con un numero de igual de productos en cada deposito
     *
     * @param numProductos Almacena el un entero que corresponde al numero del productos inicial con el que se quiere instanciar el expendedor
     */
    public Expendedor(int numProductos){
        depositos = new ArrayList();
        for (TipoProducto producto : TipoProducto.values()) {
            depositos.add(producto.ordinal(), new Deposito<>());
            for (int i = 0; i < numProductos; i++){
                depositos.get(producto.ordinal()).addObjeto(producto.createProducto((producto.ordinal() + 1) * 100 + i));
            }
        }
        vuelto = new Deposito<>();


        /*coca = new Deposito<>(numProductos);
        sprite = new Deposito<>(numProductos);
        fanta = new Deposito<>(numProductos);
        super8 = new Deposito<>(numProductos);
        snicker = new Deposito<>(numProductos);
        vuelto = new Deposito<>(0);
        for (int i = 0; i < numProductos; i++) {
            coca.addObjeto(new CocaCola(i + 100));
            sprite.addObjeto(new Sprite(i + 200));
            fanta.addObjeto(new Fanta(i + 300));
            super8.addObjeto(new Super8(i + 400));
            snicker.addObjeto(new Snicker(i + 500));
    }*/
    }

    /**
     * Este metodo permite la compra de productos al expendedor ingresando el pago y eligiendo que tipo de producto quiere comprar
     *
     * @param m Corresponde a la moneda con la que se quiere pagar
     * @param producto Corresponde a un objeto de tipo TipoProducto con el que se elige el tipo de producto que se quiere comprar
     * @return En el caso de que el pago y la eleccion del tipo de producto sea correcta retorna el producto seleccionado
     * @throws PagoIncorrectoException Excepcion en caso de que se quiera comprar sin moneda (se intenta comprar con moneda null"
     * @throws PagoInsuficienteException Excepcion en caso de que el pago sea menor al precion del producto
     * @throws NoHayProductoException Excepcion en caso de que el deposito esté vacío o el se haya ingresado un tipo de producto erroneo
     */

    public Producto comprarProducto(Moneda m, TipoProducto producto) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto aux = null;
        if(m == null){ //Condicional por si se intenta pagar con momneda nula (Pagar sin moneda)
            throw new PagoIncorrectoException("PagoIncorrectoException");
        }
        if(m.getValor() < producto.getPrecio()){ //Condicional por si se intenta pagar con moneda inferior al precio
            vuelto.addObjeto(m);
            System.out.println("Vuelto = " + m.getValor());
            throw new PagoInsuficienteException("PagoInsuficienteException");
        }
        //Si no se cumplen ninguno de los if's anteriores entonces la moneda no es nula y el precio es mayor o igual al del producto
        if(producto == TipoProducto.COCACOLA){
            aux = depositos.get(0).getObjeto();
        }else if(producto == TipoProducto.SPRITE){
            aux = depositos.get(1).getObjeto();
        } else if(producto == TipoProducto.FANTA){
            aux = depositos.get(2).getObjeto();
        }else if(producto == TipoProducto.SUPER8){
            aux = depositos.get(3).getObjeto();
        }else if(producto == TipoProducto.SNICKER){
            aux = depositos.get(4).getObjeto();
        }
        if(aux == null){
            vuelto.addObjeto(m);
            System.out.println("Vuelto = " + m.getValor());
            throw new NoHayProductoException("NoHayProductoException");
        }
        int n = (m.getValor() - producto.getPrecio())/100;
        for (int i = 0; i < n; i++){
            vuelto.addObjeto(new Moneda100());
        }
        return aux;
    }

    /**
     * Este metodo permite la obtencion del vuelto en caso de que la compra se haya realizado correctamente
     * @return Retorna una moneda del deposito (en particular retorna el primer elemento del deposito de monedas)
     */
    public Moneda getVuelto(){
        return vuelto.getObjeto();
    }
    public ArrayList<Deposito<Producto>> getDepositos(){
        return depositos;
    }
}
