package com.example.lab4_20200643.controllers;

import com.example.lab4_20200643.entity.User;
import com.example.lab4_20200643.entity.Vuelo;
import com.example.lab4_20200643.repository.UserRepository;
import com.example.lab4_20200643.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {
    final VueloRepository vueloRepository;
    final UserRepository userRepository;

    public HomeController(VueloRepository vueloRepository, UserRepository userRepository) {
        this.vueloRepository = vueloRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String inicio(){
        return "inicio";
    }

    @PostMapping("/homePage")
    public String homePage(Model model, @RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena){
        User user  =  userRepository.findByEmail(correo);


            List<Vuelo> listaVuelos = vueloRepository.findAll();
            model.addAttribute("listaVuelos", listaVuelos);
            
            return "homePage";





    }

}
