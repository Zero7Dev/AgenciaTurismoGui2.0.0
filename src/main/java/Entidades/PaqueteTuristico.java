package Entidades;

import administracion.AdministradorPaquetesTuristicos;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class PaqueteTuristico {

    public static void gestionarPaquetesTuristicos() {
        Scanner scanner = new Scanner(System.in);
        AdministradorPaquetesTuristicos adminPaquetes = new AdministradorPaquetesTuristicos();
                    List<PaqueteTuristico> listaPaquetes = adminPaquetes.obtenerTodosLosPaquetesTuristicos();

        while (true) {
            System.out.println(" ===== Menu Paquetes Turisticos: =====");
            System.out.println("1. Agregar Paquete Turistico: ");
            System.out.println("2. Mostrar todos los Paquetes Turisticos: ");
            System.out.println("3. Mostrar Paquetes Turisticos por nombre: ");
            System.out.println("4. Mostrar todos los Paquetes id: ");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
                
            switch (opcion) {
                case 1:
                    System.out.println("Añadir Paquete Turistico");
                    adminPaquetes.agregarPaqueteTuristico();
                    break;
                case 2:
                    System.out.println("Lista de paquetes: ");
                    adminPaquetes.MostrarPaquetes();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del Paquete que desea saber su informacion:");
                    for (int i = 0; i < listaPaquetes.size(); i++) {
                        System.out.println(listaPaquetes.get(i).getId() + ". " + listaPaquetes.get(i).nombre);
                    }
                    System.out.print("Opcion:");
                    String nombrePaqueteBuscar = scanner.nextLine();
                    adminPaquetes.mostrarPaqueteTuristico(nombrePaqueteBuscar);
                    break;
                case 4:
                    System.out.println("Ingrese el id del Paquete que desea saber su informacion: ");
                    for (int i = 0; i < listaPaquetes.size(); i++) {
                        System.out.println(listaPaquetes.get(i).getId() + ". " + listaPaquetes.get(i).nombre);
                    }
                    System.out.print("Opcion:");
                    adminPaquetes.MostrarPaqueteXid(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

    private int id;
    private String nombre;
    private String destino;
    private int duracion;
    private double precio;
    private boolean comidaIncluida;
    private String[] actividades;

    public PaqueteTuristico(String destino, int duracion) {
        this.destino = destino;
        this.duracion = duracion;
    }

    public PaqueteTuristico(int id, String nombre, String destino, int duracion, double precio, boolean comidaIncluida, String[] actividades) {
        this.id = id;
        this.nombre = nombre;
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
        this.comidaIncluida = comidaIncluida;
        this.actividades = actividades;
    }

    public String getDescripcion() {
        return this.toString();
    }

    public String[] getActividades() {
        return actividades;
    }

    public String getNombrePaquete() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setId(int id) {
        if (id > 0 && id <= 1000) {
            this.id = id;
        } else {
            System.out.println("ID inválido. Debe ser mayor que 0 y menor o igual a 1000.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre inválido. Debe proporcionar un nombre válido.");
        }
    }

    public void setDestino(String destino) {
        if (destino != null && !destino.trim().isEmpty()) {
            this.destino = destino;
        } else {
            System.out.println("Destino inválido. Debe proporcionar un destino válido.");
        }
    }

    public void setActividades(String[] actividades) {
        this.actividades = actividades;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0 && duracion <= 30) {
            this.duracion = duracion;
        } else {
            System.out.println("Duración inválida. Debe ser mayor que 0 y menor o igual a 30.");
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0 && precio <= 10000) {
            this.precio = precio;
        } else {
            System.out.println("Precio inválido. Debe ser mayor que 0 y menor o igual a 10000.");
        }
    }

    public boolean isComidaIncluida() {
        return comidaIncluida;
    }

    public void setComidaIncluida(boolean comidaIncluida) {
        if (comidaIncluida || !comidaIncluida) {
            this.comidaIncluida = comidaIncluida;
        } else {
            System.out.println("Valor inválido para comidaIncluida. Use true o false.");
        }
    }

    public double calcularPrecio() {
        double precioFinal = precio;
        if (comidaIncluida) {
            precioFinal += 100;
        }
        return precioFinal;
    }

    public double calcularPrecio(int descuento) {
        double precioFinal = calcularPrecio();
        if (descuento > 0) {
            precioFinal -= (precioFinal * descuento / 100);
        }
        return precioFinal;
    }

    public double calcularPrecio(int descuento, int iva) {
        double precioFinal = calcularPrecio(descuento);
        if (iva > 0) {
            precioFinal += (precioFinal * iva / 100);
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "\n Nombre del paquete : " + nombre + "\n El lugar de viaje sera : " + destino
                + " \n Duración del viaje: " + duracion + " días \n El Precio sera de:" + precio
                + " \n Comida Incluida en el paquete : " + (comidaIncluida ? "Sí" : "No");
    }

    public PaqueteTuristico() {

    }

    public void mostrarDatosPaquete() {
        System.out.println(toString());
        System.out.println("");
    }

    public PaqueteTuristico ingresarPaquete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del paquete turístico:");
        System.out.print("Ingrese el id del paquete turístico:");
        setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nombre del paquete: ");
        String nombre = scanner.nextLine();
        System.out.print("Ciudad a donde se realizara el viaje: ");
        String destino = scanner.nextLine();
        System.out.print("Duración del viaje en días: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();
        if (duracion > 0) {
            setDuracion(duracion);
        }
        System.out.print("Precio del viaje: ");
        setPrecio(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("¿Comida incluida? (Si/No): ");
        boolean comidaIncluida = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("Número de actividades: ");
        int numActividades = scanner.nextInt();
        scanner.nextLine();
        String[] actividades = new String[numActividades];

        for (int e = 0; e < numActividades; e++) {
            System.out.print("Actividad " + (e + 1) + ": ");
            actividades[e] = scanner.nextLine();
        }

        PaqueteTuristico paquete = new PaqueteTuristico(id, nombre, destino, duracion, precio, comidaIncluida, actividades);
        return paquete;
    }

}
