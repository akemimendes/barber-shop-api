package com.barbershop.barbershop.entity.dto;

import com.barbershop.barbershop.entity.Cliente;

import lombok.Getter;

@Getter
public class ClienteDTO {

    private String nome;

    private String email;

    private String telefone;

    public ClienteDTO(Cliente cliente){
        this.nome=cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

}
