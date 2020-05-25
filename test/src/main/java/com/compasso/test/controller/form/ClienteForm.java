package com.compasso.test.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.compasso.test.modelo.Cidade;
import com.compasso.test.modelo.Cliente;
import com.compasso.test.repository.CidadeRepository;



public class ClienteForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty @Size(min=2, max=2)
	private String sexo;
	
	@NotNull @NotEmpty
	private LocalDateTime dataNasci;
	
	@NotNull @NotEmpty
	private int idade;
	
	@NotNull @NotEmpty
	private Long idCidade;
	



	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDateTime getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(LocalDateTime dataNasci) {
		this.dataNasci = dataNasci;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	public Cliente converter(CidadeRepository cidadeRepository) {
		Cidade cidadeConverte = cidadeRepository.findByCidade(idCidade);
		return new Cliente(nome, sexo, dataNasci, idade, idCidade, cidadeConverte);
	}
	
	
}
