package com.compasso.test.service;



import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.test.controller.dto.CidadeDto;
import com.compasso.test.controller.form.CidadeForm;
import com.compasso.test.entidades.Cidade;
import com.compasso.test.repository.CidadeRepository;
import com.compasso.test.repository.ClienteRepository;

@Service
public class CidadeService {

	private final CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	public CidadeService(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	public ResponseEntity<CidadeDto> cadastrar(@Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
		Cidade cidade = form.puxar(clienteRepository);

		URI uri = uriBuilder.path("/cadastrarCidade/{id}").buildAndExpand(cidade.getIdCidade()).toUri();


		return ResponseEntity.created(uri).body(new CidadeDto(cidade));
	}

}
