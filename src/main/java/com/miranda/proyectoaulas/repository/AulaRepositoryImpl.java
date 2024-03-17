package com.miranda.proyectoaulas.repository;

import java.util.List;

import com.miranda.proyectoaulas.model.Aula;
import com.miranda.proyectoaulas.util.JpaUtil;

import jakarta.persistence.EntityManager;


public class AulaRepositoryImpl implements GenericRepository<Aula, Long>{
	
	private EntityManager em;

	
	@Override
	public List<Aula> getAll() {
		em = JpaUtil.getEntityManager();
		List<Aula> aulas =  em.createQuery("SELECT a FROM Aula a", Aula.class).getResultList();
		em.close();
		return aulas;
	}

	@Override
	public Aula findById(Long id) {
		em = JpaUtil.getEntityManager();
		Aula aula = null;
		aula = em.find(Aula.class, id);
		em.close();
		return aula;
	}

	@Override
	public void save(Aula aula) {
		em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(aula);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	@Override
	public void update(Aula aula) {
		em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(aula);
			em.getTransaction().commit();
			
		}catch (Exception e) {
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
			Aula aula =findById(id);
			em.getTransaction().begin();
			em.remove(aula);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

}
