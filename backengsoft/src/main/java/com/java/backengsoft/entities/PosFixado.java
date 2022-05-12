package com.java.backengsoft.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;


@Entity
public class PosFixado extends Investimento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String indiceAtrelado;
	private Double taxaMensal;
	
	
	public PosFixado(String nome, float valorIncial, LocalDate dataInicial, int tipoInvestimento,
			LocalDate prazominimoResgate, LocalDate prazomaximoResgate, LocalDate dataResgate, String rentabilidade,
			Usuario usuario, String indiceAtrelado, Double taxaMensal) {
		super(nome, valorIncial, dataInicial, tipoInvestimento, prazominimoResgate, prazomaximoResgate, dataResgate,
				rentabilidade, usuario);
		this.indiceAtrelado = indiceAtrelado;
		this.taxaMensal = taxaMensal;
		// TODO Auto-generated constructor stub
	}
	
	public PosFixado() {
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
