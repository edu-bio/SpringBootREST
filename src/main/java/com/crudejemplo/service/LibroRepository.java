package com.crudejemplo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudejemplo.clases.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
