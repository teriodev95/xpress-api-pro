package com.example.repository;

import com.example.model.Usuario;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    List<Usuario> findAll();
    
    List<Usuario> findByStatusTrue();
    
    List<Usuario> findByNombreContains(String nombre);
    
    Optional<Usuario> findByUsuario(String usuario);
    
    List<Usuario> findByGerencia(String gerencia);
    
    List<Usuario> findByTipo(String tipo);
    
    List<Usuario> findByPuedeVerificarAsignacionesTrue();
    
    List<Usuario> findByPuedeCobrarTrue();
} 