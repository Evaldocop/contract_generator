package com.evaldo.geradorcontrato.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.evaldo.geradorcontrato.dto.EnderecoDto;

@Component
public class EnderecoCliente {
	 
    //@Autowired
    private RestTemplate restTemplate = new RestTemplate(); 
    private final String url = "http://viacep.com.br/ws/{cep}/json/";     
    public ResponseEntity<EnderecoDto> buscarEnderecoPorCep(String cep){ 
    	cep=cep.replace(".", "");
    	cep=cep.replace("-", "");
    	Map<String,String> param=new HashMap<String,String>();
    	param.put("cep",cep);
        return restTemplate.getForEntity(url, EnderecoDto.class,param);
    }
}
