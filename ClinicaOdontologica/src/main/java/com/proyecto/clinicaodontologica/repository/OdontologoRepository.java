package com.proyecto.clinicaodontologica.repository;
import com.proyecto.clinicaodontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {
    Optional<Odontologo> findByMatricula(String matricula);
}
