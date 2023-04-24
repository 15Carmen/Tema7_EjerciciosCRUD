package ejercicio03;

import java.util.Arrays;
import java.util.Scanner;

public class Metodos {

    //Declaramos un scanner para leer por teclado
    static Scanner sc = new Scanner(System.in);

    /**
     * Método que pintará el menu por pantalla
     */
    public static void pintarMenu() {
        System.out.println("""
                Introduzca la opción que desee:
                [1] Mostrar todos los pedidos
                [2] Añadir un pedido
                [3] Cambiar el estado de un pedido
                [4] Salir""");
    }

    /**
     * Método que comprueba si una posición del array de pedidos está libre
     * @param pedidos array de pedidos
     * @return devuelve la posición libre o -1 si no hay posiciones libres
     */
    public static int posicionLibre(Pizza[] pedidos) {
        int posicion = 0;

        while (posicion < pedidos.length && pedidos[posicion] != null) {
            posicion++;
        }
        if (posicion == pedidos.length) {
            posicion = -1;
        }

        return posicion;
    }

    /**
     * Método que muestra la lista de pedidos por consola
     * @param pedidos array de pedidos
     */
    public static void listaPedidos(Pizza[] pedidos) {

        for (Pizza pizza : pedidos) {
            if (pizza != null) {
                System.out.println(pizza);
            }
        }
    }

    /**
     * Método que crea un nuevo pedido
     * @param pedidos array de pedidos
     * @param posicion posición del pedido en el array
     * @return devuelve el array de pedidos
     */
    public static Pizza[] nuevoPedido(Pizza[] pedidos, int posicion) {

        //Si hay una posición libre
        if (posicion >= 0) {
            //Creamos un nuevo pedido
            pedidos[posicion] = new Pizza(posicion, tamanyoPizza(), tipoPizza(), "Servida");
        } else {    //Si no hay posiciones libres
            //Creamos un nuevo array con una posición más
            pedidos = Arrays.copyOf(pedidos, pedidos.length + 1);

            //Si la posición es -1, la posición será la última del array
            if (posicion == -1) {
                posicion = pedidos.length - 1;
            }

            //Creamos el nuevo pedido en la última posición del array
            pedidos[pedidos.length - 1] = new Pizza(posicion, tamanyoPizza(), tipoPizza(), "Pedida");
        }

        //Devolvemos el array de pedidos
        return pedidos;
    }



    /**
     * Método donde le pedimos al usuario que elija el tamaño de la pizza a través de un menú
     * @return devuelve el tamaño de la pizza
     */
    public static String tamanyoPizza() {

        //Declaramos las variables
        int opcion;             //Variable para guardar la opción del usuario
        String tamanyo = "";    //Variable para guardar el tamaño de la pizza

        do {    //Le pedimos el tamaño de la pizza al usuario mientras no elija una opción válida

            //Mostramos el menú por pantalla
            System.out.println("""
            Introduzca el tamaño de su pizza:
            [1] Mediana
            [2] Familiar
            """);
            //Guardamos la opción elegida por el usuario
            opcion = sc.nextInt();

            switch (opcion) {
                case 1-> { //Si la opción es 1, el tamaño será mediana
                    tamanyo = String.valueOf(Pizza.Tamanio.Mediana);
                }
                case 2-> {  //Si la opción es 2, el tamaño será familiar
                    tamanyo = String.valueOf(Pizza.Tamanio.Familiar);
                }
                default->   tamanyo = "Opción no válida";
            }
        } while (opcion != 1 && opcion != 2);

        return tamanyo;
    }

    /**
     * Método donde le pedimos al usuario que elija el tipo de pizza
     * @return devuelve el tipo de pizza
     */
    public static String tipoPizza() {
        //Declaramos las variables
        int opcion;     //Variable para guardar la opción del usuario
        String tipo;    //Variable para guardar el tipo de pizza

        do {    //Le pedimos el tipo de pizza al usuario mientras no elija una opción válida

            //Mostramos el menú por pantalla
            System.out.println("""
            Introduzca el tamaño de su pizza:
            [1] Cuatro quesos
            [2] Funghi
            [3] Margarita
            """);
            //Guardamos la opción elegida por el usuario
            opcion = sc.nextInt();

            switch (opcion) {
                case 1-> { //Si la opción es 1, el tipo será Cuatro quesos
                    tipo = String.valueOf(Pizza.Tipo.CuatroQuesos);
                }
                case 2-> {  //Si la opción es 2, el tipo será Funghi
                    tipo = String.valueOf(Pizza.Tipo.Funghi);
                }
                case 3-> {  //Si la opción es 3, el tipo será Margarita
                    tipo = String.valueOf(Pizza.Tipo.Margarita);
                }
                default->   tipo = "Opción no válida";
            }
        } while (opcion < 1 || opcion > 3);

        //Devolvemos el tipo de pizza
        return tipo;
    }

    /**
     * Método que cambia el estado de un pedido de "Pedida" a "Servida"
     * @param pedidos array de pedidos
     */
    public static void cambioEstado(Pizza[] pedidos) {
        //Declaramos las variables
        int codigo;     //Variable para guardar el código de la pizza
        int indice = 0; //Variable para guardar el índice de la pizza

        //Pedimos el código de la pizza
        System.out.println("Introduzca el código de la pizza: ");
        codigo = sc.nextInt();

        //Si el código es menor que 0 o mayor que el tamaño del array o el estado de la pizza es distinto de "Servida" devolverá -1
        if (codigo < 0 || codigo >= pedidos.length
                || pedidos[codigo] == null && pedidos[codigo].getEstado().equals("Servida")) {
            indice = -1;
        } else {    //Si no, cambia el estado de la pizza a "Servida"
            pedidos[codigo].setEstado("Servida");
        }
    }

}
