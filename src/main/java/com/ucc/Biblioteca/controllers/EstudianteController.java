package com.ucc.Biblioteca.controllers;

import com.ucc.Biblioteca.dtos.EstudianteDTO;
import com.ucc.Biblioteca.services.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<String> createEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        try{
            EstudianteDTO estudianteDTOSave = estudianteService.createEstudiante(estudianteDTO);
            if(estudianteDTOSave != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(estudianteDTOSave.toString());
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear estudiante");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de servidor");
        }
    }

    @GetMapping
    public ResponseEntity<Object> getEstudiante() {
        try{
            //Correcto
            List<EstudianteDTO> estudianteDTO = estudianteService.findAll();
            if(estudianteDTO.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiantes no encontrados");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(estudianteDTO);
            }
        }catch (Exception e){
            //Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de servidor");
        }
    }
}
