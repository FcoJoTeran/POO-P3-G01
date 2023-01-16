/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
//import com.mycompany.proyecto.enums.TipoVehiculo;
//import com.mycompany.proyecto.persona.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 *
 * @author LENOVO
 */
public class Orden implements Serializable{
    private Cliente cliente;
    private GregorianCalendar fecha;
    private String placaVehiculo;
    private TipoVehiculo tipoVehiculo;
    private ArrayList<Servicio> servicios;
    private ArrayList<Integer> cantidad;
    //private static final long serialVersionUID = -1234567L;

    public Orden(Cliente cliente, GregorianCalendar fecha, String placaVehiculo, TipoVehiculo tipoVehiculo, ArrayList<Servicio> servicios,
            ArrayList<Integer> cantidad) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.servicios = servicios;
        this.cantidad = cantidad;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }
    
    public static ArrayList<Orden> cargarOrdenes(String ruta) {
        ArrayList<Orden> ordenes = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx Cargando ordenes xxxxxxxxxxxxxxxx");
       //leer la lista de ordenes del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            ordenes = (ArrayList<Orden>) oi.readObject();
            System.out.println("=============");
            
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return ordenes;
    }
    
       public double getTotalPagar(){
           double total = 0;
           for (int i = 0; i<servicios.size();i++){
               total+= servicios.get(i).getPrecio()* cantidad.get(i);
           }
           return total;
       }
       
       public String getCodigo(){
           return cliente.getCodigo();
       }
       
       public String getFechaString(){
           //SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
            //return fmt.format(getFecha());
            return getFecha().getTime().toLocaleString();
       }
}
