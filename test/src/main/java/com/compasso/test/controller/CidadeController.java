package com.compasso.test.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.test.controller.dto.CidadeDto;
import com.compasso.test.controller.form.CidadeForm;
import com.compasso.test.modelo.Cidade;
import com.compasso.test.repository.CidadeRepository;
import com.compasso.test.repository.ClienteRepository;

@RestController
@RequestMapping("/Cidade")
public class CidadeController {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<CidadeDto> cadastroCidade(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
		Cidade cidade = form.puxar(clienteRepository);
		
		URI uri = uriBuilder.path("/cadastrarCidade/{id}").buildAndExpand(cidade.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new CidadeDto(cidade));
	}
	@GetMapping("/{nome}/{estado}")
	public  ResponseEntity<Cidade> consultaCidade(@PathVariable("nome") String nome,@PathVariable("estado") String estado){
		return ResponseEntity.ok().body(cidadeRepository.findByCidadeNome(nome, estado));
	}
	
}
