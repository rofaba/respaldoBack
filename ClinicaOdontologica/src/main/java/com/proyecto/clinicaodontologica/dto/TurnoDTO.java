package com.proyecto.clinicaodontologica.dto;
import com.proyecto.clinicaodontologica.entity.Turno;

import java.time.LocalDate;

public class TurnoDTO {

    private Long id;
    private LocalDate fechaTurno;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

    // Agregar setters y getters para los campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDTO odontologo) {
        this.odontologo = odontologo;
    }

    @Override
    public String toString() {
        return "TurnoDTO{" +
                "id=" + id +
                ", fechaTurno=" + fechaTurno +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }


}