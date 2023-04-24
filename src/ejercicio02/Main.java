package ejercicio02;

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
        Articulo[] arrayArticulos = new Articulo[30];

        do {
            Metodos.pintarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    Metodos.listado(arrayArticulos);
                }
                case 2 -> {
                    Metodos.alta(arrayArticulos);
                }
                case 3 -> {
                   Metodos.baja(arrayArticulos);
                }
                case 4 -> {
                    if (Metodos.modificar(arrayArticulos)) {
                        System.out.println("Artículo modificado con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }
                case 5 -> {
                    if (Metodos.entradaMercancia(arrayArticulos)){
                        System.out.println("Artículos añadidos con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }
                case 6 -> {
                    if (Metodos.salidaMercancia(arrayArticulos)){
                        System.out.println("Artículos retirados con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }
                case 7 -> {
                    System.out.println("Adios!!");
                }
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 7);
    }


}
