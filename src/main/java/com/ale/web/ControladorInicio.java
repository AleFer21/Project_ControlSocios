package com.ale.web;

import com.ale.domain.Socio;
import com.ale.servicio.SocioService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private SocioService socioService;

    @GetMapping("/")
    public String Inicio(Model model, @AuthenticationPrincipal User user) {
        var socios = socioService.listarSocios();
        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario que hizo login: " + user);
        model.addAttribute("socios", socios);
        model.addAttribute("totalSocios", socios.size());
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Socio socio) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Socio socio, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        socioService.guardar(socio);
        return "redirect:/";
    }

    @GetMapping("/editar/{idSocio}")
    public String editar(Socio socio, Model model) {
        socio = socioService.encontrarSocio(socio);
        model.addAttribute("socio", socio);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Socio socio) {
        socioService.eliminar(socio);
        return "redirect:/";
    }

}
