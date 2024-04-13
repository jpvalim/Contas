package br.com.jpv.contas.dto;

import br.com.jpv.contas.entities.Categoria;

public class CategoriaDTO {
	
	private Long id;
	private String descricao;
	
	public CategoriaDTO() {}
		
	public CategoriaDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public CategoriaDTO(Categoria obj) {
		id=obj.getId();
		descricao=obj.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
