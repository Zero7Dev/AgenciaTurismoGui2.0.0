/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

/**
 *
 * @author USER
 */
import Entidades.PaqueteTuristico;
//import interfaces.IAdministradorClientes;
import interfaces.IAdministradoraPaquetesTuristicos;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdministradorPaquetesTuristicos implements IAdministradoraPaquetesTuristicos {

    public static ArrayList<PaqueteTuristico> listaPaquetes;

    PaqueteTuristico paqueteTuristico = new PaqueteTuristico();

    public AdministradorPaquetesTuristicos() {
        if (listaPaquetes == null) {
            listaPaquetes = new ArrayList<>();
        }
    }

    @Override
    public void agregarPaqueteTuristico() {
        PaqueteTuristico paqueteNuevo = paqueteTuristico.ingresarPaquete();
        listaPaquetes.add(paqueteNuevo);
    }

    public static PaqueteTuristico obtenerPaqueteTuristicos(String nombre) {
        boolean PaqueteEncontrado = false;
        if (listaPaquetes.size() > 0) {
            for (PaqueteTuristico paquete : listaPaquetes) {
                if (paquete.getNombrePaquete().equalsIgnoreCase(nombre)) {
                    System.out.println(paquete.toString());
                    PaqueteEncontrado = true;
                    return paquete;
                }
            }
        } else {
            System.out.println("No existen paquetes reguistrados");
        }
        if (!PaqueteEncontrado) {
            System.out.println("El paquete no fue encontrado......");
        }
        return null;
    }

    @Override
    public PaqueteTuristico obtenerPaqueteTuristico(String nombre) {
        boolean PaqueteEncontrado = false;
        if (listaPaquetes.size() > 0) {
            for (PaqueteTuristico paquete : listaPaquetes) {
                if (paquete.getNombrePaquete().equalsIgnoreCase(nombre)) {
                    System.out.println(paquete.toString());
                    PaqueteEncontrado = true;
                    return paquete;
                }
            }
        } else {
            System.out.println("No existen paquetes reguistrados");
        }
        if (!PaqueteEncontrado) {
            System.out.println("El paquete no fue encontrado......");
        }
        return null;
    }

    @Override
    public void MostrarPaqueteXid(int Id) {
        boolean ClienteEncontrado = false;
        for (PaqueteTuristico paquete : listaPaquetes) {
            if (paquete.getId() == Id) {
                System.out.println(paquete.toString());
                ClienteEncontrado = true;
            }
        }
        if (ClienteEncontrado) {
            System.out.println("El cliente fue encontrado y mostrado");
        } else {
            System.out.println("El cliente no fue encontrado revise ");

        }
    }

    @Override
    public void eliminarPaqueteTuristicoXid(int Id) {
        boolean PaqueteEncontrado = false;
        for (int i = 0; i < listaPaquetes.size(); i++) {
            PaqueteTuristico paquete = listaPaquetes.get(i);
            if (Objects.equals(paquete.getId(), Id)) {
                listaPaquetes.remove(i);
                PaqueteEncontrado = true;
                break;
            }
        }
        if (PaqueteEncontrado) {
            System.out.println("Paquete eliminado correctamente.");
        } else {
            System.out.println("Paquete no encontrado.");
        }
    }

    @Override
    public List<PaqueteTuristico> obtenerTodosLosPaquetesTuristicos() {
        return new ArrayList<>(listaPaquetes);
    }
    int i = 0;

    public void MostrarPaquetes() {
        if (listaPaquetes.size() > 0) {

            for (PaqueteTuristico paquete : listaPaquetes) {
                System.out.println(i + ". " + paquete.toString());
                i++;
            }
        } else {
            System.out.println("No hay paquetes turisticos reguistrados......");
        }
    }

    @Override
    public void mostrarPaqueteTuristico(String nombrePaqueteBusacar) {
        if (listaPaquetes.size() > 0) {
            for (PaqueteTuristico paquete : listaPaquetes) {
                if (paquete.getNombrePaquete().equalsIgnoreCase(nombrePaqueteBusacar)) {
                    System.out.println(paquete.toString());
                };
            }
        } else {
            System.out.println("El nombre del paquete turistico seleccionado no existe o lo escribio mal");
        }
    }

    @Override
    public void MostrarReservacion(int idReservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
//+ agregarPaqueteTuristico():void
//+ MostrarPaqueteXid():void
//+ eliminarPaqueteTuristicoXid():void
//+ MostrarPaquetes():void
//+ mostrarPaqueteTuristico():void
//+ MostrarReservacion():void
//+ obtenerPaqueteTuristico(nombre:String):PaqueteTuristico
//
//
//
//
//+ ingresarPaquete():PaqueteTuristico  
//+ PaqueteTuristico():void
//+ getDescripcion():String
//+ PaqueteTuristico(int id, String nombre, String destino, int duracion, double precio, boolean comidaIncluida, String[] actividades)
//+ <<static>> gestionarPaquetesTuristicos():void
//+ PaqueteTuristico()
//+ PaqueteTuristico(destino: String, duracion: int)
//+ setId(id:int):void
//+ setNombre(nombre:String):void
//+ setDestino(destino:String):void
//+ setDuracion(Duracion:int):void
//+ setPrecio(Precio:double):void
//+ setComidaIncluida():void
//+ getId():int
//+ getDestino():String
//+ getActividades():String[]
//+ getDuracion():int
//+ getPrecio():void
//+ calcularPrecio():double
//+ calcularPrecio(int descuento):double
//+ calcularPrecio(int descuento, int iva):double
//+ toString():String