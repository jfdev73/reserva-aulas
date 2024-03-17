package com.miranda.proyectoaulas.repository;

import java.util.List;

import com.miranda.proyectoaulas.model.Usuario;
import com.miranda.proyectoaulas.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UsuarioRepository implements GenericRepository<Usuario, Long> {

	private EntityManager em;

	@Override
	public List<Usuario> getAll() {
		em = JpaUtil.getEntityManager();
		List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
		em.close();
		return usuarios;
	}

	@Override
	public Usuario findById(Long id) {
		em = JpaUtil.getEntityManager();
		Usuario user = null;
		user = em.find(Usuario.class, id);
		em.close();
		return user;
	}
	
	@Override
	public Usuario logged(String username, String password) {
		em = JpaUtil.getEntityManager();
		Usuario user;
		Query query =  em.createQuery("SELECT u from Usuario u WHERE u.username=?1 and u.password=?2", Usuario.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		try {
			user = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			user=null;
			e.printStackTrace();
		}
		
		em.close();
		return user;
	}

	@Override
	public void save(Usuario usuario) {
		em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Usuario user) {
		em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(Long id) {
		em = JpaUtil.getEntityManager();
		try {
			Usuario user = findById(id);
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

}
