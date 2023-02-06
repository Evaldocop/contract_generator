package com.evaldo.geradorcontrato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaldo.geradorcontrato.domain.Contrato;



public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	

}