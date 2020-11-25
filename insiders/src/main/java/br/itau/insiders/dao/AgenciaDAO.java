package br.itau.insiders.dao;

import org.springframework.data.repository.CrudRepository;

import br.itau.insiders.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia, Integer> {
    
}
