package com.barbershop.barbershop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.barbershop.entity.Agendamento;
import com.barbershop.barbershop.entity.dto.AgendamentoDTO;
import com.barbershop.barbershop.service.IAgendamentoService;


@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    private final IAgendamentoService agendamentoService;

    public AgendamentoController(IAgendamentoService agendamentoService){
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll(){
        List<Agendamento> agendas = agendamentoService.findAll();
        List<AgendamentoDTO> agendasDTO= agendas.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(agendasDTO);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> save(@RequestBody AgendamentoDTO agendamentoDTO){
        agendamentoService.save(new Agendamento(agendamentoDTO));
        return ResponseEntity.ok().body(agendamentoDTO);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        agendamentoService.delete(id);
        return ResponseEntity.ok().body(Map.of("message","Agendamento excluído com sucesso!"));
    }

}
