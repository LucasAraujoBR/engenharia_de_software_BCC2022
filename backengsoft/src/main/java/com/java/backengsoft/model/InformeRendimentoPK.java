package com.java.backengsoft.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InformeRendimentoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "investimento_id", nullable = false)
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
	
	@Override
	public int hashCode() {
		return Objects.hash(investimento, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		InformeRendimentoPK other = (InformeRendimentoPK) obj;
		return Objects.equals(investimento, other.investimento) && Objects.equals(usuario, other.usuario);
	}
	

}
