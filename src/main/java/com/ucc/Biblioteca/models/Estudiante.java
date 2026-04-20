package com.ucc.Biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(nullable = true, length = 100)
    private String nombre;

    @Column(nullable = true, length = 100)
    private String apellido;

    @Column(nullable = true, length = 150, unique = true)
    private String correo;

    @Column(nullable = true, length = 100)
    private String pass;

    public Estudiante(String nombre, int id, String apellido, String correo, String pass) {
        this.nombre = nombre;
        this.id = id;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
    }

    public Estudiante() {}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
