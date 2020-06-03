package com.compasso.test.entidades;

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
	private String cep;

	public Cidade(String nome, String estado, String cep) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.cep = cep;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
