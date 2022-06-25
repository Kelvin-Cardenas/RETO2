package com.tismart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tismart.entity.Escuela;
import com.tismart.entity.Facultad;
import com.tismart.repository.EscuelaReposi;
import com.tismart.repository.FacultadReposi;

@Service
public class EscuelaServiceImpl implements IEscuelaService {
	
	@Autowired
	private EscuelaReposi escuelareposi;
	@Autowired
	private FacultadReposi facultadreposi;

	@Override
	@Transactional(readOnly =true)
	public List<Escuela> findAll(Sort sort) {
		
		return escuelareposi.findAll(sort);
	}

	@Override
	@Transactional(readOnly =true)
	public Page<Escuela> findAll(Pageable pageable) {
		
		return escuelareposi.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =true)
	public Escuela findById(int id) {
		
		return escuelareposi.findById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		escuelareposi.deleteById(id);;
		
	}

	@Override
	@Transactional
	public Escuela save(Escuela escuela) {
		
		Facultad facultad = facultadreposi.
				findById(escuela.getFacultad().getIdfacultad()).orElse(null);
		escuela.setFacultad(facultad);
		
		return escuelareposi.save(escuela);
		
	}
	

}
