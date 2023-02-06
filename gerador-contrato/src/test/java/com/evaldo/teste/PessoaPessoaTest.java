package com.evaldo.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evaldo.geradorcontrato.Application;
import com.evaldo.geradorcontrato.domain.Pessoa;
import com.evaldo.geradorcontrato.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class PessoaPessoaTest {

	@Autowired
	private PessoaService service;

	String cpf = "CPF_test";

	@Test
	public void inserirPessoa() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fulano teste");
		pessoa.setCpf(cpf);
		if (!service.buscarPorCpf(cpf).isPresent())
			service.salvar(pessoa);
		assertEquals(false, service.findAll().isEmpty());

	}

	@Test
	public void buscarPessoaPorCpf() {
		assertEquals(true, service.buscarPorCpf(cpf).isPresent());
	}

}
