package br.com.jpv.contas.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

import br.com.jpv.contas.entities.enums.TipoDespesa;

@Entity
public class Despesa extends Transacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer tipoDespesa;
	
	public Despesa() {}
	
	public Despesa(Long id, LocalDate data, String descricao, Double valor, TipoDespesa tipoDespesa, Categoria categoria) {
		super(id, data, descricao, valor, categoria);
		this.setTipoDespesa(tipoDespesa.getCode());
		
	}

	public Integer getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(Integer tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}


}
