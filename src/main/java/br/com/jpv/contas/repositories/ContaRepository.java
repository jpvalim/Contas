package br.com.jpv.contas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jpv.contas.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>  {

}
