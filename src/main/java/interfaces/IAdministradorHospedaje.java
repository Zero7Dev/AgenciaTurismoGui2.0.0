/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import Entidades.Hospedaje;
/**
 *
 * @author USER
 */
public interface IAdministradorHospedaje {

    void agregarHospedaje();

    void mostrarHospedajes();

    void eliminarHospedaje(String cedula);

    void mostrarHospedajesXCedula(String cedula);
    Hospedaje obtenerHospedajeCedula(String cedula) ;

}
