package com.compasso.test.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.test.controller.dto.ClienteDto;
import com.compasso.test.controller.form.AtualizacaoClienteForm;
import com.compasso.test.controller.form.ClienteForm;
import com.compasso.test.modelo.Cliente;
import com.compasso.test.repository.CidadeRepository;
import com.compasso.test.repository.ClienteRepository;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	
	@PostMapping("/cadastroCliente")
	@Transactional
	public ResponseEntity<ClienteDto> cadastroCliente( @RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
		Cliente cliente = form.converter(cidadeRepository);
		
		URI uri = uriBuilder.path("/cadastrar/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
		
	}
	
	@GetMapping("/consultaCliente/{nome}")
	public  ResponseEntity<Cliente> consultaNome(@PathVariable String nome){
		return ResponseEntity.ok().body(clienteRepository.findByNome(nome));
	}
	@GetMapping("/consultaCliente/{id}")
	public  ResponseEntity<Cliente> consultaId(@PathVariable Long id){
		return ResponseEntity.ok().body(clienteRepository.findById(id).get());
	}
	@DeleteMapping("/removerCliente/{id}")
	@Transactional
	public ResponseEntity<?> removerCliente(@PathVariable Long id){
		Optional<Cliente> optinal = clienteRepository.findById(id);
		
		if(optinal.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/atualizarNomeCliente/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarNomeCliente(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form){
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();		
	}
	
	

	

}
