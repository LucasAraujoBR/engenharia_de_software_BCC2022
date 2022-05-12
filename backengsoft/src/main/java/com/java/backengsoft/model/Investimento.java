package com.java.backengsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "investimento")
@Entity
public class Investimento {//investimento seria melhor definilo como abstrato?
	

    @Column
    private String nome;
    @Column
    private float valorIncial;
    @Column
    private LocalDate dataInicial;
    @Column
    private int tipoDeInvestimentos;
    
    /*Adicinei aqui visto que todo investimento possui prazo minimo e máximo com uma data de resgate*/
    private LocalDate prazominimoResgate;
    
	private LocalDate prazomaximoResgate;
	
	private LocalDate DataResgate;
	
	
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
        return tipoDeInvestimentos;
    }

    public void setTipoDeInvestimentos(int tipoDeInvestimentos) {
        this.tipoDeInvestimentos = tipoDeInvestimentos;
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

	public LocalDate getDataResgate() {
		return DataResgate;
	}

	public void setDataResgate(LocalDate dataResgate) {
		DataResgate = dataResgate;
	}
	
	public void aplicarValor() {
		
	}
	
	public void gerarRelatorio() {
		
	}
	
	public void calcularMontanteDeResgate() {
		
	}
	public void calcularRendimento() {
		
	}
}
