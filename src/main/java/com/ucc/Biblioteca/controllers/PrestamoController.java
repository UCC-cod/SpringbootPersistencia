package com.ucc.Biblioteca.controllers;

import com.ucc.Biblioteca.dtos.PrestamoDTO;
import com.ucc.Biblioteca.services.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
@CrossOrigin
public class PrestamoController {
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public PrestamoDTO createPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        return prestamoService.createPrestamo(prestamoDTO);
    }

    @GetMapping
    public List<PrestamoDTO> getPrestamo() {
        return prestamoService.findAll();
    }
}
