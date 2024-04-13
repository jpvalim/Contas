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

import br.com.jpv.contas.dto.ContaDTO;
import br.com.jpv.contas.dto.DespesaDto;
import br.com.jpv.contas.dto.ReceitaDto;
import br.com.jpv.contas.entities.Conta;
import br.com.jpv.contas.entities.Despesa;
import br.com.jpv.contas.entities.Receita;
import br.com.jpv.contas.entities.Transacao;
import br.com.jpv.contas.services.ContaService;
import br.com.jpv.contas.services.DespesaService;
import br.com.jpv.contas.services.ReceitaService;

@RestController
@RequestMapping (value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@Autowired
	private DespesaService despService;
	
	@Autowired
	private ReceitaService recService;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping (value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		Conta obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	//trazer as informações paginadas
	//criar uma busca por período
	@GetMapping(value = "/extrato/{id}")
	public ResponseEntity<List<Transacao>> extrato(@PathVariable Long id){
		Conta obj = service.findById(id);
		return ResponseEntity.ok(obj.getExtrato());
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ContaDTO objDto){
		Conta obj= service.fromDTO(objDto);
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
	
	@DeleteMapping (value = "despesa/{idConta}/{idDespesa}")
	public ResponseEntity<Void> removeDespesa(@PathVariable Long idConta, @PathVariable Long idDespesa ){
		service.removeDespesa(idConta, idDespesa);
			
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value="receita/{id}")
	public ResponseEntity<Void> addReceita(@PathVariable Long id, @RequestBody ReceitaDto obj){
		Receita receita = recService.fromDto(obj);
		service.addReceita(id, receita);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody ContaDTO objDto){
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	

	

}
