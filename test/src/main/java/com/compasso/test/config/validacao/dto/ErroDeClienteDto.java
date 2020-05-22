package com.compasso.test.config.validacao.dto;

public class ErroDeClienteDto {

	private String campo;
	private String erro;
	public ErroDeClienteDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
	
	
	
	
	
}
