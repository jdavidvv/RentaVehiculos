/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentavehiculos;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class Borrar {
    
    public static void borrarCliente(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    
    System.out.println("Ingrese cedula a borrar: ");
                Scanner e = new Scanner(System.in);
                int el =e.nextInt();
                Cliente c = em.find(Cliente.class,el);            
    
    System.out.println("\nCedula: "+c.getIdcliente());
    System.out.println("Apellidos: "+c.getApellido());
    System.out.println("Nombres: "+c.getNombre());
    System.out.println("Direccion: "+c.getDireccion());
    System.out.println("Telefono: "+c.getTelefono()+"\n");
    
    
    String o;
    do{
    System.out.println("Desea borrar el cliente S/N?");
       Scanner op = new Scanner(System.in);
                o =op.nextLine();
    }while(!o.equals("s")&&!o.equals("S")&&!o.equals("n")&&!o.equals("N"));
    
    if(o.equals("s")||o.equals("S")){    
    em.remove(c);
    em.getTransaction().commit();
    System.out.println("El registro a sido borrado\n");
    }else{
        System.out.println("Accion cancelada");
    }
    
     em.close();
     emf.close(); 
   }
    
    public static void borrarVehiculo(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    
    System.out.println("Ingrese ID a borrar: ");
                Scanner e = new Scanner(System.in);
                int el =e.nextInt();
                Vehiculo v = em.find(Vehiculo.class,el);            
    
    System.out.println("\nID: "+v.getIdvehiculo());
    System.out.println("Modelo: "+v.getModelo());
    System.out.println("Color: "+v.getColor()+"\n");
    
    String o;
    do{
    System.out.println("Desea borrar el vehiculo S/N?");
       Scanner op = new Scanner(System.in);
                o =op.nextLine();
    }while(!o.equals("s")&&!o.equals("S")&&!o.equals("n")&&!o.equals("N"));
    
    if(o.equals("s")||o.equals("S")){    
    em.remove(v);
    em.getTransaction().commit();
    System.out.println("El registro a sido borrado\n");
    }else{
        System.out.println("Accion cancelada");
    }
    
     em.close();
     emf.close(); 
   }
    
   public static void borrarReserva(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    
    System.out.println("Ingrese ID a borrar: ");
                Scanner e = new Scanner(System.in);
                int el =e.nextInt();
                Reserva r = em.find(Reserva.class,el);            
                Cliente c = em.find(Cliente.class,r.getIdCliente());
                Vehiculo v = em.find(Vehiculo.class,r.getIdVehiculo());
    System.out.println("\nID: "+r.getIdreserva());
    System.out.println("Cedula: "+r.getIdCliente());
    System.out.println("Apellidos: "+c.getApellido());
    System.out.println("Nombres: "+c.getNombre());
    System.out.println("Vehiculo: "+r.getIdVehiculo());
    System.out.println("Modelo: "+v.getModelo());
    System.out.println("Color: "+v.getColor()+"\n");
    
    String o;
    do{
    System.out.println("Desea borrar el vehiculo S/N?");
       Scanner op = new Scanner(System.in);
                o =op.nextLine();
    }while(!o.equals("s")&&!o.equals("S")&&!o.equals("n")&&!o.equals("N"));
    
    if(o.equals("s")||o.equals("S")){    
    em.remove(v);
    em.getTransaction().commit();
    System.out.println("El registro a sido borrado\n");
    }else{
        System.out.println("Accion cancelada");
    }
    
     em.close();
     emf.close(); 
   }    
   public static void borrar(String[] args) {
       int op;
   
        do{
        System.out.println("\n1. Borrar cliente");
        System.out.println("2. Borrar Vehiculo");
        System.out.println("3. Borrar Reserva");
        System.out.println("4. Salir\n");
        System.out.println("Elija una Opcion:");
        Scanner s=new Scanner(System.in);
        op=s.nextInt();
        
        
        switch(op){
            case 1:
                Borrar.borrarCliente();
                break;
            case 2:
                Borrar.borrarVehiculo();
                break;
            case 3:
                //Borrar.borrarReserva();
                break;
            case 4:
                //SALIR
                break;
            default:
                System.out.println("Opcion Invalida");
                }
          }while(op!=4);
   }
  }



