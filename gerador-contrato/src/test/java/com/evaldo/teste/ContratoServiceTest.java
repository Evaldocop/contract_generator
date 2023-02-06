package com.evaldo.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evaldo.geradorcontrato.Application;
import com.evaldo.geradorcontrato.domain.Contrato;
import com.evaldo.geradorcontrato.domain.Empresa;
import com.evaldo.geradorcontrato.domain.Endereco;
import com.evaldo.geradorcontrato.domain.Pessoa;
import com.evaldo.geradorcontrato.service.ContratoService;
import com.evaldo.geradorcontrato.service.EmpresaService;
import com.evaldo.geradorcontrato.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ContratoServiceTest {

	@Autowired
	private ContratoService service;

	@Autowired
	private EmpresaService serviceEmpresa;

	@Autowired
	private PessoaService pessoaService;

	private Long idContrato = 1L;
	private String cnpjNovo = "cnpjNovo";
	private String cnpjExistente = "cnpj2";
	private String cpfNovo = "cpfNovo";
	private String cpfExistente = "CPF_test";

	@Test
	public void inserirContrato() {
		Contrato contrato;

		// atributos primitivo
		BigDecimal valPriFaixaLucro = BigDecimal.valueOf(10.00);
		BigDecimal valSegFaixaLucro = BigDecimal.valueOf(10.00);
		BigDecimal valTerFaixaLucro = BigDecimal.valueOf(10.00);
		BigDecimal valFinal = BigDecimal.valueOf(100000.00);
		Integer qntdLojas = 100;
		String valorPorExtenso = "Cem mil reais";
		Endereco endereco = new Endereco("Rua das Flores", "Salvador", "Ba", "04-f", "41297310");
		// empresas
		Empresa contratada =serviceEmpresa.buscarPorCnpj(cnpjExistente).orElse(null);
		Empresa contratante=serviceEmpresa.buscarPorCnpj(cnpjNovo).orElse(null);
		
		Pessoa primeiraTestemunha =pessoaService.buscarPorCpf(cpfExistente).orElse(null);
		Pessoa segundaTestemunha =pessoaService.buscarPorCpf(cpfNovo).orElse(null) ;;

		if (!serviceEmpresa.buscarPorCnpj(contratada.getCnpj()).isPresent()) {
			Empresa empresaNova = preencherDadosEmpresaNova("FABRICA SOFTWARE LTDA ", "FSOFTWARE", contratada.getCnpj(),
					endereco);
			serviceEmpresa.salvar(empresaNova);
			contratada = serviceEmpresa.buscarPorCnpj(empresaNova.getCnpj()).get();
		}
		
		if (!serviceEmpresa.buscarPorCnpj(contratante.getCnpj()).isPresent()) {
			Empresa empresaNova = preencherDadosEmpresaNova("FABRICA SOFTWARE LTDA ", "FSOFTWARE",
					contratante.getCnpj(), endereco);
			serviceEmpresa.salvar(empresaNova);
			contratante = serviceEmpresa.buscarPorCnpj(empresaNova.getCnpj()).get();
		}

		if (!pessoaService.buscarPorCpf(primeiraTestemunha.getCpf()).isPresent()) {
			pessoaService.salvar(primeiraTestemunha);
			primeiraTestemunha = pessoaService.buscarPorCpf(primeiraTestemunha.getCpf()).get();
		
		}

		if (!pessoaService.buscarPorCpf(segundaTestemunha.getCpf()).isPresent()) {
			pessoaService.salvar(segundaTestemunha);
			segundaTestemunha = pessoaService.buscarPorCpf(segundaTestemunha.getCpf()).get();
		}

		contrato = new Contrato(valPriFaixaLucro, valSegFaixaLucro, valTerFaixaLucro, valFinal, valorPorExtenso,
				qntdLojas, contratada, contratante, primeiraTestemunha, segundaTestemunha);
		
		service.salvar(contrato);

		assertEquals(true, service.obterPorId(contrato.getId()).isPresent());
	}

	@Test
	public void buscarEmpresaPorCnpj() {
		String cnpj = "cnpj2";
		assertEquals(true, serviceEmpresa.buscarPorCnpj(cnpj).isPresent());
	}

	public Empresa preencherDadosEmpresaNova(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco) {
		return new Empresa(razaoSocial, nomeFantasia, cnpj, endereco);
	}

	

}
