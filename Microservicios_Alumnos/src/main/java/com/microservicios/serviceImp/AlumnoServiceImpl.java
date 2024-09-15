package com.microservicios.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.microservicios.entity.Alumno;
import com.microservicios.repository.AlumnoRepository;
import com.microservicios.service.AlumnoService;
import com.microservicios.service.CommonServiceImpl;

import jakarta.transaction.Transactional;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService{

	@Override
	@Transactional
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	

}
