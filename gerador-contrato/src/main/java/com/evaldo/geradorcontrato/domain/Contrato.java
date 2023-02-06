package com.evaldo.geradorcontrato.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="contrato")
public class Contrato   implements Serializable  {
	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_inicio")
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataInicio;


	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "val_mensl_pri_faixa_lucro")
	private BigDecimal valPriFaixaLucro;;
	
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "val_mensl_seg_faixa_lucro")
	private BigDecimal valSegFaixaLucro;

	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "	val_mensl_ter_faixa_lucro")
	private BigDecimal valTerFaixaLucro;
	

	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "val_final")
	private BigDecimal valFinal;
	
	@Column(name="valor_por_extenso")
	private String valorPorExtenso;
	
	@Column(name="qntd_lojas")
	private Integer qntdLojas;
	
	@ManyToOne
	@JoinColumn
	private Empresa contratada ;
	
	@ManyToOne
	@JoinColumn
	private Empresa contratante;
	
	@ManyToOne
	@JoinColumn(name="primeira_testemunha_id")
	private Pessoa primeiraTestemunha;
	
	
	@ManyToOne
	@JoinColumn(name="segunda_testemunha_id")
	private Pessoa segundaTestemunha;

	
	public Contrato(BigDecimal valPriFaixaLucro, BigDecimal valSegFaixaLucro, BigDecimal valTerFaixaLucro,
			BigDecimal valFinal, String valorPorExtenso, Integer qntdLojas, Empresa contratada, Empresa contratante,
			Pessoa primeiraTestemunha, Pessoa segundaTestemunha) {
		super();
		this.valPriFaixaLucro = valPriFaixaLucro;
		this.valSegFaixaLucro = valSegFaixaLucro;
		this.valTerFaixaLucro = valTerFaixaLucro;
		this.valFinal = valFinal;
		this.valorPorExtenso = valorPorExtenso;
		this.qntdLojas = qntdLojas;
		this.contratada = contratada;
		this.contratante = contratante;
		this.primeiraTestemunha = primeiraTestemunha;
		this.segundaTestemunha = segundaTestemunha;
	}
	public BigDecimal getValPriFaixaLucro() {
		return valPriFaixaLucro;
	}


	public void setValPriFaixaLucro(BigDecimal valPriFaixaLucro) {
		this.valPriFaixaLucro = valPriFaixaLucro;
	}


	public BigDecimal getValSegFaixaLucro() {
		return valSegFaixaLucro;
	}


	public void setValSegFaixaLucro(BigDecimal valSegFaixaLucro) {
		this.valSegFaixaLucro = valSegFaixaLucro;
	}


	public BigDecimal getValTerFaixaLucro() {
		return valTerFaixaLucro;
	}


	public void setValTerFaixaLucro(BigDecimal valTerFaixaLucro) {
		this.valTerFaixaLucro = valTerFaixaLucro;
	}


	public BigDecimal getValFinal() {
		return valFinal;
	}


	public void setValFinal(BigDecimal valFinal) {
		this.valFinal = valFinal;
	}


	public String getValorPorExtenso() {
		return valorPorExtenso;
	}


	public void setValorPorExtenso(String valorPorExtenso) {
		this.valorPorExtenso = valorPorExtenso;
	}


	public Integer getQntdLojas() {
		return qntdLojas;
	}


	public void setQntdLojas(Integer qntdLojas) {
		this.qntdLojas = qntdLojas;
	}


	public Empresa getContratada() {
		return contratada;
	}


	public void setContratada(Empresa contratada) {
		this.contratada = contratada;
	}


	public Empresa getContratante() {
		return contratante;
	}





	public void setContratante(Empresa contratante) {
		this.contratante = contratante;
	}


	public Pessoa getPrimeiraTestemunha() {
		return primeiraTestemunha;
	}


	public void setPrimeiraTestemunha(Pessoa primeiraTestemunha) {
		this.primeiraTestemunha = primeiraTestemunha;
	}


	public Pessoa getSegundaTestemunha() {
		return segundaTestemunha;
	}


	public void setSegundaTestemunha(Pessoa segundaTestemunha) {
		this.segundaTestemunha = segundaTestemunha;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

}
