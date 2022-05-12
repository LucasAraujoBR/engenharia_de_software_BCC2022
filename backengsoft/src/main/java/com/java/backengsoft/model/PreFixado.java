package com.java.backengsoft.model;

import javax.persistence.Entity;

@Entity
public class PreFixado extends Investimento {
	
	private int id;
	private Double taxaRendabilidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getTaxaRendabilidade() {
		return taxaRendabilidade;
	}
	public void setTaxaRendabilidade(Double taxaRendabilidade) {
		this.taxaRendabilidade = taxaRendabilidade;
	}
	
}
