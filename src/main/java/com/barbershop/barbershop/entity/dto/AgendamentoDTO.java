package com.barbershop.barbershop.entity.dto;

import java.time.LocalDate;

import com.barbershop.barbershop.entity.Agendamento;
import com.barbershop.barbershop.entity.Cliente;

import lombok.Getter;

@Getter
public class AgendamentoDTO {

    private LocalDate data;

    private LocalDate hora;

    private Cliente cliente = new Cliente();

    public AgendamentoDTO(Agendamento agendamento){
        this.data = agendamento.getData();
        this.hora = agendamento.getHora();
        this.cliente = agendamento.getCliente();
    }
}
