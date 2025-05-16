package ejercicioSQLite;

import javax.swing.*;
import java.awt.*;

public class Swing {
    //Menú Principal
    public static void menuPrincipal(){
        //Creamos el frame con sus respectivas características
        JFrame frame = new JFrame("Menú Principal");
        frame.setLayout(new GridLayout(4, 1, 5, 5));
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Creamos los botones
        JButton buttonGestionPeliculas = new JButton("Gestionar Películas");
        JButton buttonGestionarReservas = new JButton("Gestionar Reservas");
        JButton buttonGestionarEmpleados = new JButton("Gestionar Empleados");
        JButton buttonGestionarClientes = new JButton("Gestionar Clientes");

        //Cambiamos el color de los botones
        buttonGestionPeliculas.setBackground(new Color(125, 210, 181));
        buttonGestionarReservas.setBackground(new Color(125, 210, 181));
        buttonGestionarEmpleados.setBackground(new Color(125, 210, 181));
        buttonGestionarClientes.setBackground(new Color(125, 210, 181));

        //Definimos las acciones de los botones
        buttonGestionPeliculas.addActionListener(_ -> menuGestionPeliculas(frame));
        buttonGestionarReservas.addActionListener(_ -> menuGestionReservas(frame));
        buttonGestionarEmpleados.addActionListener(_ -> menuGestionEmpleados(frame));
        buttonGestionarClientes.addActionListener(_ -> menuGestionClientes(frame));

        //Añadimos los elementos al frame
        frame.add(buttonGestionPeliculas);
        frame.add(buttonGestionarReservas);
        frame.add(buttonGestionarEmpleados);
        frame.add(buttonGestionarClientes);

        //Hacemos el frame visible
        frame.setVisible(true);
    }

    //Menús de Gestión
    public static void menuGestionPeliculas(JFrame frame) {
        //Creamos el frame con sus respectivas características
        JFrame frameGestionPeliculas = new JFrame("Gestión Películas");
        frameGestionPeliculas.setLayout(new GridLayout(3, 2, 5, 5));
        frameGestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameGestionPeliculas.setSize(600, 600);
        frameGestionPeliculas.setResizable(false);
        frameGestionPeliculas.setLocationRelativeTo(null);

        //Ocultamos el frame anterior
        frame.setVisible(false);

        //Creamos los botones
        JButton buttonAgregarPelicula = new JButton("Agregar Película");
        JButton buttonMostrarDatosPelicula = new JButton("Mostrar Datos Película");
        JButton buttonModificarDatosPelicula = new JButton("Modificar Datos Película");
        JButton buttonEliminarPelicula = new JButton("Eliminar Película");
        JButton buttonMostrarTodasPeliculas = new JButton("Mostrar Todas las Películas");
        JButton buttonVolverAtrás = new JButton("Volver");

        //Cambiamos el color de los botones
        buttonAgregarPelicula.setBackground(new Color(125, 210, 181));
        buttonMostrarTodasPeliculas.setBackground(new Color(125, 210, 181));
        buttonModificarDatosPelicula.setBackground(new Color(125, 210, 181));
        buttonEliminarPelicula.setBackground(new Color(125, 210, 181));
        buttonMostrarDatosPelicula.setBackground(new Color(125, 210, 181));
        buttonVolverAtrás.setBackground(new Color(225, 83, 83));

        //Definimos las acciones de los botones
        buttonAgregarPelicula.addActionListener(_ -> agregarPeliculasSwing(frameGestionPeliculas));
        buttonMostrarDatosPelicula.addActionListener(_ -> mostrarPeliculaSwing(frameGestionPeliculas));
        buttonModificarDatosPelicula.addActionListener(_ -> modificarPeliculaSwing(frameGestionPeliculas));
        buttonEliminarPelicula.addActionListener(_ -> eliminarPeliculaSwing(frameGestionPeliculas));
        buttonMostrarTodasPeliculas.addActionListener(_ -> mostrarTablaPeliculasSwing());
        buttonVolverAtrás.addActionListener(_ -> {
            frameGestionPeliculas.setVisible(false);
            frame.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameGestionPeliculas.add(buttonAgregarPelicula);
        frameGestionPeliculas.add(buttonMostrarDatosPelicula);
        frameGestionPeliculas.add(buttonModificarDatosPelicula);
        frameGestionPeliculas.add(buttonEliminarPelicula);
        frameGestionPeliculas.add(buttonMostrarTodasPeliculas);
        frameGestionPeliculas.add(buttonVolverAtrás);

        //Hacemos el frame visible
        frameGestionPeliculas.setVisible(true);
    }

    public static void menuGestionReservas(JFrame frame) {
        //Creamos el frame con sus respectivas características
        JFrame frameGestionReservas = new JFrame("Gestión Reservas");
        frameGestionReservas.setLayout(new GridLayout(3, 2, 5, 5));
        frameGestionReservas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameGestionReservas.setSize(600, 600);
        frameGestionReservas.setResizable(false);
        frameGestionReservas.setLocationRelativeTo(null);

        //Ocultamos el frame anterior
        frame.setVisible(false);

        //Creamos los botones
        JButton buttonAgregarReserva = new JButton("Agregar Reserva");
        JButton buttonMostrarDatosReserva = new JButton("Mostrar Datos Reserva");
        JButton buttonModificarDatosReserva = new JButton("Modificar Datos Reserva");
        JButton buttonEliminarReserva = new JButton("Eliminar Reserva");
        JButton buttonMostrarTodasReservas = new JButton("Mostrar Todas las Reservas");
        JButton buttonVolverAtrás = new JButton("Volver");

        //Cambiamos el color de los botones
        buttonAgregarReserva.setBackground(new Color(125, 210, 181));
        buttonMostrarTodasReservas.setBackground(new Color(125, 210, 181));
        buttonModificarDatosReserva.setBackground(new Color(125, 210, 181));
        buttonEliminarReserva.setBackground(new Color(125, 210, 181));
        buttonMostrarDatosReserva.setBackground(new Color(125, 210, 181));
        buttonVolverAtrás.setBackground(new Color(225, 83, 83));

        //Definimos las acciones de los botones
        buttonAgregarReserva.addActionListener(_ -> agregarReservasSwing(frameGestionReservas));
        buttonMostrarDatosReserva.addActionListener(_ -> mostrarReservaSwing(frameGestionReservas));
        buttonModificarDatosReserva.addActionListener(_ -> modificarReservaSwing(frameGestionReservas));
        buttonEliminarReserva.addActionListener(_ -> eliminarReservaSwing(frameGestionReservas));
        buttonMostrarTodasReservas.addActionListener(_ -> mostrarTablaReservasSwing());
        buttonVolverAtrás.addActionListener(_ -> {
            frameGestionReservas.setVisible(false);
            frame.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameGestionReservas.add(buttonAgregarReserva);
        frameGestionReservas.add(buttonMostrarDatosReserva);
        frameGestionReservas.add(buttonModificarDatosReserva);
        frameGestionReservas.add(buttonEliminarReserva);
        frameGestionReservas.add(buttonMostrarTodasReservas);
        frameGestionReservas.add(buttonVolverAtrás);

        //Hacemos el frame visible
        frameGestionReservas.setVisible(true);
    }
    
    public static void menuGestionEmpleados(JFrame frame) {
        //Creamos el frame con sus respectivas características
        JFrame frameGestionEmpleados = new JFrame("Gestión Empleados");
        frameGestionEmpleados.setLayout(new GridLayout(3, 2, 5, 5));
        frameGestionEmpleados.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameGestionEmpleados.setSize(600, 600);
        frameGestionEmpleados.setResizable(false);
        frameGestionEmpleados.setLocationRelativeTo(null);

        //Ocultamos el frame anterior
        frame.setVisible(false);

        //Creamos los botones
        JButton buttonAgregarEmpleado = new JButton("Agregar Empleado");
        JButton buttonMostrarDatosEmpleado = new JButton("Mostrar Datos Empleado");
        JButton buttonModificarDatosEmpleado = new JButton("Modificar Datos Empleado");
        JButton buttonEliminarEmpleado = new JButton("Eliminar Empleado");
        JButton buttonMostrarTodosEmpleados = new JButton("Mostrar Todos los Empleados");
        JButton buttonVolverAtrás = new JButton("Volver");

        //Cambiamos el color de los botones
        buttonAgregarEmpleado.setBackground(new Color(125, 210, 181));
        buttonMostrarTodosEmpleados.setBackground(new Color(125, 210, 181));
        buttonModificarDatosEmpleado.setBackground(new Color(125, 210, 181));
        buttonEliminarEmpleado.setBackground(new Color(125, 210, 181));
        buttonMostrarDatosEmpleado.setBackground(new Color(125, 210, 181));
        buttonVolverAtrás.setBackground(new Color(225, 83, 83));

        //Definimos las acciones de los botones
        buttonAgregarEmpleado.addActionListener(_ -> agregarEmpleadoSwing(frameGestionEmpleados));
        buttonMostrarDatosEmpleado.addActionListener(_ -> mostrarEmpleadoSwing(frameGestionEmpleados));
        buttonModificarDatosEmpleado.addActionListener(_ -> modificarEmpleadoSwing(frameGestionEmpleados));
        buttonEliminarEmpleado.addActionListener(_ -> eliminarEmpleadoSwing(frameGestionEmpleados));
        buttonMostrarTodosEmpleados.addActionListener(_ -> mostrarTablaEmpleadosSwing());
        buttonVolverAtrás.addActionListener(_ -> {
            frameGestionEmpleados.setVisible(false);
            frame.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameGestionEmpleados.add(buttonAgregarEmpleado);
        frameGestionEmpleados.add(buttonMostrarDatosEmpleado);
        frameGestionEmpleados.add(buttonModificarDatosEmpleado);
        frameGestionEmpleados.add(buttonEliminarEmpleado);
        frameGestionEmpleados.add(buttonMostrarTodosEmpleados);
        frameGestionEmpleados.add(buttonVolverAtrás);

        //Hacemos el frame visible
        frameGestionEmpleados.setVisible(true);
    }
    
    public static void menuGestionClientes(JFrame frame) {
        //Creamos el frame con sus respectivas características
        JFrame frameGestionClientes = new JFrame("Gestión Clientes");
        frameGestionClientes.setLayout(new GridLayout(3, 2, 5, 5));
        frameGestionClientes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameGestionClientes.setSize(600, 600);
        frameGestionClientes.setResizable(false);
        frameGestionClientes.setLocationRelativeTo(null);

        //Ocultamos el frame anterior
        frame.setVisible(false);

        //Creamos los botones
        JButton buttonAgregarCliente = new JButton("Agregar Cliente");
        JButton buttonMostrarDatosCliente = new JButton("Mostrar Datos Cliente");
        JButton buttonModificarDatosCliente = new JButton("Modificar Datos Cliente");
        JButton buttonEliminarCliente = new JButton("Eliminar Cliente");
        JButton buttonMostrarTodosClientes = new JButton("Mostrar Todos los Clientes");
        JButton buttonVolverAtrás = new JButton("Volver");

        //Cambiamos el color de los botones
        buttonAgregarCliente.setBackground(new Color(125, 210, 181));
        buttonMostrarTodosClientes.setBackground(new Color(125, 210, 181));
        buttonModificarDatosCliente.setBackground(new Color(125, 210, 181));
        buttonEliminarCliente.setBackground(new Color(125, 210, 181));
        buttonMostrarDatosCliente.setBackground(new Color(125, 210, 181));
        buttonVolverAtrás.setBackground(new Color(225, 83, 83));

        //Definimos las acciones de los botones
        buttonAgregarCliente.addActionListener(_ -> agregarClienteSwing(frameGestionClientes));
        buttonMostrarDatosCliente.addActionListener(_ -> mostrarClienteSwing(frameGestionClientes));
        buttonModificarDatosCliente.addActionListener(_ -> modificarClienteSwing(frameGestionClientes));
        buttonEliminarCliente.addActionListener(_ -> eliminarClienteSwing(frameGestionClientes));
        buttonMostrarTodosClientes.addActionListener(_ -> mostrarTablaClientesSwing());
        buttonVolverAtrás.addActionListener(_ -> {
            frameGestionClientes.setVisible(false);
            frame.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameGestionClientes.add(buttonAgregarCliente);
        frameGestionClientes.add(buttonMostrarDatosCliente);
        frameGestionClientes.add(buttonModificarDatosCliente);
        frameGestionClientes.add(buttonEliminarCliente);
        frameGestionClientes.add(buttonMostrarTodosClientes);
        frameGestionClientes.add(buttonVolverAtrás);

        //Hacemos el frame visible
        frameGestionClientes.setVisible(true);
    }
    
    //Métodos Swing Gestión de Películas
    public static void agregarPeliculasSwing(JFrame frameGestionPeliculas) {
        //Creamos el frame con sus respectivas características
        JFrame frameAgregarPelicula = new JFrame("Agregar Película");
        frameAgregarPelicula.setLayout(new GridLayout(6, 2, 5, 5));
        frameAgregarPelicula.setSize(600, 600);
        frameAgregarPelicula.setResizable(false);
        frameAgregarPelicula.setLocationRelativeTo(null);
        frameAgregarPelicula.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionPeliculas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelAgregarTituloPelicula = new JLabel("Título:");
        JTextField textFieldAgregarTituloPelicula = new JTextField();

        JLabel labelAgregarDirectorPelicula = new JLabel("Director:");
        JTextField textFieldAgregarDirectorPelicula = new JTextField();

        JLabel labelAgregarAnyoPelicula = new JLabel("Año:");
        JTextField textFieldAgregarAnyoPelicula = new JTextField();

        JLabel labelAgregarGeneroPelicula = new JLabel("Género:");
        JTextField textFieldAgregarGeneroPelicula = new JTextField();

        JLabel labelAgregarRatingPelicula = new JLabel("Rating:");
        JTextField textFieldAgregarRatingPelicula = new JTextField();

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarAgregarPelicula = new JButton("Enviar");

        //Centramos el texto de las labels
        labelAgregarTituloPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarDirectorPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarAnyoPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarGeneroPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarRatingPelicula.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelAgregarTituloPelicula.setOpaque(true);
        labelAgregarDirectorPelicula.setOpaque(true);
        labelAgregarAnyoPelicula.setOpaque(true);
        labelAgregarGeneroPelicula.setOpaque(true);
        labelAgregarRatingPelicula.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelAgregarTituloPelicula.setBackground(new Color(198, 232, 210));
        labelAgregarDirectorPelicula.setBackground(new Color(198, 232, 210));
        labelAgregarAnyoPelicula.setBackground(new Color(198, 232, 210));
        labelAgregarGeneroPelicula.setBackground(new Color(198, 232, 210));
        labelAgregarRatingPelicula.setBackground(new Color(198, 232, 210));

        //Cambiamos el color de los botones
        buttonEnviarAgregarPelicula.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameAgregarPelicula.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameAgregarPelicula.setVisible(false);
            frameGestionPeliculas.setVisible(true);
        });
        buttonEnviarAgregarPelicula.addActionListener(_ -> {
            String tituloPelicula = textFieldAgregarTituloPelicula.getText();
            String directorPelicula = textFieldAgregarDirectorPelicula.getText();
            int anyoPelicula = Integer.parseInt(textFieldAgregarAnyoPelicula.getText());
            String generoPelicula = textFieldAgregarGeneroPelicula.getText();
            double ratingPelicula = Double.parseDouble(textFieldAgregarRatingPelicula.getText());

            Peliculas.agregarPeliculas(tituloPelicula, directorPelicula, anyoPelicula, generoPelicula, ratingPelicula);

            textFieldAgregarTituloPelicula.setText("");
            textFieldAgregarDirectorPelicula.setText("");
            textFieldAgregarAnyoPelicula.setText("");
            textFieldAgregarGeneroPelicula.setText("");
            textFieldAgregarRatingPelicula.setText("");

            JFrame framePeliculaAñadida = new JFrame();

            framePeliculaAñadida.setSize(400, 200);
            framePeliculaAñadida.setResizable(false);
            framePeliculaAñadida.setLocationRelativeTo(null);

            JLabel labelPeliculaAñadida = new JLabel("Película añadida con éxito!");

            labelPeliculaAñadida.setHorizontalAlignment(SwingConstants.CENTER);
            labelPeliculaAñadida.setOpaque(true);
            labelPeliculaAñadida.setBackground(new Color(0x90A1D3));

            framePeliculaAñadida.add(labelPeliculaAñadida);

            framePeliculaAñadida.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameAgregarPelicula.add(labelAgregarTituloPelicula);
        frameAgregarPelicula.add(textFieldAgregarTituloPelicula);
        frameAgregarPelicula.add(labelAgregarDirectorPelicula);
        frameAgregarPelicula.add(textFieldAgregarDirectorPelicula);
        frameAgregarPelicula.add(labelAgregarAnyoPelicula);
        frameAgregarPelicula.add(textFieldAgregarAnyoPelicula);
        frameAgregarPelicula.add(labelAgregarGeneroPelicula);
        frameAgregarPelicula.add(textFieldAgregarGeneroPelicula);
        frameAgregarPelicula.add(labelAgregarRatingPelicula);
        frameAgregarPelicula.add(textFieldAgregarRatingPelicula);
        frameAgregarPelicula.add(buttonVolverAtras);
        frameAgregarPelicula.add(buttonEnviarAgregarPelicula);

        //Hacemos el frame visible
        frameAgregarPelicula.setVisible(true);
    }

    public static void mostrarPeliculaSwing(JFrame frameGestionPeliculas){
        //Creamos el frame con sus respectivas características
        JFrame frameMostrarDatosPelicula = new JFrame("Mostrar Datos Película");
        frameMostrarDatosPelicula.setLayout(new GridLayout(2, 2, 5, 5));
        frameMostrarDatosPelicula.setSize(600, 230);
        frameMostrarDatosPelicula.setResizable(false);
        frameMostrarDatosPelicula.setLocationRelativeTo(null);
        frameMostrarDatosPelicula.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionPeliculas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelMostrarDatosPelicula = new JLabel("Introduce el título de la película:");
        JTextField textFieldMostrarDatosPelicula = new JTextField();

        //Centramos el texto de las labels
        labelMostrarDatosPelicula.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelMostrarDatosPelicula.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelMostrarDatosPelicula.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarMostrarDatos = new JButton("Consultar");

        //Cambiamos el color de los botones
        buttonEnviarMostrarDatos.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameMostrarDatosPelicula.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameMostrarDatosPelicula.setVisible(false);
            frameGestionPeliculas.setVisible(true);

        });
        buttonEnviarMostrarDatos.addActionListener(_ -> {
            String tituloPeliculaConsultada = textFieldMostrarDatosPelicula.getText();

            Peliculas.mostrarPelicula(tituloPeliculaConsultada);

            textFieldMostrarDatosPelicula.setText("");
        });

        //Añadimos los elementos al frame
        frameMostrarDatosPelicula.add(labelMostrarDatosPelicula);
        frameMostrarDatosPelicula.add(textFieldMostrarDatosPelicula);
        frameMostrarDatosPelicula.add(buttonVolverAtras);
        frameMostrarDatosPelicula.add(buttonEnviarMostrarDatos);

        //Hacemos el frame visible
        frameMostrarDatosPelicula.setVisible(true);
    }

    public static void modificarPeliculaSwing(JFrame frameGestionPeliculas) {
        //Creamos el frame con sus respectivas características
        JFrame frameModificarDatosPelicula = new JFrame("Modificar Datos Película");
        frameModificarDatosPelicula.setLayout(new GridLayout(6, 2, 5, 5));
        frameModificarDatosPelicula.setSize(600, 600);
        frameModificarDatosPelicula.setResizable(false);
        frameModificarDatosPelicula.setLocationRelativeTo(null);
        frameModificarDatosPelicula.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Ocultamos el frame anterior
        frameGestionPeliculas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelModificarTituloPelicula = new JLabel("Título de la película a modificar:");
        JTextField textFieldModificarTituloPelicula = new JTextField();

        JLabel labelModificarDirectorPelicula = new JLabel("Nuevo Director:");
        JTextField textFieldModificarDirectorPelicula = new JTextField();

        JLabel labelModificarAnyoPelicula = new JLabel("Nuevo Año:");
        JTextField textFieldModificarAnyoPelicula = new JTextField();

        JLabel labelModificarGeneroPelicula = new JLabel("Nuevo Género:");
        JTextField textFieldModificarGeneroPelicula = new JTextField();

        JLabel labelModificarRatingPelicula = new JLabel("Nuevo Rating:");
        JTextField textFieldModificarRatingPelicula = new JTextField();

        //Centramos el texto de las labels
        labelModificarTituloPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarDirectorPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarAnyoPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarGeneroPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarRatingPelicula.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelModificarTituloPelicula.setOpaque(true);
        labelModificarDirectorPelicula.setOpaque(true);
        labelModificarAnyoPelicula.setOpaque(true);
        labelModificarGeneroPelicula.setOpaque(true);
        labelModificarRatingPelicula.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelModificarTituloPelicula.setBackground(new Color(198, 232, 210));
        labelModificarDirectorPelicula.setBackground(new Color(198, 232, 210));
        labelModificarAnyoPelicula.setBackground(new Color(198, 232, 210));
        labelModificarGeneroPelicula.setBackground(new Color(198, 232, 210));
        labelModificarRatingPelicula.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarModificarPelicula = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarModificarPelicula.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameModificarDatosPelicula.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameModificarDatosPelicula.setVisible(false);
            frameGestionPeliculas.setVisible(true);
        });
        buttonEnviarModificarPelicula.addActionListener(_ -> {
            String tituloPeliculaModificada = textFieldModificarTituloPelicula.getText();
            String directorNuevoPelicula = textFieldModificarDirectorPelicula.getText();
            int anyoNuevoPelicula = Integer.parseInt(textFieldModificarAnyoPelicula.getText());
            String generoNuevoPelicula = textFieldModificarGeneroPelicula.getText();
            double ratingNuevoPelicula = Double.parseDouble(textFieldModificarRatingPelicula.getText());
            
            Peliculas.modificarPelicula(tituloPeliculaModificada, directorNuevoPelicula, anyoNuevoPelicula, generoNuevoPelicula, ratingNuevoPelicula);

            textFieldModificarTituloPelicula.setText("");
            textFieldModificarDirectorPelicula.setText("");
            textFieldModificarAnyoPelicula.setText("");
            textFieldModificarGeneroPelicula.setText("");
            textFieldModificarRatingPelicula.setText("");

            JFrame framePeliculaModificada = new JFrame();

            framePeliculaModificada.setSize(400, 200);
            framePeliculaModificada.setResizable(false);
            framePeliculaModificada.setLocationRelativeTo(null);

            JLabel labelPeliculaModificada = new JLabel("Película modificada con éxito!");

            labelPeliculaModificada.setHorizontalAlignment(SwingConstants.CENTER);
            labelPeliculaModificada.setOpaque(true);
            labelPeliculaModificada.setBackground(new Color(0x90A1D3));

            framePeliculaModificada.add(labelPeliculaModificada);

            framePeliculaModificada.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameModificarDatosPelicula.add(labelModificarTituloPelicula);
        frameModificarDatosPelicula.add(textFieldModificarTituloPelicula);
        frameModificarDatosPelicula.add(labelModificarDirectorPelicula);
        frameModificarDatosPelicula.add(textFieldModificarDirectorPelicula);
        frameModificarDatosPelicula.add(labelModificarAnyoPelicula);
        frameModificarDatosPelicula.add(textFieldModificarAnyoPelicula);
        frameModificarDatosPelicula.add(labelModificarGeneroPelicula);
        frameModificarDatosPelicula.add(textFieldModificarGeneroPelicula);
        frameModificarDatosPelicula.add(labelModificarRatingPelicula);
        frameModificarDatosPelicula.add(textFieldModificarRatingPelicula);
        frameModificarDatosPelicula.add(buttonVolverAtras);
        frameModificarDatosPelicula.add(buttonEnviarModificarPelicula);

        //Hacemos el frame visible
        frameModificarDatosPelicula.setVisible(true);
    }
    
    public static void eliminarPeliculaSwing(JFrame frameGestionPeliculas) {
        //Creamos el frame con sus respectivas características
        JFrame frameEliminarPelicula = new JFrame("Eliminar Película");
        frameEliminarPelicula.setLayout(new GridLayout(2, 2, 5, 5));
        frameEliminarPelicula.setSize(600, 230);
        frameEliminarPelicula.setResizable(false);
        frameEliminarPelicula.setLocationRelativeTo(null);
        frameEliminarPelicula.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionPeliculas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelEliminarPelicula = new JLabel("Introduce el título de la película a eliminar:");
        JTextField textFieldEliminarPelicula = new JTextField();

        //Centramos el texto de las labels
        labelEliminarPelicula.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelEliminarPelicula.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelEliminarPelicula.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarEliminarPelicula = new JButton("Eliminar");

        //Cambiamos el color de los botones
        buttonEnviarEliminarPelicula.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameEliminarPelicula.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameEliminarPelicula.setVisible(false);
            frameGestionPeliculas.setVisible(true);
        });
        buttonEnviarEliminarPelicula.addActionListener(_ -> {
            String tituloPeliculaEliminada = textFieldEliminarPelicula.getText();

            Peliculas.eliminarPelicula(tituloPeliculaEliminada);

            textFieldEliminarPelicula.setText("");

            JFrame framePeliculaEliminada = new JFrame();

            framePeliculaEliminada.setSize(400, 200);
            framePeliculaEliminada.setResizable(false);
            framePeliculaEliminada.setLocationRelativeTo(null);

            JLabel labelPeliculaEliminada = new JLabel("Película eliminada con éxito!");

            labelPeliculaEliminada.setHorizontalAlignment(SwingConstants.CENTER);
            labelPeliculaEliminada.setOpaque(true);
            labelPeliculaEliminada.setBackground(new Color(0x90A1D3));

            framePeliculaEliminada.add(labelPeliculaEliminada);

            framePeliculaEliminada.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameEliminarPelicula.add(labelEliminarPelicula);
        frameEliminarPelicula.add(textFieldEliminarPelicula);
        frameEliminarPelicula.add(buttonVolverAtras);
        frameEliminarPelicula.add(buttonEnviarEliminarPelicula);

        //Hacemos el frame visible
        frameEliminarPelicula.setVisible(true);
    }

    public static void mostrarTablaPeliculasSwing(){
        Peliculas.mostrarTabla();
    }
    
    //Métodos Swing Gestión de Reservas
    public static void agregarReservasSwing(JFrame frameGestionReservas) {
        //Creamos el frame con sus respectivas características
        JFrame frameAgregarReserva = new JFrame("Agregar Reserva");
        frameAgregarReserva.setLayout(new GridLayout(6, 2, 5, 5));
        frameAgregarReserva.setSize(600, 600);
        frameAgregarReserva.setResizable(false);
        frameAgregarReserva.setLocationRelativeTo(null);
        frameAgregarReserva.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionReservas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelAgregarIDReserva = new JLabel("ID Reserva:");
        JTextField textFieldAgregarIDReserva = new JTextField();

        JLabel labelAgregarDNICliente = new JLabel("DNI Cliente:");
        JTextField textFieldAgregarDNICliente = new JTextField();

        JLabel labelAgregarTituloPeliculaReservada = new JLabel("Título película:");
        JTextField textFieldAgregarTituloPeliculaReservada = new JTextField();

        JLabel labelAgregarFechaInicio = new JLabel("Fecha de Inicio (DD-MM-YYYY):");
        JTextField textFieldAgregarFechaInicio = new JTextField();

        JLabel labelAgregarFechaFinal = new JLabel("Fecha Final (DD-MM-YYYY):");
        JTextField textFieldAgregarFechaFinal = new JTextField();

        //Centramos el texto de las labels
        labelAgregarIDReserva.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarDNICliente.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarTituloPeliculaReservada.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarFechaFinal.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelAgregarIDReserva.setOpaque(true);
        labelAgregarDNICliente.setOpaque(true);
        labelAgregarTituloPeliculaReservada.setOpaque(true);
        labelAgregarFechaInicio.setOpaque(true);
        labelAgregarFechaFinal.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelAgregarIDReserva.setBackground(new Color(198, 232, 210));
        labelAgregarDNICliente.setBackground(new Color(198, 232, 210));
        labelAgregarTituloPeliculaReservada.setBackground(new Color(198, 232, 210));
        labelAgregarFechaInicio.setBackground(new Color(198, 232, 210));
        labelAgregarFechaFinal.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarAgregarReserva = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarAgregarReserva.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameAgregarReserva.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameAgregarReserva.setVisible(false);
            frameGestionReservas.setVisible(true);
        });
        buttonEnviarAgregarReserva.addActionListener(_ -> {
            String idReserva = textFieldAgregarIDReserva.getText();
            String DNIcliente = textFieldAgregarDNICliente.getText();
            String tituloPeliculaReservada = textFieldAgregarTituloPeliculaReservada.getText();
            String fechaInicio = textFieldAgregarFechaInicio.getText();
            String fechaFinal = textFieldAgregarFechaFinal.getText();

            Reservas.agregarReservas(idReserva, DNIcliente, tituloPeliculaReservada, fechaInicio, fechaFinal);

            textFieldAgregarIDReserva.setText("");
            textFieldAgregarDNICliente.setText("");
            textFieldAgregarTituloPeliculaReservada.setText("");
            textFieldAgregarFechaInicio.setText("");
            textFieldAgregarFechaFinal.setText("");

            JFrame frameReservaAñadida = new JFrame();

            frameReservaAñadida.setSize(400, 200);
            frameReservaAñadida.setResizable(false);
            frameReservaAñadida.setLocationRelativeTo(null);

            JLabel labelReservaAñadida = new JLabel("Reserva añadida con éxito!");

            labelReservaAñadida.setHorizontalAlignment(SwingConstants.CENTER);
            labelReservaAñadida.setOpaque(true);
            labelReservaAñadida.setBackground(new Color(0x90A1D3));

            frameReservaAñadida.add(labelReservaAñadida);

            frameReservaAñadida.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameAgregarReserva.add(labelAgregarIDReserva);
        frameAgregarReserva.add(textFieldAgregarIDReserva);
        frameAgregarReserva.add(labelAgregarDNICliente);
        frameAgregarReserva.add(textFieldAgregarDNICliente);
        frameAgregarReserva.add(labelAgregarTituloPeliculaReservada);
        frameAgregarReserva.add(textFieldAgregarTituloPeliculaReservada);
        frameAgregarReserva.add(labelAgregarFechaInicio);
        frameAgregarReserva.add(textFieldAgregarFechaInicio);
        frameAgregarReserva.add(labelAgregarFechaFinal);
        frameAgregarReserva.add(textFieldAgregarFechaFinal);
        frameAgregarReserva.add(buttonVolverAtras);
        frameAgregarReserva.add(buttonEnviarAgregarReserva);

        //Hacemos el frame visible
        frameAgregarReserva.setVisible(true);
    }

    public static void mostrarReservaSwing(JFrame frameGestionReservas) {
        //Creamos el frame con sus respectivas características
        JFrame frameMostrarDatosReserva = new JFrame("Mostrar Datos Reserva");
        frameMostrarDatosReserva.setLayout(new GridLayout(2, 2, 5, 5));
        frameMostrarDatosReserva.setSize(600, 230);
        frameMostrarDatosReserva.setResizable(false);
        frameMostrarDatosReserva.setLocationRelativeTo(null);
        frameMostrarDatosReserva.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionReservas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelMostrarDatosReserva = new JLabel("Introduce el ID de la reserva:");
        JTextField textFieldMostrarDatosReserva = new JTextField();

        //Centramos el texto de las labels
        labelMostrarDatosReserva.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelMostrarDatosReserva.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelMostrarDatosReserva.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarMostrarDatos = new JButton("Consultar");

        //Cambiamos el color de los botones
        buttonEnviarMostrarDatos.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameMostrarDatosReserva.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameMostrarDatosReserva.setVisible(false);
            frameGestionReservas.setVisible(true);
        });
        buttonEnviarMostrarDatos.addActionListener(_ -> {
            String IDReservaConsultada = textFieldMostrarDatosReserva.getText();

            Reservas.mostrarReserva(IDReservaConsultada);

            textFieldMostrarDatosReserva.setText("");
        });

        //Añadimos los elementos al frame
        frameMostrarDatosReserva.add(labelMostrarDatosReserva);
        frameMostrarDatosReserva.add(textFieldMostrarDatosReserva);
        frameMostrarDatosReserva.add(buttonVolverAtras);
        frameMostrarDatosReserva.add(buttonEnviarMostrarDatos);

        //Hacemos el frame visible
        frameMostrarDatosReserva.setVisible(true);
    }

    public static void modificarReservaSwing(JFrame frameGestionReservas){
        //Creamos el frame con sus respectivas características
        JFrame frameModificarDatosReserva = new JFrame("Modificar Datos Reserva");
        frameModificarDatosReserva.setLayout(new GridLayout(6, 2, 5, 5));
        frameModificarDatosReserva.setSize(600, 600);
        frameModificarDatosReserva.setResizable(false);
        frameModificarDatosReserva.setLocationRelativeTo(null);
        frameModificarDatosReserva.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionReservas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelModificarIDReserva = new JLabel("ID Reserva a modificar:");
        JTextField textFieldModificarIDReserva = new JTextField();

        JLabel labelModificarDNICliente = new JLabel("Nuevo DNI Cliente:");
        JTextField textFieldModificarDNICliente = new JTextField();

        JLabel labelModificarTituloPeliculaReservada = new JLabel("Nuevo Título película:");
        JTextField textFieldModificarTituloPeliculaReservada = new JTextField();

        JLabel labelModificarFechaInicio = new JLabel("Nueva Fecha de Inicio (DD-MM-YYYY):");
        JTextField textFieldModificarFechaInicio = new JTextField();

        JLabel labelModificarFechaFinal = new JLabel("Nueva Fecha Final (DD-MM-YYYY):");
        JTextField textFieldModificarFechaFinal = new JTextField();

        //Centramos el texto de las labels
        labelModificarIDReserva.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarDNICliente.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarTituloPeliculaReservada.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarFechaFinal.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelModificarIDReserva.setOpaque(true);
        labelModificarDNICliente.setOpaque(true);
        labelModificarTituloPeliculaReservada.setOpaque(true);
        labelModificarFechaInicio.setOpaque(true);
        labelModificarFechaFinal.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelModificarIDReserva.setBackground(new Color(198, 232, 210));
        labelModificarDNICliente.setBackground(new Color(198, 232, 210));
        labelModificarTituloPeliculaReservada.setBackground(new Color(198, 232, 210));
        labelModificarFechaInicio.setBackground(new Color(198, 232, 210));
        labelModificarFechaFinal.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarModificarReserva = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarModificarReserva.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameModificarDatosReserva.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameModificarDatosReserva.setVisible(false);
            frameGestionReservas.setVisible(true);
        });
        buttonEnviarModificarReserva.addActionListener(_ -> {
            String idReservaModificada = textFieldModificarIDReserva.getText();
            String nuevoDNIcliente = textFieldModificarDNICliente.getText();
            String nuevotituloPeliculaReservada = textFieldModificarTituloPeliculaReservada.getText();
            String nuevafechaInicio = textFieldModificarFechaInicio.getText();
            String nuevafechaFinal = textFieldModificarFechaFinal.getText();

            Reservas.modificarReserva(idReservaModificada, nuevoDNIcliente, nuevotituloPeliculaReservada, nuevafechaInicio, nuevafechaFinal);

            textFieldModificarIDReserva.setText("");
            textFieldModificarDNICliente.setText("");
            textFieldModificarTituloPeliculaReservada.setText("");
            textFieldModificarFechaInicio.setText("");
            textFieldModificarFechaFinal.setText("");

            JFrame frameReservaModificada = new JFrame();

            frameReservaModificada.setSize(400, 200);
            frameReservaModificada.setResizable(false);
            frameReservaModificada.setLocationRelativeTo(null);

            JLabel labelReservaModificada = new JLabel("Reserva modificada con éxito!");

            labelReservaModificada.setHorizontalAlignment(SwingConstants.CENTER);
            labelReservaModificada.setOpaque(true);
            labelReservaModificada.setBackground(new Color(0x90A1D3));

            frameReservaModificada.add(labelReservaModificada);

            frameReservaModificada.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameModificarDatosReserva.add(labelModificarIDReserva);
        frameModificarDatosReserva.add(textFieldModificarIDReserva);
        frameModificarDatosReserva.add(labelModificarDNICliente);
        frameModificarDatosReserva.add(textFieldModificarDNICliente);
        frameModificarDatosReserva.add(labelModificarTituloPeliculaReservada);
        frameModificarDatosReserva.add(textFieldModificarTituloPeliculaReservada);
        frameModificarDatosReserva.add(labelModificarFechaInicio);
        frameModificarDatosReserva.add(textFieldModificarFechaInicio);
        frameModificarDatosReserva.add(labelModificarFechaFinal);
        frameModificarDatosReserva.add(textFieldModificarFechaFinal);
        frameModificarDatosReserva.add(buttonVolverAtras);
        frameModificarDatosReserva.add(buttonEnviarModificarReserva);

        //Hacemos el frame visible
        frameModificarDatosReserva.setVisible(true);
    }

    public static void eliminarReservaSwing(JFrame frameGestionReservas){
        //Creamos el frame con sus respectivas características
        JFrame frameEliminarReserva = new JFrame("Eliminar Reserva");
        frameEliminarReserva.setLayout(new GridLayout(2, 2, 5, 5));
        frameEliminarReserva.setSize(600, 230);
        frameEliminarReserva.setResizable(false);
        frameEliminarReserva.setLocationRelativeTo(null);
        frameEliminarReserva.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionReservas.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelEliminarReserva = new JLabel("Introduce el ID de la reserva a eliminar:");
        JTextField textFieldEliminarReserva = new JTextField();

        //Centramos el texto de las labels
        labelEliminarReserva.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelEliminarReserva.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelEliminarReserva.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarEliminarReserva = new JButton("Eliminar");

        //Cambiamos el color de los botones
        buttonEnviarEliminarReserva.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameEliminarReserva.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameEliminarReserva.setVisible(false);
            frameGestionReservas.setVisible(true);
        });
        buttonEnviarEliminarReserva.addActionListener(_ -> {
            String tituloReservaEliminada = textFieldEliminarReserva.getText();

            Reservas.eliminarReservas(tituloReservaEliminada);

            textFieldEliminarReserva.setText("");

            JFrame frameReservaEliminada = new JFrame();

            frameReservaEliminada.setSize(400, 200);
            frameReservaEliminada.setResizable(false);
            frameReservaEliminada.setLocationRelativeTo(null);

            JLabel labelReservaEliminada = new JLabel("Reserva eliminada con éxito!");

            labelReservaEliminada.setHorizontalAlignment(SwingConstants.CENTER);
            labelReservaEliminada.setOpaque(true);
            labelReservaEliminada.setBackground(new Color(0x90A1D3));

            frameReservaEliminada.add(labelReservaEliminada);

            frameReservaEliminada.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameEliminarReserva.add(labelEliminarReserva);
        frameEliminarReserva.add(textFieldEliminarReserva);
        frameEliminarReserva.add(buttonVolverAtras);
        frameEliminarReserva.add(buttonEnviarEliminarReserva);

        //Hacemos el frame visible
        frameEliminarReserva.setVisible(true);
    }

    public static void mostrarTablaReservasSwing(){
        Reservas.mostrarTabla();
    }
    
    //Métodos Swing Gestión de Empleados
    public static void agregarEmpleadoSwing(JFrame frameGestionEmpleados){
        //Creamos el frame con sus respectivas características
        JFrame frameAgregarEmpleado = new JFrame("Agregar Empleado");
        frameAgregarEmpleado.setLayout(new GridLayout(5, 2, 5, 5));
        frameAgregarEmpleado.setSize(600, 500);
        frameAgregarEmpleado.setResizable(false);
        frameAgregarEmpleado.setLocationRelativeTo(null);
        frameAgregarEmpleado.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionEmpleados.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelAgregarIDEmpleado = new JLabel("ID:");
        JTextField textFieldAgregarIDEmpleado = new JTextField();

        JLabel labelAgregarDNIEmpleado = new JLabel("DNI:");
        JTextField textFieldAgregarDNIEmpleado = new JTextField();

        JLabel labelAgregarNombreEmpleado = new JLabel("Nombre:");
        JTextField textFieldAgregarNombreEmpleado = new JTextField();

        JLabel labelAgregarApellidosEmpleado = new JLabel("Apellidos:");
        JTextField textFieldAgregarApellidosEmpleado = new JTextField();

        //Centramos el texto de las labels
        labelAgregarIDEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarDNIEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarNombreEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarApellidosEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelAgregarIDEmpleado.setOpaque(true);
        labelAgregarDNIEmpleado.setOpaque(true);
        labelAgregarNombreEmpleado.setOpaque(true);
        labelAgregarApellidosEmpleado.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelAgregarIDEmpleado.setBackground(new Color(198, 232, 210));
        labelAgregarDNIEmpleado.setBackground(new Color(198, 232, 210));
        labelAgregarNombreEmpleado.setBackground(new Color(198, 232, 210));
        labelAgregarApellidosEmpleado.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarAgregarEmpleado = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarAgregarEmpleado.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameAgregarEmpleado.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameAgregarEmpleado.setVisible(false);
            frameGestionEmpleados.setVisible(true);
        });
        buttonEnviarAgregarEmpleado.addActionListener(_ -> {
            String idEmpleado = textFieldAgregarIDEmpleado.getText();
            String DNIempleado = textFieldAgregarDNIEmpleado.getText();
            String nombreEmpleado = textFieldAgregarNombreEmpleado.getText();
            String apellidosEmpleado = textFieldAgregarApellidosEmpleado.getText();

            Empleados.agregarEmpleados(idEmpleado, DNIempleado, nombreEmpleado, apellidosEmpleado);

            textFieldAgregarIDEmpleado.setText("");
            textFieldAgregarDNIEmpleado.setText("");
            textFieldAgregarNombreEmpleado.setText("");
            textFieldAgregarApellidosEmpleado.setText("");

            JFrame frameEmpleadoAñadido = new JFrame();

            frameEmpleadoAñadido.setSize(400, 200);
            frameEmpleadoAñadido.setResizable(false);
            frameEmpleadoAñadido.setLocationRelativeTo(null);

            JLabel labelEmpleadoAñadido = new JLabel("Empleado añadido con éxito!");

            labelEmpleadoAñadido.setHorizontalAlignment(SwingConstants.CENTER);
            labelEmpleadoAñadido.setOpaque(true);
            labelEmpleadoAñadido.setBackground(new Color(0x90A1D3));

            frameEmpleadoAñadido.add(labelEmpleadoAñadido);

            frameEmpleadoAñadido.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameAgregarEmpleado.add(labelAgregarIDEmpleado);
        frameAgregarEmpleado.add(textFieldAgregarIDEmpleado);
        frameAgregarEmpleado.add(labelAgregarDNIEmpleado);
        frameAgregarEmpleado.add(textFieldAgregarDNIEmpleado);
        frameAgregarEmpleado.add(labelAgregarNombreEmpleado);
        frameAgregarEmpleado.add(textFieldAgregarNombreEmpleado);
        frameAgregarEmpleado.add(labelAgregarApellidosEmpleado);
        frameAgregarEmpleado.add(textFieldAgregarApellidosEmpleado);
        frameAgregarEmpleado.add(buttonVolverAtras);
        frameAgregarEmpleado.add(buttonEnviarAgregarEmpleado);

        //Hacemos el frame visible
        frameAgregarEmpleado.setVisible(true);
    }

    public static void mostrarEmpleadoSwing(JFrame frameGestionEmpleados){
        //Creamos el frame con sus respectivas características
        JFrame frameMostrarDatosEmpleado = new JFrame("Mostrar Datos Empleado");
        frameMostrarDatosEmpleado.setLayout(new GridLayout(2, 2, 5, 5));
        frameMostrarDatosEmpleado.setSize(600, 230);
        frameMostrarDatosEmpleado.setResizable(false);
        frameMostrarDatosEmpleado.setLocationRelativeTo(null);
        frameMostrarDatosEmpleado.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionEmpleados.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelMostrarDatosEmpleado = new JLabel("Introduce el ID del empleado:");
        JTextField textFieldMostrarDatosEmpleado = new JTextField();

        //Centramos el texto de las labels
        labelMostrarDatosEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelMostrarDatosEmpleado.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelMostrarDatosEmpleado.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarMostrarDatos = new JButton("Consultar");

        //Cambiamos el color de los botones
        buttonEnviarMostrarDatos.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameMostrarDatosEmpleado.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameMostrarDatosEmpleado.setVisible(false);
            frameGestionEmpleados.setVisible(true);
        });
        buttonEnviarMostrarDatos.addActionListener(_ -> {
            String IDEmpleadoConsultado = textFieldMostrarDatosEmpleado.getText();

            Empleados.mostrarEmpleado(IDEmpleadoConsultado);

            textFieldMostrarDatosEmpleado.setText("");
        });

        //Añadimos los elementos al frame
        frameMostrarDatosEmpleado.add(labelMostrarDatosEmpleado);
        frameMostrarDatosEmpleado.add(textFieldMostrarDatosEmpleado);
        frameMostrarDatosEmpleado.add(buttonVolverAtras);
        frameMostrarDatosEmpleado.add(buttonEnviarMostrarDatos);

        //Hacemos el frame visible
        frameMostrarDatosEmpleado.setVisible(true);
    }

    public static void modificarEmpleadoSwing(JFrame frameGestionEmpleados){
        //Creamos el frame con sus respectivas características
        JFrame frameModificarDatosEmpleado = new JFrame("Modificar Datos Empleado");
        frameModificarDatosEmpleado.setLayout(new GridLayout(5, 2, 5, 5));
        frameModificarDatosEmpleado.setSize(600, 500);
        frameModificarDatosEmpleado.setResizable(false);
        frameModificarDatosEmpleado.setLocationRelativeTo(null);
        frameModificarDatosEmpleado.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionEmpleados.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelModificarIDEmpleado = new JLabel("ID Empleado a modificar:");
        JTextField textFieldModificarIDEmpleado = new JTextField();

        JLabel labelModificarDNIEmpleado = new JLabel("Nuevo DNI Empleado:");
        JTextField textFieldModificarDNIEmpleado = new JTextField();

        JLabel labelModificarNombreEmpleado = new JLabel("Nuevo Nombre:");
        JTextField textFieldModificarNombreEmpleado = new JTextField();

        JLabel labelModificarApellidosEmpleado = new JLabel("Nuevos Apellidos:");
        JTextField textFieldModificarApellidosEmpleado = new JTextField();

        //Centramos el texto de las labels
        labelModificarIDEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarDNIEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarNombreEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarApellidosEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelModificarIDEmpleado.setOpaque(true);
        labelModificarDNIEmpleado.setOpaque(true);
        labelModificarNombreEmpleado.setOpaque(true);
        labelModificarApellidosEmpleado.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelModificarIDEmpleado.setBackground(new Color(198, 232, 210));
        labelModificarDNIEmpleado.setBackground(new Color(198, 232, 210));
        labelModificarNombreEmpleado.setBackground(new Color(198, 232, 210));
        labelModificarApellidosEmpleado.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarModificarEmpleado = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarModificarEmpleado.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameModificarDatosEmpleado.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameModificarDatosEmpleado.setVisible(false);
            frameGestionEmpleados.setVisible(true);
        });
        buttonEnviarModificarEmpleado.addActionListener(_ -> {
            String idEmpleadoModificado = textFieldModificarIDEmpleado.getText();
            String nuevoDNIempleado = textFieldModificarDNIEmpleado.getText();
            String nuevoNombre = textFieldModificarNombreEmpleado.getText();
            String nuevosApellidos = textFieldModificarApellidosEmpleado.getText();

            Empleados.modificarEmpleado(idEmpleadoModificado, nuevoDNIempleado, nuevoNombre, nuevosApellidos);

            textFieldModificarIDEmpleado.setText("");
            textFieldModificarDNIEmpleado.setText("");
            textFieldModificarNombreEmpleado.setText("");
            textFieldModificarApellidosEmpleado.setText("");

            JFrame frameEmpleadoModificado = new JFrame();

            frameEmpleadoModificado.setSize(400, 200);
            frameEmpleadoModificado.setResizable(false);
            frameEmpleadoModificado.setLocationRelativeTo(null);

            JLabel labelEmpleadoModificado = new JLabel("Empleado modificado con éxito!");

            labelEmpleadoModificado.setHorizontalAlignment(SwingConstants.CENTER);
            labelEmpleadoModificado.setOpaque(true);
            labelEmpleadoModificado.setBackground(new Color(0x90A1D3));

            frameEmpleadoModificado.add(labelEmpleadoModificado);

            frameEmpleadoModificado.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameModificarDatosEmpleado.add(labelModificarIDEmpleado);
        frameModificarDatosEmpleado.add(textFieldModificarIDEmpleado);
        frameModificarDatosEmpleado.add(labelModificarDNIEmpleado);
        frameModificarDatosEmpleado.add(textFieldModificarDNIEmpleado);
        frameModificarDatosEmpleado.add(labelModificarNombreEmpleado);
        frameModificarDatosEmpleado.add(textFieldModificarNombreEmpleado);
        frameModificarDatosEmpleado.add(labelModificarApellidosEmpleado);
        frameModificarDatosEmpleado.add(textFieldModificarApellidosEmpleado);
        frameModificarDatosEmpleado.add(buttonVolverAtras);
        frameModificarDatosEmpleado.add(buttonEnviarModificarEmpleado);

        //Hacemos el frame visible
        frameModificarDatosEmpleado.setVisible(true);
    }

    public static void eliminarEmpleadoSwing(JFrame frameGestionEmpleados){
        //Creamos el frame con sus respectivas características
        JFrame frameEliminarEmpleado = new JFrame("Eliminar Empleado");
        frameEliminarEmpleado.setLayout(new GridLayout(2, 2, 5, 5));
        frameEliminarEmpleado.setSize(600, 230);
        frameEliminarEmpleado.setResizable(false);
        frameEliminarEmpleado.setLocationRelativeTo(null);
        frameEliminarEmpleado.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionEmpleados.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelEliminarEmpleado = new JLabel("Introduce el ID del empleado a eliminar:");
        JTextField textFieldEliminarEmpleado = new JTextField();

        //Centramos el texto de las labels
        labelEliminarEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelEliminarEmpleado.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelEliminarEmpleado.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarEliminarEmpleado = new JButton("Eliminar");

        //Cambiamos el color de los botones
        buttonEnviarEliminarEmpleado.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameEliminarEmpleado.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameEliminarEmpleado.setVisible(false);
            frameGestionEmpleados.setVisible(true);
        });
        buttonEnviarEliminarEmpleado.addActionListener(_ -> {
            String tituloEmpleadoEliminado = textFieldEliminarEmpleado.getText();

            Empleados.eliminarEmpleado(tituloEmpleadoEliminado);

            textFieldEliminarEmpleado.setText("");

            JFrame frameEmpleadoEliminado = new JFrame();

            frameEmpleadoEliminado.setSize(400, 200);
            frameEmpleadoEliminado.setResizable(false);
            frameEmpleadoEliminado.setLocationRelativeTo(null);

            JLabel labelEmpleadoEliminado = new JLabel("Empleado eliminado con éxito!");

            labelEmpleadoEliminado.setHorizontalAlignment(SwingConstants.CENTER);
            labelEmpleadoEliminado.setOpaque(true);
            labelEmpleadoEliminado.setBackground(new Color(0x90A1D3));

            frameEmpleadoEliminado.add(labelEmpleadoEliminado);

            frameEmpleadoEliminado.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameEliminarEmpleado.add(labelEliminarEmpleado);
        frameEliminarEmpleado.add(textFieldEliminarEmpleado);
        frameEliminarEmpleado.add(buttonVolverAtras);
        frameEliminarEmpleado.add(buttonEnviarEliminarEmpleado);

        //Hacemos visible el frame
        frameEliminarEmpleado.setVisible(true);
    }

    public static void mostrarTablaEmpleadosSwing(){
        Empleados.mostrarTabla();
    }

    //Métodos Swing Gestión de Clientes
    public static void agregarClienteSwing(JFrame frameGestionClientes){
        //Creamos el frame con sus respectivas características
        JFrame frameAgregarCliente = new JFrame("Agregar Cliente");
        frameAgregarCliente.setLayout(new GridLayout(4, 2, 5, 5));
        frameAgregarCliente.setSize(600, 400);
        frameAgregarCliente.setResizable(false);
        frameAgregarCliente.setLocationRelativeTo(null);
        frameAgregarCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionClientes.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelAgregarDNICliente = new JLabel("DNI:");
        JTextField textFieldAgregarDNICliente = new JTextField();

        JLabel labelAgregarNombreCliente = new JLabel("Nombre:");
        JTextField textFieldAgregarNombreCliente = new JTextField();

        JLabel labelAgregarApellidosCliente = new JLabel("Apellidos:");
        JTextField textFieldAgregarApellidosCliente = new JTextField();

        //Centramos el texto de las labels
        labelAgregarDNICliente.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarNombreCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAgregarApellidosCliente.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelAgregarDNICliente.setOpaque(true);
        labelAgregarNombreCliente.setOpaque(true);
        labelAgregarApellidosCliente.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelAgregarDNICliente.setBackground(new Color(198, 232, 210));
        labelAgregarNombreCliente.setBackground(new Color(198, 232, 210));
        labelAgregarApellidosCliente.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarAgregarCliente = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarAgregarCliente.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameAgregarCliente.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameAgregarCliente.setVisible(false);
            frameGestionClientes.setVisible(true);
        });
        buttonEnviarAgregarCliente.addActionListener(_ -> {
            String DNICliente = textFieldAgregarDNICliente.getText();
            String nombreCliente = textFieldAgregarNombreCliente.getText();
            String apellidosCliente = textFieldAgregarApellidosCliente.getText();

            Clientes.agregarClientes(DNICliente, nombreCliente, apellidosCliente);

            textFieldAgregarDNICliente.setText("");
            textFieldAgregarNombreCliente.setText("");
            textFieldAgregarApellidosCliente.setText("");

            JFrame frameClienteAñadido = new JFrame();

            frameClienteAñadido.setSize(400, 200);
            frameClienteAñadido.setResizable(false);
            frameClienteAñadido.setLocationRelativeTo(null);

            JLabel labelClienteAñadido = new JLabel("Cliente añadido con éxito!");

            labelClienteAñadido.setHorizontalAlignment(SwingConstants.CENTER);
            labelClienteAñadido.setOpaque(true);
            labelClienteAñadido.setBackground(new Color(0x90A1D3));

            frameClienteAñadido.add(labelClienteAñadido);

            frameClienteAñadido.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameAgregarCliente.add(labelAgregarDNICliente);
        frameAgregarCliente.add(textFieldAgregarDNICliente);
        frameAgregarCliente.add(labelAgregarNombreCliente);
        frameAgregarCliente.add(textFieldAgregarNombreCliente);
        frameAgregarCliente.add(labelAgregarApellidosCliente);
        frameAgregarCliente.add(textFieldAgregarApellidosCliente);
        frameAgregarCliente.add(buttonVolverAtras);
        frameAgregarCliente.add(buttonEnviarAgregarCliente);

        //Hacemos visible el frame
        frameAgregarCliente.setVisible(true);
    }

    public static void mostrarClienteSwing(JFrame frameGestionClientes){
        //Creamos el frame con sus respectivas características
        JFrame frameMostrarDatosCliente = new JFrame("Mostrar Datos Cliente");
        frameMostrarDatosCliente.setLayout(new GridLayout(2, 2, 5, 5));
        frameMostrarDatosCliente.setSize(600, 230);
        frameMostrarDatosCliente.setResizable(false);
        frameMostrarDatosCliente.setLocationRelativeTo(null);
        frameMostrarDatosCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionClientes.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelMostrarDatosCliente = new JLabel("Introduce el ID del cliente:");
        JTextField textFieldMostrarDatosCliente = new JTextField();

        //Centramos el texto de las labels
        labelMostrarDatosCliente.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelMostrarDatosCliente.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelMostrarDatosCliente.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarMostrarDatos = new JButton("Consultar");

        //Cambiamos el color de los botones
        buttonEnviarMostrarDatos.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameMostrarDatosCliente.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameMostrarDatosCliente.setVisible(false);
            frameGestionClientes.setVisible(true);
        });
        buttonEnviarMostrarDatos.addActionListener(_ -> {
            String IDClienteConsultado = textFieldMostrarDatosCliente.getText();

            Clientes.mostrarCliente(IDClienteConsultado);

            textFieldMostrarDatosCliente.setText("");
        });

        //Añadimos los elementos al frame
        frameMostrarDatosCliente.add(labelMostrarDatosCliente);
        frameMostrarDatosCliente.add(textFieldMostrarDatosCliente);
        frameMostrarDatosCliente.add(buttonVolverAtras);
        frameMostrarDatosCliente.add(buttonEnviarMostrarDatos);

        //Hacemos el frame visible
        frameMostrarDatosCliente.setVisible(true);
    }

    public static void modificarClienteSwing(JFrame frameGestionClientes){
        //Creamos el frame con sus respectivas características
        JFrame frameModificarDatosCliente = new JFrame("Modificar Datos Cliente");
        frameModificarDatosCliente.setLayout(new GridLayout(4, 2, 5, 5));
        frameModificarDatosCliente.setSize(600, 400);
        frameModificarDatosCliente.setResizable(false);
        frameModificarDatosCliente.setLocationRelativeTo(null);
        frameModificarDatosCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionClientes.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelModificarDNICliente = new JLabel("DNI Cliente a modificar:");
        JTextField textFieldModificarDNICliente = new JTextField();

        JLabel labelModificarNombreCliente = new JLabel("Nuevo Nombre:");
        JTextField textFieldModificarNombreCliente = new JTextField();

        JLabel labelModificarApellidosCliente = new JLabel("Nuevos Apellidos:");
        JTextField textFieldModificarApellidosCliente = new JTextField();

        //Centramos el texto de las labels
        labelModificarDNICliente.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarNombreCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModificarApellidosCliente.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelModificarDNICliente.setOpaque(true);
        labelModificarNombreCliente.setOpaque(true);
        labelModificarApellidosCliente.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelModificarDNICliente.setBackground(new Color(198, 232, 210));
        labelModificarNombreCliente.setBackground(new Color(198, 232, 210));
        labelModificarApellidosCliente.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarModificarCliente = new JButton("Enviar");

        //Cambiamos el color de los botones
        buttonEnviarModificarCliente.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameModificarDatosCliente.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameModificarDatosCliente.setVisible(false);
            frameGestionClientes.setVisible(true);
        });
        buttonEnviarModificarCliente.addActionListener(_ -> {
            String DNIClienteModificado = textFieldModificarDNICliente.getText();
            String nuevoNombre = textFieldModificarNombreCliente.getText();
            String nuevosApellidos = textFieldModificarApellidosCliente.getText();

            Clientes.modificarCliente(DNIClienteModificado, nuevoNombre, nuevosApellidos);

            textFieldModificarDNICliente.setText("");
            textFieldModificarNombreCliente.setText("");
            textFieldModificarApellidosCliente.setText("");

            JFrame frameClienteModificado = new JFrame();

            frameClienteModificado.setSize(400, 200);
            frameClienteModificado.setResizable(false);
            frameClienteModificado.setLocationRelativeTo(null);

            JLabel labelClienteModificado = new JLabel("Cliente modificado con éxito!");

            labelClienteModificado.setHorizontalAlignment(SwingConstants.CENTER);
            labelClienteModificado.setOpaque(true);
            labelClienteModificado.setBackground(new Color(0x90A1D3));

            frameClienteModificado.add(labelClienteModificado);

            frameClienteModificado.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameModificarDatosCliente.add(labelModificarDNICliente);
        frameModificarDatosCliente.add(textFieldModificarDNICliente);
        frameModificarDatosCliente.add(labelModificarNombreCliente);
        frameModificarDatosCliente.add(textFieldModificarNombreCliente);
        frameModificarDatosCliente.add(labelModificarApellidosCliente);
        frameModificarDatosCliente.add(textFieldModificarApellidosCliente);
        frameModificarDatosCliente.add(buttonVolverAtras);
        frameModificarDatosCliente.add(buttonEnviarModificarCliente);

        //Hacemos el frame visible
        frameModificarDatosCliente.setVisible(true);
    }

    public static void eliminarClienteSwing(JFrame frameGestionClientes){
        //Creamos el frame con sus respectivas características
        JFrame frameEliminarCliente = new JFrame("Eliminar Cliente");
        frameEliminarCliente.setLayout(new GridLayout(2, 2, 5, 5));
        frameEliminarCliente.setSize(600, 230);
        frameEliminarCliente.setResizable(false);
        frameEliminarCliente.setLocationRelativeTo(null);
        frameEliminarCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ocultamos el frame anterior
        frameGestionClientes.setVisible(false);

        //Creamos las etiquetas y los textFields
        JLabel labelEliminarCliente = new JLabel("Introduce el ID del cliente a eliminar:");
        JTextField textFieldEliminarCliente = new JTextField();

        //Centramos el texto de las labels
        labelEliminarCliente.setHorizontalAlignment(SwingConstants.RIGHT);

        //Definimos las etiquetas opacas para poder cambiarles el color
        labelEliminarCliente.setOpaque(true);

        //Cambiamos el color de las etiquetas
        labelEliminarCliente.setBackground(new Color(198, 232, 210));

        //Creamos los botones
        JButton buttonVolverAtras = new JButton("Volver");
        JButton buttonEnviarEliminarCliente = new JButton("Eliminar");

        //Cambiamos el color de los botones
        buttonEnviarEliminarCliente.setBackground(new Color(125, 210, 181));
        buttonVolverAtras.setBackground(new Color(225, 83, 83));

        //Cambiamos el color del frame
        frameEliminarCliente.getContentPane().setBackground(new Color(198, 232, 210));

        //Definimos las acciones de los botones
        buttonVolverAtras.addActionListener(_ -> {
            frameEliminarCliente.setVisible(false);
            frameGestionClientes.setVisible(true);
        });
        buttonEnviarEliminarCliente.addActionListener(_ -> {
            String tituloClienteEliminado = textFieldEliminarCliente.getText();

            Clientes.eliminarCliente(tituloClienteEliminado);

            textFieldEliminarCliente.setText("");

            JFrame frameClienteEliminado = new JFrame();

            frameClienteEliminado.setSize(400, 200);
            frameClienteEliminado.setResizable(false);
            frameClienteEliminado.setLocationRelativeTo(null);

            JLabel labelClienteEliminado = new JLabel("Cliente eliminado con éxito!");

            labelClienteEliminado.setHorizontalAlignment(SwingConstants.CENTER);
            labelClienteEliminado.setOpaque(true);
            labelClienteEliminado.setBackground(new Color(0x90A1D3));

            frameClienteEliminado.add(labelClienteEliminado);

            frameClienteEliminado.setVisible(true);
        });

        //Añadimos los elementos al frame
        frameEliminarCliente.add(labelEliminarCliente);
        frameEliminarCliente.add(textFieldEliminarCliente);
        frameEliminarCliente.add(buttonVolverAtras);
        frameEliminarCliente.add(buttonEnviarEliminarCliente);

        //Hacemos el frame visible
        frameEliminarCliente.setVisible(true);
    }

    public static void mostrarTablaClientesSwing(){
        Clientes.mostrarTabla();
    }
}