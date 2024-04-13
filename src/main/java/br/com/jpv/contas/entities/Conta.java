package br.com.jpv.contas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String banco;
	private String nome;
	private Double saldo;
	private Double limite;
	
	
	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
	private List<Transacao> extrato = new ArrayList<>();
	
		
	public Conta() {};
	
	public Conta(Long id, String banco, String nome, Double saldo, Double limite) {
		super();
		this.id = id;
		this.banco = banco;
		this.nome = nome;
		this.saldo = saldo;
		this.limite = limite;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Transacao> getExtrato() {
		return extrato;
	}

	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	public void inserirDespesa(Despesa desp) {
			desp.setConta(this);
			setSaldo(this.saldo - desp.getValor());
			getExtrato().add(desp);
	
	}
	
	public void inserirReceita(Receita receita) {
		receita.setConta(this);
		setSaldo(this.saldo + receita.getValor());
		getExtrato().add(receita);
	}
	
}
