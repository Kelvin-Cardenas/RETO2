package com.tismart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tismart.entity.Escuela;
import com.tismart.service.IEscuelaService;

@RestController
@RequestMapping(value = "/escuela")
public class EscuelaController {
	
	@Autowired
	private IEscuelaService escuelaService;
		
	@GetMapping
	public ResponseEntity<List<Escuela>> findAll(@RequestParam(required = false) Integer page, 
												@RequestParam(required = false)Integer size){
		
		
		
		
		Sort sortByName = Sort.by("nombre");
		
		if (page != null && size != null) {
			
			Pageable pageable = PageRequest.of(page, size, sortByName);
			
			List<Escuela> escuela = escuelaService.findAll(pageable).getContent();
			
			if(escuela.size() >0) {				
				return new ResponseEntity<List<Escuela>>(escuela,HttpStatus.OK);
				
			}else {				
				return new ResponseEntity<List<Escuela>>(HttpStatus.NO_CONTENT);				
			}
			
		}else {			
			
			List<Escuela> escuela = escuelaService.findAll(sortByName);
			
			if(escuela.size() >0) {
				
				return new ResponseEntity<List<Escuela>>(escuela,HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<List<Escuela>>(HttpStatus.NO_CONTENT);
				
			}					
		}	
	}
	
	
	
	
	@GetMapping(value="/{id}")	
	public ResponseEntity<Escuela> finById( @PathVariable int id){
		
		Escuela escuela = escuelaService.findById(id);
		
		ResponseEntity<Escuela> responseEntity=null;
		
		if(escuela !=null) {
			responseEntity=new ResponseEntity<Escuela>(escuela ,HttpStatus.OK);
			
			
		}else {
			responseEntity=new ResponseEntity<Escuela>(HttpStatus.NO_CONTENT);			
			
		}
		
		return responseEntity;
		
	
	
	}
	
	@PostMapping("/posteEscuela")
	public ResponseEntity<Map<String,Object>> Insert(@Validated @RequestBody Escuela escuela, BindingResult result) {
		
		Map<String,Object> responseAsMap = new HashMap<String,Object>();
		ResponseEntity<Map<String, Object>> responseEntity = null;
		List<String> errores=null;
		
		if(result.hasErrors()) {
			errores = new ArrayList<String>();
			for(ObjectError error: result.getAllErrors()) {
				errores.add(error.getDefaultMessage());			
				
			}
			
			responseAsMap.put("erros",errores);
			responseEntity = new ResponseEntity<Map<String,Object>>(responseAsMap,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		
		
		try {
			
			Escuela escuelaFromdb=escuelaService.save(escuela);
			if(escuelaFromdb != null) {
				responseAsMap.put("escuela", escuela);
				responseAsMap.put("mensaje","la escuela con id"+ escuela.getIdescuela()+"se ha creadi cin exito ");
				responseEntity = new ResponseEntity<Map<String,Object>>(responseAsMap,HttpStatus.OK);		
										
						
			}else {
				
				responseAsMap.put("No se creo el mensaje","error");
				responseEntity = new ResponseEntity<Map<String,Object>>(responseAsMap,HttpStatus.INTERNAL_SERVER_ERROR);										
						
			}
			
		} catch (DataAccessException e) {
			responseAsMap.put("No se creo el mensaje","error:"+e.getMostSpecificCause().toString());
			responseEntity = new ResponseEntity<Map<String,Object>>(responseAsMap,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}	
		
		
		return responseEntity;
			
		}
		
		
		
	
	
	}

	
