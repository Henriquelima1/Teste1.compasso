package com.compasso.test.controller.dto;

import com.compasso.test.modelo.Cidade;

public class CidadeDto {

	private Long id;
	
	private String nome;
	private String estado;
	
	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();

	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEstado() {
		return estado;
	}
	
	
	
	
}
