package gestion.dao;

import gestion.model.Login;

public interface LoginDao extends Dao<Login, Long> {
	public Login findByLogin(String login);

}
