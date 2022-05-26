package com.apiservi.siseduBackend.dto;

import java.util.Date;

public class PersonaDTO {

    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String sFechaCreacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getsFechaCreacion() {
        return sFechaCreacion;
    }

    public void setsFechaCreacion(String sFechaCreacion) {
        this.sFechaCreacion = sFechaCreacion;
    }

    public PersonaDTO(String nombre, String apPaterno, String apMaterno, String sFechaCreacion) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.sFechaCreacion = sFechaCreacion;
    }
}
