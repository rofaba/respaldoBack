package com.proyecto.clinicaodontologica.service;

import com.proyecto.clinicaodontologica.entity.Domicilio;
import com.proyecto.clinicaodontologica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public Domicilio guardarDomicilio(Domicilio domicilio) {

        return domicilioRepository.save(domicilio);
    }
}