package br.com.jpv.contas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpv.contas.dto.CartaoCreditoDTO;
import br.com.jpv.contas.entities.CartaoCredito;
import br.com.jpv.contas.entities.Despesa;
import br.com.jpv.contas.repositories.CartaoCreditoRepository;
import br.com.jpv.contas.resources.exceptions.DataIntegrityException;
import br.com.jpv.contas.resources.exceptions.ObjectNotFoundException;

@Service
public class CartaoCreditoService {
	
	@Autowired
	private CartaoCreditoRepository repo;
	
	public List<CartaoCredito> findAll(){
		return repo.findAll();
	}

	public CartaoCredito findById(Long id) {
		return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto de id "  + id + " não encontrado"));
	}

	public CartaoCredito fromDTO(CartaoCreditoDTO objDto) {
		CartaoCredito obj = new CartaoCredito(objDto.getId(), objDto.getLimite(), objDto.getDescricao(),objDto.getNome(), objDto.getFechamentoCartao(), objDto.getVencimentoCartao(), objDto.getPrazoFechamentoCartao());
		return obj;
	}

	public CartaoCredito insert(CartaoCredito obj) {
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

	public CartaoCredito update(CartaoCreditoDTO objDto) {
		CartaoCredito obj = findById(objDto.getId());
		updateData(objDto, obj);
		return repo.save(obj);
	}
	
		
	private void updateData(CartaoCreditoDTO origem, CartaoCredito destino) {
		destino.setId(origem.getId());
		destino.setLimite(origem.getLimite());
		destino.setNome(origem.getNome());
		destino.setDescricao(origem.getDescricao());
	}
	
	public void addDespesa(Long idCartao, Despesa despesa) {
		CartaoCredito cartao = findById(idCartao);
		cartao.incluirDespesaCartao(despesa);
		repo.save(cartao);
	
	}
		
	
}
