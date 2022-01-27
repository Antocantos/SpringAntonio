package com.antonio.spring.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.antonio.spring.modelo.Empleado;
import com.antonio.spring.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {

    //List<Empleado> repositorio = new ArrayList<>();

    @Autowired
    private EmpleadoRepositorio repositorio2;

    public Empleado add(Empleado e) {
        repositorio2.save(e);
        return e;
    }

    public List<Empleado> findAll(){
        return (List<Empleado>)repositorio2.findAll();
    }

    public Empleado finById(long id) {
        return repositorio2.findById(id).get();
    }

    public Empleado edit(Empleado e) {
        repositorio2.save(e);
        return e;
    }

    public void deleteProducto(long id) {
        repositorio2.deleteById(id);
    }


}
