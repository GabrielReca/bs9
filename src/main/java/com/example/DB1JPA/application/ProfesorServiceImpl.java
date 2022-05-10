package com.example.DB1JPA.application;

import com.example.DB1JPA.application.port.ProfesorService;
import com.example.DB1JPA.domain.Estudiante;
import com.example.DB1JPA.domain.Persona;
import com.example.DB1JPA.domain.Profesor;
import com.example.DB1JPA.infrastructure.dto.input.ProfesorInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.ProfesorOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.ProfesorPersonaOutputDTO;
import com.example.DB1JPA.infrastructure.repository.PersonaRepository;
import com.example.DB1JPA.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository pfr;

    @Autowired
    PersonaRepository pr;

    @Override
    public ProfesorOutputDTO buscarPorID(String id) throws Exception {
        Profesor profesor = pfr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    @Override
    public ProfesorOutputDTO buscarPorID_Persona(int id) throws Exception {
        Profesor profesor = pr.findById(id).get().getProfesor();
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    @Override
    public ProfesorPersonaOutputDTO buscarPorIDFull(String id) throws Exception {
        /*Persona persona = pr.findById(id).get();
        Profesor profesor = persona.getProfesor();
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(profesor, persona);*/
        return null;
    }

    @Override
    public List<ProfesorPersonaOutputDTO> buscarTodosFull() {
        List<Profesor> listaPro = (List<Profesor>) pfr.findAll();
        List<ProfesorPersonaOutputDTO> listaOutput = new ArrayList<>();

        for(Profesor i: listaPro)
        {
            Persona persona = i.getPersona();
            ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(i, persona);
            listaOutput.add(profesorPersonaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public ProfesorOutputDTO anhadirProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Profesor profesor = new Profesor(profesorInputDTO);
        pfr.save(profesor);
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    @Override
    public ProfesorOutputDTO modificarProfesor(String id, ProfesorInputDTO profesorInputDTO) throws Exception {
        if(profesorInputDTO.getId_profesor() == null)
            throw new Exception("usuario puede ser nulo");
        else if(profesorInputDTO.getId_profesor().length() > 10)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            pfr.deleteById(id);
            Profesor profesor = new Profesor(profesorInputDTO);
            pfr.save(profesor);
            ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
            return profesorOutputDTO;
        }
    }

    @Override
    public ProfesorOutputDTO eliminarProfesor(String id) throws Exception {
        Profesor profesor = pfr.findById(id).get();
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        pfr.deleteById(id);
        return profesorOutputDTO;
    }
}
