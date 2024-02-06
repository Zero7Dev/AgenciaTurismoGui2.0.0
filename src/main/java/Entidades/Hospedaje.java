
package Entidades;

import administracion.AdministradorHospedaje;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospedaje {

    public ArrayList<Hospedaje> listaHospedajes;
    private String cedula;
    private int numeroTelefono;
    private int CantidadPersonas;
    private static String[] hoteles = {"Hotel economico", "Hotel de lujo", "Hotel Vip"};
    private boolean MayorEdad;
    private int tipoHotel;
    private double PagarHotel=0.0;
    private String ReservarHotel;
    private double CostoF;
    private int noche;

    public Hospedaje() {
    this.cedula = "";
    this.numeroTelefono = 0;
    this.CantidadPersonas = 0;
    this.MayorEdad = false;
    this.listaHospedajes = new ArrayList<>();
    }

    public Hospedaje(String cedula, int numeroTelefono, int CantidadPersona, boolean MayorEdad) {
        this.cedula = cedula;
        this.numeroTelefono = numeroTelefono;
        this.CantidadPersonas = CantidadPersonas;
        this.MayorEdad = MayorEdad;
    }

     public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.CantidadPersonas = CantidadPersonas;
    }

    public void setHoteles(String[] hoteles) {
        this.hoteles = hoteles;
    }

    public void setMayorEdad(boolean mayorEdad) {
        this.MayorEdad = MayorEdad;
    }

    public void setCostoF(double costoF) {
        this.CostoF = CostoF;
    }

    public void setNoche(int noche) {
        this.noche = noche;
    }

    public void setTipoHotel(int tipoHotel) {
        this.tipoHotel = tipoHotel;
    }

    public String getCedula() {
        return cedula;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public int getCantidadPersonas() {
        return CantidadPersonas;
    }

    public String[] getHoteles() {
        return hoteles;
    }

    public boolean isMayorEdad() {
        return MayorEdad;
    }

    public double getCostoF() {
        return CostoF;
    }

    public int getNoche() {
        return noche;
    }

    public int getTipoHotel() {
        return tipoHotel;
    }

    public void setPagarHotel(double pagarHotel){
        if(pagarHotel > 0 && pagarHotel < 10000) {
            this.PagarHotel= pagarHotel;
        } else {
            System.out.println("invalido, ingrese un valor de 0-10000");
        }
    }
    public double getPagarHotel(){
        return PagarHotel;
    }

    public void setReservarHotel(String reservarHotel) {
        if(reservarHotel.equalsIgnoreCase("reservado") || reservarHotel.equalsIgnoreCase("no reservado")) {
            this.ReservarHotel = reservarHotel;
        } else {
            System.out.println("invalido, ingrese reservado o no reservado'.");
        }
    }

    public String getReservarHotel() {
        return ReservarHotel;
    }

    public ArrayList<Hospedaje> getListaHospedajes() {
        return listaHospedajes;
    }

    public void setListaHospedajes(ArrayList<Hospedaje> listaHospedajes) {
        this.listaHospedajes = listaHospedajes;
    }

   

    public Hospedaje Ingresar() {
         Scanner scan= new Scanner(System.in);
    
    System.out.print("Ingrese su numero de cedula = ");
    cedula=scan.nextLine();
    System.out.print("Ingrese numero de telefono = ");
    numeroTelefono=scan.nextInt();
    System.out.print("Con cuantas personas va a companado? = ");
    CantidadPersonas=scan.nextInt();
    System.out.print("cuantas noches desea quedarse = ");
    noche=scan.nextInt();
    System.out.println("Eleja una de las siguientes opciones = ");
        for(int i=0; i< hoteles.length;i++){
            System.out.println((i+1)+ "."+ hoteles[i]);
        }
        System.out.print("Elija una opcion = ");
        tipoHotel= scan.nextInt();
            switch(tipoHotel){
                case 1:
                    System.out.println("Usted eligio un Hotel economico ");
                    calcularCosto(100, CantidadPersonas);
                break;
                case 2:
                    System.out.println("Usted eligio un Hotel de lujo ");
                    calcularCosto(250, CantidadPersonas);
                break;
                case 3:
                    System.out.println("Usted eligio un Hotel Vip ");
                    calcularCosto(500, CantidadPersonas);
                break;
                default:
                    System.out.println("Ingreso una opcion incorrecta ");
                break;    
                
            }
    System.out.print("Usted es mayor de edad? (True/False)");
    MayorEdad=scan.nextBoolean();
    scan.nextLine();
    System.out.print("escriba reservado si desea reservar el hotel = ");
    ReservarHotel=scan.nextLine();
        return this;
    }
        
    public void calcularCosto(int costoPorPersona, int cantidadPersonas){
        this.CostoF = costoPorPersona * cantidadPersonas;
    }
    
    public void calcularDescuento(double descuento){
        descuento=0.03;
        this.CostoF -= this.CostoF * descuento;
    }
    
    public void calcularNoche(int noche){
        this.CostoF *= noche;
    }
    public void administrar() {
        AdministradorHospedaje admin = new AdministradorHospedaje();

        admin.agregarHospedaje();
    }

    public void Mostrar(){
        System.out.println("numero de cedula = " + cedula);
        System.out.println("numero de telefono = " + numeroTelefono);
        System.out.println("con cuantas personas va a companado = " + CantidadPersonas);
        System.out.println("cuantas noches se van a quedar = " + noche);
        System.out.println("Es Mayor de edad? = " + MayorEdad);
        System.out.println("valor cancelado = " + PagarHotel);
        System.out.println(" estado de reserva = " + ReservarHotel);
        System.out.println("El valor final del hotel es de = " + CostoF);
    }

    @Override
    public String toString() {
        return  
                "cedula='" + cedula + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", cantidadPersonas=" + CantidadPersonas +
                ", hoteles=" + hoteles +
                ", mayorEdad=" + MayorEdad +
                ", pagarHotel=" + PagarHotel +
                ", reservarHotel='" + ReservarHotel + '\'' +
                ", costoF=" + CostoF +
                ", noche=" + noche +
                ", tipoHotel=" + tipoHotel +
                '}';
    }
    
    public static void gestionarHospedaje () {
        Scanner scanner = new Scanner(System.in);
        AdministradorHospedaje adminHospedaje = new AdministradorHospedaje();

        while (true) {
            System.out.println("===== Menu Hospedaje: =====");
            System.out.println("1. Agregar Hospedaje");
            System.out.println("2. Mostrar Hospedajes");
            System.out.println("3. Buscar Hospedaje por cédula del cliente");
            System.out.println("4. Eliminar Hospedaje por cédula del cliente");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    adminHospedaje.agregarHospedaje();
                    break;
                case 2:
                    adminHospedaje.mostrarHospedajes();
                    break;
                case 3:
                    System.out.println("Ingrese la cédula del cliente");
                    String cedulaCliente = scanner.nextLine();
                    scanner.nextLine();
                    adminHospedaje.mostrarHospedajesXCedula(cedulaCliente);
                    break;
                case 4:
                    System.out.println("Ingrese la cédula del cliente para eliminar el hospedaje");
                    String cedulaClWente = scanner.nextLine();
                    adminHospedaje.eliminarHospedaje(cedulaClWente);
                    break;
                case 0:
                    return;  // Volver al menú principal
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}
