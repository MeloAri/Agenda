package com.ArielMelo.Agenda.Business.Service;

import com.ArielMelo.Agenda.DTO.CompromissoDTO;
import com.ArielMelo.Agenda.Infrastructure.Entities.Compromisso;
import com.ArielMelo.Agenda.Infrastructure.Entities.Usuario;
import com.ArielMelo.Agenda.Infrastructure.Repository.CompromissoRepository;
import com.ArielMelo.Agenda.Infrastructure.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository compromissoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Compromisso criarCompromisso(CompromissoDTO dto){
        Usuario usuario = usuarioRepository.findById(dto.usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Compromisso c = new Compromisso();
        c.setTitulo(dto.titulo);
        c.setDescricao(dto.descricao);
        c.setDataHora(dto.dataHora);
        c.setUsuario(usuario);

        return compromissoRepository.save(c);
    }

    public List<Compromisso> listarPorUsuario(Long UsuarioId){
        return compromissoRepository.findByUsuarioId(UsuarioId);
    }

    public Compromisso buscarPorId(Long id){
        return compromissoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Compromisso não encontrado"));
    }

    public Compromisso atualizar(Long id, CompromissoDTO dto){
        Compromisso compromisso = buscarPorId(id);

        compromisso.setTitulo(dto.titulo);
        compromisso.setDescricao(dto.descricao);
        compromisso.setDataHora(dto.dataHora);

        return compromissoRepository.save(compromisso);
    }

    public void excluir(Long id){
        compromissoRepository.deleteById(id);
    }

    public List<Compromisso> listarPorPeriodo(LocalDateTime inicio, LocalDateTime fim){
        return compromissoRepository.findByDataHoraBetween(inicio,fim);
    }
}
