package br.itau.insiders.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.insiders.dao.AgendamentoDAO;
import br.itau.insiders.model.Agendamento;

@RestController
@CrossOrigin("*")
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired      // Injeção de Dependência
    private AgendamentoDAO dao;
    
    @GetMapping("/all")
    public List<Agendamento> listarTodos() {
        List<Agendamento> lista = (List<Agendamento>) dao.findAll();

        return lista;
    }

    @PostMapping("/periodo")
    public List<Agendamento> listarPorPeriodo(@RequestBody Agendamento agendamento) {        
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(agendamento.getDataAgendamento().toString(), fmt);
        List<Agendamento> lista = (List<Agendamento>) dao.findByDataAgendamentoGreaterThanEqualOrderByDataAgendamento(data);

        return lista;

    }
    @PostMapping("/data")
    public List<Agendamento> listarPorHoje(@RequestBody Agendamento agendamento) {        
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(agendamento.getDataAgendamento().toString(), fmt);
        List<Agendamento> lista = (List<Agendamento>) dao.findByDataAgendamento(data);

        return lista;

    }

    @PostMapping("/novo")
    public ResponseEntity<Agendamento> novoAnuncio(@RequestBody Agendamento agendamento){
        Agendamento newAgendamento = dao.save(agendamento);

        return ResponseEntity.ok(newAgendamento);
    }

    
}
