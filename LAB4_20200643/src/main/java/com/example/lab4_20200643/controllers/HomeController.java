package com.example.lab4_20200643.controllers;

import com.example.lab4_20200643.entity.Vuelo;
import com.example.lab4_20200643.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    final VueloRepository vueloRepository;

    public HomeController(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

    @GetMapping("/homePage")
    public String homePage(Model model){
        List<Vuelo> listaVuelos = vueloRepository.findAll();
        model.addAttribute("listaVuelos",listaVuelos);
        return "homePage";
    }
}
