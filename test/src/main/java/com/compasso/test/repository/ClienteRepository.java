package com.compasso.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.test.entidades.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByNome(String nome);
}
