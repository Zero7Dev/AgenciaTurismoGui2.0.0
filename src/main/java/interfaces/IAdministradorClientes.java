/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IAdministradorClientes {

    public void agregarCliente();

    void eliminarClienteCedula(String cedula);

    Cliente obtenerClienteCedulas(String cedula);
    public void MostrarClientesXcedula(String cedula) ;

    List<Cliente> obtenerTodosLosClientes();
}
