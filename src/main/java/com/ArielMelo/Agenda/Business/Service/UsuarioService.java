package com.ArielMelo.Agenda.Business.Service;

import com.ArielMelo.Agenda.Infrastructure.Entities.Usuario;
import com.ArielMelo.Agenda.Infrastructure.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
}
