package com.ucc.Biblioteca.repositories;

import com.ucc.Biblioteca.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
}
