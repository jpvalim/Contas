package br.com.jpv.contas.dto;

public class DespesaDto {
	private String descricaoDespesa;
	
	public DespesaDto() {}

	public DespesaDto(String descricaoDespesa) {
		super();
		this.descricaoDespesa = descricaoDespesa;
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	
	
}
