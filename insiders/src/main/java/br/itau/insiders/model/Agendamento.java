package br.itau.insiders.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                 // esta classe será armazenada no banco de dados
@Table(name= "itmn032_agendamento")    // nome da tabela no banco de dados
@Getter @Setter @NoArgsConstructor
public class Agendamento {
    @Id                 // este campo é chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    @Column(name = "num_seq")
    private int numSeq;
    
    @Column(name = "nome_cli", length = 100)
    private String nomeCliente;

    @Column(name = "email_cli", length = 100)
    private String emailCliente;

    @Column(name="celular_cli", length = 20)
    private String celularCliente;

    @Column(name="data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name="hora_agendamento")
    private  LocalTime horaAgendamento;

    @Column(name="observacao", length = 250)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_agencia")
    @JsonIgnoreProperties("agendamentos")
    private Agencia agencia;

}