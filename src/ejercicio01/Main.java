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
            Metodos.pintarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Estos son nuestr@s alumn@s");
                    Metodos.listado(arrayAlumnos);
                }
                case 2 -> {
                    Metodos.crearAlumno(arrayAlumnos);
                }
                case 3 -> {
                   if (Metodos.modificarAlumno(arrayAlumnos)) {
                        System.out.println("Alumno modificado con éxito");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                }
                case 4 -> {
                    if (Metodos.borrarAlumno(arrayAlumnos)) {
                        System.out.println("Alumno borrado con éxito");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                }
                case 5 -> {
                    System.out.println("Adios!!");
                }
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 5);
    }


}