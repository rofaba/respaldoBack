package com.proyecto.clinicaodontologica.controller;
import com.proyecto.clinicaodontologica.entity.Paciente;
import com.proyecto.clinicaodontologica.exception.ResourceNotFoundException;
import com.proyecto.clinicaodontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/todos")
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<String> registrarPaciente(@RequestBody Paciente paciente) {
        try {
            // Registrar el paciente y su domicilio
            pacienteService.registrarPaciente(paciente);
            return ResponseEntity.ok("Paciente registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al registrar el paciente");
        }
    }
    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacientePorID(paciente.getId());
        if(pacienteBuscado.isPresent()) {
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok("paciente actualizado");
        }else{
            return ResponseEntity.badRequest().body("paciente no encontrado");
        }
    }
    @GetMapping("/buscarCorreo/{email}")
    public ResponseEntity<Paciente> buscarEmail(@PathVariable String email){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorCorreo(email);
        if(pacienteBuscado.isPresent()) {

            return ResponseEntity.ok(pacienteBuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws
            ResourceNotFoundException {
            Optional<Paciente> pacienteBuscado= pacienteService.buscarPacientePorID(id);
            if(pacienteBuscado.isEmpty()){
                throw new ResourceNotFoundException("Paciente no encontrado, no se pudo eliminar.");
        } else{
                pacienteService.eliminarPaciente(id);
                return ResponseEntity.ok("Se eliminó con exito");
            }
    }
}
