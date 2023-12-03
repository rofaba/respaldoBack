package com.proyecto.clinicaodontologica.dto;

import java.time.LocalDate;

public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;

    public PacienteDTO(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public PacienteDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public PacienteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
    }
}


