/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Reserva;

/**
 *
 * @author USER
 */
public interface IAdministradoraReservas {
    void agregarReserva();
    void mostrarTodasLasReservas();
    void buscarReservaXcedula(String cedula);
    void eliminarReservaXcedula(String cedula);
         void MostrarReservacion(int idReservacion);
             public Reserva obtenerReservaXid(int idReserva) ;



}


