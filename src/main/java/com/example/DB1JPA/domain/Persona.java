package com.example.DB1JPA.domain;

import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String company_email;
    @Column
    private String personal_email;
    @Column
    private String city;
    @Column
    private boolean active;
    @Column
    private Date created_date;
    @Column
    private String imagen_url;
    @Column
    private Date termination_date;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Profesor profesor;

    public Persona(PersonaInputDTO personaDTO)
    {
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.isActive());
        setCreated_date(personaDTO.getCreated_date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTermination_date());
        setEstudiante(personaDTO.getEstudiante());
        setProfesor(personaDTO.getProfesor());
    }
}
