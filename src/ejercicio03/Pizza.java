package ejercicio03;

/**
 * Clase donde definiremos el objeto pizza
 */
public class Pizza {

    //Declaramos los atributos de la clase
    /**
     * Atributo que guardará un valor diferente en cada pizza
     */
    private int codigo;

    /**
     * Atributo que guardará el tamaño de la pizza
     */
    enum Tamanio {
        Mediana, Familiar
    }
    private Tamanio tamanio = Tamanio.Mediana;

    /**
     * Atributo que guardará el tipo de pizza
     */
    enum Tipo {
        Margarita, CuatroQuesos, Funghi
    }
    private Tipo tipo = Tipo.Margarita;

    /**
     * Atributo que guardará el estado de la pizza
     */
    enum Estado {
        Pedida, Servida
    }
    private Estado estado = Estado.Pedida;

    //Declaramos los constructores

    /**
     * Constructor por defecto
     */
    public Pizza() {
    }

    /**
     * Constructor con parámetros
     * @param codigo
     * @param tamanio
     * @param tipo
     * @param estado
     */
    public Pizza(int codigo, String tamanio, String tipo, String estado) {
        this.codigo = codigo;
        this.tamanio = Tamanio.valueOf(tamanio);
        this.tipo = Tipo.valueOf(tipo);
        this.estado = Estado.valueOf(estado);
    }

    //Declaramos los getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTamanio() {
        return String.valueOf(tamanio);
    }

    public void setTamanio(String tamanio) {
        this.tamanio = Tamanio.valueOf(tamanio);
    }

    public String getTipo() {
        return String.valueOf(tipo);
    }

    public void setTipo(String tipo) {
        this.tipo = Tipo.valueOf(tipo);
    }

    public String getEstado() {
        return String.valueOf(estado);
    }

    public void setEstado(String estado) {
        this.estado = Estado.valueOf(estado);
    }


    /**
     * Método que devuelve un String con los datos de la pizza
     * @return
     */
    @Override
    public String toString() {
        return "Código: " + codigo + "; Tamaño: " + tamanio + "; Tipo = " + tipo + "; Estado = " + estado + "";

    }
}
