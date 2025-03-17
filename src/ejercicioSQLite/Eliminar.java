package ejercicioSQLite;

import java.util.Scanner;

public class Eliminar {
    public static void menuEliminacion(int opcionSeleccionada, Scanner s) {
        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión de eliminación de tablas\n" +
                    "--------------------------------------------");

            System.out.print("0. Volver atrás\n" +
                    "1. Eliminar tabla clientes\n" +
                    "2. Eliminar tabla empleados\n" +
                    "3. Eliminar tabla reservas\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 0:
                    System.out.println("Saliendo del menú de gestión de eliminación de tablas...");
                    break;
                case 1:
                    Clientes.eliminarTablaClientes();
                    break;
                case 2:
                    Empleados.eliminarTablaEmpleados();
                    break;
                case 3:
                    Reservas.eliminarTablaReservas();
                    break;
                default:
                    System.out.println("Número introducido incorrecto, vuelve a intentarlo");
            }
        }
    }
}
