package ejercicio01;

import java.util.Scanner;

/**
 * Clase principal donde gestionaremos los alumnos
 */
public class Main {

    //Declaramos un scanner para leer por teclado
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opcion; //Variable que guarda la opción que elige el usuario

        //Declaramos un array de alumnos de 30 posiciones
        Alumno[] arrayAlumnos = new Alumno[30];

        do {
            pintarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Estos son nuestr@s alumn@s");
                    listado(arrayAlumnos);
                }
                case 2 -> {
                    crearAlumno(arrayAlumnos);
                }
                case 3 -> {
                   if (modificarAlumno(arrayAlumnos)) {
                        System.out.println("Alumno modificado con éxito");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                }
                case 4 -> {
                    borrarAlumno(arrayAlumnos);
                }
                case 5 -> {
                    System.out.println("Adios!!");
                }
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 5);
    }

    /**
     * Método que pinta el menú por pantalla
     */
    private static void pintarMenu() {
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
     * Método que muestra el listado de alumnos
     *
     * @param arrayAlumnos Array de alumnos
     */
    private static void listado(Alumno[] arrayAlumnos) {

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
    private static void crearAlumno(Alumno[] arrayAlumnos) {

        //Declaramos las variables
        String nombre;      //Variable donde guardaremos el nombre del alumno
        double notaMedia;   //Variable donde guardaremos la nota media del alumno

        //Pedimos los datos por teclado al usuario
        System.out.println("Introduce el nombre del alumno");
        nombre = sc.next();
        System.out.println("Introduce la nota media del alumno");
        notaMedia = sc.nextDouble();

        //Recorremos el array de alumnos
        for (int i = 0; i < arrayAlumnos.length; i++) {
            //Si la posición del array es null, es que no hay ningún alumno en esa posición
            if (arrayAlumnos[i] == null) {
                //Creamos un nuevo alumno y lo guardamos en la posición i del array
                arrayAlumnos[i] = new Alumno(nombre, notaMedia);
                break;
            }
        }

    }

    /**
     * Precondición: El nombre del alumno debe existir
     * Método que modifica la nota del alumno que elija el usuario
     * Postcondición: El nombre del alumno no se puede modificar, solo la nota media
     *
     * @param arrayAlumnos Array de alumnos
     * @return
     */
    private static boolean modificarAlumno(Alumno[] arrayAlumnos) {
        //Declaramos las variables
        String nombre;      //Variable donde guardaremos el nombre del alumno
        double notaMedia;   //Variable donde guardaremos la nota media del alumno
        boolean encontrado = true; //Variable que nos indica si el nombre del alumno ha sido encontrado

        //Pedimos los datos por teclado al usuario
        System.out.println("Introduce el nombre del alumno que quieres modificar");
        nombre = sc.next();

        //Recorremos el array de alumnos
        for (Alumno alumno : arrayAlumnos) {
            //Si el alumno no es nulo y el nombre del alumno es igual al nombre que ha introducido el usuario
            if (alumno != null && alumno.getNombre().equalsIgnoreCase(nombre)) {
                //Pedimos la nueva nota media
                System.out.println("Introduce la nueva nota media del alumno");
                notaMedia = sc.nextDouble();
                //Modificamos la nota media del alumno
                alumno.setNotaMedia(notaMedia);
                break;
            }else {
                encontrado = false;
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
    private static void borrarAlumno(Alumno[] arrayAlumnos) {

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