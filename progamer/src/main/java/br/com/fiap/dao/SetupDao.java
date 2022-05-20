package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;

public class SetupDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager manager = factory.createEntityManager();

	public void insert(Setup setup) {
		
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.clear();
		
	}
	
	public List<Setup> list(){
		
		TypedQuery<Setup> query = 
				manager.createQuery("SELECT s FROM Setup s", Setup.class);
		
		return query.getResultList();
		
	}

	public void delete(Setup setup) {
		manager.getTransaction().begin();
		setup = manager.merge(setup);
		manager.remove(setup);
		manager.getTransaction().commit();
		
	}

	public void update(Setup setup) {
		manager.getTransaction().begin();
		setup = manager.merge(setup);
		manager.getTransaction().commit();
	}

}
