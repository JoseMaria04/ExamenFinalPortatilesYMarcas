package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Portatil;


public class ControladorPortatil {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalPortatilesYMarcas");

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Portatil findById (int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM portatil where id= ?", Portatil.class);
		q.setParameter(1, id);
		
		Portatil l = (Portatil) q.getSingleResult();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Portatil findFirst (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM portatil order by id limit 1", Portatil.class);
		
		Portatil l = (Portatil) q.getSingleResult();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Portatil findLast() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM portatil order by id desc limit 1", Portatil.class);
		
		Portatil l = (Portatil) q.getSingleResult();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param actualId
	 * @return
	 */
	public static Portatil findNext(int actualId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM portatil where id > ? order by id limit 1", Portatil.class);
		q.setParameter(1, actualId);
		
		Portatil l = (Portatil) q.getSingleResult();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param actualId
	 * @return
	 */
	public static Portatil findPrevious(int actualId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM portatil where id < ? order by id desc limit 1", Portatil.class);
		q.setParameter(1, actualId);
		
		Portatil l = (Portatil) q.getSingleResult();
		em.close();
		return l;
	}
	
	public static void eliminarEntidad(Portatil l) {
		EntityManager em = entityManagerFactory.createEntityManager();		

		l = em.merge(l);
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 */
	public static void modificarEntidad (Portatil l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Portatil> findAll (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM portatil ", Portatil.class);
		
		@SuppressWarnings("unchecked")
		List<Portatil> l = (List<Portatil>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 */
	public static void creacionEntidad (Portatil l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
}
