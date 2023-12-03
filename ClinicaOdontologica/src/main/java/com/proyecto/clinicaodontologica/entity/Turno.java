package com.proyecto.clinicaodontologica.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", referencedColumnName = "id")
    private Odontologo odontologo;

    @Column
    private LocalDate fechaTurno;

    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDate fechaTurno) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fechaTurno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Long getPacienteId() {
        return paciente.getId();
    }
    public Long getOdontologoId() {
        return odontologo.getId();
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
