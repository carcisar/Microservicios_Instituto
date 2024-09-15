package com.microservicios.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.entity.Alumno;
import com.microservicios.entity.Curso;
import com.microservicios.entity.Examen;
import com.microservicios.services.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cursos")
public class CursoController extends CommonController<Curso, CursoService>{
	
	
	@Value("${config.balanceador.test}")
	private String balanceadorTest;

	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		Map<String, Object> response = new HashMap<>();
		response.put("balanceador", balanceadorTest);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result,@PathVariable Long id ){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curso> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		cursoDb.setName(curso.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
		
	}
	

	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		alumnos.forEach(a -> {
			cursoDb.addAlumnos(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		cursoDb.removeAlumnos(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> findByCursoByAlumnoId(@PathVariable Long id) {
		Curso curso = service.findByCursoByAlumnoId(id);
		return ResponseEntity.ok(curso);
		
	}


	

	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		examenes.forEach(a -> {
			cursoDb.addExamen(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		cursoDb.removeExamen(examen);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
