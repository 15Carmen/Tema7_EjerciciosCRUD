package ejercicio02;

public class Articulo {
    //Declaramos los atributos

    /**
     * Atributo que guardará el codigo del artículo
     */
    private int codigo;

    /**
     * Atributo que guardará la descripción del artículo
     */
    private String descripcion;

    /**
     * Atributo que guardará el precio de compra del artículo
     */
    private double precioCompra;

    /**
     * Atributo que guardará el precio de venta del artículo
     */
    private double precioVenta;

    /**
     * Atributo que guardará el numero de unidades en stock del artículo
     */
    private int stock;

    //Creamos los constructores

    /**
     * Constructor por defecto
     */
    public Articulo() {

    }

    /**
     * Constructor con parámetros
     * @param codigo
     * @param descripcion
     * @param precioCompra
     * @param precioVenta
     * @param stock
     */
    public Articulo(int codigo, String descripcion, double precioCompra, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    //Creamos los métodos get y set

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    //Creamos el método toString
    @Override
    public String toString() {

        //Creamos una variable para almacenar el texto
        String texto;
        texto = "Código: " + codigo + " Descripción: " + descripcion + " Precio de compra: " + precioCompra + " Precio de venta: " + precioVenta + " Stock: " + stock;

        return texto;
    }
}
