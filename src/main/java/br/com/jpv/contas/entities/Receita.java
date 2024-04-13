package br.com.jpv.contas.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Receita extends Transacao implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	public Receita() {}
	
	public Receita(Long id, LocalDate data, String descricao, Double valor, Categoria categoria) {
		super(id, data, descricao, valor, categoria);
		
		
	}

}
