package br.itau.insiders.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.insiders.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
    
    public List<Agendamento> findByNomeCliente(String nomeCliente);
    public List<Agendamento> findByDataAgendamentoGreaterThanEqualOrderByDataAgendamento(LocalDate dataAgendamento);
    public List<Agendamento> findByDataAgendamento(LocalDate dataAgendamento);
}
