package com.java.backengsoft.model;

import javax.persistence.Entity;

@Entity
public class PosFixado extends Investimento{
	
	private int id;
	private String indiceAtrelado;
	private Double taxaMensal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIndiceAtrelado() {
		return indiceAtrelado;
	}
	public void setIndiceAtrelado(String indiceAtrelado) {
		this.indiceAtrelado = indiceAtrelado;
	}
	public Double getTaxaMensal() {
		return taxaMensal;
	}
	public void setTaxaMensal(Double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}

	
}
