package ejercicio01;

/**
 * Clase Alumno donde guardaremos el nombre del alumno y su nota media
 */
public class Alumno {

    //Declaramos los atributos

    /**
     * Atributo que guardará el nombre del alumno
     */
    private String nombre;

    /**
     * Atributo que guardará la nota media del alumno
     */
    private double notaMedia;

    //Creamos los constructores

    /**
     * Constructor por defecto
     */
    public Alumno() {
    }

    /**
     * Constructor con parámetros
     * @param nombre
     * @param notaMedia
     */
    public Alumno(String nombre, double notaMedia) {
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    //Creamos los métodos get y set

    //TODO: Hacer comprobaciones en los setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaMedia() {
        return notaMedia;
    }
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    //Creamos el método toString
    @Override
    public String toString() {
        String texto;
        texto = "Nombre: " + nombre + "; Nota media: " + notaMedia;

        return texto;
    }
}
