package com.ucc.Biblioteca.services.impl;

import com.ucc.Biblioteca.dtos.EstudianteDTO;
import com.ucc.Biblioteca.models.Estudiante;
import com.ucc.Biblioteca.repositories.EstudianteRepository;
import com.ucc.Biblioteca.services.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapToEntity(estudianteDTO);
        estudianteRepository.save(estudiante);
        return mapToDTO(estudiante);
    }

    @Override
    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //Para traer la información de la BD
    private EstudianteDTO mapToDTO(Estudiante estudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        //estudianteDTO.setId(estudiante.getId());
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setApellido(estudiante.getApellido());
        estudianteDTO.setCorreo(estudiante.getCorreo());
        estudianteDTO.setPass(estudiante.getPass());
        return estudianteDTO;
    }

    //Para crear
    private Estudiante mapToEntity(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setApellido(estudianteDTO.getApellido());
        estudiante.setCorreo(estudianteDTO.getCorreo());
        estudiante.setPass(estudianteDTO.getPass());
        return estudiante;
    }
}
