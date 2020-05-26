package com.compasso.test.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.test.modelo.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{


	Cidade findByNomeCidade(String nome, String estado);
	Cidade findByCidade(Long id);
	
	
	
	
}
