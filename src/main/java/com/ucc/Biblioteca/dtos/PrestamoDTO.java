package com.ucc.Biblioteca.dtos;

import java.util.Date;

public class PrestamoDTO {
    private int estudianteID;
    private int libroID;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public PrestamoDTO() {
    }

    public PrestamoDTO(int estudianteID, int libroID, Date fechaPrestamo) {
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

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
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
