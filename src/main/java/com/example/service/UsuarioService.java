package com.example.service;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    
    public List<Usuario> listarActivos() {
        return usuarioRepository.findByStatusTrue();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public Optional<Usuario> buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContains(nombre);
    }
    
    public List<Usuario> buscarPorGerencia(String gerencia) {
        return usuarioRepository.findByGerencia(gerencia);
    }
    
    public List<Usuario> buscarPorTipo(String tipo) {
        return usuarioRepository.findByTipo(tipo);
    }
    
    public List<Usuario> listarVerificadoresAsignaciones() {
        return usuarioRepository.findByPuedeVerificarAsignacionesTrue();
    }
    
    public List<Usuario> listarCobradores() {
        return usuarioRepository.findByPuedeCobrarTrue();
    }
} 