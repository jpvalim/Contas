package br.com.jpv.contas.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ContaCorrente extends Conta implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Double saldoTotal;
	
	public ContaCorrente() {}
	
	public ContaCorrente(Long id, String banco, Double saldoTotal) {
		super(id, banco);
		this.saldoTotal = saldoTotal;
	
	}
	
	
	@Override
	public void Depositar(Double valor) {
		this.saldoTotal += valor;
		
	}

	@Override
	public void Retirar(Double valor) {
		this.saldoTotal -= valor;
		
	}

	public Double getSaldoTotal() {
		return saldoTotal;
	}
	
	
}
