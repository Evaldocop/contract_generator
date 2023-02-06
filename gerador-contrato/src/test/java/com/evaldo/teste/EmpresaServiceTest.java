package com.evaldo.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evaldo.geradorcontrato.Application;
import com.evaldo.geradorcontrato.domain.Empresa;
import com.evaldo.geradorcontrato.domain.Endereco;
import com.evaldo.geradorcontrato.service.EmpresaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class EmpresaServiceTest {

	@Autowired
	private EmpresaService service;

	@Test
	public void inserirEndereco() {

		String cnpj = "cnpj2";
		Endereco endereco = new Endereco();
		endereco.setCep("41297310");
		endereco.setCidade("Salvador");
		endereco.setLogradouro("Rua das Flores");
		endereco.setNumero("04-F");
		endereco.setUf("Ba");
		Empresa empresa = new Empresa("razaoSocial", "nomeFantasia", cnpj, endereco);
		if (!service.buscarPorCnpj(cnpj).isPresent())
			service.salvar(empresa);
		assertEquals(false, service.findAll().isEmpty());
	}

	@Test
	public void buscarEmpresaPorCnpj() {
		String cnpj = "cnpj2";
		assertEquals(true, service.buscarPorCnpj(cnpj).isPresent());
	}

}
