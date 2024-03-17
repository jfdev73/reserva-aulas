package com.miranda.proyectoaulas.repository;

import java.util.List;

import com.miranda.proyectoaulas.model.Reserva;
import com.miranda.proyectoaulas.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class ReservaRepositoryJPA implements GenericRepository<Reserva, Long> {
	private EntityManager em;

	@Override
	public List<Reserva> getAll() {
		em = JpaUtil.getEntityManager();
		List<Reserva> reservas = em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
		em.close();
		return reservas;
	}

	@Override
	public Reserva findById(Long id) {
		em = JpaUtil.getEntityManager();
		Reserva reserva = null;
		reserva = em.find(Reserva.class, id);
		em.close();
		return reserva;
	}

	@Override
	public void save(Reserva reserva) {
		em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(reserva);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Reserva reserva) {
		em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(reserva);
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
			Reserva reserva = findById(id);
			em.getTransaction().begin();
			em.remove(reserva);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

}
