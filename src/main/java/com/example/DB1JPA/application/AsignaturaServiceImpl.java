package com.example.DB1JPA.application;

import com.example.DB1JPA.application.port.AsignaturaService;
import com.example.DB1JPA.domain.Estudiante;
import com.example.DB1JPA.domain.Asignatura;
import com.example.DB1JPA.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;
import com.example.DB1JPA.infrastructure.repository.AsignaturaRepository;
import com.example.DB1JPA.infrastructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepository ar;

    @Autowired
    EstudianteRepository er;

    @Override
    public EstudianteAsignaturaOutputDTO buscarAsignaturasPorID(String id) {
        Estudiante estudiante = er.findById(id).get();
        EstudianteAsignaturaOutputDTO estudianteAsignaturaOutputDTO = new EstudianteAsignaturaOutputDTO(estudiante);
        return estudianteAsignaturaOutputDTO;
    }

    @Override
    public AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO estudianteAsignaturaInputDTO) {
        Asignatura estudianteAsignatura = new Asignatura(estudianteAsignaturaInputDTO);
        ar.save(estudianteAsignatura);
        AsignaturaOutputDTO estudianteAsignaturaOutputDTO = new AsignaturaOutputDTO(estudianteAsignatura);
        return estudianteAsignaturaOutputDTO;
    }
}
