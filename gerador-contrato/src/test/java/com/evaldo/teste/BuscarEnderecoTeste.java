package com.evaldo.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evaldo.geradorcontrato.Application;
import com.evaldo.geradorcontrato.dto.EnderecoDto;
import com.evaldo.geradorcontrato.util.EnderecoCliente;

import lombok.extern.java.Log;
@Log
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
public class BuscarEnderecoTeste {
	@Autowired
	private EnderecoCliente  enderecoCliente;
	
	@Test
	public void enderecoTest(){
		
		
		ResponseEntity<EnderecoDto> endereco=  enderecoCliente.buscarEnderecoPorCep("41297310");
		assertEquals("41297-310",endereco.getBody().getCep() );
		
		log.info("Logradouro: "+ endereco.getBody().getLogradouro());
		
	}

}
