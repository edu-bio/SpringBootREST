package com.crudejemplo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudejemplo.clases.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
