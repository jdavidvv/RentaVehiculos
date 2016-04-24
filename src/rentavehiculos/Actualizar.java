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
public class Actualizar {
   
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
   EntityManager em = emf.createEntityManager();
        public Cliente actualizarCliente(Integer IDCLIENTE, String APELLIDO, String NOMBRE, String DIRECCION, Integer TELEFONO) {
            em.getTransaction().begin();
            Cliente c = new Cliente();
            c.setIdcliente(IDCLIENTE);
            c.setApellido(APELLIDO);
            c.setNombre(NOMBRE);
            c.setDireccion(DIRECCION);
            c.setTelefono(TELEFONO);
            em.merge(c);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return c;   
     }
        
         public Vehiculo actualizarVehiculo(Integer IDVEHICULO, String MODELO, String COLOR) {
            em.getTransaction().begin();
            Vehiculo v = new Vehiculo();
            v.setIdvehiculo(IDVEHICULO);
            v.setModelo(MODELO);
            v.setColor(COLOR);
            em.merge(v);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return v;   
     }
         
         /*public Reserva actualizarReserva(Integer IDRESERVA, Integer IDCLIENTE,Integer IDVEHICULO) {
            em.getTransaction().begin();
            Reserva r = new Reserva();
            r..setIdreserva(IDRESERVA);
            r.setIdecliente(IDCLIENTE);
            r.setIdvehiculo(IDVEHICULO);
            em.merge(r);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return r;   
     }*/
    
    

   public static void actualizar(String[] args) {
    int op;
   
        do{
        System.out.println("\n1. Editar Cliente");
        System.out.println("2. Editar Vehiculo");
        System.out.println("3. Salir\n");
        System.out.println("Elija una Opcion:");
        Scanner s=new Scanner(System.in);
        op=s.nextInt();
        
        
        switch(op){
            case 1:
                 Actualizar a1= new Actualizar();
                System.out.println("Ingrese ID cliente a editar: ");
                Scanner c = new Scanner(System.in);
                int codigo=c.nextInt();
                System.out.println("Apellidos: ");
                Scanner a = new Scanner(System.in);
                String apellidos=a.nextLine();
                System.out.println("Nombres: ");
                Scanner n = new Scanner(System.in);
                String nombres=n.nextLine();
                System.out.println("Direccion: ");
                Scanner d = new Scanner(System.in);
                String direccion=d.nextLine();
                System.out.println("Telefono: ");
                Scanner t = new Scanner(System.in);
                int telefono=t.nextInt();
                
                a1.actualizarCliente(codigo, apellidos, nombres, direccion, telefono);                                       
                
                break;
            case 2:
                Actualizar a2= new Actualizar();
                System.out.println("Ingrese ID vehiculo a editar: ");
                Scanner c1 = new Scanner(System.in);
                int codigo1=c1.nextInt();
                System.out.println("Modelo: ");
                Scanner m = new Scanner(System.in);
                String modelo=m.nextLine();
                System.out.println("Color: ");
                Scanner col = new Scanner(System.in);
                String color=col.nextLine();
                
                a2.actualizarVehiculo(codigo1, modelo, color);
                
                break;
            case 3:
                //SALIR
                break;
            default:
                System.out.println("Opcion Invalida");
                }
          }while(op!=3);
   }  
      
 
    }



