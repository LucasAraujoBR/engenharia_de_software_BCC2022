package com.java.backengsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Table(name= "usuario")
@Entity
public class Usuario {

    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String numeroDeTelefone;
    @Column
    private String email;
    @Column
    private String valorTotalInvestido;
    // Tem que fazer uma tabela para investimentosList
    private List<Investimento> investimentoList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValorTotalInvestido() {
        return valorTotalInvestido;
    }

    public void setValorTotalInvestido(String valorTotalInvestido) {
        this.valorTotalInvestido = valorTotalInvestido;
    }

    public List<Investimento> getInvestimentoList() {
        return investimentoList;
    }

    public void setInvestimentoList(List<Investimento> investimentoList) {
        this.investimentoList = investimentoList;
    }
}


