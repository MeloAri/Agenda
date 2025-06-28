package com.ArielMelo.Agenda.Controller;

import com.ArielMelo.Agenda.Business.Service.CompromissoService;
import com.ArielMelo.Agenda.DTO.CompromissoDTO;
import com.ArielMelo.Agenda.Infrastructure.Entities.Compromisso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {

    @Autowired
    private CompromissoService compromissoService;

    @PostMapping
    public ResponseEntity<Compromisso> criar(@RequestBody CompromissoDTO dto){
        Compromisso salvo = compromissoService.criarCompromisso(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Compromisso> listarPorUsuario(@PathVariable Long usuarioId){
        return compromissoService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compromisso> buscarPorId(@PathVariable Long id){
        Compromisso compromisso = compromissoService.buscarPorId(id);
        return ResponseEntity.ok(compromisso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compromisso> atualizar(@PathVariable Long id, @RequestBody CompromissoDTO dto){
        Compromisso atualizado = compromissoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        compromissoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/periodo")
    public List<Compromisso> listarPorPeriodo(
            @RequestParam("inicio") String inicio,
            @RequestParam("fim") String fim
    ){
        LocalDateTime dtInicio = LocalDateTime.parse(inicio);
        LocalDateTime dtFim = LocalDateTime.parse(fim);
        return  compromissoService.listarPorPeriodo(dtInicio, dtFim);
    }
}
