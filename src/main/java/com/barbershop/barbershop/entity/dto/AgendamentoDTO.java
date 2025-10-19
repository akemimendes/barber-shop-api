package com.barbershop.barbershop.entity.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.barbershop.barbershop.entity.Agendamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AgendamentoDTO {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;

    private Long clienteId;

    public AgendamentoDTO(Agendamento agendamento){
	this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.hora = agendamento.getHora();
        this.clienteId = agendamento.getCliente().getId();
    }
}
