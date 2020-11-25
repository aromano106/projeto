package br.itau.insiders.dao;

import org.springframework.data.repository.CrudRepository;

import br.itau.insiders.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
    public  Usuario findByEmail(String email);
    public  Usuario findByEmailAndSenha(String email, String senha);
    public  Usuario findByEmailOrRacf(String email, String racf);

}
