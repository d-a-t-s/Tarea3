package Logica;

/**
 * Esta enumeracion ofrece constantes para poder seleccionar el tipo de producto ademas de asignar a cada tipo de producto un precio diferente
 */
public enum TipoProducto {
    COCACOLA(100){ //Precio anterior 400
        @Override
        public Producto createProducto(int serie){
            return new CocaCola(serie);
        }
    },
    SPRITE(500){
        @Override
        public Producto createProducto(int serie){
            return new Sprite(serie);
        }
    },
    FANTA(800){ //Precio anterior 600
        @Override
        public Producto createProducto(int serie){
            return new Fanta(serie);
        }
    },
    SUPER8(1000){ //Precio anterior 700
        @Override
        public Producto createProducto(int serie){
            return new Super8(serie);
        }
    },
    SNICKER(1200){ //Precio anterior 800
        @Override
        public Producto createProducto(int serie){
            return new Snicker(serie);
        }
    };
    private final int precio;

    /**
     * Metodo constructor de TipoProducto que inicializa a "tipo" y "precio"
     * @param precio corresponde al precio de cada producto
     */
    TipoProducto(int precio) {
        this.precio = precio;
    }

    public int getPrecio(){
        return precio;
    }

    public abstract Producto createProducto(int serie);
}
