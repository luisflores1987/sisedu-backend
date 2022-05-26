package com.apiservi.siseduBackend.service;

import com.apiservi.siseduBackend.dto.PersonaDTO;
import com.apiservi.siseduBackend.utilitarios.Constantes;
import com.apiservi.siseduBackend.dto.ErrorDTO;
import com.apiservi.siseduBackend.entity.Persona;
import com.apiservi.siseduBackend.repository.PersonaRepository;
import com.apiservi.siseduBackend.utilitarios.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    private List<Persona> listPersona(){
        return personaRepository.findAll();
    }

    private Optional<Persona> findById(int id) {
        return personaRepository.findById(id);
    }

    private Optional<Persona> findByName(String nombre) {
        return personaRepository.findBysNombres(nombre);
    }

    @Override
    public Map<String, Object> mapResultfindPersona() {
        Map<String, Object> mapResultado = new HashMap<String, Object>();
        List<Persona>  listPersona = new ArrayList<Persona>();
        List<PersonaDTO>  listPersonaDto = new ArrayList<PersonaDTO>();
        try {
            listPersona = this.listPersona();
            listPersonaDto = this.lstPersonaDTO(listPersona);
            if(CollectionUtils.isEmpty(listPersonaDto)){
                mapResultado.put("resultado", new ErrorDTO("No existe Data"));
                return mapResultado;
            }
        }catch (Exception e){
            mapResultado.put("resultado", new ErrorDTO(e));
            return mapResultado;
        }

        mapResultado.put("resultado",listPersonaDto);
        return mapResultado;
    }

    @Override
    public Map<String, Object> mapResultfindById(int id) {
        Map<String, Object> mapResultado = new HashMap<String, Object>();
        Optional<Persona> oPersona;
        try {
            oPersona = this.findById(id);
            if(oPersona.isPresent()){
                mapResultado.put("resultado", new ErrorDTO("No existe Persona"));
                return mapResultado;
            }
        }catch (Exception e){
            mapResultado.put("resultado", new ErrorDTO(e));
            return mapResultado;
        }
        mapResultado.put("resultado",oPersona);
        return mapResultado;
    }

    @Override
    public Map<String, Object> mapResultfindByName(String nombre) {
        Map<String, Object> mapResultado = new HashMap<String, Object>();
        List<Persona>  listPersona = new ArrayList<Persona>();
        List<PersonaDTO>  listPersonaDto = new ArrayList<PersonaDTO>();
        try {
            listPersona = personaRepository.findBysLikeNombres(nombre);
            listPersonaDto = this.lstPersonaDTO(listPersona);
            if(CollectionUtils.isEmpty(listPersonaDto)){
                mapResultado.put("resultado", new ErrorDTO("No existe Data"));
                return mapResultado;
            }
        }catch (Exception e){
            mapResultado.put("resultado", new ErrorDTO(e));
            return mapResultado;
        }

        mapResultado.put("resultado",listPersonaDto);
        return mapResultado;
    }

    @Override
    public Map<String, Object>  save(Map<String, String> mapPersona) {

        Map<String, Object> mapResultado = new HashMap<String, Object>();
        Map<String, Object> mapResultadoValidacion= this.validarParametros(mapPersona);
        Boolean esValidado = mapResultadoValidacion.get("error")!=null?(Boolean)mapResultadoValidacion.get("error"):false;
        if(esValidado){
            mapResultado.put("resultado", new ErrorDTO(mapResultadoValidacion.get("mensaje").toString()));
            return mapResultado;
        }
        try{
            String nombre =mapPersona.get("nombre");
            String apPaterno = mapPersona.get("apPaterno");
            String apMaterno = mapPersona.get("apPaterno");

            Persona persona = new Persona(apPaterno, apMaterno, nombre);
            this.save(persona);
            mapResultado.put("resultado", Constantes.GUARDO_SATISFACTORIAMENTE);
        }catch(Exception e){
            mapResultado.put("resultado", new ErrorDTO(e));
            return mapResultado;
        }
        return mapResultado;
    }

    private Map<String, Object> validarParametros(Map<String, String> mapPersona) {

        String mensajeError = "";

        Map<String, Object> mapResultado = new HashMap<String, Object>();

        if(StringUtils.isBlank(mapPersona.get("nombre"))){
            mapResultado.put("error", true);
            mensajeError =  mensajeError.concat(Constantes.ES_OBLIGATORIO_NOMBRE_PERSONA)+",\t";
        }
        if(StringUtils.isBlank(mapPersona.get("apPaterno"))){
            mapResultado.put("error", true);
            mensajeError =  mensajeError.concat(Constantes.ES_OBLIGATORIO_APELLIDO_PATERNO_PERSONA)+",\t";
        }
        if(StringUtils.isBlank( mapPersona.get("apMaterno"))){
            mapResultado.put("error", true);
            mensajeError =  mensajeError.concat(Constantes.ES_OBLIGATORIO_APELLIDO_MATERNO_PERSONA)+",\t";
        }
        if(this.existsByNombre(mapPersona.get("nombre"))){
            mapResultado.put("error", true);
            mensajeError =  mensajeError.concat(Constantes.NO_EXISTE_DATA)+",\t";
        }

        mapResultado.put("mensaje", mensajeError);

        return mapResultado;
    }

    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    public void delete(int id) {
        personaRepository.deleteById(id);
    }

    public Boolean existsById(int id) {
        return personaRepository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return personaRepository.existsBysNombres(nombre);
    }

    private List<PersonaDTO> lstPersonaDTO(List<Persona>  listPersona) throws ParseException {
        List<PersonaDTO>  listPersonaDto = new ArrayList<PersonaDTO>();
        for(Persona persona:listPersona){
            listPersonaDto.add(this.personaToPersonaDTO(persona));
        }
        return listPersonaDto;
    }

    private PersonaDTO personaToPersonaDTO(Persona persona) throws ParseException{
        Timestamp tFechaCreacion = persona.getDFechaCreacion();
        Date dFechaCreacion = tFechaCreacion;
        /*formatear la fecha*/
        String dateToStr = DateUtils.dateToString(dFechaCreacion, Constantes.FORMATOFECHAHORAYYYYMMDD);
        return new PersonaDTO(
                persona.getSNombres(),
                persona.getSApellidoPaterno(),
                persona.getSApellidoMaterno(),
                dateToStr);
    }
}
