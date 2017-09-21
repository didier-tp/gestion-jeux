package gestion.dao;

import gestion.model.Destinataire;

public interface DestinataireDao extends Dao<Destinataire, Long> {
	public Destinataire findByName(String name);

	public Destinataire findByFirstName(String firstName);

	public Destinataire findByMail(String mail);
}
