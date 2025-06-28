package com.ArielMelo.Agenda.Infrastructure.Repository;

import com.ArielMelo.Agenda.Infrastructure.Entities.Compromisso;
import com.ArielMelo.Agenda.Infrastructure.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {
    List<Compromisso> findByUsuarioId(Long usuarioId);
    List<Compromisso> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
