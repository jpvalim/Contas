package br.com.jpv.contas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpv.contas.dto.ContaDTO;
import br.com.jpv.contas.entities.Conta;
import br.com.jpv.contas.entities.Despesa;
import br.com.jpv.contas.entities.Receita;
import br.com.jpv.contas.entities.Transacao;
import br.com.jpv.contas.repositories.ContaRepository;
import br.com.jpv.contas.resources.exceptions.DataIntegrityException;
import br.com.jpv.contas.resources.exceptions.ObjectNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	
		
	public List<Conta> findAll(){
		return repo.findAll();
	}

	public Conta findById(Long id) {
		return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto de id "  + id + " não encontrado"));
	}

	public Conta fromDTO(ContaDTO objDto) {
		Conta obj = new Conta(objDto.getId(), objDto.getBanco(), objDto.getNome(), objDto.getSaldo(), objDto.getLimite());
		return obj;
	}
	
	
	public Conta insert(Conta obj) {
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

	public Conta update(ContaDTO objDto) {
		Conta obj = findById(objDto.getId());
		updateData(objDto, obj);
		return repo.save(obj);
	}
	
	public void addDespesa(Long idConta, Despesa despesa) {
		Conta conta = findById(idConta);
		conta.inserirDespesa(despesa);
		repo.save(conta);
	
	}
		
	public void addReceita(Long idConta, Receita receita) {
		Conta conta = findById(idConta);
		conta.inserirReceita(receita);
		repo.save(conta);
		
	}
	
	private void updateData(ContaDTO origem, Conta destino) {
		destino.setId(origem.getId());
		destino.setBanco(origem.getBanco());
		destino.setLimite(origem.getLimite());
		destino.setNome(origem.getNome());
		destino.setSaldo(origem.getSaldo());
	}

	public void removeDespesa(Long idConta, Long idDespesa) {
		Conta conta = findById(idConta);
		List<Transacao> despesas = conta.getExtrato();
		for (Transacao transacao : despesas) {
			if(transacao.getId() == idDespesa){
				conta.getExtrato().remove(transacao);
				repo.save(conta);
				break;
			}
			throw new ObjectNotFoundException("Despesa não encontrada");
		}
		
		
		
	}

	
}
