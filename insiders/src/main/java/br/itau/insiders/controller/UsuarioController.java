package br.itau.insiders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.insiders.dao.UsuarioDAO;
import br.itau.insiders.dto.UsuarioDto;
import br.itau.insiders.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired      // Injeção de Dependência
    private UsuarioDAO dao;

    @GetMapping("/all")
    public List<Usuario> listarTodos() {
        List<Usuario> lista = (List<Usuario>) dao.findAll();

        return lista;

    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> validaEmailSenha (@RequestBody Usuario user) {
        Usuario userFinded = dao.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFinded != null) {
            if (userFinded.getSenha().equals(user.getSenha())) {
                UsuarioDto userDto = new UsuarioDto(userFinded);
                return ResponseEntity.ok(userDto);
            }
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.status(401).build();

    }

}
