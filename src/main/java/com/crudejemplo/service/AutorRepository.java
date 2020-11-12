package com.crudejemplo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudejemplo.clases.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

	@Query (value= "SELECT nombre FROM Autor", nativeQuery = true)
	List<String> test2();
}
