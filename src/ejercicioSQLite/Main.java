package ejercicioSQLite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcionSeleccionada = 1;

        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión del videoclub\n" +
                    "----------------------------------");

            System.out.print("0. Salir del programa\n" +
                    "1. Gestión de películas\n" +
                    "2. Gestión de clientes\n" +
                    "3. Gestión de empleados\n" +
                    "4. Gestión de reservas\n" +
                    "5. Creación de tablas\n" +
                    "6. Eliminación de tablas\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 1:
                    Peliculas.menuPeliculas(opcionSeleccionada, s);
                    opcionSeleccionada = 1;
                    break;
                case 2:
                    Clientes.menuClientes(opcionSeleccionada, s);
                    opcionSeleccionada = 1;
                    break;
                case 3:
                    Empleados.menuEmpleados(opcionSeleccionada, s);
                    opcionSeleccionada = 1;
                    break;
                case 4:
                    Reservas.menuReservas(opcionSeleccionada, s);
                    opcionSeleccionada = 1;
                    break;
                case 5:
                    Crear.menuCreacion(opcionSeleccionada, s);
                    opcionSeleccionada = 1;
                    break;
                case 6:
                    Eliminar.menuEliminacion(opcionSeleccionada, s);
                    opcionSeleccionada = 1;
                    break;
            }
        }
    }
}
