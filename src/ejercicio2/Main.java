package ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcionSeleccionada = 0;

        while (opcionSeleccionada != 9){
            System.out.println("1. Listar Clientes\n" +
                    "2. Listar Facturas con Líneas\n" +
                    "3. Listar Articulos y Categorias\n" +
                    "4. Agregar Cliente\n" +
                    "5. Agregar Artículo\n" +
                    "6. Eliminar Artículo\n" +
                    "7. Modificar el precio de un artículo\n" +
                    "8. Agregar Población\n" +
                    "9. Salir");
            System.out.print("Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            
            switch (opcionSeleccionada){
                case 1:
                    Cliente.listarClientes();
                    break;
                case 2:
                    LineaFac.listarLineaFac();
                    break;
                case 3:
                    System.out.println("Los articulos son:");
                    Article.listarArticle();
                    System.out.println();
                    System.out.println("Las categorias son:");
                    Categoria.listarCategoria();
                    break;
                case 4:
                    System.out.println("Introduce los datos del cliente:");
                    System.out.print("Código: ");
                    int cod_cli = s.nextInt();
                    s.nextLine();
                    System.out.print("Nombre: ");
                    String nom = s.nextLine();
                    System.out.print("Adreça: ");
                    String adreca = s.nextLine();
                    System.out.print("Cp: ");
                    int cp = s.nextInt();
                    System.out.print("Cod_pob: ");
                    int cod_pob = s.nextInt();

                    Cliente.agregarClient(cod_cli, nom, adreca, cp, cod_pob);
                    break;
                case 5:
                    System.out.println("Introduce los datos del articulo:");
                    System.out.print("Cod_a: ");
                    int cod_a = s.nextInt();
                    s.nextLine();
                    System.out.print("Descripción: ");
                    String descrip = s.nextLine();
                    System.out.print("Preu: ");
                    double preu = s.nextDouble();
                    System.out.print("Stock: ");
                    int stock = s.nextInt();
                    System.out.print("Categoria: ");
                    String categoria = s.nextLine();

                    Article.agregarArticle(cod_a, descrip, preu, stock, categoria);
                    break;
                case 6:
                    System.out.println("Eliminar articulos");
                    System.out.print("Introduce el codigo del cliente que desea eliminar: ");
                    int eliminado = s.nextInt();
                    Article.eliminarArticle(eliminado);
                    break;
                case 7:
                    System.out.println("Modificar el precio del articulo");
                    System.out.print("Introduce el porcentaje que se le sumara o restara al precio actual: ");
                    double nuevoPrecio = s.nextDouble();
                    Article.modificarArticle(nuevoPrecio);
                    break;
                case 8:
                    System.out.println("Agregar una población");
                    System.out.print("Cod_pob: ");
                    int cod_poble = s.nextInt();
                    s.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = s.nextLine();
                    System.out.print("Cod_pro: ");
                    String cod_pro = s.nextLine();

                    Poble.agregarPoble(cod_poble, nombre, cod_pro);
                    break;
            }
        }
    }
}
