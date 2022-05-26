package com.apiservi.siseduBackend.controller;

import com.apiservi.siseduBackend.dto.Mensaje;
import com.apiservi.siseduBackend.dto.PersonaDTO;
import com.apiservi.siseduBackend.entity.Persona;
import com.apiservi.siseduBackend.service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {


    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> list(){
        Map<String, Object> mapResultado = personaService.mapResultfindPersona();
        /*List<Persona> list = (List<Persona>) mapResultado.get("resultado");*/
        return new ResponseEntity(mapResultado, HttpStatus.OK);
    }

/*   @GetMapping("/detail/{idPersona}")
    public ResponseEntity<Persona> getByIdPersona(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.findById(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }*/

    @GetMapping("/detail/{nombre}")
    public ResponseEntity<Persona> getByIdPersona(@PathVariable("nombre") String nombre){
        if(!personaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe nombre"), HttpStatus.NOT_FOUND);
        Map<String, Object> mapResultado = personaService.mapResultfindByName(nombre);
        /*List<Persona> list = (List<Persona>) mapResultado.get("resultado");*/
        return new ResponseEntity(mapResultado, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPersona(@RequestBody PersonaDTO personadto){

        /*verificar si existe la persona*/
        String nombre = StringUtils.defaultString(personadto.getNombre());
        String apPaterno = StringUtils.defaultString(personadto.getApPaterno());
        String apMaterno = StringUtils.defaultString(personadto.getApMaterno());

        Map<String, String> mapParameter = new HashMap<String, String>();
        mapParameter.put("nombre",nombre);
        mapParameter.put("apPaterno",apPaterno);
        mapParameter.put("apMaterno",apMaterno);
        Map<String, Object> mapResultado = personaService.save(mapParameter);

        return new ResponseEntity(mapResultado.get("resultado"), HttpStatus.OK);
    }

}
