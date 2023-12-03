package com.proyecto.clinicaodontologica.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinicaodontologica.dto.OdontologoDTO;
import com.proyecto.clinicaodontologica.entity.Odontologo;
import com.proyecto.clinicaodontologica.exception.ResourceNotFoundException;
import com.proyecto.clinicaodontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Tested on Postman OK.
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDTO>> buscarTodos() {
        List<OdontologoDTO> odontologosDTO = odontologoService.listarTodos().stream()
                .map(odontologo -> objectMapper.convertValue(odontologo, OdontologoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(odontologosDTO);
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }
    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(odontologo.getId());
        if(odontologoBuscado.isPresent()){
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok("Odontologo actualizado");
        }
        else{
            return ResponseEntity.badRequest().body("Odontologo no encontrado");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> buscarPorID(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }
    @GetMapping("/buscar/{matricula}")
    public ResponseEntity<Optional<Odontologo>> buscarPorMatricula(@PathVariable String matricula){
        return ResponseEntity.ok(odontologoService.buscarPorMatricula(matricula));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws
            ResourceNotFoundException {

           Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(id);

        if(odontologoBuscado.isEmpty()){
            throw new ResourceNotFoundException("Odontólogo no encontrado, no se pudo eliminar");
        }
        else{
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Odontólogo se ha eliminado con éxito");
        }
       }

    }
