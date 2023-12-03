package com.proyecto.clinicaodontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_id_seq")
    private Long id;
    @Column
    private String matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @OneToMany(mappedBy = "odontologo",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos= new HashSet<>();

    public Odontologo() {
    }

    public Odontologo(String matricula, String nombre, String apellido, Set<Turno> turnos) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turnos = turnos;
    }

    public Odontologo(String number, String john, String doe) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Odontologo odontologo = (Odontologo) obj;
        return id == odontologo.id &&
                matricula.equals(odontologo.matricula) &&
                nombre.equals(odontologo.nombre) &&
                apellido.equals(odontologo.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, nombre, apellido);
    }


}

