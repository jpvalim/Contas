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
import javax.persistence.OneToMany;

@Entity
public class CartaoCredito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double limite;
	private String descricao;
	private String nome;
	private LocalDate fechamentoCartao;
	private LocalDate vencimentoCartao;
	private int prazoFechamentoCartao;
	
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Fatura> faturas = new ArrayList<>();
		
	public CartaoCredito() {}

	public CartaoCredito(Long id, Double limite, String descricao, String nome, LocalDate fechamentoCartao, LocalDate vencimentoCartao, int prazoFechamentoCartao) {
		super();
		this.id = id;
		this.limite = limite;
		this.descricao = descricao;
		this.nome = nome;
		this.fechamentoCartao = fechamentoCartao;
		this.vencimentoCartao = vencimentoCartao;
		this.prazoFechamentoCartao = prazoFechamentoCartao;
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

	public List<Fatura> getFatura() {
		return faturas;
	}

	public void incluirDespesaCartao(Despesa despesa) {
				
		for (Fatura f : faturas) {
			if(despesa.getData().isAfter(f.getVencimentFatura().plusDays(prazoFechamentoCartao))) {
				this.fecharFatura();
				break;
			}
			else {
				f.inserirDespesa(despesa);
				return;
			}
		}
			
		if (this.faturas.isEmpty()) {
			Fatura fatura = new Fatura(null, this.fechamentoCartao.getMonthValue(), this.vencimentoCartao, this);
			fatura.inserirDespesa(despesa);
			this.faturas.add(fatura);
		}
		else {
			int mesFaturaNova = faturas.get(faturas.size() - 1).getMes();
			mesFaturaNova += 1;
			Fatura fatura = new Fatura(null, mesFaturaNova, this.vencimentoCartao, this);
			fatura.inserirDespesa(despesa);
			this.faturas.add(fatura);
		}
	
	}
	
	public double faturaCartao(int mes) {
		double soma = 0;
		for (Fatura fatura : faturas) {
			if(mes == fatura.getMes()) {
				for (Transacao desp : fatura.getDespesas()) {
					soma += desp.getValor();
				}
			}
		}
		
		return soma;
	}
	
	public List<Transacao> getDespesasFatura(int mes){
		for (Fatura fatura : faturas) {
			if(mes == fatura.getMes()) {
				return fatura.getDespesas();
			}
		}
		return null;
	}
	
	public void fecharFatura() {
		setFechamentoCartao(this.fechamentoCartao.plusMonths(1));
	}
	
	


	
}
