package com.java.backengsoft.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private int numero;
	private int CEP;
	private String referencia;
	private String Cidade;
	
	@JsonIgnore
    @OneToOne
	private Usuario usuario;
	
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
