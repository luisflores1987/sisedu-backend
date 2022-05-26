package com.apiservi.siseduBackend.service;

import com.apiservi.siseduBackend.entity.Persona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonaService {
    Map<String, Object> mapResultfindPersona();
    Map<String, Object> mapResultfindById(int id);
    Map<String, Object> mapResultfindByName(String nombre);
    Map<String, Object>  save(Map<String, String> mapPersona);
    public void delete(int id);
    Boolean existsById(int id);
    boolean existsByNombre(String nombre);
}
