package com.compasso.test.controller;


import javax.transaction.Transactional;
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
import com.compasso.test.entidades.Cidade;
import com.compasso.test.repository.CidadeRepository;
import com.compasso.test.repository.ClienteRepository;

import com.compasso.test.service.CidadeService;

@RestController
@RequestMapping("/Cidade")
public class CidadeController {


	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	
	private final CidadeService cidadeService;

	

	
	
	@Autowired
	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	@PostMapping("/cadastroCidade")
	@Transactional
	public ResponseEntity<CidadeDto> cadastroCidade(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
		
		return cidadeService.cadastrar(form, uriBuilder);
	}
	@GetMapping("/consultaCidade/{nome}/{estado}")
	public  ResponseEntity<Cidade> consultaCidade(@PathVariable("nome") String nome,@PathVariable("estado") String estado){
		return ResponseEntity.ok().body(cidadeRepository.findByNomeAndEstado(nome, estado));
	}
	
}
