package com.ucc.Biblioteca.services;

import com.ucc.Biblioteca.dtos.PrestamoDTO;

import java.util.List;

public interface PrestamoService {
    PrestamoDTO createPrestamo(PrestamoDTO prestamoDTO);
    List<PrestamoDTO> findAll();
}
