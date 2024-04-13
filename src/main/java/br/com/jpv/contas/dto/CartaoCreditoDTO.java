package br.com.jpv.contas.dto;

import java.time.LocalDate;

import br.com.jpv.contas.entities.CartaoCredito;

public class CartaoCreditoDTO {
	
	private Long id;
	private Double limite;
	private String descricao;
	private String nome;
	private LocalDate fechamentoCartao;
	private LocalDate vencimentoCartao;
	private int prazoFechamentoCartao;
		
	
	public CartaoCreditoDTO() {}

	public CartaoCreditoDTO(Long id, Double limite, String descricao, String nome, LocalDate fechamentoCartao, LocalDate vencimentoCartao, int prazoFechamentoCartao) {
		super();
		this.id = id;
		this.limite = limite;
		this.descricao = descricao;
		this.nome = nome;
		this.fechamentoCartao = fechamentoCartao;
		this.vencimentoCartao = vencimentoCartao;
		this.prazoFechamentoCartao = prazoFechamentoCartao;
	}

	public CartaoCreditoDTO(CartaoCredito obj) {
		this.id = obj.getId();
		this.limite = obj.getLimite();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getFechamentoCartao() {
		return fechamentoCartao;
	}

	public void setFechamentoCartao(LocalDate fechamentoCartao) {
		this.fechamentoCartao = fechamentoCartao;
	}

	public LocalDate getVencimentoCartao() {
		return vencimentoCartao;
	}

	public void setVencimentoCartao(LocalDate vencimentoCartao) {
		this.vencimentoCartao = vencimentoCartao;
	}

	public int getPrazoFechamentoCartao() {
		return prazoFechamentoCartao;
	}

	public void setPrazoFechamentoCartao(int prazoFechamentoCartao) {
		this.prazoFechamentoCartao = prazoFechamentoCartao;
	}

	
	
	
}
