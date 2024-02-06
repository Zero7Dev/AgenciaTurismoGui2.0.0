package Entidades;

import administracion.AdministradorClientes;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente {

    public static void gestionarClientes() {
        Scanner scanner = new Scanner(System.in);
        AdministradorClientes adminClientes = new AdministradorClientes();

        while (true) {
            System.out.println("===== Menu Clientes =====");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Mostrar Clientes");

            System.out.println("3. Buscar informacion del cliente por cedula");
            System.out.println("4. Eliminar Cliente por cedula");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Añadir Cliente");
                    adminClientes.agregarCliente();
                    break;
                case 2:
                    System.out.println("-------------------------");
                    System.out.println("Informacion Cliente:");
                    System.out.println("-------------------------");
                    adminClientes.MostrarClientes();
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del cliente para obtener su informacion: ");
                    String cedulaCliente = scanner.nextLine();
                    Cliente clienteInfo = adminClientes.obtenerClienteCedula(cedulaCliente);
                    clienteInfo.toString();
                    break;
                case 4:
                    System.out.println("Ingrese la cédula del cliente a eliminar: ");
                    String cedulaClienteEliminar = scanner.nextLine();
                    scanner.nextLine();
                    adminClientes.eliminarClienteCedula(cedulaClienteEliminar);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
    private String Nombres, Apellidos, correo;
    private float total;
    private String[] tipocliente;
    private int num_agencia, d;
    private String cedula;
    private int telefono;

// Métodos getters
    public String getCedula() {
        return cedula;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getNombres() {
        return this.Nombres;
    }

    public String getApellidos() {
        return this.Apellidos;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String[] getTipoCliente() {
        return this.tipocliente;
    }

    public int getNumAgencia() {
        return this.num_agencia;
    }

    public int getD() {
        return d;
    }

    public float getTotal() {
        return total;
    }

// Métodos setters
    public void setCedula(String cedula) {
        if (cedula.equals('0') && cedula.isEmpty() && cedula.length() < 1) {
            System.out.println("Cédula no válida");
        } else {
            this.cedula = cedula;
        }
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.length() > 5) {
            this.correo = correo;
        }
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setTelefono(int telefono) {
        if (telefono == 0 && telefono < 0) {
            System.out.println("Teléfono no válido");
            this.telefono = telefono;
        } else {
            this.telefono = telefono;
        }
    }

    public void setNombres(String Nombres) {
        if (Nombres != null && Nombres.length() > 2) {
            this.Nombres = Nombres;
        }
    }

    public void setApellidos(String Apellidos) {
        if (Apellidos != null && Apellidos.length() > 2) {
            this.Apellidos = Apellidos;
        }
    }

    public void setD(int d) {
        this.d = d;
    }

    public String[] getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(String[] tipocliente) {
        this.tipocliente = tipocliente;
    }

    public int getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(int num_agencia) {
        this.num_agencia = num_agencia;
    }

    public Cliente() {
        this.d = 10;
    }

    public Cliente(String Nombres, String Apellidos, String correo, String cedula, int telefono, String[] tipocliente, int num_agencia) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.correo = correo;
        this.tipocliente = new String[4];
        this.num_agencia = num_agencia;
    }

        boolean inis = true;
    public Cliente ingresar() {
        Cliente client = new Cliente();
        Scanner scan = new Scanner(System.in);
        System.out.println("Datos del cliente");
        System.out.print("Nombres: ");
        client.setNombres(scan.nextLine());
        System.out.print("Apellidos: ");
        client.setApellidos(scan.nextLine());
        System.out.print("Direccion del correo: ");
        client.setCorreo(scan.nextLine());
        System.out.print("Cedula de identidad: ");
        client.setCedula(scan.nextLine());
        System.out.print("Telefono: ");
        client.setTelefono(scan.nextInt());
        scan.nextLine();
        inis=true;

        System.out.println("Ha utilizado nuestro servicio anteriormente?: ");
        System.out.println("Por favor digite el numero de veces ");
        setNum_agencia(scan.nextInt());
        scan.nextLine();
        client.tipocliente = new String[getNumAgencia()];
        for (int i = 0; i < getNumAgencia(); i++) {
            System.out.print("Opinion sobre su expericia #" + (i + 1) + ": ");
            client.tipocliente[i] = scan.nextLine();
        }
        return client;
    }

    public int Calcularprecio() {
        if (num_agencia == 0) {
            d += 12;
        }
        if (num_agencia == 1) {
            d += 15;
        }
        if (num_agencia > 1) {
            d += 20;
        }
        return 0;

    }

    public float Calcularprecio(float des) {
        if (num_agencia > 10) {
            des = 0.10F * num_agencia;
        }
        return 0;

    }

    public double Calcularprecio(double ss) {
        if (num_agencia > 20) {
            ss = 0.20 * num_agencia;
        }
        return 0;
    }

    public void Mostrar() {
        System.out.println("                                                 ");
        System.out.println("----------------------------------------------");
        System.out.println("Datos de Registro del cliente");
        System.out.println("----------------------------------------------");
        Calcularprecio();
        System.out.println("Nombres del cliente: " + getNombres());
        System.out.println("Apellidos del cliente " + getApellidos());
        System.out.println("Direccion de Correo: " + getCorreo());
        System.out.println("Cedula: " + getCedula());
        System.out.println("Telefono: " + getTelefono());
        for (int i = 0; i < getNumAgencia(); i++) {
            System.out.println("opiniones: " + this.tipocliente[i]);
        }
        if (inis) {
            System.out.println("Por el uso de nuestros servicios con anterioridad usted ha conseguido un descuento de: $" + Calcularprecio() + "en su proxima compra");
            System.out.println("Registro de datos exitoso");
            inis = false;
        }
    }

    @Override
    public String toString() {
        return "\n cedula: " + getCedula()
                + "\n Nombre del cliente: " + getNombres()
                + "\n Telefono del cliente: " + getTelefono()
                + "\n Apellidos del cliente: " + getApellidos()
                + "\n Direccion del correo: " + getCorreo()
                + "\n Opiniones sobre nuestro servicio: " + Arrays.toString(tipocliente)
                + "\n Por el uso de nuestros servicios con anterioridad usted ha conseguido un descuento de: $" + d + " en su proxima compra"
                + ("\n Registro de datos exitoso....!!!");

    }

    public Cliente(String Nombres, String Apellidos, String correo, String cedula, int telefono, int ppd, float total, String[] tipocliente, int num_agencia) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.total = total;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.correo = correo;
        this.tipocliente = tipocliente;
        this.num_agencia = num_agencia;
    }
}