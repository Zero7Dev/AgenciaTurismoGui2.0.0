package Entidades;

//import java.util.ArrayList;
import administracion.AdministradorReservas;
import administracion.AdministradorPaquetesTuristicos;
import administracion.AdministradorClientes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Reserva {

    private int hora;
    private String correo;
    private int precio;
    private String cedula;
    private String pasajero[];
    private int idReserva;
    private String fecha;
    Reserva reservaNew;
    private Cliente cliente;

    public String getCorreo() {
        return correo;
    }

    public Reserva() {

    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva(PaqueteTuristico paqueteSeleccionado, Cliente client, String fecha, String correo) {
        idReserva = (int) (Math.random() * 100) + 1;
        this.fecha = fecha;
        this.correo = correo;
        this.cliente = client;
        this.paqueteSelecionado = paqueteSelecionado;
    }

    Scanner scanner = new Scanner(System.in);

    public PaqueteTuristico paqueteSelecionado;

    public Reserva ingresarDatos() {
        Reserva NewReserva = new Reserva();
        System.out.println("Ingresar datos de reserva: ");
        System.out.print("Ingrese el id de la reservacion: ");
        NewReserva.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Ingrese la hora de la reservacion: ");
        NewReserva.setHora(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Ingrese la fecha de la reserva: ");
        NewReserva.setFecha(scanner.nextLine());
        System.out.print("Ingrese el correo del cliente para la reserva: ");
        NewReserva.setCorreo(scanner.nextLine());
        System.out.print("Ingrese la cantidad de pasajeros: ");
        int cantpasajeros = scanner.nextInt();
        scanner.nextLine();
        this.pasajero = new String[cantpasajeros];
        for (int i = 0; i < this.pasajero.length; i++) {
            System.out.print("Ingrese los nombres de los pasajeros: " + (i + 1));
            this.pasajero[i] = scanner.nextLine();
        }
        NewReserva.setPasajero(this.pasajero);
        System.out.print("Ingrese el nombre del paquete turístico: ");
        String nombrePaquete = scanner.nextLine();
        System.out.println("DETALLES DEL PAQUETE TURISTICO ASOCIADOS AL NOMBRE DEL PAQUETE TURISTICO INGRESADO: ");
        NewReserva.setPaqueteSelecionado(AdministradorPaquetesTuristicos.obtenerPaqueteTuristicos(nombrePaquete));
        System.out.print("(EL CLIENTE TUVO QUE HABERSE REGUISTRASO PREVIAMENTE EN LA APLICACION: )\n Ingrese la cedula del cliente: ");
        String clienteNum = scanner.nextLine();
        System.out.println("DATOS DEL CLIENTE ASOCIADOS A LA CEDULA INGRESADA: ");
        Cliente clientex = AdministradorClientes.obtenerClienteCedula(clienteNum);
        NewReserva.setCliente(clientex);
        return NewReserva;
    }

    public String[] getPasajero() {
        return pasajero;
    }

    public void setPasajero(String[] pasajero) {
        this.pasajero = pasajero;
    }

    public PaqueteTuristico getPaqueteSelecionado() {
        return paqueteSelecionado;
    }

    public void setPaqueteSelecionado(PaqueteTuristico paqueteSelecionado) {
        this.paqueteSelecionado = paqueteSelecionado;
    }

    public void MostrarReservacion() {
        System.out.println("AGENCIA TURISMO :");
        System.out.println("..............................................");
        System.out.println("ID RESERVACION: " + getId());
        System.out.println("----------------------------------------------");
        System.out.println("DATOS DEL CLIENTE");
        System.out.println("Nombres del cliente: " + cliente.getNombres());
        System.out.println("Apellidos del cliente " + cliente.getApellidos());
        System.out.println("Direccion de Correo: " + cliente.getCorreo());
        System.out.println("Cedula: " + cliente.getCedula());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("----------------------------------------------");
        System.out.println("DATOS DE LA RESERVACION:");
        System.out.println("Hora de Reserva: " + getHora());
        System.out.println("Fecha de Reserva: " + getFecha());
        System.out.println("Correo del Cliente: " + getCorreo());
        System.out.println("Correo del : " + getPasajero().toString());
        System.out.println("----------------------------------------------");
        System.out.println("DATOS DEL  PAQUETE TURISTICO ADQUIRIDO: ");
        System.out.println("Nombre del Paquete: " + paqueteSelecionado.getNombrePaquete());
        System.out.println("Descripción del Paquete: " + paqueteSelecionado.getDescripcion());
        System.out.println("Precio del Paquete: " + paqueteSelecionado.getPrecio());
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static void gestionarReservas() {
        Scanner scanner = new Scanner(System.in);
        AdministradorReservas AdminReserva = new AdministradorReservas();
        AdministradorClientes AdminCliente = new AdministradorClientes();
        AdministradorPaquetesTuristicos AdminPaquetes = new AdministradorPaquetesTuristicos();
        while (true) {
            System.out.println("Menu Reservas: ");
            System.out.println("1. Agregar Reserva");
            System.out.println("2. Mostrar Reservas");
            System.out.println("3. Buscar Reserva por la cedula del cliente");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    AdminReserva.agregarReserva();
                    break;
                case 2:
                    AdminReserva.mostrarTodasLasReservas();
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del cliente");
                    String CedulaCliente = scanner.nextLine();
                    AdminReserva.buscarReservaXcedula(CedulaCliente);

                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no valida. Intentelo de nuevo.");
                    break;
            }
        }
    }

}
