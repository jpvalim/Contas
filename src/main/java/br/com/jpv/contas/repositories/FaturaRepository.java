package br.com.jpv.contas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jpv.contas.entities.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long>  {

}
