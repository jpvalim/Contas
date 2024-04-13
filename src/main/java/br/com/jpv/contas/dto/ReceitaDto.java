package br.com.jpv.contas.dto;

public class ReceitaDto {
	private String descricaoReceita;
	
	public ReceitaDto() {}

	public ReceitaDto(String descricaoReceita) {
		super();
		this.descricaoReceita = descricaoReceita;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}
	
	
}
