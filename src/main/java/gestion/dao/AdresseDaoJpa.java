package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Adresse;



@Repository
@Transactional
public  class AdresseDaoJpa implements AdresseDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	
	public List<Adresse> findAll() {
		Query query = em.createQuery("select A from Client as a");
		return query.getResultList();
	}

	@Override
	public Adresse find(Long pk) {
		// TODO Auto-generated method stub
		return em.find(Adresse.class, pk);
	}

	@Override
	public void create(Adresse obj) {
		em.persist(obj);
	}

	@Override
	public Adresse update(Adresse obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Adresse obj) {
		em.remove(em.merge(obj));
	}

	public Adresse findByStreet(String street) {
		System.out.println(street);
		Query query = em.createQuery("from Adresse as a where a.rue=:larue");
		return (Adresse) query.setParameter("larue", street).getSingleResult();
	}
	@Override
	public Adresse findByCP(String CP) {
		System.out.println(CP);
		Query query = em.createQuery("from Adresse as a where a.codePostal=:cp");
		return (Adresse) query.setParameter("cp", CP).getSingleResult();
	}

	@Override
	public Adresse findByCity(String city) {
		System.out.println(city);
		Query query = em.createQuery("from Adresse as a where a.ville=:laville");
		return (Adresse) query.setParameter("laville", city).getSingleResult();
	}
	
}
