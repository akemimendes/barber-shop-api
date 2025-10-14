package com.barbershop.barbershop.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.barbershop.barbershop.entity.Cliente;
import com.barbershop.barbershop.exception.EmailEmUsoExcecao;
import com.barbershop.barbershop.exception.NaoEncontradoExcecao;
import com.barbershop.barbershop.exception.TelefoneEmUsoExcecao;
import com.barbershop.barbershop.repository.IClienteRepository;
import com.barbershop.barbershop.service.IClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService implements IClienteService {

    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente find(final long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoExcecao("Não foi encontrado o cliente de id " + id));
    }

    @Override
    public Cliente save(final Cliente cliente) {
        if (clienteRepository.existsByTelefone(cliente.getEmail())) {
            throw new TelefoneEmUsoExcecao("O telefone " + cliente.getTelefone() + " já está em uso");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new TelefoneEmUsoExcecao("O email " + cliente.getEmail() + " já está em uso");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(final Cliente cliente,final long id) {
        var optional = clienteRepository.findById(id);
        if (optional.isPresent() && !Objects.equals(optional.get().getTelefone(), cliente.getTelefone())) {
            var message = "O telefone " + cliente.getTelefone() + " já está em uso";
            throw new TelefoneEmUsoExcecao(message);
        }
        if (optional.isPresent() && !Objects.equals(optional.get().getEmail(), cliente.getEmail())) {
            var message = "O email " + cliente.getEmail() + " já está em uso";
            throw new EmailEmUsoExcecao(message);
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(final long id) {
        var optional = clienteRepository.findById(id);
        if (optional.isPresent()){
            clienteRepository.deleteById(id);
        }else{
            new NaoEncontradoExcecao("Não foi encontrado o cliente de id " + id);
        }
    }

}
