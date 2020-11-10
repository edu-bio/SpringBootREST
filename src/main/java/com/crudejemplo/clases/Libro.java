package com.crudejemplo.clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Libro")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="libroId")
	private int id;
	@Column(name="titulo")
	private String titulo;
	@Column(name="isbn")
	private int isbn;
	@OneToMany(mappedBy="libros", cascade=CascadeType.ALL)
	@JoinTable(name="autores")
	private int autorId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	
}
