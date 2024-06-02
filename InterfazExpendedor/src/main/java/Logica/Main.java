package Logica;
import javax.management.modelmbean.ModelMBean;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(10);
        Moneda m = new Moneda500();
        try{
            Comprador c = new Comprador(m, TipoProducto.COCACOLA, exp);
            System.out.println("Producto: " + exp.getProducto().sabor());
            c = new Comprador(m, TipoProducto.SNICKER, exp);
        }catch(PagoIncorrectoException PagoIncorrectoException){
            System.out.println("Para comprar debe introducir una moneda primero\n");
        }catch(PagoInsuficienteException PagoInsuficienteException){
            System.out.println("El pago que a ingresado es menor al precio del producto\n");
        }catch(NoHayProductoException NoHayProductoException){
            System.out.println("El deposito está vacio o se introdujo un numero de producto erroneo\n");
        }finally{
            int n = exp.getDepositoVuelto().getNumeroProductos();
            System.out.println(n);
            for(int i = 0; i < n; i++){
                System.out.println(exp.getVuelto().getValor());
            }
        }
        /*
        //Caso en el que se paga con una moneda, se elige un producto correcto y sobra vuelto
        try{
            exp = new Expendedor(3);
            m = new Moneda1000();
            c = new Comprador(m, TipoProducto.SNICKER, exp);
            System.out.println("Que consumiste: " + c.queConsumiste());
            System.out.println("Cuanto vuelto: " + c.cuantoVuelto() + "\n");
        }catch(PagoIncorrectoException PagoIncorrectoException){
            System.out.println("Para comprar debe introducir una moneda primero\n");
        }catch(PagoInsuficienteException PagoInsuficienteException){
            System.out.println("El pago que a ingresado es menor al precio del producto\n");
        }catch(NoHayProductoException NoHayProductoException){
            System.out.println("El deposito está vacio o se introdujo un numero de producto erroneo\n");
        }
        //Caso en el que se quiere comprar con una moneda inferior al precio del producto
        try{
            exp = new Expendedor(3);
            m = new Moneda100();
            c = new Comprador(m, TipoProducto.COCACOLA, exp);
            System.out.println("Que consumiste: " + c.queConsumiste());
            System.out.println("Cuanto vuelto: " + c.cuantoVuelto());
        }catch(PagoIncorrectoException PagoIncorrectoException){
            System.out.println("Para comprar debe introducir una moneda primero\n");
        }catch(PagoInsuficienteException PagoInsuficienteException){
            System.out.println("El pago que a ingresado es menor al precio del producto\n");
        }catch(NoHayProductoException NoHayProductoException){
            System.out.println("El deposito está vacio o se introdujo un numero de producto erroneo\n");
        }
        //El caso en el que se ingresa un numero de producto incorrecto queda obsoleto pues ahora no se adminten numeros erroneos
        //Caso en el que se ingresa un numero de producto incorrecto
        try{
            exp = new Expendedor(3);
            m = new Moneda500();
            c = new Comprador(m, 10, exp);
            System.out.println("Que consumiste: " + c.queConsumiste());
            System.out.println("Cuanto vuelto: " + c.cuantoVuelto() + "\n");
        }catch(PagoIncorrectoException PagoIncorrectoException){
            System.out.println("Para comprar debe introducir una moneda primero\n");
        }catch(PagoInsuficienteException PagoInsuficienteException){
            System.out.println("El pago que a ingresado es menor al precio del producto\n");
        }catch(NoHayProductoException NoHayProductoException){
            System.out.println("El deposito está vacio o se introdujo un numero de producto erroneo\n");
        }
        //Caso en el que se intenta comprar sin moneda (moneda nula)
        try{
            exp = new Expendedor(3);
            m = null;
            c = new Comprador(m, TipoProducto.SUPER8, exp);
            System.out.println("Que consumiste: " + c.queConsumiste());
            System.out.println("Cuanto vuelto: " + c.cuantoVuelto() + "\n");
        }catch(PagoIncorrectoException PagoIncorrectoException){
            System.out.println("Para comprar debe introducir una moneda primero\n");
        }catch(PagoInsuficienteException PagoInsuficienteException){
            System.out.println("El pago que a ingresado es menor al precio del producto\n");
        }catch(NoHayProductoException NoHayProductoException){
            System.out.println("El deposito está vacio o se introdujo un numero de producto erroneo\n");
        }
        //Caso en el que el deposito queda vacio
        try{
            m = new Moneda1500();
            exp = new Expendedor(1);
            c = new Comprador(m, TipoProducto.SPRITE, exp);
            System.out.println("Que consumiste: " + c.queConsumiste());
            System.out.println("Cuanto vuelto: " + c.cuantoVuelto() + "\n");
            Moneda m1 = new Moneda500();
            c = new Comprador(m1, TipoProducto.SPRITE, exp);
            System.out.println("Que consumiste: " + c.queConsumiste());
            System.out.println("Cuanto vuelto: " + c.cuantoVuelto() + "\n");
        }catch(PagoIncorrectoException PagoIncorrectoException){
            System.out.println("Para comprar debe introducir una moneda primero\n");
        }catch(PagoInsuficienteException PagoInsuficienteException){
            System.out.println("El pago que a ingresado es menor al precio del producto\n");
        }catch(NoHayProductoException NoHayProductoException){
            System.out.println("El deposito está vacio o se introdujo un numero de producto erroneo\n");
        }
        */
    }
}