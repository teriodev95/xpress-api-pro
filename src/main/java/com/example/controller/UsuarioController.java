package com.example.controller;

import com.example.model.Usuario;
import com.example.service.UsuarioService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Controller("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Get
    @Transactional
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }
    
    @Get("/activos")
    @Transactional
    public List<Usuario> listarActivos() {
        return usuarioService.listarActivos();
    }

    @Get("/{id}")
    @Transactional
    public HttpResponse<Usuario> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(id);
        return usuarioOptional.map(HttpResponse::ok)
                .orElseGet(() -> HttpResponse.notFound());
    }
    
    @Get("/usuario/{nombreUsuario}")
    @Transactional
    public HttpResponse<Usuario> buscarPorUsuario(@PathVariable String nombreUsuario) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorUsuario(nombreUsuario);
        return usuarioOptional.map(HttpResponse::ok)
                .orElseGet(() -> HttpResponse.notFound());
    }

    @Get("/buscar")
    @Transactional
    public List<Usuario> buscarPorNombre(@QueryValue String nombre) {
        return usuarioService.buscarPorNombre(nombre);
    }
    
    @Get("/gerencia/{gerencia}")
    @Transactional
    public List<Usuario> buscarPorGerencia(@PathVariable String gerencia) {
        return usuarioService.buscarPorGerencia(gerencia);
    }
    
    @Get("/tipo/{tipo}")
    @Transactional
    public List<Usuario> buscarPorTipo(@PathVariable String tipo) {
        return usuarioService.buscarPorTipo(tipo);
    }
    
    @Get("/verificadores")
    @Transactional
    public List<Usuario> listarVerificadoresAsignaciones() {
        return usuarioService.listarVerificadoresAsignaciones();
    }
    
    @Get("/cobradores")
    @Transactional
    public List<Usuario> listarCobradores() {
        return usuarioService.listarCobradores();
    }
} 