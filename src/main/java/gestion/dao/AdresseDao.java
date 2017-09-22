package gestion.dao;

import gestion.model.Adresse;

public interface AdresseDao extends Dao<Adresse, Long> {

	
	public Adresse findByStreet(String rue);
	
	public Adresse findByCity(String city);
	
	public Adresse findByCP(String CP);


}
