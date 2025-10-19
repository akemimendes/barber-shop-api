package com.barbershop.barbershop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.barbershop.barbershop.entity.Cliente;
import com.barbershop.barbershop.entity.dto.ClienteDTO;
import com.barbershop.barbershop.service.IClienteService;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService){
        this.clienteService=clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> clientes= clienteService.findAll();
        List<ClienteDTO> clientesDTO = clientes.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientesDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable long id){
        Cliente cliente= clienteService.find(id);
        return ResponseEntity.ok().body(new ClienteDTO(cliente));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO cliente){
        Cliente newCliente=clienteService.save(new Cliente(cliente));
        return ResponseEntity.ok().body(new ClienteDTO(newCliente));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO cliente, @PathVariable long id){
        clienteService.update(new Cliente(cliente),id);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        clienteService.delete(id);
        return ResponseEntity.ok().body(Map.of("message","Cliente excluído com sucesso!"));
    }

}
