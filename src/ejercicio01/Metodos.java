package ejercicio01;

import ejercicio03.Pizza;

import java.util.Scanner;

public class Metodos {

    //Declaramos un scanner para leer por teclado
    static Scanner sc = new Scanner(System.in);

    /**
     * Método que pinta el menú por pantalla
     */
    public static void pintarMenu() {
        System.out.println("""
                 ALUMNOS/AS
                 ===================
                 1. Listado.
                 2. Nuevo Alumno.
                 3. Modificar.
                 4. Borrar.
                 5. Salir.
                """);

    }

    /**
     * Método que comprueba si una posion del array de pedidos está libre
     *
     * @param arrayAlumnos lista de alumnos
     * @return devuelve la posición libre o -1 si no hay posiciones libres
     */
    public static int posicionLibre(Alumno[] arrayAlumnos) {
        //Declaramos las variables
        int posicion = 0;   //Variable que guarda la posición libre

        //Mientras la posición sea menor que el tamaño del array y el alumno en esa posición no sea nulo, seguimos buscando
        while (posicion < arrayAlumnos.length && arrayAlumnos[posicion] != null) {
            posicion++;
        }
        //Si la posición es igual al tamaño del array, indicamos que no hay posiciones libres
        if (posicion == arrayAlumnos.length) {
            posicion = -1;
        }

        //Devolvemos la posición
        return posicion;
    }


    /**
     * Método que busca en el array de alumnos si existe el alumno que le pasamos por parámetro
     *
     * @param arrayAlumnos Array de alumnos
     * @param nombre       Nombre del alumno que le pedimos al usuario
     * @return true si encuentra al alumno, false si no lo encuentra
     */
    public static boolean busquedaAlumno(Alumno[] arrayAlumnos, String nombre) {
        //Declaramos las variables
        boolean encontrado = false;

        //Recorremos el array de alumnos
        for (Alumno arrayAlumno : arrayAlumnos) {
            //Si el alumno no es nulo y el nombre coincide, indicamos que lo hemos encontrado
            if (arrayAlumno != null && arrayAlumno.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Método que muestra el listado de alumnos
     *
     * @param arrayAlumnos Array de alumnos
     */
    public static void listado(Alumno[] arrayAlumnos) {

        //Recorremos el array de alumnos
        for (Alumno alumno : arrayAlumnos) {
            //Si el alumno no es nulo, lo mostramos por pantalla
            if (alumno != null) {
                System.out.println(alumno);
            }
        }
    }

    /**
     * Método que le pregunta al usuario los datos del alumno y los guarda en el array
     */
    public static void crearAlumno(Alumno[] arrayAlumnos) {

        //Declaramos las variables
        String nombre;      //Variable donde guardaremos el nombre del alumno
        double notaMedia;   //Variable donde guardaremos la nota media del alumno

        //Pedimos los datos por teclado al usuario
        System.out.println("Introduce el nombre del alumno");
        nombre = sc.next();
        sc.nextLine();
        System.out.println("Introduce la nota media del alumno");
        notaMedia = sc.nextDouble();
        sc.nextLine();

        //Si la posición del array es null, es que no hay ningún alumno en esa posición
        if (posicionLibre(arrayAlumnos) != -1) {
            //Creamos un nuevo alumno y lo guardamos en la posición i del array
            arrayAlumnos[posicionLibre(arrayAlumnos)] = new Alumno(nombre, notaMedia);
        }

    }

    /**
     * Precondición: El nombre del alumno debe existir
     * Método que modifica la nota del alumno que elija el usuario
     * Postcondición: El nombre del alumno no se puede modificar, solo la nota media
     *
     * @param arrayAlumnos Array de alumnos
     * @return Devuelve true si el alumno ha sido modificado y false si no ha sido encontrado
     */
    public static boolean modificarAlumno(Alumno[] arrayAlumnos) {
        //Declaramos las variables
        String nombre;      //Variable donde guardaremos el nombre del alumno
        double notaMedia;   //Variable donde guardaremos la nota media del alumno
        boolean encontrado = false; //Variable que nos indica si el nombre del alumno ha sido encontrado

        //Pedimos los datos por teclado al usuario
        System.out.println("Introduce el nombre del alumno que quieres modificar");
        nombre = sc.next();

        //Recorremos el array de alumnos
        for (Alumno alumno : arrayAlumnos) {
            //Si el alumno no es nulo y el nombre del alumno es igual al nombre que ha introducido el usuario
            if (alumno != null && alumno.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                //Pedimos la nueva nota media
                System.out.println("Introduce la nueva nota media del alumno");
                notaMedia = sc.nextDouble();
                //Modificamos la nota media del alumno
                alumno.setNotaMedia(notaMedia);
                break;
            }
        }

        return encontrado;
    }

    /**
     * Método que borra el alumno que elija el usuario, es decir lo pone a null
     *
     * @param arrayAlumnos Array de alumnos
     * @return
     */
    public static void borrarAlumno(Alumno[] arrayAlumnos) {

        //Declaramos las variables
        String nombre;      //Variable donde guardaremos el nombre del alumno

        //Le pedimos al usuario el nombre del alumno que quiere borrar
        System.out.println("Introduce el nombre del alumno que quieres borrar");
        nombre = sc.next();

        //Recorremos el array de alumnos
        for (int i = 0; i < arrayAlumnos.length; i++) {
            //Si el alumno no es nulo y el nombre del alumno es igual al nombre que ha introducido el usuario
            if (arrayAlumnos[i] != null && arrayAlumnos[i].getNombre().equalsIgnoreCase(nombre)) {
                //Borramos el alumno
                arrayAlumnos[i] = null;
                break;
            }
        }

    }
}
