package com.evaldo.geradorcontrato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaldo.geradorcontrato.domain.Endereco;
import com.evaldo.geradorcontrato.dto.EnderecoDto;
import com.evaldo.geradorcontrato.repository.EnderecoRepository;
import com.evaldo.geradorcontrato.util.EnderecoCliente;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	

	@Autowired
	private EnderecoCliente enderecoCliente;
   
	@Transactional(readOnly=false)
	public void salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
		
	}

	public List<Endereco> findAll() {		
		return enderecoRepository.findAll();
	}
	
	public Endereco buscarPorId(Long id) {		
		return enderecoRepository.findById(id).get();
	}
	
	public ResponseEntity<EnderecoDto> buscarEnderecoPorCep(String cep){
		cep.replace(".","");
		cep.replace("-","");
		return enderecoCliente.buscarEnderecoPorCep(cep);
		
		
	}


}
