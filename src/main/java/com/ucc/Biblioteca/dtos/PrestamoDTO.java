package com.ucc.Biblioteca.dtos;

import java.time.LocalDate;

public class PrestamoDTO {
    private int estudianteID;
    private int libroID;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public PrestamoDTO() {
    }

    public PrestamoDTO(int estudianteID, int libroID, LocalDate fechaPrestamo) {
        this.estudianteID = estudianteID;
        this.libroID = libroID;
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "PrestamoDTO{" +
                "estudianteID=" + estudianteID +
                ", libroID=" + libroID +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
