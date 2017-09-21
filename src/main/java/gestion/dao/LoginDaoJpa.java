package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Login;

@Repository
@Transactional
public class LoginDaoJpa implements LoginDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Login> findAll() {
		Query query = em.createQuery("select l from Login as l");
		return query.getResultList();
	}

	@Override
	public Login find(Long pk) {
		return em.find(Login.class, pk);
	}

	public Login findByLogin(String login) {
		Query query = em.createQuery("select l from Login as l where l.login=login");
		return (Login) query.getSingleResult();
	}

	@Override
	public void create(Login obj) {
		em.persist(obj);

	}

	@Override
	public Login update(Login obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Login obj) {
		em.remove(em.merge(obj));

	}

}
