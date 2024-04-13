package br.com.jpv.contas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.jpv.contas.dto.CategoriaDTO;
import br.com.jpv.contas.entities.Categoria;
import br.com.jpv.contas.repositories.CategoriaRepository;
import br.com.jpv.contas.resources.exceptions.DataIntegrityException;
import br.com.jpv.contas.resources.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}

	public Categoria findById(Long id) {
		return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto de id "  + id + " não encontrado"));
	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		Categoria obj = new Categoria(objDto.getId(), objDto.getDescricao());
		return obj;
	}

	public Categoria insert(Categoria obj) {
		return repo.save(obj);
		
	}

	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		}
		catch (Exception e) {
			throw new DataIntegrityException("Não foi possível excluir o objeto. " + e.getMessage());
		}
		
	}

	public Categoria update(CategoriaDTO objDto) {
		Categoria obj = findById(objDto.getId());
		obj.setDescricao(objDto.getDescricao());
		return repo.save(obj);
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Categoria findByDescricao(String descricao) {
		try {
			return repo.findByDescricao(descricao).get();
		}
		catch(Exception e){
			Categoria cat = new Categoria(null, descricao);
			return repo.save(cat);
		}

		
	}


}
