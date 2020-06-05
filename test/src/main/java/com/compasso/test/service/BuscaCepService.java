package com.compasso.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.test.entidades.buscacep.Endereco;

@Service
public class BuscaCepService {

	@Value("${viacep}") private String viacep;
	//private static final String URL = "https://viacep.com.br/ws/{cep}/json/";

	public String find(RestTemplate restTemplate, String cep) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(viacep).queryParam("cep", cep);
		Endereco endereco = restTemplate.getForObject(builder.buildAndExpand(builder).toUri(), Endereco.class);

		return endereco.toString();
	}
}
