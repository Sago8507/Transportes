package com.anncode.negocio;

import com.anncode.transporteshibernate.Camion.Camion;
import com.anncode.transporteshibernate.Camion.CamionDAO;
import com.anncode.util.Utilerias;

import java.util.List;

import org.hibernate.Session;


public class Menu {

	CamionDAO camionDao = new CamionDAO();
	
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
		System.out.println("\nSeleccionar un ID...");

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
		return camion;
	}
	
}
