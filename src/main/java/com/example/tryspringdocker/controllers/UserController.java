package com.example.tryspringdocker.controllers;

import com.example.tryspringdocker.entity.TemperatureData;
import com.example.tryspringdocker.entity.User;
import com.example.tryspringdocker.repos.TemperatureDataRepository;
import com.example.tryspringdocker.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TemperatureDataRepository temperatureDataRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//
//        return "signup_form";
//    }

    @GetMapping("/loginsuccess")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("temperatureData",new TemperatureData());
        return "logged_in";
    }

    @PostMapping("/temperature")
    public String addTemperatureData(TemperatureData temperature) {

       temperatureDataRepo.save(temperature);
        return "logged_in";
    }
    @GetMapping("/analytics")
    public String analytics( Model model) {
        model.addAttribute("avg",temperatureDataRepo.findAverageTemperature());
        model.addAttribute("max",temperatureDataRepo.findMaxTemperature());
        model.addAttribute("min",temperatureDataRepo.findMinTemperature());
        return "results";
    }
}