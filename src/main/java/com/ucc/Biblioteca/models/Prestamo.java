package com.ucc.Biblioteca.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="estudiante_id", nullable=false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="libro_id", nullable=false)
    private Libro libro;

    @Column(nullable = false)
    private Date fechaPrestamo;

    @Column(nullable = true)
    private Date fechaDevolucion;


}
