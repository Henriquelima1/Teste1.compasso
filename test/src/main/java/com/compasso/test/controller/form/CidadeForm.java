package com.compasso.test.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.compasso.test.entidades.Cidade;
import com.compasso.test.repository.ClienteRepository;

public class CidadeForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2)
	private String estado;
	private String cep;

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

	public Cidade puxar(ClienteRepository clienteRepository) {
		return new Cidade(nome, estado, cep);
	}

}
