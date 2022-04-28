package com.example.DB1JPA.repository;

import com.example.DB1JPA.clases.Persona;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    Persona buscarPersona(String usuario);

}