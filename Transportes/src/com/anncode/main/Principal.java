package com.anncode.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anncode.transporteshibernate.Camion.Camion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory;
		
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		
		
		//Insertar
		Camion camion = new Camion("ABCD123",2.0,"BMW","100.0");
		Session session = sessionFactory.openSession();
		//session.beginTransaction();
		
		//session.save(camion); //Insertando el registro
		//session.getTransaction().commit();
		
		
		//Obtener
		Camion camion2 = (Camion) session.get(Camion.class, 1);
		System.out.println("ID        :" + camion2.getId());
		System.out.println("MATRICULA :" + camion2.getMatricula());
		System.out.println("POTENCIA  :" + camion2.getPotencia());
		System.out.println("MODELO    :" + camion2.getModelo());
		System.out.println("TIPO      :" + camion2.getTipo());
		
		List<Camion> camiones = (List<Camion>) 
		//session.createCriteria(Camion.class).setMaxResults(2).list();
		session.createCriteria(Camion.class).list();
		
		for(Camion camion3 : camiones){
			System.out.println(" ID        " + camion3.getId());
			System.out.println(" MATRICULA " + camion3.getMatricula());
		}
		
		//Actualizar HQL
		session.beginTransaction();
		String hql = "UPDATE Camion set matricula = :matricula WHERE id = :id ";
		Query query = session.createQuery(hql);
		query.setParameter("matricula", "MRY6392");
		query.setParameter("id", 1);
		query.executeUpdate();
		session.getTransaction().commit();
		
		//Actualizar con objetos
		session.beginTransaction();
		Camion camion4 = (Camion) session.get(Camion.class, 6);
		camion4.setMatricula("MAT666");
		session.getTransaction().commit();
		
		
		//Eliminar por HQL
		/*
		session.beginTransaction();
		hql = "DELETE FROM Camion WHERE id = :id";
		query = session.createQuery(hql);
		query.setParameter("id", 5);
		query.executeUpdate();
		session.getTransaction().commit();
		*/
		
		//Eliminar con objeto
		/*
		session.beginTransaction();
		Camion camion5 = (Camion) session.get(Camion.class, 3);
		session.delete(camion5);
		session.getTransaction().commit();
		*/
		
		
		//cerramos la transaccion
		session.close();
		sessionFactory.close();
		
	}

	
	
}
