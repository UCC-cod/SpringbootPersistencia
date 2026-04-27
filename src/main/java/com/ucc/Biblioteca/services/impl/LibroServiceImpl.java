package com.ucc.Biblioteca.services.impl;

import com.ucc.Biblioteca.dtos.LibroDTO;
import com.ucc.Biblioteca.models.Libro;
import com.ucc.Biblioteca.repositories.LibroRepository;
import com.ucc.Biblioteca.services.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroDTO createLibro(LibroDTO libroDTO) {
        Libro  libro = mapToEntity(libroDTO);
        libroRepository.save(libro);
        return mapToDTO(libro);
    }

    @Override
    public List<LibroDTO> findAll() {
        return libroRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LibroDTO mapToDTO(Libro libro) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAutor(libro.getAutor());
        libroDTO.setIsbn(libro.getIsbn());
        libroDTO.setCantidad(libro.getCantidad());
        return libroDTO;
    }

    private Libro mapToEntity(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setIsbn(libroDTO.getIsbn());
        libro.setCantidad(libroDTO.getCantidad());
        return libro;
    }
}
