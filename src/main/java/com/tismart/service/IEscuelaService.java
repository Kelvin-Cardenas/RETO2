package com.tismart.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tismart.entity.Escuela;

public interface IEscuelaService {

	
	public List<Escuela> findAll( Sort sort);
	
	public Page<Escuela> findAll(Pageable pageable);
	
	public Escuela findById(int id);
	
	public void delete(int id);
	
	public Escuela save(Escuela escuela);
}
