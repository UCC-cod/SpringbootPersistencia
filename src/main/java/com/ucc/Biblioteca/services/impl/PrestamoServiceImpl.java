package com.ucc.Biblioteca.services.impl;

import com.ucc.Biblioteca.dtos.PrestamoDTO;
import com.ucc.Biblioteca.models.Estudiante;
import com.ucc.Biblioteca.models.Libro;
import com.ucc.Biblioteca.models.Prestamo;
import com.ucc.Biblioteca.repositories.EstudianteRepository;
import com.ucc.Biblioteca.repositories.LibroRepository;
import com.ucc.Biblioteca.repositories.PrestamoRepository;
import com.ucc.Biblioteca.services.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final EstudianteRepository estudianteRepository;
    private final LibroRepository libroRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository,  EstudianteRepository estudianteRepository,  LibroRepository libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.estudianteRepository = estudianteRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public PrestamoDTO createPrestamo(PrestamoDTO prestamoDTO) {
        return null;
    }

    @Override
    public List<PrestamoDTO> findAll() {
        return List.of();
    }

    private PrestamoDTO mapToDTO(Prestamo prestamo) {
        PrestamoDTO prestamoDTO = new PrestamoDTO();
        prestamoDTO.setEstudianteID(prestamo.getEstudiante().getId());
        prestamoDTO.setLibroID(prestamo.getLibro().getId());
        prestamoDTO.setFechaPrestamo(prestamo.getFechaPrestamo());
        prestamoDTO.setFechaDevolucion(prestamo.getFechaDevolucion());
        return prestamoDTO;
    }

    private Prestamo mapToEntity(PrestamoDTO prestamoDTO) {
        Prestamo prestamo = new Prestamo();

        Estudiante estudiante = estudianteRepository
                .findById(prestamoDTO.getEstudianteID())
                .orElseThrow(()-> new RuntimeException("Estudiante no encontrado"));


        Libro libro = libroRepository
                .findById(prestamoDTO.getLibroID())
                .orElseThrow(()-> new RuntimeException("Libro no encontrado"));

        prestamo.setEstudiante(estudiante);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
        prestamo.setFechaDevolucion(prestamoDTO.getFechaDevolucion());
        return prestamo;
    }
}
