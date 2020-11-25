package br.itau.insiders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.insiders.dao.AgenciaDAO;
import br.itau.insiders.model.Agencia;

@RestController
@CrossOrigin("*")
@RequestMapping("/agencia")
public class AgenciaController {
    @Autowired      // Injeção de Dependência
    private AgenciaDAO dao;

    @GetMapping("/all")
    public List<Agencia> listarTodos() {
        List<Agencia> lista = (List<Agencia>) dao.findAll();

        return lista;

    }
}
