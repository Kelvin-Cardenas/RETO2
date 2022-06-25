package com.tismart.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ESCUELA")
public class Escuela {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDESCUELA")
	private int idescuela;
	
	
	@Column(name="NOMBRE")
	
	private String nombre;
	
	@Column(name="CANTALUMNOS")
	private int cantalumnos;
	
	@Column(name="RECURSO_FISCAL")
	private double recurso_fiscal;
	
	@Column(name="LICENCIADA")
	private String licenciada;
	
	@Column(name="CLASIFICACION")
	private int clasificacion;
	
	
	@Column(name="FECHAREGISTRO")
	private Date fecharegistro;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IDFACULTAD")
	@JsonManagedReference
	private Facultad facultad;
	
	
	
	
	
	public Escuela() {
		super();
	}
	public Escuela(int idescuela, String nombre, int cantalumnos, double recurso_fiscal, String licenciada,
			int clasificacion, Date fecharegistro, Facultad facultad) {
		super();
		this.idescuela = idescuela;
		this.nombre = nombre;
		this.cantalumnos = cantalumnos;
		this.recurso_fiscal = recurso_fiscal;
		this.licenciada = licenciada;
		this.clasificacion = clasificacion;
		this.fecharegistro = fecharegistro;
		this.facultad = facultad;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantalumnos() {
		return cantalumnos;
	}
	public void setCantalumnos(int cantalumnos) {
		this.cantalumnos = cantalumnos;
	}
	public double getRecurso_fiscal() {
		return recurso_fiscal;
	}
	public void setRecurso_fiscal(double recurso_fiscal) {
		this.recurso_fiscal = recurso_fiscal;
	}
	public String getLicenciada() {
		return licenciada;
	}
	public void setLicenciada(String licenciada) {
		this.licenciada = licenciada;
	}
	public int getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	@Override
	public String toString() {
		return "Escuela [idescuela=" + idescuela + ", nombre=" + nombre + ", cantalumnos=" + cantalumnos
				+ ", recurso_fiscal=" + recurso_fiscal + ", licenciada=" + licenciada + ", clasificacion="
				+ clasificacion + ", fecharegistro=" + fecharegistro + ", facultad=" + facultad + "]";
	}
	
	
	

	

}
