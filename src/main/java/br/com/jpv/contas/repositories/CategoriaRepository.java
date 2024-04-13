package br.com.jpv.contas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jpv.contas.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
	Optional<Categoria> findByDescricao(String descricao);
}
