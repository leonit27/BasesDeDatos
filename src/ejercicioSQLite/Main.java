package ejercicioSQLite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcionSeleccionada = 1;

        Clientes.crearTablaClientes();

        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión del videoclub\n" +
                    "----------------------------------");

            System.out.print("0. Salir del programa\n" +
                    "1. Gestión de películas\n" +
                    "2. Gestión de clientes\n" +
                    "3. Gestión de ??????????\n" +
                    "4. Creación de tablas\n" +
                    "5. Eliminación de tablas\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 1:
                    while (opcionSeleccionada != 0) {
                        System.out.println("Menú de gestión de películas\n" +
                                "------------------------------");

                        System.out.print("0. Volver atrás\n" +
                                "1. Agregar una película\n" +
                                "2. Mostrar los datos de una película\n" +
                                "3. Modificar datos de una película\n" +
                                "4. Eliminar película\n" +
                                "5. Mostrar todas las películas\n" +
                                "Elige una opción: ");
                        opcionSeleccionada = s.nextInt();
                        s.nextLine();

                        switch (opcionSeleccionada) {
                            case 0:
                                System.out.println("Saliendo del menú de gestión de películas...");
                                break;
                            case 1:
                                System.out.print("Título: ");
                                String tituloAgregado = s.nextLine();

                                System.out.print("Director: ");
                                String directorAgregado = s.nextLine();

                                System.out.print("Año: ");
                                int anyoAgregado = s.nextInt();
                                s.nextLine();

                                System.out.print("Género: ");
                                String generoAgregado = s.nextLine();

                                System.out.print("Rating: ");
                                double ratingAgregado = s.nextDouble();
                                s.nextLine();

                                Peliculas.agregarPeliculas(tituloAgregado, directorAgregado, anyoAgregado, generoAgregado, ratingAgregado);
                                break;
                            case 2:
                                System.out.print("Introduce el título de la película que quieras ver los datos: ");
                                String tituloVisualizado = s.nextLine();

                                Peliculas.mostrarPelicula(tituloVisualizado);
                                break;
                            case 3:
                                System.out.print("Introduce el título de la película que quieras modificar los datos: ");
                                String tituloModificado = s.nextLine();

                                System.out.print("Nuevo director: ");
                                String directorModificado = s.nextLine();

                                System.out.print("Nuevo año: ");
                                int anyoModificado = s.nextInt();
                                s.nextLine();

                                System.out.print("Nuevo género: ");
                                String generoModificado = s.nextLine();

                                System.out.print("Nuevo rating: ");
                                double ratingModificado = s.nextDouble();
                                s.nextLine();

                                Peliculas.modificarPelicula(tituloModificado, directorModificado, anyoModificado, generoModificado, ratingModificado);
                                break;
                            case 4:
                                System.out.print("Introduce el título de la película que deseas eliminar: ");
                                String tituloEliminado = s.nextLine();

                                Peliculas.eliminarPelicula(tituloEliminado);
                                break;
                            case 5:
                                Peliculas.mostrarTabla();
                                break;
                            default:
                                System.out.println("Número introducido incorrecto, vuelve a intentarlo");
                        }
                    }
                    opcionSeleccionada = 1;
                case 2:
                    while (opcionSeleccionada != 0) {
                        System.out.println("Menú de gestión de clientes\n" +
                                "------------------------------");

                        System.out.print("0. Volver atrás\n" +
                                "1. Agregar un cliente\n" +
                                "2. Mostrar los datos de un cliente\n" +
                                "3. Modificar datos de un cliente\n" +
                                "4. Eliminar cliente\n" +
                                "5. Mostrar todos los clientes\n" +
                                "Elige una opción: ");
                        opcionSeleccionada = s.nextInt();
                        s.nextLine();

                        switch (opcionSeleccionada) {
                            case 0:
                                System.out.println("Saliendo del menú de gestión de clientes...");
                                break;
                            case 1:
                                System.out.print("DNI: ");
                                String DNIagregado = s.nextLine();

                                System.out.print("Nombre: ");
                                String nombreAgregado = s.nextLine();

                                System.out.print("Apellidos: ");
                                String apellidosAgregados = s.nextLine();

                                Clientes.agregarClientes(DNIagregado, nombreAgregado, apellidosAgregados);
                                break;
                            case 2:
                                System.out.print("Introduce el DNI del cliente que quieras ver los datos: ");
                                String DNIvisualizado = s.nextLine();

                                Clientes.mostrarCliente(DNIvisualizado);
                                break;
                            case 3:
                                System.out.print("Introduce el DNI del cliente que quieras modificar los datos: ");
                                String DNImodificado = s.nextLine();

                                System.out.print("Nuevo nombre: ");
                                String nombreModificado = s.nextLine();

                                System.out.print("Nuevos apellidos: ");
                                String apellidosModificados = s.nextLine();

                                Clientes.modificarCliente(DNImodificado, nombreModificado, apellidosModificados);
                                break;
                            case 4:
                                System.out.print("Introduce el DNI del cliente que deseas eliminar: ");
                                String DNIeliminado = s.nextLine();

                                Clientes.eliminarCliente(DNIeliminado);
                                break;
                            case 5:
                                Clientes.mostrarTabla();
                                break;
                            default:
                                System.out.println("Número introducido incorrecto, vuelve a intentarlo");
                        }
                    }
                    opcionSeleccionada = 1;
            }
        }
    }
}
