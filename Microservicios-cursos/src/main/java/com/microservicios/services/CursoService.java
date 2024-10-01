package com.microservicios.services;

import org.springframework.web.bind.annotation.PathVariable;

import com.microservicios.entity.Curso;
import com.microservicios.service.CommonService;

public interface CursoService extends CommonService<Curso>{
	
	public Curso findByCursoByAlumnoId(Long id);
	public Iterable<Long> obtenerExamenesIdConRespuestasAlumnos(Long alumnoId);


}
