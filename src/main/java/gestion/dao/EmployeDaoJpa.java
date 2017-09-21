package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Employe;

@Repository
@Transactional
public class EmployeDaoJpa implements EmployeDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> findAll() {
		Query query = em.createQuery("select e from Employe as e");
		return query.getResultList();
	}

	@Override
	public Employe find(Long pk) {
		return em.find(Employe.class, pk);
	}

	public Employe findByName(String name) {
		Query query = em.createQuery("select e from Employe as e where e.nom=name");
		return (Employe) query.getSingleResult();
	}

	public Employe findByFirstName(String firstName) {
		Query query = em.createQuery("select e from Employe as e where e.prenom=firstName");
		return (Employe) query.getSingleResult();
	}

	public Employe findByMail(String mail) {
		Query query = em.createQuery("select e from Employe as e where e.mail=mail");
		return (Employe) query.getSingleResult();
	}

	@Override
	public void create(Employe obj) {
		em.persist(obj);

	}

	@Override
	public Employe update(Employe obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Employe obj) {
		em.remove(em.merge(obj));
	}

}
