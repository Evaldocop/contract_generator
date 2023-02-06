package com.evaldo.teste;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.annotations.UpdateTimestamp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evaldo.geradorcontrato.Application;
import com.evaldo.geradorcontrato.domain.Contrato;
import com.evaldo.geradorcontrato.repository.EmpresaRepository;
import com.evaldo.geradorcontrato.repository.EnderecoRepository;
import com.evaldo.geradorcontrato.repository.PessoaRepository;
import com.evaldo.geradorcontrato.service.ContratoService;
import com.evaldo.geradorcontrato.util.ParameterMap;
import com.evaldo.geradorcontrato.util.TratamentoArquivo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TratamentoLinhasArquivoTest {

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
    
    @Autowired
    private ParameterMap map;

	@Test
	public void editTest() {
		

		Contrato contrato=new Contrato();
		contrato.setContratada(empresaRepository.findById(19L).get());
		contrato.setContratante(empresaRepository.findById(20L).get());
		contrato.setPrimeiraTestemunha(pesoaRepository.findById(8L).get());
		contrato.setSegundaTestemunha(pesoaRepository.findById(9L).get());
		contrato.setQntdLojas(100);
		contrato.setValFinal(new BigDecimal(100));
		contrato.setValPriFaixaLucro(new BigDecimal(100));
		contrato.setValSegFaixaLucro(new BigDecimal(100));
		contrato.setValTerFaixaLucro(new BigDecimal(100));
		contrato.setValorPorExtenso("Cem reais");
		
		contrato.setId(10000L);
		Map<String, String> parametros = map.carrregaParametros(contrato);
		String teste1="{CONTRATADA_RAZAO";
	    
		tratamentoArquivo.editarLinha(parametros,teste1,true);
		
	}
}
