package com.anncode.negocio;

import com.anncode.transporteshibernate.Camion.Camion;
import com.anncode.transporteshibernate.Camion.CamionDAO;
import com.anncode.util.Utilerias;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SourceType;
import org.hibernate.cfg.Configuration;


public class Menu {

	private CamionDAO camionDao = new CamionDAO();
	private Camion camion = null;
	private int idSelect;
	SessionFactory sessionFactory;
	private Session session;
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		
		session = sessionFactory.openSession();
	}
	
	public int insertaCamion() {
		
		System.out.println("\n+++++++++++ Alta de nuevo Camion  +++++++++++");
		System.out.println("Proporciona la Matricula...");
		String matricula = Utilerias.leerCadena();
		System.out.println("Proporciona la Potencia...");
		double potencia = Utilerias.leerFlotante();
		System.out.println("Proporciona el Modelo...");
		String modelo = Utilerias.leerCadena();
		System.out.println("Proporciona el Tipo...");
		String tipo = Utilerias.leerCadena();
		
		camion = new Camion();
		camion.setMatricula(matricula);
		camion.setPotencia(potencia);
		camion.setModelo(modelo);
		camion.setTipo(tipo);
		
		System.out.println("id         : " + camion.getId());
		System.out.println("matricula  : " + camion.getMatricula());
		System.out.println("potencia   : " + camion.getPotencia());
		System.out.println("modelo     : " + camion.getModelo());
		System.out.println("tipo       : " + camion.getTipo());
		
		camionDao.insertar(camion, session);
		session.close();
		session = sessionFactory.openSession();
		System.out.println("\nCreacion efectuada correctamente!!!!!!!!!!");
		
		return 1;
	}
	
	public int muestrasCamiones() {
		List<Camion> camiones = camionDao.obtenerTodosRegistros(session);
		
		System.out.println("++++++++ Lista de Camiones ++++++++\n");
		System.out.println("Id   Matricula           Modelo");
		System.out.println("--------------------------------------------");
		
		String cuerpo, id, matricula, modelo;
		
		
		for(Camion camion : camiones){
			
			id        = Utilerias.formatoValor(camion.getId(), 5);
			matricula = Utilerias.formatoValor(camion.getMatricula(), 20);
			modelo    = Utilerias.formatoValor(camion.getModelo(), 20);
			
			cuerpo =  id + matricula + modelo;
			System.out.println(cuerpo);
			
		}
		System.out.println("--------------------------------------------");
		System.out.println("\nSeleccionar un ID para ver el detalle.");
		System.out.println("Para salir presiona la letra                    'S'...");
		System.out.println("Para Insertar un nuevo camion presiona la letra 'I'...");
		
		boolean flag = true;
		while (flag){
			flag = false;
			String opcion = Utilerias.leerCadena();
			if (opcion.equalsIgnoreCase("s")){
				return 5;	//salir
			}else if (opcion.equalsIgnoreCase("i")){
				return 0;	//insertar
			}else{
				try{
					idSelect = Integer.parseInt(opcion);
					return 2;	// muestraCamion
				}catch(NumberFormatException ex){
	            	System.out.println("*************************************************");
	                System.out.println("Tienes que escribir solo números o 'S' para Salir");
	                System.out.println("*************************************************");
	                flag = true;
				}
			}
		}
		return 0;
	}

	public int muestraCamion() {
		
		camion = camionDao.obtenerRegistrosPorID(idSelect, session);
		
		if (camion == null){
			System.out.println("No se encontro Camion por ID " + idSelect + ". Elegir uno valido.");
			return 1;
		}
		
		String ids, matricula,potencia, modelo, tipo;
		
		ids       = Utilerias.formatoValor(camion.getId(), 5);
		matricula = Utilerias.formatoValor(camion.getMatricula(), 20);
		potencia  = Utilerias.formatoValor(camion.getPotencia(), 10);
		modelo    = Utilerias.formatoValor(camion.getModelo(), 20);
		tipo      = Utilerias.formatoValor(camion.getTipo(), 20);
		
		System.out.println("\n\n+++++++++ Datos del camión +++++++++\n");
		System.out.println("Id   Matricula           Potencia  Modelo              Tipo");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(ids + matricula + potencia + modelo + tipo);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("     Opciones...");
		System.out.println("            0.- Regresar");
		System.out.println("            1.- Actualizar");
		System.out.println("            2.- Borrar");
		System.out.println("            S.- Salir");
		
		boolean flag = true;
		while(flag){
			flag = false;
			
			String opcion = Utilerias.leerCadena();
			if (opcion.equalsIgnoreCase("s")){
				return 5;
			}else{
				try{
					int opcionDetalle = Integer.parseInt(opcion);
					if(opcionDetalle == 0)
						return 1;
					else if (opcionDetalle == 1)
						return 3;
					else if (opcionDetalle == 2)
						return 4;
					else{
						System.out.println("Opcion no Valida...");
						return 2;
					}
				}catch(NumberFormatException ex){
					System.out.println("*************************************************");
		            System.out.println("Tienes que escribir solo números o 'S' para Salir");
		            System.out.println("*************************************************");
		            flag = true;
				}
			}
		}
		return 0;
	}

	public int actualizaCamion() {
		
		System.out.println("\n++++++ Actualizacion del Camion con id " + camion.getId() + " ++++++");
		System.out.println("Proporciona la nueva Matricula...");
		String matricula = Utilerias.leerCadena();
		System.out.println("Proporciona la nueva Potencia...");
		double potencia = Utilerias.leerFlotante();
		System.out.println("Proporciona el nuevo Modelo...");
		String modelo = Utilerias.leerCadena();
		System.out.println("Proporciona el nuevo Tipo...");
		String tipo = Utilerias.leerCadena();
		
		camion.setMatricula(matricula);
		camion.setPotencia(potencia);
		camion.setModelo(modelo);
		camion.setTipo(tipo);
		
		camionDao.actualizar(camion, session);
		
		System.out.println("\nActulizacion efectuada correctamente!!!!!!!!!!");
		return 1;
	}

	public int eliminaCamion() {
		System.out.println("\n++++++ Elminacion del Camion con id " + camion.getId() + " ++++++\n");
		System.out.println("     Opciones...");
		System.out.println("            B.- Borrar");
		System.out.println("            R.- Regresar");
		System.out.println("            S.- Salir");
		
		boolean flag = true;
		while(flag){
			flag = false;
			
			String opcion = Utilerias.leerCadena();
			if (opcion.equalsIgnoreCase("b")){
				camionDao.eliminar(camion, session);
				return 1;
			}else if (opcion.equalsIgnoreCase("r")) {
				return 2;
			}else if (opcion.equalsIgnoreCase("s")) {
				return 5;
			}else{
				System.out.println("Opcion no valida, favor de seleccionar una opcion...");
				flag = true;
			}
		}
		return 0;
	}

	public void salir() {
		session.close();
		sessionFactory.close();
		
	}


	
	
	/*
	public List<Camion> muestrasCamiones(Session session){
		
		List<Camion> camiones = camionDao.obtenerTodosRegistros(session);
		
		System.out.println("++++++++ Lista de Camiones ++++++++\n");
		System.out.println("Id   Matricula           Modelo");
		System.out.println("--------------------------------------------");
		
		String cuerpo, id, matricula, modelo;
		
		for(Camion camion : camiones){
			
			id = Utilerias.formatoValor(camion.getId(), 5);
			matricula = Utilerias.formatoValor(camion.getMatricula(), 20);
			modelo = Utilerias.formatoValor(camion.getModelo(), 20);
			
			cuerpo =  id + matricula + modelo;
			System.out.println(cuerpo);
			
		}
		System.out.println("--------------------------------------------");
		System.out.println("\nSeleccionar un ID. Para salir presiona la letra 'S'...");

		return camiones;
		//String menu = Utilerias.leerCadena();
	}
	
	public Camion muestraCamion(int id, Session session){
		
		Camion camion = camionDao.obtenerRegistrosPorID(id, session);
		
		if (camion == null)
			return null;
		
		String ids, matricula,potencia, modelo, tipo;
		
		ids = Utilerias.formatoValor(camion.getId(), 5);
		matricula = Utilerias.formatoValor(camion.getMatricula(), 20);
		potencia = Utilerias.formatoValor(camion.getPotencia(), 10);
		modelo = Utilerias.formatoValor(camion.getModelo(), 20);
		tipo = Utilerias.formatoValor(camion.getTipo(), 20);
		
		System.out.println("\n\n+++++++++ Datos del camión +++++++++\n");
		System.out.println("Id   Matricula           Potencia  Modelo              Tipo");
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println(ids + matricula + potencia + modelo + tipo);
		System.out.println("\n--------------------------------------------------------------------");
		System.out.println("     Opciones...");
		System.out.println("            0.- Regresar");
		System.out.println("            1.- Actualizar");
		System.out.println("            2.- Borrar");
		System.out.println("            S.- Salir");
		return camion;
	}
	
	public void actualizaCamion(Camion camion, Session session){
	}
	*/
}
