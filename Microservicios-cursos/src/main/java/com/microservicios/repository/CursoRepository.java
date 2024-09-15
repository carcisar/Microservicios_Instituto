package com.microservicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.microservicios.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
	public Curso findByCursoByAlumnoId(Long id);

}
