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
			
		System.exit(0);
	}
}
