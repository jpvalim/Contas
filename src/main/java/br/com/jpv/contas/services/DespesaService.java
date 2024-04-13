package br.com.jpv.contas.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpv.contas.dto.DespesaDto;
import br.com.jpv.contas.entities.Categoria;
import br.com.jpv.contas.entities.Despesa;
import br.com.jpv.contas.entities.enums.TipoDespesa;

@Service
public class DespesaService {

	@Autowired
	private CategoriaService categoriaService;
	
	public Despesa fromDto(DespesaDto obj) {
				
		String[] despesa = obj.getDescricaoDespesa().split(",");
		Categoria categoria = categoriaService.findByDescricao(despesa[0]);
		LocalDate data = LocalDate.parse(despesa[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String descricao = despesa[2];
		Double valor = Double.parseDouble(despesa[3]);
		TipoDespesa tipo = TipoDespesa.valueOf(despesa[4]);
		
		return new Despesa(null, data, descricao, valor, tipo, categoria);
				
	}
}
