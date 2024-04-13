package br.com.jpv.contas.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpv.contas.dto.ReceitaDto;
import br.com.jpv.contas.entities.Categoria;
import br.com.jpv.contas.entities.Receita;

@Service
public class ReceitaService {

	@Autowired
	private CategoriaService categoriaService;
	
	public Receita fromDto(ReceitaDto obj) {
				
		String[] despesa = obj.getDescricaoReceita().split(",");
		Categoria categoria = categoriaService.findByDescricao(despesa[0]);
		LocalDate data = LocalDate.parse(despesa[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String descricao = despesa[2];
		Double valor = Double.parseDouble(despesa[3]);
				
		return new Receita(null, data, descricao, valor, categoria);
				
	}
}
