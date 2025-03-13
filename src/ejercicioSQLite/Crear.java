package ejercicioSQLite;

import java.util.Scanner;

public class Crear {
    public static void menuCreacion(int opcionSeleccionada, Scanner s) {
        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión de creación de tablas\n" +
                    "----------------------------------------");

            System.out.print("0. Volver atrás\n" +
                    "1. Crear tabla clientes\n" +
                    "2. Crear tabla empleados\n" +
                    "3. Crear tabla reservas\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 0:
                    System.out.println("Saliendo del menú de gestión de creación de tablas...");
                    break;
                case 1:
                    Clientes.crearTablaClientes();
                    break;
                case 2:
                    Empleados.crearTablaEmpleados();
                    break;
                case 3:
                    Reservas.crearTablaReservas();
                default:
                    System.out.println("Número introducido incorrecto, vuelve a intentarlo");
            }
        }
    }
}
