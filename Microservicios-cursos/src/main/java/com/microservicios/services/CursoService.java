package com.microservicios.services;

import com.microservicios.entity.Curso;
import com.microservicios.service.CommonService;

public interface CursoService extends CommonService<Curso>{
	
	public Curso findByCursoByAlumnoId(Long id);


}
