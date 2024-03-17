package com.miranda.proyectoaulas.repository;

import java.util.List;

import com.miranda.proyectoaulas.model.Usuario;

public interface GenericRepository<T, D> {

	List<T> getAll();

	T findById(D id);

	void save(T t);

	void update(T t);

	void delete(D id);

	default Usuario logged(String username, String password) {
		return null;
	}

}
