package com.evaldo.geradorcontrato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaldo.geradorcontrato.domain.Empresa;



public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Optional<Empresa> findByCnpj(String cnpj);

	

}