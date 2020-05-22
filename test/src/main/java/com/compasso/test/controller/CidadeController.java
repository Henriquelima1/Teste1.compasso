package com.compasso.test.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.test.modelo.Cidade;
import com.compasso.test.repository.CidadeRepository;

@RestController
@RequestMapping("/Cidade")
public class CidadeController {

	@Autowired
	CidadeRepository cidadeRepository;
	@PostMapping
	public ResponseEntity<?> cadastroCidade(@RequestBody Cidade cidade) {
		Cidade cidadeSalvo = cidadeRepository.save(cidade);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/Cidade").path("/{id}")
			.buildAndExpand(cidadeSalvo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	@GetMapping("/{nome}/{estado}")
	public  ResponseEntity<Cidade> consultaCidade(@PathVariable("nome") String nome,@PathVariable("estado") String estado){
		return ResponseEntity.ok().body(cidadeRepository.findByCidade(nome, estado));
	}
	
}
