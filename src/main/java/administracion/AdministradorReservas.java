/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

/**
 *
 * @author USER
 */
import Entidades.Reserva;
import interfaces.IAdministradoraReservas;
import java.util.ArrayList;
import java.util.List;

public class AdministradorReservas implements IAdministradoraReservas {

    public ArrayList<Reserva> listaReservas;
    Reserva reservaNueva = new Reserva();

    public AdministradorReservas() {
        this.listaReservas = new ArrayList<>();
    }

    @Override
    public void agregarReserva() {
        Reserva ReservaNueva = reservaNueva.ingresarDatos();
        listaReservas.add(ReservaNueva);
    } 

    @Override
    public void MostrarReservacion(int idReservacion) {
        if (listaReservas.size() > 0) {
            for (int i = 0; i < listaReservas.size(); i++) {
                if (idReservacion == listaReservas.get(i).getId()) {
                    listaReservas.get(i).toString();
                }
            }
        }
    }
@Override
    public Reserva obtenerReservaXid(int idReserva) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getId() == idReserva) {
                System.out.println(reserva.toString());
                return reserva;
            }
        }
        return null;
    }

    @Override
    public void eliminarReservaXcedula(String cedula) {
        for (Reserva reserva : (ArrayList<Reserva>) listaReservas) {
            if (reserva.getCliente().getCedula().equalsIgnoreCase(cedula)) {
                listaReservas.remove(reserva);
            }
        }
    }

    @Override
    public void mostrarTodasLasReservas() {
        System.out.println("Lista de LReservas:");
        for (Reserva reserva : (ArrayList<Reserva>) listaReservas) {
            reserva.MostrarReservacion();
        }
    }

    @Override
    public void buscarReservaXcedula(String cedula) {
                for (Reserva reservaC : (ArrayList<Reserva>) listaReservas) {
                    if (reservaC.getCliente().getCedula().equalsIgnoreCase(cedula) ) {
                        reservaC.toString();
                        reservaC.MostrarReservacion();

            }
        }

    }

}
