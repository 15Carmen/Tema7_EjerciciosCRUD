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
        this.nombre = "";
        this.notaMedia = 0;
    }

    /**
     * Constructor con parámetros
     * @param nombre
     * @param notaMedia
     */
    public Alumno(String nombre, double notaMedia) {
        this.nombre = nombre;

        if (notaMedia < 0) {
            this.notaMedia = 0;
        }else if (notaMedia > 10) {
            this.notaMedia = 10;
        }else {
            this.notaMedia = notaMedia;
        }
    }

    //Creamos los métodos get y set

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
        if (notaMedia < 0) {
            this.notaMedia = 0;
        }else if (notaMedia > 10) {
            this.notaMedia = 10;
        }else {
            this.notaMedia = notaMedia;
        }
    }

    //Creamos el método toString
    @Override
    public String toString() {
        String texto;
        texto = "Nombre: " + nombre + "; Nota media: " + notaMedia;

        return texto;
    }
}
