package com.evaldo.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evaldo.geradorcontrato.Application;
import com.evaldo.geradorcontrato.domain.Contrato;
import com.evaldo.geradorcontrato.domain.Pessoa;
import com.evaldo.geradorcontrato.repository.EmpresaRepository;
import com.evaldo.geradorcontrato.repository.EnderecoRepository;
import com.evaldo.geradorcontrato.repository.PessoaRepository;
import com.evaldo.geradorcontrato.service.ContratoService;
import com.evaldo.geradorcontrato.service.PessoaService;
import com.evaldo.geradorcontrato.util.TratamentoArquivo;
import com.sun.star.bridge.oleautomation.Decimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TratamentoArquivoTest {

	@Autowired
	private TratamentoArquivo tratamentoArquivo;
	
	@Autowired
	private PessoaRepository pesoaRepository;
	
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContratoService service;

	@Test
	public void editTest() {
		
		Contrato contrato=new Contrato();
		contrato.setContratada(empresaRepository.findById(1L).get());
		contrato.setContratante(empresaRepository.findById(2L).get());
		contrato.setPrimeiraTestemunha(pesoaRepository.findById(1L).get());
		contrato.setSegundaTestemunha(pesoaRepository.findById(2L).get());
		contrato.setQntdLojas(100);
		contrato.setValFinal(new BigDecimal(100));
		contrato.setValPriFaixaLucro(new BigDecimal(100));
		contrato.setValSegFaixaLucro(new BigDecimal(100));
		contrato.setValTerFaixaLucro(new BigDecimal(100));
		contrato.setValorPorExtenso("Cem reais");
		contrato.setDataInicio(new Date());
		service.salvar(contrato);
		tratamentoArquivo.editarArquivo(contrato);
		
	}
}
