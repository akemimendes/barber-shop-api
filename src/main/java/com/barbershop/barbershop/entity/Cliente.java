package com.barbershop.barbershop.entity;

import java.util.HashSet;
import java.util.Set;

import com.barbershop.barbershop.entity.dto.ClienteDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
                @UniqueConstraint(name = "UK_EMAIL", columnNames = "email"),
                @UniqueConstraint(name = "UK_TELEFONE", columnNames = "telefone")
        })
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Agendamento> agendamentos = new HashSet<Agendamento>();

     public Cliente(ClienteDTO cliente){
        this.nome=cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

}
