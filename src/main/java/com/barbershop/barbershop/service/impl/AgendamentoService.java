package com.barbershop.barbershop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbershop.barbershop.entity.Agendamento;
import com.barbershop.barbershop.exception.NaoEncontradoExcecao;
import com.barbershop.barbershop.repository.IAgendamentoRepository;
import com.barbershop.barbershop.service.IAgendamentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendamentoService implements IAgendamentoService {

    private final IAgendamentoRepository agendamentoRepository;

    @Override
    public List<Agendamento> findAll() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento save(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public void delete(long id) {
        var optional = agendamentoRepository.findById(id);
        if (optional.isPresent()) {
            agendamentoRepository.deleteById(id);
        }else{
            new NaoEncontradoExcecao("Não foi encontrado o cliente de id " + id);
        }
    }

}
