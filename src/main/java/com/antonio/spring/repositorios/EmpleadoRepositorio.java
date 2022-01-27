package com.antonio.spring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.antonio.spring.modelo.Empleado;


public interface EmpleadoRepositorio extends CrudRepository<Empleado,Long> {

}