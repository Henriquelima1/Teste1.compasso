package com.compasso.test.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.compasso.test.modelo.buscacep.Endereco;

@Service
public class BuscaCepService {

	public String find(RestTemplate restTemplate) {
		Endereco endereco = restTemplate.getForObject("https://viacep.com.br/ws/99010190/json/", Endereco.class);
		
		return endereco.toString();
	}
}
