package com.barbershop.barbershop.service;

import java.util.List;

import com.barbershop.barbershop.entity.Cliente;

public interface IClienteService {

    List<Cliente> findAll();

    Cliente find(final long id);

    Cliente save(final Cliente cliente);

    Cliente update(final Cliente cliente, final long id);

    void delete(final long id);

    
}
