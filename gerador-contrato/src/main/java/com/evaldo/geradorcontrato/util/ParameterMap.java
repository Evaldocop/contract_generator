package com.evaldo.geradorcontrato.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.evaldo.geradorcontrato.domain.Contrato;
@Component
public class ParameterMap {
	
	public Map<String, String> carrregaParametros(Contrato contrato) {
		
	   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("{{numero_contrato}}", contrato.getId().toString());
		parametros.put("{{CEP_CONTRATADA}}", contrato.getContratada().getEndereco().getCep());
		parametros.put("{{CEP_CONTRATANTE}}", contrato.getContratante().getEndereco().getCep());
		parametros.put("{{CIDADE_CONTRATADA}}", contrato.getContratada().getEndereco().getCidade());
		parametros.put("{{CIDADE_CONTRATANTE}}", contrato.getContratante().getEndereco().getCidade());
		parametros.put("{{CNPJ_CONTRATADA}}", contrato.getContratada().getCnpj());
		parametros.put("{{CNPJ_CONTRATANTE}}", contrato.getContratante().getCnpj());
		parametros.put("{{CONTRATADA_RAZAO_SOCIAL}}", contrato.getContratada().getRazaoSocial());
		parametros.put("{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATADA}}",
				contrato.getContratada().getEndereco().getLogradouro() + ", "
						+ contrato.getContratada().getEndereco().getNumero());

		parametros.put("{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATANTE}}",
				contrato.getContratante().getEndereco().getLogradouro() + ", "
						+ contrato.getContratante().getEndereco().getNumero());
		parametros.put("{{ESTADO_CONTRATADA}}", contrato.getContratada().getEndereco().getUf());
		parametros.put("{{ESTADO_CONTRATANTE}}", contrato.getContratante().getEndereco().getUf());
		parametros.put("{{NOME_FANTASIA_CONTRATADA}}", contrato.getContratada().getNomeFantasia());
		parametros.put("{{NOME_FANTASIA_CONTRATANTE}}", contrato.getContratante().getNomeFantasia());
		parametros.put("{{RAZAO_SOCIAL_CONTRATANTE}}", contrato.getContratante().getRazaoSocial());
		parametros.put("{{CONTRATANTE_RAZAO_SOCIAL}}", contrato.getContratante().getRazaoSocial());
		parametros.put("{{valor1}}", contrato.getValPriFaixaLucro().toString());
		parametros.put("{{valor2}}", contrato.getValSegFaixaLucro().toString());
		parametros.put("{{valor3}", contrato.getValTerFaixaLucro().toString());
		parametros.put("{{valor_final}}", contrato.getValFinal().toString());
		parametros.put("{{qtde_lojas}}", contrato.getQntdLojas().toString());
		parametros.put("{{valor_por_extenso}}", contrato.getValorPorExtenso());
		
		parametros.put("{{data_inicio_contrato}}", format.format(contrato.getDataInicio()));
		parametros.put("{{NOME_TESTEMUNHA1}}", contrato.getPrimeiraTestemunha().getNome());
		parametros.put("{{CPF_TESTEMUNHA1}}", contrato.getPrimeiraTestemunha().getCpf());parametros.put("{{CPF_TESTEMUNHA2}}", contrato.getPrimeiraTestemunha().getCpf());
		parametros.put("{{CPF_TESTEMUNHA2}}", contrato.getSegundaTestemunha().getCpf());
		parametros.put("{{NOME_TESTEMUNHA2}}", contrato.getSegundaTestemunha().getNome());
		
		
		
		parametros.put("{CONTRATADA_RAZAO", "{CONTRATADA_RAZAO");
		


		
		/*parametros.put("{_SOCIAL}}", "NAO LOCALIZADO");
		parametros.put("{_SOCIAL}}novo texto (PLATAFORMA COMO SERVIÇO) -Número do novo texto : numero_contrato}}", "NAO LOCALIZADO");
		parametros.put("{{CONTRATADA_RAZAOSOCIAL}novo texto (PLATAFORMA COMO SERVIÇO) -Número do novo texto : numero_contrato}}", "NAO LOCALIZADO");*/
		
		return parametros;
	}

}
