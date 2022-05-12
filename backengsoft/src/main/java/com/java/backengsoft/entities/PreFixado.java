package com.java.backengsoft.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PreFixado extends Investimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Double taxaRentabilidade;
	
	
	public PreFixado(String nome, float valorIncial, LocalDate dataInicial, int tipoInvestimento,
			LocalDate prazominimoResgate, LocalDate prazomaximoResgate, LocalDate dataResgate, String rentabilidade,
			Usuario usuario, Double taxaRentabilidade) {
		super(nome, valorIncial, dataInicial, tipoInvestimento, prazominimoResgate, prazomaximoResgate, dataResgate,
				rentabilidade, usuario);
		this.taxaRentabilidade = taxaRentabilidade;
	}
	
	public PreFixado() {
	
	}

	public Double getTaxaRendabilidade() {
		return taxaRentabilidade;
	}
	public void setTaxaRendabilidade(Double taxaRentabilidade) {
		this.taxaRentabilidade = taxaRentabilidade;
	}
	
}
