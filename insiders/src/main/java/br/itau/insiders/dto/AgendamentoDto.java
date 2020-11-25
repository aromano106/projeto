package br.itau.insiders.dto;

import br.itau.insiders.model.Agendamento;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AgendamentoDto {
    private String nomeCliente;
    private String emailCliente;
    private String celularCliente;
    private String dataAgendamento;
    private  String horaAgendamento;
    private String observacao;

    public AgendamentoDto(Agendamento agendamento) {
        this.nomeCliente = agendamento.getNomeCliente();
        this.emailCliente = agendamento.getEmailCliente();
        this.celularCliente = agendamento.getCelularCliente();
        //this.dataAgendamento = agendamento.getDataAgendamento();
        //this.emailCliente = agendamento.getEmailCliente();
        //this.emailCliente = agendamento.getEmailCliente();
    }
}
