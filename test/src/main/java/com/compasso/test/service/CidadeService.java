package com.compasso.test.service;

import java.net.URI;
import java.util.Optional;

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
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public ResponseEntity<CidadeDto> cadastrar(@Valid CidadeForm form, UriComponentsBuilder uriBuilder){
		Cidade cidade = form.puxar(clienteRepository);
		cidadeRepository.save(cidade);

		URI uri = uriBuilder.path("/cadastrarCidade/{id}").buildAndExpand(cidade.getIdCidade()).toUri();

		return ResponseEntity.created(uri).body(new CidadeDto(cidade));
	}

	public ResponseEntity<Cidade> consultar( String nome, String estado) {
		
		Optional<Cidade> optional = Optional.of(cidadeRepository.findByNomeAndEstado(nome, estado));
		if(optional.isPresent()) {
			Cidade cidade =cidadeRepository.findByNomeAndEstado(nome, estado);
			return ResponseEntity.ok(cidade);
		}
		
		return ResponseEntity.notFound().build();	
	}
}
