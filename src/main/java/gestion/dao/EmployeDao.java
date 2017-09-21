package gestion.dao;

import gestion.model.Employe;

public interface EmployeDao extends Dao<Employe, Long> {
	public Employe findByName(String name);

	public Employe findByFirstName(String firstName);

	public Employe findByMail(String mail);
}
