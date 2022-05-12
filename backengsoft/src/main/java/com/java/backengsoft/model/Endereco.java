package com.java.backengsoft.model;

import javax.persistence.Entity;

@Entity
public class Endereco {
	private int id;
	private String rua;
	private int numero;
	private int CEP;
	private String referencia;
	private String Cidade;
	
	
	public Endereco(String rua, int numero, int CEP, String referencia, String cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.CEP = CEP;
		this.referencia = referencia;
		Cidade = cidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	
	
	
}
