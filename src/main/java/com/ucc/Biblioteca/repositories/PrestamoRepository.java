package com.ucc.Biblioteca.repositories;

import com.ucc.Biblioteca.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}
