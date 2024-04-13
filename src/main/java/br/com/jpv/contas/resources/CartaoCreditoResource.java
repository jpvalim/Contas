package br.com.jpv.contas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jpv.contas.dto.CartaoCreditoDTO;
import br.com.jpv.contas.dto.DespesaDto;
import br.com.jpv.contas.entities.CartaoCredito;
import br.com.jpv.contas.entities.Despesa;
import br.com.jpv.contas.services.CartaoCreditoService;
import br.com.jpv.contas.services.DespesaService;

@RestController
@RequestMapping (value = "/cartoes")
public class CartaoCreditoResource {
	
	@Autowired
	private CartaoCreditoService service;
	
	@Autowired
	private DespesaService despService;
	
		
	@GetMapping
	public ResponseEntity<List<CartaoCredito>> findAll(){
		List<CartaoCredito> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping (value = "/{id}")
	public ResponseEntity<CartaoCredito> findById(@PathVariable Long id){
		CartaoCredito obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
		
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CartaoCreditoDTO objDto){
		CartaoCredito obj= service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value="despesa/{id}")
	public ResponseEntity<Void> addDespesa(@PathVariable Long id, @RequestBody DespesaDto obj){
		Despesa despesa = despService.fromDto(obj);
		service.addDespesa(id, despesa);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody CartaoCreditoDTO objDto){
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	

	

}
