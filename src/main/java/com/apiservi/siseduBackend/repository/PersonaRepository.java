package com.apiservi.siseduBackend.repository;

import com.apiservi.siseduBackend.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findBysNombres(String nombre);
    @Query(value = "Select * from Persona p where p.s_nombres like %?1%", nativeQuery = true)
    List<Persona> findBysLikeNombres(String nombre);
    Boolean existsById(int id);
    boolean existsBysNombres(String nombre);
}
