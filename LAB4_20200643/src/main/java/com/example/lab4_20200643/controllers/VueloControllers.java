package com.example.lab4_20200643.controllers;

import com.example.lab4_20200643.entity.Vuelo;
import com.example.lab4_20200643.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vuelos")
public class VueloControllers {
    final VueloRepository vueloRepository;

    public VueloControllers(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @GetMapping("/homepage")
    public String mostrarDatosVuelo (Model model){
        List<Vuelo> listaVuelos = vueloRepository.findAll();
        model.addAttribute("listaVuelos", listaVuelos);
        return "homePage";

    }
}
