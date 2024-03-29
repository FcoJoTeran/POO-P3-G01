/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;




import java.util.ArrayList;
//import com.mycompany.proyecto.NewMain;

//import com.mycompany.proyecto.persona.Cliente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Tecnico extends Usuario{
    private ArrayList<Orden> listaOrden;
    private ArrayList<String> reportes = new ArrayList<>();
    //Contructor del tecnico
    public Tecnico(String u, String c, String n, TipoUsuario t, ArrayList<Orden> listaOrden) {
        super(u,c,n,t);
        this.listaOrden = listaOrden;
    }
    //Este metodo da el total de ventas por tecnico
   public double totalPorTecnico(int mes3, int agno3){
    double total = 0;
    for(Orden o: listaOrden){
                    if(o.getFecha().get(Calendar.MONTH) == mes3 && (o.getFecha().get(Calendar.YEAR) == agno3 )){
                        for(Servicio ser: o.getServicios()){
                            int idx = o.getServicios().indexOf(ser);
                            total += (ser.getPrecio()* o.getCantidad().get(idx));
                        
                    }
    }
   }
    return total;
}
   public ArrayList<Orden> getListaOrden(){
       return listaOrden;
   }
   
 // EL MENU SE HARA EN FX ASI QUE NO HAY NECESIDAD DE PONERLO PERo LO DEJO POR SI ACASO 

//Se escribe el menu
  /* public void menu(){
      int opc = 0;
        do{
            System.out.println("""
                           1. Generar orden de servicios
                           2. Reportar falta de insumos
                           3. Salir
                           
                           Seleccione una opción:
                           """);
      Scanner sc = new Scanner(System.in);
       opc = sc.nextInt();
       ArrayList<Servicio> s1 = new ArrayList<>();
       ArrayList<Integer> ca1 = new ArrayList<>();
        switch(opc){
            case 1 -> {
                System.out.println("Ingrese codigo del cliente: ");
                String codcl = sc.nextLine();
                Cliente cl = Cliente.BuscarCliente(codcl);
                System.out.println("Ingrese fecha del servicio (dd/MM/YYYY)");
                String fecha = sc.nextLine();
                String[] fechArray = fecha.split("/");

                //Se hace un split y se crea un objeto de clase Calendar
                int dia = Integer.valueOf(fechArray[0]);
                int mes = Integer.valueOf(fechArray[1]) - 1;
                int anio = Integer.valueOf(fechArray[2]);
                GregorianCalendar cal = new GregorianCalendar(anio, mes, dia);
                System.out.println("""
                                                   Ingrese un numero para el tipo de vehiculo:
                                                   1.- Automovil
                                                   2.- Motocicletas
                                                   3.- Bus
                                                   """);
                int numTipoVeh = sc.nextInt();
                TipoVehiculo tipo = null;
                switch(numTipoVeh){
                    case 1 -> tipo = TipoVehiculo.AUTOMOVIL;
                    case 2 -> tipo = TipoVehiculo.MOTOCICLETAS;
                    case 3 -> tipo = TipoVehiculo.BUS;
                }
                System.out.println("Ingrese placa del vehiculo: (XXX-####)");
                String placa = sc.next();
               
                double total = 0;
                String servic = "";
                int cantid1 = 0;
                while(!"-1".equals(servic) && cantid1 != -1){
                    System.out.println("Ingrese un servicio: ");
                    servic = sc.next();
                    if(servic.equals("-1")){
                        break;
                    }
                    Servicio servic1 = Servicio.BuscarServicio(servic);
                    System.out.println("Ingrese la cantidad: ");
                    cantid1= sc.nextInt();
                    if(cantid1 ==-1){
                        break;
                    }
                    total += servic1.getPrecio() * cantid1;
                    s1.add(servic1);
                    ca1.add(cantid1);
                }
                NewMain.ordenes.add(new Orden(cl,cal,placa,tipo,s1,ca1));
              }
            
            case 2 -> {
                System.out.println("Escriba su reporte: ");
                String rep = sc.next();
                System.out.println("Desea enviar el reporte a: "+ NewMain.correo+" ? (Y/N)");
                sc.nextLine();
                String resp = sc.next();
                if(resp.equals("Y")){
                    reportes.add(rep);

                    System.out.println("Reporte enviado\n");
                }
                break;
            

              }
            default -> {
                break;
              }

                
   }
}while(opc != 3);
}*/

    public ArrayList<String> getReportes() {
        return reportes;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public modelo.TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setListaOrden(ArrayList<Orden> listaOrden) {
        this.listaOrden = listaOrden;
    }

    public void setReportes(ArrayList<String> reportes) {
        this.reportes = reportes;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoUsuario(modelo.TipoUsuario TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }
    
}