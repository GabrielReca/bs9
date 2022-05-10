package com.example.DB1JPA.application.port;

import com.example.DB1JPA.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;

public interface AsignaturaService {
    EstudianteAsignaturaOutputDTO buscarAsignaturasPorID(String id);

    AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO estudianteAsignaturaInputDTO);
}
