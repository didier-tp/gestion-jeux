package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Commande;

@Repository
@Transactional
public class CommandeDaoJpa implements CommandeDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findAll() {
		Query query = em.createQuery("select c from Commande as c");
		return query.getResultList();
	}

	@Override
	public Commande find(Long pk) {
		return em.find(Commande.class, pk);
	}

	@Override
	public void create(Commande obj) {
		em.persist(obj);
	}

	@Override
	public Commande update(Commande obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Commande obj) {
		em.remove(em.merge(obj));
	}

}
