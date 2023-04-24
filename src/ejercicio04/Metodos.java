package ejercicio04;

import ejercicio01.Alumno;

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
                [1] Mostrar todas las cuentas
                [2] Crear cuenta
                [3] Modificar cuenta
                [4] Borrar cuenta
                [5] Ingresar dinero
                [6] Sacar dinero
                [7] Salir
                """);
    }

    /**
     * Método que comprueba si una posición del array de pedidos está libre
     * @param arrayCuentas lista de cuentas
     * @return devuelve la posición libre o -1 si no hay posiciones libres
     */
    public static int posicionLibre(CuentaCorriente[] arrayCuentas) {
        //Declaramos las variables
        int posicion = 0;   //Variable que guarda la posición libre

        //Mientras la posición sea menor que el tamaño del array y el alumno en esa posición no sea nulo, seguimos buscando
        while (posicion < arrayCuentas.length && arrayCuentas[posicion] != null) {
            posicion++;
        }
        //Si la posición es igual al tamaño del array, indicamos que no hay posiciones libres
        if (posicion == arrayCuentas.length) {
            posicion = -1;
        }

        //Devolvemos la posición
        return posicion;
    }

    /**
     * Método que busca en el array de alumnos si existe el alumno que le pasamos por parámetro
     *
     * @param arrayCuentas Array de cuentas
     * @param dni dni que le pedimos al usuario
     * @return true si encuentra al alumno, false si no lo encuentra
     */
    public static boolean busquedaCuenta(CuentaCorriente[] arrayCuentas, String dni) {
        //Declaramos las variables
        boolean encontrado = false;

        //Recorremos el array de alumnos
        for (CuentaCorriente cuentas : arrayCuentas) {
            //Si el alumno no es nulo y el nombre coincide, indicamos que lo hemos encontrado
            if (cuentas != null && cuentas.getDNI().equalsIgnoreCase(dni)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Método que busca en el array de cuentas la que le pasamos por parámetro (con el dni) y devuelve su posición
     * @param arrayCuentas Array de cuentas
     * @param dni Dni de la cuenta corriente que le pedimos al usuario
     * @return posición de la cuenta en el array
     */
    public static int posicionCuenta(CuentaCorriente[] arrayCuentas, String dni) {
        //Declaramos las variables
        int posicion = 0;   //Variable que guarda la posición del alumno

        //Recorremos el array de alumnos
        for (CuentaCorriente cuentas : arrayCuentas) {
            //Si el alumno no es nulo y el nombre coincide, indicamos que lo hemos encontrado
            if (cuentas != null && cuentas.getDNI().equalsIgnoreCase(dni)) {
                break;
            }
            posicion++;
        }
        return posicion;
    }

    /**
     * Método que lista todas las cuentas introducidas en el array
     *
     * @param cuentas array de cuentas
     */
    public static void mostrarCuentas(CuentaCorriente[] cuentas) {

        for (CuentaCorriente cuenta : cuentas) {
            if (cuenta != null) {
                System.out.println(cuenta);
            }
        }
    }

    /**
     * Método que crea una cuenta corriente en el array de cuentas
     * @param arrayCuentas array de cuentas
     */
    public static void crearCuenta(CuentaCorriente[] arrayCuentas) {

        //Declaramos las variables
        String nombre;
        String dni;
        double saldo;
        String sexo;

        //Le pedimos al usuario que introduzca los datos de la cuenta
        System.out.println("Introduzca el nombre del titular de la cuenta:");
        nombre = sc.nextLine();
        System.out.println("Introduzca el DNI del titular de la cuenta:");
        dni = sc.nextLine();
        System.out.println("Introduzca el saldo de la cuenta:");
        saldo = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduzca el género del titular de la cuenta:");
        sexo = sc.nextLine();

        //Creamos la cuenta en la primera posición libre del array
        if(posicionLibre(arrayCuentas) != -1) {
            arrayCuentas[posicionLibre(arrayCuentas)] = new CuentaCorriente(nombre, dni, saldo, sexo);
        } else {
            //Si no hay posiciones libres, creamos un array auxiliar con una posición más que el array original
            arrayCuentas = Arrays.copyOf(arrayCuentas, arrayCuentas.length + 1);
            arrayCuentas[arrayCuentas.length - 1] = new CuentaCorriente(nombre, dni, saldo, sexo);
        }

    }

    /**
     * Precondición: El dni de la cuenta debe existir
     * Método que modifica la cuenta corriente elegida por el usuario
     *
     * @param arrayCuentas Array de cuentas corrientes
     * @return Devuelve true si la cuenta ha sido modificada y false si no ha sido encontrada
     */
    public static boolean modificarCuentaCorriente(CuentaCorriente[] arrayCuentas) {
        //Declaramos las variables
        String nombre;  //Variable que guarda el nombre del titular de la cuenta
        String dni;     //Variable que guarda el dni de la cuenta
        double saldo;   //Variable que guarda el saldo de la cuenta
        String sexo;    //Variable que guarda el género del titular de la cuenta
        boolean encontrado = false; //Variable que nos indica si el dni de la cuenta ha sido encontrada

        //Pedimos los datos por teclado al usuario
        System.out.println("Introduce el dni del titular de la cuenta que quieres modificar");
        dni = sc.next();

        //Si la cuenta existe, modificamos el resto de parámetros
        if (busquedaCuenta(arrayCuentas, dni)) {
            //Indicamos que la cuenta ha sido encontrada
            encontrado = true;
            //Pedimos los nuevos datos por teclado
            System.out.println("Introduce el nuevo nombre del titular: ");
            nombre = sc.nextLine();
            System.out.println("Introduce el nuevo saldo de la cuenta: ");
            saldo = sc.nextDouble();
            sc.nextLine();
            System.out.println("Introduce el nuevo género del titular: ");
            sexo = sc.nextLine();

            //Modificamos la nota media del alumno
            arrayCuentas[posicionCuenta(arrayCuentas, dni)].setNombre(nombre);
            arrayCuentas[posicionCuenta(arrayCuentas, dni)].setSaldo(saldo);
            arrayCuentas[posicionCuenta(arrayCuentas, dni)].setSexo(CuentaCorriente.Sexo.valueOf(sexo));
        }

        //Devolvemos si el alumno ha sido encontrado o no
        return encontrado;
    }

    /**
     * Método que borra la cuenta que elija el usuario, es decir la pone a null
     *
     * @param arrayCuentas Array de cuentas corrientes
     * @return Devuelve true si la cuenta ha sido borrada y false si no ha sido encontrada
     */
    public static boolean borrarCuenta(CuentaCorriente[] arrayCuentas) {

        //Declaramos las variables
        String dni;                 //Variable que guarda el dni del titular de la cuenta
        String nombre;              //Variable donde guardaremos el nombre del titular de la cuenta
        double saldo;               //Variable donde guardaremos el saldo de la cuenta
        String sexo;                //Variable donde guardaremos el género del titular de la cuenta
        boolean encontrado = false; //Variable que nos indica si el nombre del alumno ha sido encontrado

        //Le pedimos al usuario el dni del titular de la cuenta que quiere borrar
        System.out.println("Introduce el dni del titular de la cuenta que quieres borrar");
        dni = sc.next();

        //Si el alumno existe, lo borramos
        if (busquedaCuenta(arrayCuentas, dni)) {
            //Indicamos que el alumno ha sido encontrado
            encontrado = true;
            //Borramos el alumno
            arrayCuentas[posicionCuenta(arrayCuentas,dni)] = null;
        }

        //Devolvemos si el alumno ha sido encontrado o no
        return encontrado;
    }

}
