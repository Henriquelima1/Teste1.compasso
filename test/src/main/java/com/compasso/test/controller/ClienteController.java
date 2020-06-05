package com.compasso.test.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import com.compasso.test.entidades.Cliente;
import com.compasso.test.repository.CidadeRepository;
import com.compasso.test.repository.ClienteRepository;
import com.compasso.test.service.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	private ClienteService clienteService;

	@PostMapping("/cadastroCliente")
	@Transactional
	public ResponseEntity<ClienteDto> cadastroCliente(@RequestBody @Valid ClienteForm form,
			UriComponentsBuilder uriBuilder) {

		return clienteService.cadastrar(form, uriBuilder);

	}
	
	@GetMapping("/consultaCliente/consultarNome/{nome}")
	public ResponseEntity<Cliente> consultaNome(@Param(value = "nome") String nome ) {
		return ResponseEntity.ok().body(clienteRepository.findByNome(nome));
	}

	@GetMapping("/consultaCliente/{id}")
	public ResponseEntity<Cliente> consultaId(@PathVariable Long id) {
		return ResponseEntity.ok().body(clienteRepository.findById(id).get());
	}

	@DeleteMapping("/removerCliente/{id}")
	@Transactional
	public ResponseEntity<?> removerCliente(@PathVariable Long id) {
		return clienteService.remover(id);
	}

	@PutMapping("/atualizarNomeCliente/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarNomeCliente(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoClienteForm form) {
		return clienteService.atualizarNomeCliente(id, form);
	}

}
