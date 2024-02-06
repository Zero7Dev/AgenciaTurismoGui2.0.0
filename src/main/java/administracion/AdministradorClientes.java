/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

/**
 *
 * @author USER
 */
import Entidades.Cliente;
import interfaces.IAdministradorClientes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
//import java.util.Scanner;

public class AdministradorClientes implements IAdministradorClientes {

    public static ArrayList<Cliente> listaClientes;
    Cliente nuevoCliente = new Cliente();

    public AdministradorClientes() {
        if (listaClientes == null) {
            listaClientes = new ArrayList<>();
        }
    }

    @Override
    public void agregarCliente() {
        Cliente NuevoCliente = nuevoCliente.ingresar();
        listaClientes.add(NuevoCliente);
    }

    @Override
    public void eliminarClienteCedula(String Cedula) {
        boolean clienteEncontrado = false;
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            if (Objects.equals(cliente.getCedula(), Cedula)) {
                listaClientes.remove(i);
                clienteEncontrado = true;
                break;
            }
        }
        if (clienteEncontrado) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static Cliente obtenerClienteCedula(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println(cliente.toString());
                return cliente;
            }
        }
        System.out.println("La cedula del cliente seleccionado no está registrada en el sistema");
        return null;
    }

    @Override
    public Cliente obtenerClienteCedulas(String cedula) {
        if (listaClientes.size() > 0) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
                    System.out.println(listaClientes.get(i).toString());
                    Cliente cl = listaClientes.get(i);
                    return cl;
                }
            }
        } else {
            System.out.println("La cedula cliente seleccionado no esta reguistrado en el sistema");
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {

        return new ArrayList<>(listaClientes);
    }

    @Override
    public void MostrarClientesXcedula(String cedula) {
        if (listaClientes.size() > 0) {

            for (Cliente client : listaClientes) {
                if (client.getCedula().equalsIgnoreCase(cedula)) {
                    System.out.println(client.toString());

                }
            }
        } else {
            System.out.println("El cliente no existe en el sistema o la cedula fue mal ingresada");
        }
    }

    public static void MostrarClientes() {
        for (Cliente clienteLista : listaClientes) {
            System.out.println(clienteLista.toString());
        }
    }

}
