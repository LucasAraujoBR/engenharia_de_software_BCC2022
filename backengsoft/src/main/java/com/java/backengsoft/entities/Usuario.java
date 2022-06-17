package com.java.backengsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    private String nome;
    
    @Column(unique = true)
    private String cpf;

    private String numeroDeTelefone;
    
    @Column(unique = true)
    private String email;
    
    private Double valorTotalInvestido;
        
    @OneToMany(mappedBy="usuario")
    private List<Investimento> investimentos = new ArrayList<>();
    
    @OneToOne
    private Endereco endereco;
    
    @OneToMany(mappedBy = "id.usuario")
	private Set<InformeRendimento> informesRendimento = new HashSet<>();
   

	public Usuario(String nome, String cpf, String numeroDeTelefone, String email, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.numeroDeTelefone = numeroDeTelefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Usuario() {
	
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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

    public Double getValorTotalInvestido() {
        return valorTotalInvestido;
    }

    public void setValorTotalInvestido(Double valorTotalInvestido) {
        this.valorTotalInvestido = valorTotalInvestido;
    }
    public void addValorTotalInvestido(Double valorTotalInvestido) {
    	this.valorTotalInvestido += valorTotalInvestido;
    }

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}
	public void addInvestimento(Investimento investimento) {
		this.investimentos.add(investimento);
	}

	public boolean removerInvestimento(Investimento investimento) {
		for(Investimento obj : investimentos) {
			if(investimento.equals(obj)) {
				this.investimentos.remove(investimento);
				return true;
			}
	     }
		return false;
	}

	public Set<InformeRendimento> getInformesRendimento() {
		return informesRendimento;
	}

	public void addInformesRendimento(InformeRendimento informesRendimento) {
		this.informesRendimento.add(informesRendimento);
	}
	public boolean removeInformeRendimento(InformeRendimento informeRendimento) {
		for(InformeRendimento obj : informesRendimento) {
			if(informeRendimento.equals(obj)) {
				this.informesRendimento.remove(informeRendimento);
				return true;
			}
	     }
		return false;
		
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
		Usuario other = (Usuario) obj;
		return id == other.id;
	}
	
	
}


