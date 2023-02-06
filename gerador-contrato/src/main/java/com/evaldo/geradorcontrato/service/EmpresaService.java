package com.evaldo.geradorcontrato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaldo.geradorcontrato.domain.Empresa;
import com.evaldo.geradorcontrato.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return empresaRepository.findAll();
	}
	
	public void salvar( Empresa empresa) {
		 empresaRepository.save(empresa);
		
	}

	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		return empresaRepository.findByCnpj(cnpj);
	}

}
