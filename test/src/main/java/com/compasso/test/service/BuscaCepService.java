package com.compasso.test.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.test.entidades.buscacep.Endereco;

@Service
public class BuscaCepService {

	private static final String URL = "https://viacep.com.br/ws/{cep}/json/";

	public String find(RestTemplate restTemplate, String cep) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL).queryParam("cep", cep);
		Endereco endereco = restTemplate.getForObject(builder.buildAndExpand(builder).toUri(), Endereco.class);

		return endereco.toString();
	}
}
