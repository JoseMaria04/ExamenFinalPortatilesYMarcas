package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Marca;

public class ControladorMarca {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalPortatilesYMarcas");

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Marca> findById (int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM marca order by id = ? desc;", Marca.class);
		q.setParameter(1, id);
		
		@SuppressWarnings("unchecked")
		List<Marca> l = (List<Marca>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Marca> findAll (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM marca;", Marca.class);
		
		@SuppressWarnings("unchecked")
		List<Marca> l = (List<Marca>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 */
	public static void modificarEntidad (Marca l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
}
