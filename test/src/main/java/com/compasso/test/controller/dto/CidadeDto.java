package com.compasso.test.controller.dto;

import com.compasso.test.entidades.Cidade;

public class CidadeDto {

	private Long idCidade;

	private String nome;
	private String estado;
	private String cep;

	public CidadeDto(Cidade cidade) {
		this.idCidade = cidade.getIdCidade();
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();
		this.cep = cidade.getCep();

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

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "Cidade Cadastrada [nome=" + nome + ", estado=" + estado + ", cep=" + cep + "]";

	}

}
