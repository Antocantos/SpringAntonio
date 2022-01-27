package com.antonio.spring.servicios;


import com.antonio.spring.modelo.Producto;
import com.antonio.spring.modelo.Usuario;
import com.antonio.spring.repositorios.ProductoRepositorio;
import com.antonio.spring.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorioUsuario;

    public Usuario add(Usuario e) {
        repositorioUsuario.save(e);
        return e;
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) repositorioUsuario.findAll();
    }

    public Usuario findById(long id) {
        return repositorioUsuario.findById(id).get();
    }

    public Usuario edit(Usuario e) {
        repositorioUsuario.save(e);
        return e;
    }

    public void deleteUsuario(long id) {
        repositorioUsuario.deleteById(id);
    }

}
