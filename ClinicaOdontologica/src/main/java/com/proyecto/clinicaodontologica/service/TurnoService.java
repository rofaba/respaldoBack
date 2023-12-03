package com.proyecto.clinicaodontologica.service;
import com.proyecto.clinicaodontologica.dto.OdontologoDTO;
import com.proyecto.clinicaodontologica.dto.PacienteDTO;
import com.proyecto.clinicaodontologica.dto.TurnoDTO;
import com.proyecto.clinicaodontologica.entity.Odontologo;
import com.proyecto.clinicaodontologica.entity.Paciente;
import com.proyecto.clinicaodontologica.entity.Turno;
import com.proyecto.clinicaodontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoDTO guardarTurno(Turno turno) {
        Turno turnoGuardado = turnoRepository.save(turno);
        return turnoATurnoDTO(turnoGuardado);
    }

    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    public void actualizarTurno(Turno turno) {
        turnoRepository.save(turno);
    }

    public Optional<Turno> buscarTurnoPorId(Long id) {
        return turnoRepository.findById(id);
    }

    public TurnoDTO guardarTurnoConDetalles(Turno turno) {
        Turno turnoGuardado = turnoRepository.save(turno);
        return turnoATurnoDTOConDetalles(turnoGuardado);
    }

    public TurnoDTO turnoATurnoDTO(Turno turno) {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setFechaTurno(turno.getFechaTurno());
        return turnoDTO;
    }
    public TurnoDTO turnoATurnoDTOConDetalles(Turno turno) {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setFechaTurno(turno.getFechaTurno());

        // Construir PacienteDTO con detalles
        PacienteDTO pacienteDTO = new PacienteDTO();
        Paciente paciente = turno.getPaciente();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        turnoDTO.setPaciente(pacienteDTO);

        // Construir OdontologoDTO con detalles
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        Odontologo odontologo = turno.getOdontologo();
        odontologoDTO.setId(odontologo.getId());
        odontologoDTO.setNombre(odontologo.getNombre());
        odontologoDTO.setApellido(odontologo.getApellido());
        turnoDTO.setOdontologo(odontologoDTO);

        return turnoDTO;
    }

    public List<Turno> buscarTodosLosTurnos() {
        return turnoRepository.findAll();
    }
}

