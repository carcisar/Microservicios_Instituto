package com.microservicios.service;

import java.util.List;
import java.util.Optional;

import com.microservicios.entity.Alumno;



public interface AlumnoService extends CommonService<Alumno>{
	
	
	public List<Alumno> findByNombreOrApellido(String term);

}
