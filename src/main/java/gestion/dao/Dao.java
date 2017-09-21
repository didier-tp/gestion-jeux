package gestion.dao;

import java.util.List;

public interface Dao<T, PK> {
	List<T> findAll();

	T find(PK pk);

	void create(T obj);

	T update(T obj);

	void delete(T obj);
}
