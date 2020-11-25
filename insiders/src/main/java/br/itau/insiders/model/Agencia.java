package br.itau.insiders.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                 // esta classe será armazenada no banco de dados
@Table(name= "itmn032_agencia")    // nome da tabela no banco de dados
@Getter @Setter @NoArgsConstructor
public class Agencia {
    @Id                 // este campo é chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome_agencia", length = 100)
    private String nomeAgencia;

    @Column(name = "hora_inicio")
    private int horaInicio;

    @Column(name="hora_fim")
    private int horaFim;

    @OneToMany(mappedBy = "agencia")
    @JsonIgnoreProperties("agencia")
    private List<Agendamento> agendamentos;

}
