package com.compasso.test.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.compasso.test.modelo.Cliente;



public class ClienteDto {

	private Long id;
	
	private String nome;
	private String sexo;
	private LocalDateTime dataNasci;
	private int idade;
	
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome= cliente.getNome();
		this.sexo= cliente.getSexo();
		this.dataNasci= cliente.getDataNasci();
		this.idade= cliente.getIdade();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getSexo() {
		return sexo;
	}


	public LocalDateTime getDataNasci() {
		return dataNasci;
	}


	public int getIdade() {
		return idade;
	}
	
	//Metodo trocado de "List" para "Page" para paginação
	
		public static Page<ClienteDto> converter(Page<Cliente> cliente) {
			//"(ClienteDto::new)" para pegar o construtor
			
			return cliente.map(ClienteDto::new);
			
			//Codigo sendo Ajustado para a Paginação
			//return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
		}
	
}
