package com.anncode.main;

import java.util.List;

import javax.enterprise.inject.Default;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anncode.negocio.Menu;
import com.anncode.transporteshibernate.Camion.Camion;
import com.anncode.transporteshibernate.Camion.CamionDAO;
import com.anncode.util.Utilerias;

public class Principal {
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		SessionFactory sessionFactory;
		
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		List<Camion> camiones;
		int idSelect = 0;
		int opcionDetalle = 0;
		String opcion = null;
		Camion camion = null;
		
		int opcionMenu = 1;// 1=muestraCamiones,2=detalleCamion 3=actualiza, 4=elimina, 5=salir
		
		
		
		salirDoWhile:
		do{
			switch(opcionMenu){
				case 0:
					opcionMenu = menu.insertaCamion();
					break;
				case 1:	
					opcionMenu = menu.muestrasCamiones();
					break;
				case 2: 
					opcionMenu = menu.muestraCamion();
					break;
				case 3:
					opcionMenu = menu.actualizaCamion();
					break;
				case 4:
					opcionMenu = menu.eliminaCamion();
					break;
				case 5:
					menu.salir();
					break salirDoWhile;
				default:
					System.out.println("Salir");
					break salirDoWhile;
			}
				
			
		}while(true);
		
		
		
		
		
		
		/*
		salirDo:
		do{
			switch(opcionMenu){
				case 1:	camiones = menu.muestrasCamiones(session);
						opcion = Utilerias.leerCadena();
						if (opcion.equalsIgnoreCase("s")){
							opcionMenu = 5;
						}else{
							try{
								idSelect = Integer.parseInt(opcion);
								opcionMenu = 2;
				            }catch(NumberFormatException ex){
				            	System.out.println("*************************************************");
				                System.out.println("Tienes que escribir solo números o 'S' para Salir");
				                System.out.println("*************************************************");
				                opcionMenu = 1;
				            }
						}
						break;
				case 2: 
					camion = menu.muestraCamion(idSelect, session);
					if (camion == null){
						System.out.println("No se encontro Camion por ID " + idSelect + ". Elegir uno valido.");
						opcionMenu = 1;
						break;
					}
						
					opcion = Utilerias.leerCadena();
					if (opcion.equalsIgnoreCase("s")){
						opcionMenu = 5;
					}else{
						try{
							opcionDetalle = Integer.parseInt(opcion);
							if(opcionDetalle == 0)
								opcionMenu = 1;
							else if (opcionDetalle == 1)
								opcionMenu = 3;
							else if (opcionDetalle == 2)
								opcionMenu = 4;
							else{
								System.out.println("Opcion no Valida...");
								opcionMenu = 2;
							}
						}catch(NumberFormatException ex){
							System.out.println("*************************************************");
				            System.out.println("Tienes que escribir solo números o 'S' para Salir");
				            System.out.println("*************************************************");
				            opcionMenu = 2;
						}
					}
					break;
				default:
					System.out.println("Salir");
					opcion = "S";
			}
				
			
			if (opcion.equalsIgnoreCase("s"))
				break salirDo;
			
			
		}while(true);
		
		*/
		
		
			
		System.exit(0);
	}
	
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SessionFactory sessionFactory;
//		
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		sessionFactory = configuration.buildSessionFactory();
//		
//		
//		//Insertar
//		Camion camion = new Camion("ABCD123",2.0,"BMW","100.0");
//		Session session = sessionFactory.openSession();
//		//session.beginTransaction();
//		
//		//session.save(camion); //Insertando el registro
//		//session.getTransaction().commit();
//		
//		
//		//Obtener
//		Camion camion2 = (Camion) session.get(Camion.class, 1);
//		System.out.println("ID        :" + camion2.getId());
//		System.out.println("MATRICULA :" + camion2.getMatricula());
//		System.out.println("POTENCIA  :" + camion2.getPotencia());
//		System.out.println("MODELO    :" + camion2.getModelo());
//		System.out.println("TIPO      :" + camion2.getTipo());
//		
//		List<Camion> camiones = (List<Camion>) 
//		//session.createCriteria(Camion.class).setMaxResults(2).list();
//		session.createCriteria(Camion.class).list();
//		
//		for(Camion camion3 : camiones){
//			System.out.println(" ID        " + camion3.getId());
//			System.out.println(" MATRICULA " + camion3.getMatricula());
//		}
//		
//		//Actualizar HQL
//		session.beginTransaction();
//		String hql = "UPDATE Camion set matricula = :matricula WHERE id = :id ";
//		Query query = session.createQuery(hql);
//		query.setParameter("matricula", "MRY6392");
//		query.setParameter("id", 1);
//		query.executeUpdate();
//		session.getTransaction().commit();
//		
//		//Actualizar con objetos
//		session.beginTransaction();
//		Camion camion4 = (Camion) session.get(Camion.class, 6);
//		camion4.setMatricula("MAT666");
//		session.getTransaction().commit();
//		
//		
//		//Eliminar por HQL
//		/*
//		session.beginTransaction();
//		hql = "DELETE FROM Camion WHERE id = :id";
//		query = session.createQuery(hql);
//		query.setParameter("id", 5);
//		query.executeUpdate();
//		session.getTransaction().commit();
//		*/
//		
//		//Eliminar con objeto
//		/*
//		session.beginTransaction();
//		Camion camion5 = (Camion) session.get(Camion.class, 3);
//		session.delete(camion5);
//		session.getTransaction().commit();
//		*/
//		
//		
//		//cerramos la transaccion
//		session.close();
//		sessionFactory.close();
//		
//	}
//
//	
	
}
