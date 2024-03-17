package com.miranda.proyectoaulas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula")
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numaula;
	
	private int capacidad;
	
	private String descripcion;
	
	private String nombre;
	
	private int estado;

	public Long getNumaula() {
		return numaula;
	}

	public void setNumaula(Long numaula) {
		this.numaula = numaula;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Aula [numaula=" + numaula + ", capacidad=" + capacidad + ", descripcion=" + descripcion + ", nombre="
				+ nombre + ", estado=" + estado + "]";
	}
	
	
	
	

}
