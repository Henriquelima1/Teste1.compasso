package com.compasso.test.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.compasso.test.service.BuscaCepService;

@RestController
@RequestMapping("/Enderecos")
public class BuscaCepResource {

	private static final RestTemplate Endereco = null;
	
	@Autowired
	private BuscaCepService buscaCepService;
	
	public String find() {
		buscaCepService.find(Endereco);
		return Endereco.toString();
	}
	
}
