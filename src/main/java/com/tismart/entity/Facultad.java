package com.tismart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "FACULTAD")
public class Facultad {

	@Id
	@Column(name = "IDFACULTAD")
	private int idfacultad;

	@Column(name = "DESCFACULTAD")
	private String descfacultad;

	@Column(name = "FECHAREGISTRO")
	private Date fecharegistro;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "facultad")
	@JsonBackReference
	private List<Escuela> escuela;

	public Facultad() {
		super();
	}

	public Facultad(int idfacultad, String descfacultad, Date fecharegistro, List<Escuela> escuela) {
		super();
		this.idfacultad = idfacultad;
		this.descfacultad = descfacultad;
		this.fecharegistro = fecharegistro;
		this.escuela = escuela;
	}

	public int getIdfacultad() {
		return idfacultad;
	}

	public void setIdfacultad(int idfacultad) {
		this.idfacultad = idfacultad;
	}

	public String getDescfacultad() {
		return descfacultad;
	}

	public void setDescfacultad(String descfacultad) {
		this.descfacultad = descfacultad;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public List<Escuela> getEscuela() {
		return escuela;
	}

	public void setEscuela(List<Escuela> escuela) {
		this.escuela = escuela;
	}

	@Override
	public String toString() {
		return "Facultad [idfacultad=" + idfacultad + ", descfacultad=" + descfacultad + ", fecharegistro="
				+ fecharegistro + ", escuela=" + escuela + "]";
	}

}
