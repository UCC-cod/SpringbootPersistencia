package com.ucc.Biblioteca.services;

import com.ucc.Biblioteca.dtos.LibroDTO;

import java.util.List;

public interface LibroService {
    LibroDTO createLibro(LibroDTO libroDTO);
    List<LibroDTO> findAll();
}
