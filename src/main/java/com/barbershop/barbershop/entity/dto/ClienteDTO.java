package com.barbershop.barbershop.entity.dto;

import com.barbershop.barbershop.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDTO{

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    public ClienteDTO(Cliente cliente){
	this.id=cliente.getId();
        this.nome=cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

}
