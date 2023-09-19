package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Continente;


public class ControladorContinente {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalPortatilesYMarcas");
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Continente> findById (int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Continente order by id = ? desc;", Continente.class);
		q.setParameter(1, id);
		
		@SuppressWarnings("unchecked")
		List<Continente> l = (List<Continente>) q.getResultList();
		em.close();
		return l;
	}
}
