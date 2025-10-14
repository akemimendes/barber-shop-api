package com.barbershop.barbershop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbershop.barbershop.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long>{

    boolean existsByTelefone(final String telefone);

    boolean existsByEmail(final String email);

    Optional<Cliente> findByTelefone(final String telefone);

    Optional<Cliente> findByEmail(final String email);
}
