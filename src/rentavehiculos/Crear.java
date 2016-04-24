/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentavehiculos;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crear {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RentaVehiculosPU");
        EntityManager em = emf.createEntityManager();
        
        public Cliente crearCliente(Integer IDCLIENTE, String APELLIDO, String NOMBRE, String DIRECCION, Integer TELEFONO) {
        em.getTransaction().begin();
        Cliente c = new Cliente();
        c.setIdcliente(IDCLIENTE);
        c.setApellido(APELLIDO);
        c.setNombre(NOMBRE);
        c.setDireccion(DIRECCION);
        c.setTelefono(TELEFONO);
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }
        
        public Vehiculo crearVehiculo(Integer IDVEHICULO, String MODELO, String COLOR) {
        em.getTransaction().begin();
        Vehiculo v = new Vehiculo();
        v.setIdvehiculo(IDVEHICULO);
        v.setModelo(MODELO);
        v.setColor(COLOR);
        em.persist(v);
        em.getTransaction().commit();
        return v;
    }
        
        public Reserva crearReserva(Integer IDRESERVA,Integer IDCLIENTE,Integer IDVEHICULO) {
        em.getTransaction().begin();
        Reserva r = new Reserva();
        r.setIdreserva(IDRESERVA);
        Cliente c = new Cliente();
        Vehiculo v = new Vehiculo();
                          
            System.out.println("RESERVA CREADA");
            System.out.println("ID: " + r.getIdreserva());
            System.out.println("Cliente: " + c.getIdcliente());
            System.out.println("Apellidos: " + c.getApellido());
            System.out.println("Nombres: " + c.getNombre());
            System.out.println("Vehiculo: " + v.getIdvehiculo());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Color: " + v.getColor() + "\n");
           

        em.persist(r);
        em.getTransaction().commit();
        return r;
    }
                
        public static void main(String[] args) {
       
         int op; 
         int codigov=0;
         int codigor=0;
                              
        do{
        System.out.println("\n1. Registrar cliente");
        System.out.println("2. Registrar Vehiculo");
        System.out.println("3. Hacer Reserva");
        System.out.println("4. Borrar");
        System.out.println("5. Buscar");
        System.out.println("6. Editar");
        System.out.println("7. Salir\n");
        System.out.println("Elija una Opcion:");
        Scanner s=new Scanner(System.in);
        
        op=s.nextInt();
        
        switch(op){
            case 1:
                //Crear cliente
                Crear c = new Crear();
                System.out.println("\nCedula: ");
                Scanner ce = new Scanner(System.in);
                int cedula=ce.nextInt();
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
                
                c.crearCliente(cedula, apellidos, nombres, direccion, telefono);                                       
                
                break;
            case 2:
                //Crear vehiculo
                Crear v = new Crear();
                codigov++;
                System.out.println("\nCodigo: "+codigov);
                System.out.println("Modelo: ");
                Scanner m = new Scanner(System.in);
                String modelo=m.nextLine();
                System.out.println("Color: ");
                Scanner co = new Scanner(System.in);
                String color=co.nextLine();
                
                v.crearVehiculo(codigov, modelo, color);
                
                break;
            case 3:
                //Hacer reserva
                break;
            case 4:
                Borrar.borrar(args);
                break;
            case 5:
                Buscar.buscar(args);
                break;
            case 6:
                Actualizar.actualizar(args);
                break;
            case 7:
                //SALIR
                break;
            default:
                System.out.println("Opcion Invalida");
        }
        
        
        
        }while(op!=7);
    }
    
}
