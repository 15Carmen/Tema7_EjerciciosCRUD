package ejercicio02;

import java.util.Scanner;

/**
 * Clase principal donde gestionaremos el almacén
 */
public class Main {

    //Declaramos un scanner para leer por teclado
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opcion; //Variable que guarda la opción que elige el usuario

        //Declaramos un array de artículos de 30 posiciones
        Articulo[] arrayArticulos = new Articulo[30];

        do {
            Metodos.pintarMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1 -> {
                    System.out.println("Estos son nuestros artículos");
                    Metodos.listado(arrayArticulos);
                }

                case 2 -> {
                    Metodos.alta(arrayArticulos);
                }

                case 3 -> {
                    Metodos.baja(arrayArticulos);
                }

                case 4-> {
                    if (Metodos.modificar(arrayArticulos)) {
                        System.out.println("Artículo modificado con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }

                case 5 -> {
                    if (Metodos.entradaMercancia(arrayArticulos)) {
                        System.out.println("Entrada de mercancía realizada con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }

                case 6 -> {
                    if (Metodos.salidaMercancia(arrayArticulos)) {
                        System.out.println("Salida de mercancía realizada con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }

                case 7 -> System.out.println("Hasta pronto");

            }

        }while (opcion != 7);
    }






}
