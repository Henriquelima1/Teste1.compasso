package com.compasso.test.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Cliente {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sexo;
	private LocalDateTime dataNasci;
	private int idade;
	private String nomeCidade;
	private String nomeEstado;
	
	@OneToOne
	private Cidade cidade;
	
	
	public Cliente( String nome, String sexo, LocalDateTime dataNasci, int idade, String nomeCidade,
			String nomeEstado, Cidade cidade) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasci = dataNasci;
		this.idade = idade;
		this.nomeCidade = nomeCidade;
		this.nomeEstado = nomeEstado;
		this.cidade = cidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
}
