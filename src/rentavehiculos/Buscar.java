/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentavehiculos;

/**
 *
 * @author David
 */

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class Buscar {
   
     public static void buscarCliente(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
   EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    String o="s";
    
    do{
        
         System.out.println("Ingrese ID a buscar: ");
         Scanner b = new Scanner(System.in);
         int bu = b.nextInt();
         Cliente c = em.find(Cliente.class, bu);

         System.out.println("\nID: " + c.getIdcliente());
         System.out.println("Apellidos: " + c.getApellido());
         System.out.println("Nombres: " + c.getNombre());
         System.out.println("Direccion: " + c.getDireccion());
         System.out.println("Telefono: " + c.getTelefono() + "\n");
              
        System.out.println("Desea buscar otro cliente S/N?");
        Scanner op = new Scanner(System.in);
        o = op.nextLine();
    }while(o.equals("s")||o.equals("S"));
    
     em.close();
     emf.close(); 
    
   }
     
     public static void buscarVehiculo(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
   EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    String o="s";
    
    do{        
         System.out.println("Ingrese ID a buscar: ");
         Scanner b = new Scanner(System.in);
         int bu = b.nextInt();
         Vehiculo v= em.find(Vehiculo.class, bu);

         System.out.println("\nID: " + v.getIdvehiculo());
         System.out.println("Modelo : " + v.getModelo());
         System.out.println("Color : " + v.getColor() + "\n");
               
        System.out.println("Desea buscar otro Vehiculo S/N?");
        Scanner op = new Scanner(System.in);
        o = op.nextLine();
    }while(o.equals("s")||o.equals("S"));
    
     em.close();
     emf.close(); 
    
   }
     
     public static void buscarReserva(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
   EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    String o="s";
    
    do{
        if(o.equals("s")||o.equals("S")){
         System.out.println("Ingrese ID a buscar: ");
         Scanner b = new Scanner(System.in);
         int bu = b.nextInt();
         
            Reserva r = em.find(Reserva.class, bu);
            Cliente c = em.find(Cliente.class, r.getIdCliente());
            Vehiculo v = em.find(Vehiculo.class, r.getIdVehiculo());
            
            System.out.println("\nID: " + r.getIdreserva());
            System.out.println("Cliente: " + r.getIdCliente());
            System.out.println("Apellidos: " + c.getApellido());
            System.out.println("Nombres: " + c.getNombre());
            System.out.println("Vehiculo: " + r.getIdVehiculo());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Color: " + v.getColor() + "\n");
        }
        
        System.out.println("Desea buscar otro cliente S/N?");
        Scanner op = new Scanner(System.in);
        o = op.nextLine();
    }while(!o.equals("s")&&!o.equals("S")&&!o.equals("n")&&!o.equals("N"));
    
     em.close();
     emf.close(); 
    
   }
    public static void buscar(String[] args) {
        
     int op;
   
        do{
        System.out.println("\n1. Buscar cliente");
        System.out.println("2. Buscar Vehiculo");
        System.out.println("3. Buscar Reserva");
        System.out.println("4. Salir\n");
        System.out.println("Elija una Opcion:");
        Scanner s=new Scanner(System.in);
        op=s.nextInt();
        
        
        switch(op){
            case 1:
                Buscar.buscarCliente();
                break;
            case 2:
                Buscar.buscarVehiculo();
                break;
            case 3:
                //Buscar.buscarReserva();
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
