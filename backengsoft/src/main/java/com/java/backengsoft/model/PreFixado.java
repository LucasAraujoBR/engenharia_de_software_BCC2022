package com.java.backengsoft.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PreFixado extends Investimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Double taxaRentabilidade;
	
	
	public Double getTaxaRendabilidade() {
		return taxaRentabilidade;
	}
	public void setTaxaRendabilidade(Double taxaRentabilidade) {
		this.taxaRentabilidade = taxaRentabilidade;
	}
	
}
