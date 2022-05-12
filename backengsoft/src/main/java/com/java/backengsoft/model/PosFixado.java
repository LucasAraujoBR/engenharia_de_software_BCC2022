package com.java.backengsoft.model;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class PosFixado extends Investimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private String indiceAtrelado;
	private Double taxaMensal;
	
	
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
