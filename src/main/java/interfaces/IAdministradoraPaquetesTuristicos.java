/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author USER
 */
import java.util.List;
import Entidades.PaqueteTuristico;
import java.util.Scanner;
public interface IAdministradoraPaquetesTuristicos {
    PaqueteTuristico obtenerPaqueteTuristico(String Nombre);
        void eliminarPaqueteTuristicoXid(int Id);
              public void MostrarPaqueteXid(int Id);
//    void eliminarPaqueteTuristico(PaqueteTuristico paquete);
    List<PaqueteTuristico> obtenerTodosLosPaquetesTuristicos();
            public void MostrarReservacion(int idReservacion) ;
    void agregarPaqueteTuristico();
    void mostrarPaqueteTuristico(String nombre);
}