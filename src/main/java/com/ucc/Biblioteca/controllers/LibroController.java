package com.ucc.Biblioteca.controllers;

import com.ucc.Biblioteca.dtos.LibroDTO;
import com.ucc.Biblioteca.services.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
@CrossOrigin
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public LibroDTO createLibro(@RequestBody LibroDTO libroDTO) {
        return libroService.createLibro(libroDTO);
    }

    @GetMapping
    public List<LibroDTO> getLibros() {
        return libroService.findAll();
    }
}
