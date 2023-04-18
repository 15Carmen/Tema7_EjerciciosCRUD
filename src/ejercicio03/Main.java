package ejercicio03;

import java.util.Scanner;

/**
 * Clase principal
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
        int opcion;
        int contador = 0;
        int posicion;
        Pizza[] pedidos = new Pizza[0];

        do {
            Metodos.pintarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    if (contador > 0) {
                        Metodos.listaPedidos(pedidos);
                    } else {
                        System.err.println("No hay pedidos en la lista.");
                    }
                }
                case 2 -> {
                    posicion = Metodos.posicionLibre(pedidos);
                    pedidos = Metodos.nuevoPedido(pedidos, posicion);
                    if (posicion < 0) {
                        contador++;
                    }
                }
                case 3 -> {
                    if (Metodos.cambioEstado(pedidos) < 0) {
                        System.err.println("El código introducido no existe o la pizza ya ha sido servida.");
                    }
                }
                case 4 -> {
                    if (Metodos.cuentaPizzas(pedidos) != 0) {
                        System.err.println("No se puede cerrar la jornada laboral, aún hay " + Metodos.cuentaPizzas(pedidos)
                                + " pizza(s) sin entregar.");
                    }
                }
                case 5 -> System.out.println("Hasta luego.");
                default -> System.out.println("Esa opción no está contemplada.");
            }

        } while (opcion != 5);
    }
}
