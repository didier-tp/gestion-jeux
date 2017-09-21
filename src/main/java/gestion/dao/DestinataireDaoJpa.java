package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Destinataire;

@Repository
@Transactional
public class DestinataireDaoJpa implements DestinataireDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Destinataire> findAll() {
		Query query = em.createQuery("select d from Destinataire as d");
		return query.getResultList();
	}

	@Override
	public Destinataire find(Long pk) {
		return em.find(Destinataire.class, pk);
	}

	@Override
	public void create(Destinataire obj) {
		em.persist(obj);
	}

	@Override
	public Destinataire update(Destinataire obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Destinataire obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public Destinataire findByName(String name) {
		Query query = em.createQuery("select d from Destinataire as d where d.nom=name");
		return (Destinataire) query.getSingleResult();
	}

	@Override
	public Destinataire findByFirstName(String firstName) {
		Query query = em.createQuery("select d from Destinataire as d where d.prenom=firstName");
		return (Destinataire) query.getSingleResult();
	}

	@Override
	public Destinataire findByMail(String mail) {
		Query query = em.createQuery("select d from Destinataire as d where d.mail=mail");
		return (Destinataire) query.getSingleResult();
	}

}
