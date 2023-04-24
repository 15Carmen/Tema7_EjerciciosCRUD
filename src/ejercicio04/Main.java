package ejercicio04;

import java.util.Scanner;

/**
 * Clase principal donde se ejecutará el programa
 */
public class  Main {

    //Declaramos el scanner para leer por teclado
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {

        //declaramos las variables
        int opc;            //Variable que guarda la opción introducida por el usuario
        double dinero;

        //Creamos un array de cuentas
        CuentaCorriente[] arrayCuentas = new CuentaCorriente[30];

        do {
            //Pintamos el menú
            Metodos.pintarMenu();
            opc = sc.nextInt();
            sc.nextLine();

            //Según la opción elegida por el usuario
            switch (opc) {
                case 1 -> { //Mostrar cuentas
                    Metodos.mostrarCuentas(arrayCuentas);
                }
                case 2 -> { //Crear cuenta
                    Metodos.crearCuenta(arrayCuentas);
                }
                case 3 -> { //Modificar cuenta
                    //Si el método modificarCuenta devuelve true, es que ha encontrado la cuenta y la ha modificado
                    if (Metodos.modificarCuentaCorriente(arrayCuentas)){
                        System.out.println("Cuenta modificada con éxito.");
                    } else {    //Si devuelve false, es que no ha encontrado la cuenta
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 4 -> { //Borrar cuenta
                    //Si el método borrarCuenta devuelve true, es que ha encontrado la cuenta y la ha borrado
                    if (Metodos.borrarCuenta(arrayCuentas)){
                        System.out.println("Cuenta borrada con éxito.");
                    } else {    //Si devuelve false, es que no ha encontrado la cuenta
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 5 -> { //Ingresar dinero
                    //Le pedimos al usuario la cantidad de dinero que quiere ingresar
                    System.out.println("Ingrese la cantidad de dinero que quiere ingresar en la cuenta: ");
                    dinero = sc.nextDouble();
                    sc.nextLine();
                    //Llamamos al método ingresarDinero y le pasamos la cantidad de dinero
                    CuentaCorriente.ingresarDinero(dinero);
                }
                case 6 ->{  //Sacar dinero
                    //Le pedimos al usuario la cantidad de dinero que quiere sacar
                    System.out.println("Ingrese la cantidad de dinero que quiere sacar de la cuenta: ");
                    dinero = sc.nextDouble();
                    sc.nextLine();
                    //Llamamos al método sacarDinero y le pasamos la cantidad de dinero
                    CuentaCorriente.sacarDinero(dinero);
                }
                case 7 -> { //Salir
                    System.out.println("Hasta luego.");
                }
                default -> System.out.println("Opción no válida.");
            }
        }while (opc != 7);


    }

}
