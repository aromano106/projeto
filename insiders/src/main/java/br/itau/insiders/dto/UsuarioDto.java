package br.itau.insiders.dto;
import br.itau.insiders.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor

public class UsuarioDto {
    private String nome;
    private String email;
    private String racf;

    public UsuarioDto(Usuario user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.racf = user.getRacf();
    }
}
