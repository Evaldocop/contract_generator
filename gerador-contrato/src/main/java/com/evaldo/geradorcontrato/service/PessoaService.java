package com.evaldo.geradorcontrato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaldo.geradorcontrato.domain.Pessoa;
import com.evaldo.geradorcontrato.repository.PessoaRepository;



@Service
public class PessoaService {
     @Autowired
     private PessoaRepository pessoaRepository;
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		
	}
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return pessoaRepository.findAll();
	}
	public Optional<Pessoa> buscarPorCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);
	}
	

}
