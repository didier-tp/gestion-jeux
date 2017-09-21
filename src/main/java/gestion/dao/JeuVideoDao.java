package gestion.dao;

import gestion.model.JeuVideo;

public interface JeuVideoDao extends Dao<JeuVideo, Long> {

	public JeuVideo findByNom(String nom);

	public JeuVideo findByGenre(String genre);

	public JeuVideo findByPlateforme(String plateforme);
}
