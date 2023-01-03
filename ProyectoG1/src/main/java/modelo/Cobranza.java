/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import com.mycompany.proyecto.NewMain;
//import com.mycompany.proyecto.documento.Orden;

//import com.mycompany.proyecto.persona.Cliente;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Cobranza extends Usuario{

    public Cobranza(String u, String c, String n, TipoUsuario t) {
        super(u,c,n,t);
        
    }
     // EL MENU SE HARA EN FX ASI QUE NO HAY NECESIDAD DE PONERLO PEOR LO DEJO POR SI ACASO 
     /* public void menu(){
        int opc = 0;
        do{
      Scanner sc = new Scanner(System.in);
        System.out.println("""
                           1. Generar facturas a empresas
                           2. Reporte de ingresos por servicios
                           3. Reporte de atenciones por técnico
                           4. Salir
                           
                           Seleccione una opción:
                           """);
        opc = sc.nextInt();
        switch(opc){
            case 1 -> {
                //El metodo usado por Calendar da el mes en ingles por lo que se hara una lista para obtener un indice con el mes y luego buscarlo en la lista
                String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                System.out.print("Escriba el codigo del cliente Empresarial: ");
                String cod = sc.next();
                
                Cliente c = Cliente.BuscarCliente(cod);
                
                System.out.print("Inserte el año: ");
                int agno = sc.nextInt();
                System.out.print("Inserte el mes: ");
                int mes = sc.nextInt();
                int total = 50;
                System.out.println("Empresa: " + c.getNombre()+"\nPeriodo de facturación: "+ MES[mes-1]+" "+ agno);
                System.out.println("Detalle de servicios:");
                System.out.printf("%-10s %-30s %-20s %-30s %-10s %s","#Placa","Fecha","Tipo","Servicio","Cantidad","Total\n");
                for(Orden o: NewMain.ordenes){
                    if(o.getCliente().getTipoCliente_1() == TipoCliente.EMPRESARIAL){

                    if((o.getFecha().get(Calendar.MONTH)+1) == mes && (o.getFecha().get(Calendar.YEAR) == agno )){
                    for(int i =0; i<(o.getServicios().size());i++){
                        System.out.printf("%-10s %-30s %-20s %-30s %-10s %-10s\n",o.getPlacaVehiculo(),o.getFecha().getTime().toLocaleString(),o.getTipoVehiculo(),
                                o.getServicios().get(i).getNombre(),o.getCantidad().get(i),(o.getServicios().get(i).getPrecio()*o.getCantidad().get(i)));
                        total += o.getServicios().get(i).getPrecio()*o.getCantidad().get(i);
                        

                    }
                    
                }
                }}

                System.out.printf("%s %-50s\n","Total",total);
                break;}

                
            case 2 -> {
                System.out.print("Inserte el año: ");
                int agno2 = sc.nextInt();
                System.out.print("Inserte el mes: ");
                int mes2 = sc.nextInt();
                System.out.printf("%-50s %s\n","Servicio","Total");
                for(Servicio s: NewMain.servicios){
                    System.out.printf("%-50s %s\n",s.getNombre(),Servicio.TotalServicio(s, mes2, agno2));
                }
                }
                
            case 3 -> {
                System.out.print("Inserte el año: ");
                int agno3 = sc.nextInt();
                System.out.print("Inserte el mes: ");
                int mes3 = sc.nextInt();
                System.out.printf("%-50s %s\n","Técnico","Total");
                for(Usuario u: NewMain.usuarios){
                if(u.getTipoUsuario()==(TECNICO)){
                    Tecnico tec = (Tecnico) u;
                    double totalTec =tec.totalPorTecnico(mes3, agno3);
                    System.out.printf("%-50s %s\n",tec.getNombre(),totalTec);

                }
                }}
            default -> {
                break;
                }
                
        
    }}while(opc != 4);
        }*/ 
     
    
    
}
