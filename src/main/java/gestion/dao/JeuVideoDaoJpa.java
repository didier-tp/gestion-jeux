package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.JeuVideo;

@Repository
@Transactional
public class JeuVideoDaoJpa implements JeuVideoDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<JeuVideo> findAll() {
		Query query = em.createQuery("select j from JeuVideo as j");
		return query.getResultList();
	}

	@Override
	public JeuVideo find(Long pk) {
		return em.find(JeuVideo.class, pk);
	}

	@Override
	public JeuVideo findByNom(String nom) {
		Query query = em.createQuery("select j from JeuVideo as j where j.nomJeu=:nom");
		return (JeuVideo) query.setParameter("nom", nom).getSingleResult();
	}

	@Override
	public JeuVideo findByGenre(String genre) {
		Query query = em.createQuery("select j from JeuVideo as j where j.genre=:genre");
		return (JeuVideo) query.setParameter("genre", genre).getSingleResult();
	}

	@Override
	public JeuVideo findByPlateforme(String plateforme) {
		Query query = em.createQuery("select j from JeuVideo as j where j.plateforme=:plateforme");
		return (JeuVideo) query.setParameter("plateforme", plateforme).getSingleResult();
	}

	@Override
	public void create(JeuVideo obj) {
		em.persist(obj);
	}

	@Override
	public JeuVideo update(JeuVideo obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(JeuVideo obj) {
		em.remove(em.merge(obj));
	}

}
