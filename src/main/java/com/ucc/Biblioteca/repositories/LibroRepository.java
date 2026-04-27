package com.ucc.Biblioteca.repositories;

import com.ucc.Biblioteca.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
}
