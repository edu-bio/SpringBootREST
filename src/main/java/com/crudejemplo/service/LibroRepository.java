package com.crudejemplo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudejemplo.clases.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

	@Query (value= "SELECT titulo FROM Libro", nativeQuery = true)
	List<String> test1();
}
