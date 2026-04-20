package com.ucc.Biblioteca.controllers;

import com.ucc.Biblioteca.dtos.EstudianteDTO;
import com.ucc.Biblioteca.services.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public EstudianteDTO createEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.createEstudiante(estudianteDTO);
    }

    @GetMapping
    public List<EstudianteDTO> getEstudiante() {
        return estudianteService.findAll();
    }
}
