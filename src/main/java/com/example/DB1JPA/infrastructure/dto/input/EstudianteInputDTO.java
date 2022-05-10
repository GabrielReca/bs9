package com.example.DB1JPA.infrastructure.dto.input;

import com.example.DB1JPA.domain.Asignatura;
import com.example.DB1JPA.domain.Persona;
import com.example.DB1JPA.domain.Profesor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class EstudianteInputDTO implements Serializable {

    private String id;

    private int numeroHorasSemanales;

    private String rama;

    private String comentarios;

    private Persona persona;

    private Profesor profesor;

    private List<Asignatura> asignaturas;

}
