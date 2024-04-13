package br.com.jpv.contas.dto;

import br.com.jpv.contas.entities.Conta;

public class ContaDTO {
	
	private Long id;
	private String banco;
	private String nome;
	private Double saldo;
	private Double limite;
	
	public ContaDTO() {}

	public ContaDTO(Long id, String banco, String nome, Double saldo, Double limite) {
		
		this.id = id;
		this.banco = banco;
		this.nome = nome;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	public ContaDTO(Conta obj) {
		this.id = obj.getId();
		this.banco = obj.getBanco();
		this.nome = obj.getNome();
		this.saldo = obj.getSaldo();
		this.limite = obj.getLimite();
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

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	
}
