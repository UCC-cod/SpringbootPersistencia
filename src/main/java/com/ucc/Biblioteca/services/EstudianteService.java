package com.ucc.Biblioteca.services;

import com.ucc.Biblioteca.dtos.EstudianteDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO);
    List<EstudianteDTO> findAll();
}
