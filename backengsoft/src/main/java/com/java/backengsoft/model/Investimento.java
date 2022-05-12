package com.java.backengsoft.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Investimento 	implements Serializable {//investimento seria melhor definilo como abstrato?
		private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

 
    private String nome;

    private float valorIncial;

    private LocalDate dataInicial;

    private int tipoInvestimento;
    
    /*Adicinei aqui visto que todo investimento possui prazo minimo e máximo com uma data de resgate*/
    private LocalDate prazominimoResgate;
    
	private LocalDate prazomaximoResgate;
	
	private LocalDate dataResgate;
	
	private String rentabilidade;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "id.investimento")
	private Set<InformeRendimento> informesRendimento = new HashSet<>();
	

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorIncial() {
        return valorIncial;
    }

    public void setValorIncial(float valorIncial) {
        this.valorIncial = valorIncial;
    }

    public LocalDate getdataInicial() {
        return dataInicial;
    }

    public void setdataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public int getTipoDeInvestimentos() {
        return tipoInvestimento;
    }

    public void setTipoDeInvestimentos(int tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getPrazominimoResgate() {
		return prazominimoResgate;
	}

	public void setPrazominimoResgate(LocalDate prazominimoResgate) {
		this.prazominimoResgate = prazominimoResgate;
	}

	public LocalDate getPrazomaximoResgate() {
		return prazomaximoResgate;
	}

	public void setPrazomaximoResgate(LocalDate prazomaximoResgate) {
		this.prazomaximoResgate = prazomaximoResgate;
	}

	public LocalDate getdataResgate() {
		return dataResgate;
	}

	public void setdataResgate(LocalDate dataResgate) {
		this.dataResgate = dataResgate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(int tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public String getRentabilidade() {
		return rentabilidade;
	}

	public void setRentabilidade(String rentabilidade) {
		this.rentabilidade = rentabilidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<InformeRendimento> getInformesRendimento() {
		return informesRendimento;
	}


	public void aplicarValor() {
		
	}
	
	public void gerarRelatorio() {
		
	}
	
	public void calcularMontanteDeResgate() {
		
	}
	public void calcularRendimento() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", nome=" + nome + ", valorIncial=" + valorIncial + ", dataInicial="
				+ dataInicial + ", tipoInvestimento=" + tipoInvestimento + ", prazominimoResgate=" + prazominimoResgate
				+ ", prazomaximoResgate=" + prazomaximoResgate + ", dataResgate=" + dataResgate + ", usuario=" + usuario
				+ ", informesRendimento=" + informesRendimento + "]";
	}
	
}
