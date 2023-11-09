package Tarea;
/** valores y lo asociado a cada tipo de producto. */
public enum TipoProductos {
    /** bebida Coca Cola. */
    COCA_COLA("Coca Cola", 1200) {
        @Override
        public CocaCola crearProducto(int serie) {
            return new CocaCola(serie);
        }
    },
    /** bebida Fanta. */
    FANTA("Fanta", 1000) {
        @Override
        public Fanta crearProducto(int serie) {
            return new Fanta(serie);
        }
    },
    /**bebida Sprite. */
    SPRITE("Sprite", 1000) {
        @Override
        public Sprite crearProducto(int serie) {
            return new Sprite(serie);
        }
    },
    /** dulce Snickers. */
    SNICKERS("Snickers", 800) {
        @Override
        public Snickers crearProducto(int serie) {
            return new Snickers(serie);
        }
    },
    /** Representa el dulce Super ocho. */
    SUPEROCHO("Super ocho", 300) {
        @Override
        public SuperOcho crearProducto(int serie) {
            return new SuperOcho(serie);
        }
    };
    /** Texto para el tipo del producto. */
    private final String tipo;
    /** El valor del producto. */
    private final int precio;
    /** Crea un tipo de producto
     * @param tipo El tipo del producto
     * @param precio El valor del producto */
    TipoProductos(String tipo, int precio) {
        this.tipo = tipo;
        this.precio = precio;
    }
    /** da el tipo del producto.
     * @return El tipo del producto. */
    public String getTipo() {
        return this.tipo;
    }
    /** da el valor del producto.
     * @return El valor del producto. */
    public int getPrecio() {
        return this.precio;
    }
    public static TipoProductos valueOf(int cardinal) {
        if (cardinal < 0 || cardinal > TipoProductos.values().length - 1) return null;
        return TipoProductos.values()[cardinal];
    }
    /** Crea un producto de este tipo.
     * @param serie La serie del producto.
     * @return El producto de este tipo. */
    public abstract Producto crearProducto(int serie);
}