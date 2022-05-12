package com.java.backengsoft.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InformeRendimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private InformeRendimentoPK id = new InformeRendimentoPK();
	
	private String optionalMessage;
	
	private String nomeTributacao;
	
	private Double tributacao;
	
	public InformeRendimento() {
		
	}
	
	public InformeRendimento(Usuario usuario,Investimento investimento, String optionalMessage, String nomeTributacao, Double tributacao) {
		id.setUsuario(usuario);
		id.setInvestimento(investimento);
		this.optionalMessage = optionalMessage;
		this.nomeTributacao = nomeTributacao;
		this.tributacao = tributacao;
	}

	public Investimento getInvestimento() {
		return id.getInvestimento();
	}
	public void setInvestimento(Investimento investimento) {
		id.setInvestimento(investimento);
	}
	
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	public void setUsuario(Usuario usuario) {
		
	}
	public String getOptionalMessage() {
		return optionalMessage;
	}
	public void setOptionalMessage(String optionalMessage) {
		this.optionalMessage = optionalMessage;
	}
	public String getNomeTributacao() {
		return nomeTributacao;
	}
	public void setNomeTributacao(String nomeTributacao) {
		this.nomeTributacao = nomeTributacao;
	}
	public Double getTributacao() {
		return tributacao;
	}
	public void setTributacao(Double tributacao) {
		this.tributacao = tributacao;
	}
	

}
