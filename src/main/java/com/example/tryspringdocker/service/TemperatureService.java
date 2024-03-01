package com.example.tryspringdocker.service;


import com.example.tryspringdocker.repos.TemperatureDataRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class TemperatureService {
    @Autowired
    private TemperatureDataRepository temperatureDataRepository;

}
