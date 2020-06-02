package com.compasso.test.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.test.entidades.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{


	Cidade findByNomeAndEstado(String nome, String estado);
	Cidade findByIdCidade(Long idCidade);
	
	
	
	
}
