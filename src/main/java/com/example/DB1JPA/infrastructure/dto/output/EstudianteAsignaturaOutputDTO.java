package com.example.DB1JPA.infrastructure.dto.output;

import com.example.DB1JPA.domain.Asignatura;
import com.example.DB1JPA.domain.Estudiante;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstudianteAsignaturaOutputDTO {

    private String id_estudiante;
    private List<Asignatura> asignaturas;

    public EstudianteAsignaturaOutputDTO(Estudiante estudiante)
    {
        setId_estudiante(estudiante.getId());
        setAsignaturas(estudiante.getAsignaturas());
    }
}
