package com.antonio.spring.repositorios;

import com.antonio.spring.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
}
