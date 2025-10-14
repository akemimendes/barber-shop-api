package com.barbershop.barbershop.service;

import java.util.List;

import com.barbershop.barbershop.entity.Agendamento;

public interface IAgendamentoService {

    List<Agendamento> findAll();

    Agendamento save(final Agendamento agendamento);

    void delete(final long id);
    

}
