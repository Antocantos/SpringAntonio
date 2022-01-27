package com.antonio.spring.controladores;

import com.antonio.spring.modelo.Empleado;
import com.antonio.spring.modelo.Producto;
import com.antonio.spring.servicios.EmpleadoServicio;
import com.antonio.spring.upload.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;



@Controller
public class ControladorEmpleado {

    @Autowired
    EmpleadoServicio servicioEmpleado;

    @Autowired
    private StorageService storageService;


    private String ficheroEnviado; //

    @GetMapping({"/empleados"})
    public String listadoEmpleados(Model model){
        model.addAttribute("listaEmpleados", servicioEmpleado.findAll());
        return "listadoEmpleados"; //Debe ser el mismo nombre que el de la plantilla thymeleaf
    }

    @GetMapping("/empleado/new")
    public String nuevoEmpleado(Model model){
        model.addAttribute("empleadoForm", new Empleado());
        return "formEmpleado";
    }

    @PostMapping("/empleado/new/submit")
    public String nuevoEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

        if (bindingResult.hasErrors()) {
            return "formEmpleado";
        } else {
            if (!file.isEmpty()) {
                String imagen = storageService.store(file, nuevoEmpleado.getNombre());
                System.out.println("La imagen a guardar es : " + imagen);
                nuevoEmpleado.setImagen(MvcUriComponentsBuilder
                        .fromMethodName(Controlador.class, "serveFile", imagen).build().toUriString());
            }
            servicioEmpleado.add(nuevoEmpleado);
            return "redirect:/empleados";
        }

    }

    @GetMapping("/empleado/edit/{id}")
    public String editarEmpleadoForm(@PathVariable long id, Model model) {
        Empleado empleado = servicioEmpleado.finById(id);
        if (empleado != null) {
            model.addAttribute("empleadoForm", empleado);
            return "form";
        } else {
            return "redirect:/empleado/new";
        }
    }

    @PostMapping("/empleado/edit/submit")
    public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado,
                                       BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

        System.out.println(ficheroEnviado + ", " + file.getName());
        if (bindingResult.hasErrors()) {
            return "formEmpleado";
        } else {	 //Forma de seguridad de ficheros.
            if (!file.isEmpty()) {
                String avatar = storageService.store(file, nuevoEmpleado.getNombre());
                nuevoEmpleado.setImagen(MvcUriComponentsBuilder
                        .fromMethodName(Controlador.class, "serveFile", avatar).build().toUriString());
            }else {
                nuevoEmpleado.setImagen(ficheroEnviado);
            }
            servicioEmpleado.edit(nuevoEmpleado);
            return "redirect:/empleados";
        }
    }

    @GetMapping("/producto/empleado/{id}")
    public String deleteProducto(@PathVariable("id") long id){
        servicioEmpleado.deleteProducto(id);
        return "redirect:/empleados";
    }




}
