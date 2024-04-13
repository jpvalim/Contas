package br.com.jpv.contas.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fatura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer mes;
	private LocalDate vencimentFatura;
	
	@JsonIgnore
	@ManyToOne
	private CartaoCredito cartao;
	
	
	@OneToMany(mappedBy = "fatura", cascade = CascadeType.ALL)
	private List<Transacao> despesas = new ArrayList<>();
	
	public Fatura() {}

	public Fatura(Long id, Integer mes, LocalDate vencimentoFatura, CartaoCredito cartao) {
		super();
		this.id = id;
		this.mes = mes;
		this.cartao = cartao;
		this.vencimentFatura = vencimentoFatura;
		cartao.getFatura().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}

	public List<Transacao> getDespesas() {
		return despesas;
	}
	
	public LocalDate getVencimentFatura() {
		return vencimentFatura;
	}

	public void setVencimentFatura(LocalDate vencimentFatura) {
		this.vencimentFatura = vencimentFatura;
	}

	public void inserirDespesa(Despesa despesa) {
		despesa.setFatura(this);
		this.despesas.add(despesa);
	}
	
	
}
