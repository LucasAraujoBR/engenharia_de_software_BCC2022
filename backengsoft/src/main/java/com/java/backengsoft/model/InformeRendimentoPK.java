package com.java.backengsoft.model;

import javax.persistence.Embeddable;

@Embeddable
public class InformeRendimentoPK {

	private Usuario usuario;
	private Investimento investimento;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Investimento getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	
	public void ExibirRendimentoInsento() {
		
	}
	public void ExibirTributacao() {
		
	}
	

}
