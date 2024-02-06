package Entidades;
import java.util.Scanner;
//import administracion.AdministradorHospedaje;
public class SistemaAgenciaTurismo {

    Cliente ClientePresentar = new Cliente();
    PaqueteTuristico PaquetePresentar = new PaqueteTuristico();
//    AdministradorHospedaje adminHospedaje=new AdministradorHospedaje();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== > SISTEMA AGENCIA DE VIAJES < =====");
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Paquetes Turísticos");
            System.out.println("3. Gestionar Reservas");
            System.out.println("4. Gestionar hospedaje");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

          switch (opcion) {
                case 1:
                    Cliente.gestionarClientes();
                    break;
                case 2:
                    PaqueteTuristico.gestionarPaquetesTuristicos();
                    break;
                case 3:
                    Reserva.gestionarReservas();
                    break;
                case 4:
                    Hospedaje.gestionarHospedaje();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema..........");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

}
