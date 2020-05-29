package com.compasso.test.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCidade;
	private String nome;
	private String estado;
	
	
	public Cidade(String nome, String estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}
	public Long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Long id) {
		this.idCidade = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
