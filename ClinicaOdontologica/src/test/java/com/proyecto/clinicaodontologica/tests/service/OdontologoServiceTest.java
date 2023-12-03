package com.proyecto.clinicaodontologica.tests.service;

import com.proyecto.clinicaodontologica.service.OdontologoService;
import com.proyecto.clinicaodontologica.entity.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.proyecto.clinicaodontologica.entity.Odontologo;
import com.proyecto.clinicaodontologica.repository.OdontologoRepository;
import com.proyecto.clinicaodontologica.service.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Test
    void buscarPorId_TEST() {
        // Arrange
        Odontologo odontologo = new Odontologo(
                "FG123", "Doctor", "Muelas", new HashSet<>());
        odontologoRepository.save(odontologo);

        // Act
        Optional<Odontologo> resultado = odontologoService.buscarPorId(odontologo.getId());

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Doctor");
        assertThat(resultado.get().getApellido()).isEqualTo("Muelas");
    }
    @Test
    void registrarOdontologo_TEST() {
        // Arrange
        Odontologo odontologo = new Odontologo("FG456", "Diente", "Blanco", new HashSet<>());

        // Act
        Odontologo odontologoGuardado = odontologoService.registrarOdontologo(odontologo);
        Optional<Odontologo> resultado = odontologoService.buscarPorId(odontologoGuardado.getId());

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getMatricula()).isEqualTo("FG456");
        assertThat(resultado.get().getNombre()).isEqualTo("Diente");
        assertThat(resultado.get().getApellido()).isEqualTo("Blanco");
    }

    @Test
    void actualizarOdontologo_TEST() {
        // Arrange
        Odontologo odontologo = new Odontologo("FG789", "Bob", "Patiño", new HashSet<>());
        Odontologo odontologoGuardado = odontologoRepository.save(odontologo);

        // Modificar información del odontólogo
        odontologoGuardado.setNombre("Doctor");
        odontologoGuardado.setApellido("Hibbert");

        // Act
        odontologoService.actualizarOdontologo(odontologoGuardado);
        Optional<Odontologo> resultado = odontologoService.buscarPorId(odontologoGuardado.getId());

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Doctor");
        assertThat(resultado.get().getApellido()).isEqualTo("Hibbert");
    }

}
