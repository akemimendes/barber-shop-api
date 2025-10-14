package com.barbershop.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbershop.barbershop.entity.Agendamento;

@Repository
public interface IAgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
