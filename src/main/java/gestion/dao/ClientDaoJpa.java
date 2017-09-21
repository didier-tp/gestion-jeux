package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Client;

@Repository
@Transactional
public class ClientDaoJpa implements ClientDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		Query query = em.createQuery("select c from Client as c");
		return query.getResultList();
	}

	@Override
	public Client find(Long pk) {
		return em.find(Client.class, pk);
	}

	public Client findByName(String name) {
		System.out.println(name);
		Query query = em.createQuery("from Client as c where c.nom=:pname");
		return (Client) query.setParameter("pname", name).getSingleResult();
	}

	public Client findByFirstName(String firstName) {
		Query query = em.createQuery("from Client as c where c.prenom=:firstName");
		return (Client) query.setParameter("firstName", firstName).getSingleResult();
	}

	public Client findByMail(String email) {
		Query query = em.createQuery("from Client as c where c.mail=:pmail");
		return (Client) query.setParameter("pmail", email).getSingleResult();
	}

	public Client findByTel(int tel) {
		Query query = em.createQuery("from Client as c where c.telephone=:ptel");
		return (Client) query.setParameter("ptel", tel).getSingleResult();
	}

	@Override
	public void create(Client obj) {
		em.persist(obj);
	}

	@Override
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Client obj) {
		em.remove(em.merge(obj));
	}

}
