package com.barbershop.barbershop.entity;

import java.time.LocalDate;

import com.barbershop.barbershop.entity.dto.AgendamentoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalDate hora;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente = new Cliente();

    public Agendamento(AgendamentoDTO agendamento) {
        this.data = agendamento.getData();
        this.hora = agendamento.getHora();
        this.cliente = agendamento.getCliente();
    }

}
