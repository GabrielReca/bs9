package com.example.DB1JPA.infrastructure.dto.input;

import com.example.DB1JPA.domain.Persona;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorInputDTO implements Serializable
{
    private String id_profesor;

    private String comentarios;

    private String rama;

    private Persona persona;

    /*private List<String> id_estudiante;*/
}
