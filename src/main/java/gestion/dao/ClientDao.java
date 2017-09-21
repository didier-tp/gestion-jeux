package gestion.dao;

import gestion.model.Client;

public interface ClientDao extends Dao<Client, Long> {
	public Client findByName(String name);

	public Client findByMail(String mail);

	public Client findByTel(int tel);
}
