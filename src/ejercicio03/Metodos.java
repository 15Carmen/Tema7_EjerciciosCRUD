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
                [4] Cerrar la jornada laboral
                [5] Salir""");
    }

    /**
     * Método que muestra los pedidos
     * @param pedidos lista de pedidos
     */
    public static void muestraPedidos(Pizza[] pedidos) {

        for (Pizza pizza : pedidos) {
            if (pizza != null) {
                System.out.println(pizza);
            }
        }
    }

    /**
     * Método que añade un pedido
     * @param pedidos lista de pedidos
     * @param posicion posición del pedido
     * @return devuelve la lista de pedidos
     */
    public static Pizza[] nuevoPedido(Pizza[] pedidos, int posicion) {

        if (posicion >= 0) {
            sc.nextLine();

            pedidos[posicion] = new Pizza(posicion, eligeTamanyo(), eligeTipo(), "Servida");
        } else {
            pedidos = Arrays.copyOf(pedidos, pedidos.length + 1);
            sc.nextLine();

            if (posicion == -1) {
                posicion = pedidos.length - 1;
            }

            pedidos[pedidos.length - 1] = new Pizza(posicion, eligeTamanyo(), eligeTipo(), "Pedida");
        }

        return pedidos;
    }

    /**
     * Método que comprueba si una posion del array de pedidos está libre
     * @param pedidos lista de pedidos
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
     * Método donde le pedimos al usuario que elija el tamaño de la pizza
     * @return devuelve el tamaño de la pizza
     */
    public static String eligeTamanyo() {
        int opcion;
        String tamanio = "";

        do {
            System.out.println("""
            Introduzca el tamaño de su pizza:
            [1] Mediana
            [2] Familiar
            """);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    tamanio = String.valueOf(Pizza.Tamanio.Mediana);
                    break;
                case 2:
                    tamanio = String.valueOf(Pizza.Tamanio.Familiar);
                    break;
                default:
                    tamanio = "Esa opción no está contemplada";
            }
        } while (opcion != 1 && opcion != 2);

        return tamanio;
    }

    /**
     * Método donde le pedimos al usuario que elija el tipo de pizza
     * @return devuelve el tipo de pizza
     */
    public static String eligeTipo() {
        int opcion;
        String tipo;

        do {
            System.out.println("""
            Introduzca el tamaño de su pizza:
            [1] Cuatro quesos
            [2] Funghi
            [3] Margarita
            """);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    tipo = String.valueOf(Pizza.Tipo.CuatroQuesos);
                    break;
                case 2:
                    tipo = String.valueOf(Pizza.Tipo.Funghi);
                    break;
                case 3:
                    tipo = String.valueOf(Pizza.Tipo.Margarita);
                    break;
                default:
                    tipo = "No tenemos este tipo de pizza";
            }
        } while (opcion <= 0 || opcion > 3);

        return tipo;
    }

    /**
     * Método que cambia el estado de un pedido
     * @param pedidos lista de pedidos
     * @return  devuelve la posición del pedido
     */
    public static int cambioEstado(Pizza[] pedidos) {
        //Declaramos las variables

        int codigo;
        int indice = 0;

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

        return indice;
    }

    /**
     * Métod que cuenta las pizzas pedidas
     * @param pedidos lista de pedidos
     * @return el total de pizzas pedidas
     */
    public static int cuentaPizzas(Pizza[] pedidos) {
        int pedida = 0;

        for (Pizza pizza : pedidos) {
            if (pizza.getEstado().equals("Pedida")) {
                pedida++;
            }
        }

        if (pedida == 0) {
            pedidos = new Pizza[0];
        }
        return pedida;
    }
}
