package com.ucc.Biblioteca.services.impl;

import com.ucc.Biblioteca.dtos.EstudianteDTO;
import com.ucc.Biblioteca.models.Estudiante;
import com.ucc.Biblioteca.repositories.EstudianteRepository;
import com.ucc.Biblioteca.services.EstudianteService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final PasswordEncoder passwordEncoder;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository,  PasswordEncoder passwordEncoder) {
        this.estudianteRepository = estudianteRepository;
        this.passwordEncoder = passwordEncoder;
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
        return estudianteDTO;
    }

    //Para crear
    private Estudiante mapToEntity(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setApellido(estudianteDTO.getApellido());
        estudiante.setCorreo(estudianteDTO.getCorreo());
        estudiante.setPass(passwordEncoder.encode(estudianteDTO.getPass()));
        return estudiante;
    }
}
