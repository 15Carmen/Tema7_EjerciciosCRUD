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
        //Declaramos las variables
        int opc;            //Variable que guarda la opción introducida por el usuario
        int contador = 0;   //Variable que usaremos para saber cuantas pizzas están pedidas
        Pizza[] arrayPedidos = new Pizza[0]; //Array de pedidos

        do {
            //Mostramos el menu por consola y guardamos la opción que el usuario elija
            Metodos.pintarMenu();
            opc = sc.nextInt();
            switch (opc) {
                case 1 -> { //Mostramos los pedidos
                    if (contador > 0) { //Si hay pedidos
                        Metodos.listaPedidos(arrayPedidos); //Mostramos la lista de ellos
                    } else {    //Si no hay pedidos se lo indiucamos al usuario
                        System.err.println("No hay pedidos en la lista.");
                    }
                }
                case 2 -> { //Añadimos un nuevo pedido
                    //Añadimos un nuevo pedido al array de pedidos en la primera posición libre
                    arrayPedidos = Metodos.nuevoPedido(arrayPedidos, Metodos.posicionLibre(arrayPedidos));
                    if (Metodos.posicionLibre(arrayPedidos) < 0) { //Si la posición libre es mayor que 0
                        contador++; //Aumentamos el contador de pedidos
                    }
                }
                case 3 -> { //Cambiamos el estado de un pedido
                    //Si el método cambioEstado devuelve un valor menor que 0 es que el código introducido no existe o la pizza ya ha sido servida
                    if (Metodos.cambioEstado(arrayPedidos) < 0) {
                        System.err.println("El pedido introducido no existe o ya ha sido servido");
                    }
                }
                case 4 ->  System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida");
            }

        } while (opc != 4);
    }
}
