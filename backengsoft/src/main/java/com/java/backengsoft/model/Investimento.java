package com.java.backengsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "investimento")
@Entity
public class Investimento {
    @Column
    private String nome;
    @Column
    private float valorIncial;
    @Column
    private LocalDate dataInicias;
    @Column
    private int tipoDeInvestimentos;

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

    public LocalDate getDataInicias() {
        return dataInicias;
    }

    public void setDataInicias(LocalDate dataInicias) {
        this.dataInicias = dataInicias;
    }

    public int getTipoDeInvestimentos() {
        return tipoDeInvestimentos;
    }

    public void setTipoDeInvestimentos(int tipoDeInvestimentos) {
        this.tipoDeInvestimentos = tipoDeInvestimentos;
    }
}
