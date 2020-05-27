package com.compasso.test.controller.dto;

import com.compasso.test.modelo.Cidade;

public class CidadeDto {

	private Long idCidade;
	
	private String nome;
	private String estado;
	
	public CidadeDto(Cidade cidade) {
		this.idCidade = cidade.getIdCidade();
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();

	}
	public Long getIdCidade() {
		return idCidade;
	}
	public String getNome() {
		return nome;
	}
	public String getEstado() {
		return estado;
	}
	
	
	
	
}
