///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package administracion;

import Entidades.Hospedaje;
import java.util.ArrayList;
import interfaces.IAdministradorHospedaje;

/**
 *
 * @author USER
 */
  public class AdministradorHospedaje implements IAdministradorHospedaje{
     
      public  ArrayList<Hospedaje> listaHospedajes;
        Hospedaje hospedaje=new Hospedaje();

        
        public AdministradorHospedaje() {
            this.listaHospedajes = new ArrayList<>();
        }
 
 
      @Override
        public void agregarHospedaje() {
           Hospedaje hospedajeNew=hospedaje.Ingresar();
            listaHospedajes.add(hospedajeNew);
        }

      @Override
        public void mostrarHospedajes() {
            for (Hospedaje hospedaje : listaHospedajes) {
                System.out.println(hospedaje.toString());
            }
        }

      @Override
    public void eliminarHospedaje(String cedula) {
          for (Hospedaje hospedaje : listaHospedajes) {
                if(hospedaje.getCedula().equalsIgnoreCase(cedula)){
                    listaHospedajes.remove(hospedaje);
                }
            }
    }

      @Override
    public Hospedaje obtenerHospedajeCedula(String cedula) {
        for (Hospedaje hospedaje : listaHospedajes) {
                if(hospedaje.getCedula().equalsIgnoreCase(cedula)){
                return hospedaje;
            }
        }
        return null;
    }

      @Override
    public void mostrarHospedajesXCedula(String cedula) {
        for (Hospedaje hospedaje : listaHospedajes) {
            if (hospedaje.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println(hospedaje.toString());
            }
        }
    }
  }