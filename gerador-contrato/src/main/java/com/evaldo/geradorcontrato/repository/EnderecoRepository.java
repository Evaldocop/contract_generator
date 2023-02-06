package com.evaldo.geradorcontrato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaldo.geradorcontrato.domain.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	

}