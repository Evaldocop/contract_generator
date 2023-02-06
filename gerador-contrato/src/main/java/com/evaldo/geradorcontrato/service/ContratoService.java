package com.evaldo.geradorcontrato.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaldo.geradorcontrato.domain.Contrato;
import com.evaldo.geradorcontrato.repository.ContratoRepository;
import com.evaldo.geradorcontrato.util.TratamentoArquivo;



@Service
public class ContratoService  {
	
	@Autowired
	private ContratoRepository contratoRepository;
	@Autowired
	private TratamentoArquivo tratamentoArquivo;

	@Transactional
	public void salvar(Contrato contrato) {
		contratoRepository.save(contrato);
		contratoRepository.findAll();
		tratamentoArquivo.editarArquivo(contratoRepository.findAll().get(0));
		
	}

	public Optional<Contrato> obterPorId(Long id) {
		// TODO Auto-generated method stub
		return contratoRepository.findById(id);
	}

}
