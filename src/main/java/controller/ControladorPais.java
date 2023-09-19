package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pai;

public class ControladorPais {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalPortatilesYMarcas");
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Pai> findById (int id, int idContinente){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM pais where idContinente = ?  order by id = ? desc;", Pai.class);
		q.setParameter(1, idContinente);
		q.setParameter(2, id);
		
		@SuppressWarnings("unchecked")
		List<Pai> l = (List<Pai>) q.getResultList();
		em.close();
		return l;
	}
}
