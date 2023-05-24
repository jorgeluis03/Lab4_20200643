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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.time.LocalTime.now;

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

    @PostMapping("/login")
    public String iniciosesion( Model model, @RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena){
        Optional<User> optuser = userRepository.findUserByEmailAndAndPassword(correo,contrasena);
        if(optuser.isPresent()){
            User user = optuser.get();
            List<Vuelo> listaVuelos = vueloRepository.findAll();
            model.addAttribute("user", user);
            model.addAttribute("listaVuelos", listaVuelos);

            return "homePage";
        }else {
            return "redirect:/";
        }

    }
    @PostMapping("/reserva")
    public String reserva (Model model,@RequestParam("iduser") int iduser, @RequestParam("idvuelo") int idvuelo, @RequestParam("precio")BigDecimal precio){

        userRepository.reservar(precio,iduser,idvuelo);
        Optional<User> optionalUser = userRepository.findById(iduser);
        User user = optionalUser.get();
        List<Vuelo> listaVuelos = vueloRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listaVuelos", listaVuelos);
        return "homePage";
    }








}
