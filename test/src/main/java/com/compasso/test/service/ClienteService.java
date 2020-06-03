package com.compasso.test.service;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.test.controller.dto.ClienteDto;
import com.compasso.test.controller.form.AtualizacaoClienteForm;
import com.compasso.test.controller.form.ClienteForm;
import com.compasso.test.entidades.Cliente;
import com.compasso.test.repository.CidadeRepository;
import com.compasso.test.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository =clienteRepository;
	}

	public ResponseEntity<ClienteDto> cadastrar(@Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter(cidadeRepository);
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/cadastrar/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	public ResponseEntity<Object> remover(Long id) {
		Optional<Cliente> optinal = clienteRepository.findById(id);
		
		if(optinal.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<ClienteDto> atualizarNomeCliente(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form){
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();		
	}

}
