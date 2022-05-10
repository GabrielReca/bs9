package com.example.DB1JPA.application.port;

import com.example.DB1JPA.domain.Persona;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.ProfesorOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.ProfesorPersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO buscarPorID(int id) throws Exception;
    List<PersonaOutputDTO> busquedaTodos();

    EstudiantePersonaOutputDTO buscarAlumnoAsociado(int id) throws Exception;
    EstudiantePersonaOutputDTO buscarAlumnoAsociadoPorUsuario(String usuario) throws Exception;

    ProfesorPersonaOutputDTO buscarProfesorAsociadoporUsuario(String usuario) throws Exception;
    ProfesorPersonaOutputDTO buscarProfesorAsociado(int id) throws Exception;
    Persona GETgetProfesor(int id);

    PersonaOutputDTO busquedaUsuario(String usuario) throws Exception;
    PersonaOutputDTO eliminarUsuario(int id) throws Exception;
}
