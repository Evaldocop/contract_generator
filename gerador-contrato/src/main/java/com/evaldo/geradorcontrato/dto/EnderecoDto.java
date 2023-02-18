package com.evaldo.geradorcontrato.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
	private String cep;
	private String logradouro;
	private String bairro;
	private String complemento;
	private String localidade;
	private String uf;
	private String ddd;
	
	


}