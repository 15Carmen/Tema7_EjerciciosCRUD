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
        GESTISIMAL[] arrayArticulos = new GESTISIMAL[30];

        do {
            pintarMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1 -> {
                    System.out.println("Estos son nuestros artículos");
                    listado(arrayArticulos);
                }

                case 2 -> {
                    alta(arrayArticulos);
                }

                case 3 -> {
                    baja(arrayArticulos);
                }

                case 4-> {
                    if (modificar(arrayArticulos)) {
                        System.out.println("Artículo modificado con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }

                case 5 -> {
                    if (entradaMercancia(arrayArticulos)) {
                        System.out.println("Entrada de mercancía realizada con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }

                case 6 -> {
                    if (salidaMercancia(arrayArticulos)) {
                        System.out.println("Salida de mercancía realizada con éxito");
                    } else {
                        System.out.println("Artículo no encontrado");
                    }
                }

                case 7 -> System.out.println("Hasta pronto");

            }

        }while (opcion != 7);
    }

    /**
     * Método que pinta el menú por pantalla
     */
    private static void pintarMenu(){
        System.out.println("""
                
                ===============================
                GESTION SIMPLIFICADA DE ALMACEN
                ===============================
                [1] Listado
                [2] Alta
                [3] Baja
                [4] Modificación
                [5] Entrada de mercancía
                [6] Salida de mercancía
                [7] Salir
                                
                """);
    }

    /**
     * Método que muestra por pantalla el listado de artículos en el almacén
     * @param arrayArticulos
     */
    private static void listado(GESTISIMAL[] arrayArticulos) {
        for (GESTISIMAL arrayArticulo : arrayArticulos) {
            if (arrayArticulo != null) {
                System.out.println(arrayArticulo);
            }
        }

    }

    /**
     * Método que da de alta un artículo en el almacén, es decir, creamos un nuevo objeto GESTISIMAL
     * y lo guardamos en el array de artículos
     * @param arrayArticulos Array de artículos al que añadiremos el nuevo objeto GESTISIMAL
     */
    private static void alta(GESTISIMAL[] arrayArticulos){
        //Declaramos las variables
        int codigo; //Variable que guardará el código del artículo
        String descripcion; //Variable que guardará la descripción del artículo
        double precioCompra; //Variable que guardará el precio de compra del artículo
        double precioVenta; //Variable que guardará el precio de venta del artículo
        int stock; //Variable que guardará el stock del artículo

        //Pedimos los datos por teclado
        System.out.println("Introduce la descripción del artículo");
        descripcion = sc.next();
        System.out.println("Introduce el precio de compra del artículo");
        precioCompra = sc.nextDouble();
        System.out.println("Introduce el precio de venta del artículo");
        precioVenta = sc.nextDouble();
        System.out.println("Introduce el stock del artículo");
        stock = sc.nextInt();

        //Recorremos el array de artículos
        for (int i = 0; i < arrayArticulos.length; i++) {
            //Si la posición del array está vacía, creamos un nuevo objeto GESTISIMAL y lo guardamos en esa posición
            if (arrayArticulos[i] == null){
                codigo = i;
                arrayArticulos[i] = new GESTISIMAL(codigo, descripcion, precioCompra, precioVenta, stock);
                break;
            }
        }
    }

    /**
     * Método que da de baja un artículo del almacén, es decir, borramos el objeto GESTISIMAL del array de artículos
     * @param arrayArticulos Array de artículos del que borramos el objeto GESTISIMAL
     */
    private static void baja(GESTISIMAL[] arrayArticulos){
        //Declaramos las variables
        int codigo; //Variable que guardará el código del artículo que queremos dar de baja

        //Pedimos el código del artículo que queremos dar de baja
        System.out.println("Introduce el código del artículo que quieres dar de baja");
        codigo = sc.nextInt();

        //Recorremos el array de artículos
        for (int i = 0; i < arrayArticulos.length; i++) {
            //Si la posición del array no está vacía y el código del artículo es igual al código que hemos introducido
            //entonces borramos el artículo
            if (arrayArticulos[i] != null && arrayArticulos[i].getCodigo() == codigo){
                arrayArticulos[i] = null;
                break;
            }
        }
    }

    /**
     * Método que modifica el artículo del almacén que el usuario elija
     *
     * @param arrayArticulos Array de artículos que queremos modificar
     * @return  Devuelve true si el artículo ha sido modificado y false si no ha sido encontrado
     */
    private static boolean modificar(GESTISIMAL[] arrayArticulos){
        //Declaramos las variables
        int codigo; //Variable que guardará el código del artículo que queremos modificar
        boolean encontrado = true; //Variable que nos dirá si el artículo ha sido encontrado o no

        //Pedimos el código del artículo que queremos modificar
        System.out.println("Introduce el código del artículo que quieres modificar");
        codigo = sc.nextInt();

        //Recorremos el array de artículos
        for (GESTISIMAL arrayArticulo : arrayArticulos) {
            //Si la posición del array no está vacía y el código del artículo es igual al código que hemos introducido
            //entonces modificamos el artículo
            if (arrayArticulo != null && arrayArticulo.getCodigo() == codigo) {
                //Declaramos las variables
                String descripcion; //Variable que guardará la descripción del artículo
                double precioCompra; //Variable que guardará el precio de compra del artículo
                double precioVenta; //Variable que guardará el precio de venta del artículo
                int stock; //Variable que guardará el stock del artículo

                //Pedimos los datos por teclado
                System.out.println("Introduce la descripción del artículo");
                descripcion = sc.next();
                System.out.println("Introduce el precio de compra del artículo");
                precioCompra = sc.nextDouble();
                System.out.println("Introduce el precio de venta del artículo");
                precioVenta = sc.nextDouble();
                System.out.println("Introduce el stock del artículo");
                stock = sc.nextInt();

                arrayArticulo.setDescripcion(descripcion);
                arrayArticulo.setPrecioCompra(precioCompra);
                arrayArticulo.setPrecioVenta(precioVenta);
                arrayArticulo.setStock(stock);
                break;
            } else {
                encontrado = false;
            }
        }
        return encontrado;
    }

    /**
     * Método que permite al usuario introducir la entrada de mercancía en el almacén, es decir,
     * aumenta el stock del artículo que el usuario elija
     * @param arrayArticulos Array de artículos que queremos modificar
     * @return  Devuelve true si el artículo ha sido encontrado y false si no
     */
    private static boolean entradaMercancia(GESTISIMAL[] arrayArticulos){
        //Declaramos las variables
        int codigo; //Variable que guardará el código del artículo que queremos modificar
        boolean encontrado = true; //Variable que nos dirá si el artículo ha sido encontrado o no

        //Pedimos el código del artículo que queremos modificar
        System.out.println("Introduce el código del artículo que quieres modificar");
        codigo = sc.nextInt();

        //Recorremos el array de artículos
        for (GESTISIMAL arrayArticulo : arrayArticulos) {
            //Si la posición del array no está vacía y el código del artículo es igual al código que hemos introducido
            //entonces modificamos el artículo
            if (arrayArticulo != null && arrayArticulo.getCodigo() == codigo) {
                //Declaramos las variables
                int cantidad; //Variable que guardará la cantidad de artículos que queremos añadir

                //Pedimos los datos por teclado
                System.out.println("Introduce la cantidad de artículos que quieres añadir");
                cantidad = sc.nextInt();

                //Añadimos la cantidad de artículos al stock
                arrayArticulo.setStock(arrayArticulo.getStock() + cantidad);
                break;
            } else {
                encontrado = false;
            }
        }

        return encontrado;
    }

    /**
     * Método que permite al usuario introducir la salida de mercancía en el almacén, es decir,
     * disminuye el stock del artículo que el usuario elija
     * @param arrayArticulos Array de artículos que queremos modificar
     * @return Devuelve true si el artículo ha sido encontrado y false si no
     */
    private static boolean salidaMercancia(GESTISIMAL[] arrayArticulos){
        //Declaramos las variables
        int codigo; //Variable que guardará el código del artículo que queremos modificar
        boolean encontrado = true; //Variable que nos dirá si el artículo ha sido encontrado o no

        //Pedimos el código del artículo que queremos modificar
        System.out.println("Introduce el código del artículo que quieres modificar");
        codigo = sc.nextInt();

        //Recorremos el array de artículos
        for (GESTISIMAL arrayArticulo : arrayArticulos) {
            //Si la posición del array no está vacía y el código del artículo es igual al código que hemos introducido
            //entonces modificamos el artículo
            if (arrayArticulo != null && arrayArticulo.getCodigo() == codigo) {
                //Declaramos las variables
                int cantidad; //Variable que guardará la cantidad de artículos que queremos añadir

                //Pedimos los datos por teclado
                System.out.println("Introduce la cantidad de artículos que quieres añadir");
                cantidad = sc.nextInt();

                //Añadimos la cantidad de artículos al stock
                arrayArticulo.setStock(arrayArticulo.getStock() - cantidad);
                break;
            } else {
                encontrado = false;
            }
        }

        return encontrado;
    }




}
