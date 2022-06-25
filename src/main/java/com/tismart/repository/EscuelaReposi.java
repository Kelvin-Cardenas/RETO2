package com.tismart.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tismart.entity.Escuela;


@Repository
public interface EscuelaReposi extends JpaRepository<Escuela, Integer> {
	
	
	@Query(value="select e from Escuela e left join fetch e.facultad")
	public List<Escuela> findAll( Sort sort);
	
	@Query(value="select e from Escuela e left join fetch e.facultad" ,countQuery = 
			"select e from Escuela e left join e.facultad")
	
	public Page<Escuela> findAll(Pageable pageable);
	
	
	@Query(value="select e from Escuela e left join fetch e.facultad where e.id =:id")
	public Escuela findById(int id);


}
