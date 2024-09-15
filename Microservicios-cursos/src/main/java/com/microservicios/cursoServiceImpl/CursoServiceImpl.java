package com.microservicios.cursoServiceImpl;

import org.springframework.stereotype.Service;

import com.microservicios.entity.Curso;
import com.microservicios.repository.CursoRepository;
import com.microservicios.service.CommonServiceImpl;
import com.microservicios.services.CursoService;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso,CursoRepository> implements CursoService{

	@Override
	@Transactional
	public Curso findByCursoByAlumnoId(Long id) {
		return repository.findByCursoByAlumnoId(id);
	}

	

}
