package com.apiservi.siseduBackend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "profesion")
@Entity
public class Profesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nIdProfesion", nullable = false)
    private Integer nIdProfesion;

    @Column(name = "sDescripcion", nullable = false, length = 100)
    private String sDescripcion;

    @Column(name = "sEstado", nullable = false, length = 2)
    private String sEstado;

    @Column(name = "dFechaCreacion", nullable = false)
    private Timestamp dFechaCreacion;

    @Column(name = "sUsuarioCreador", nullable = false, length = 100)
    private String sUsuarioCreador;

    @Column(name = "dFechaModificacion")
    private Timestamp dFechaModificacion;

    @Column(name = "sUsuarioModifica", length = 100)
    private String sUsuarioModifica;

    @Column(name = "dFechaEliminado")
    private Timestamp dFechaEliminado;

    @Column(name = "sUsuarioElimina", length = 100)
    private String sUsuarioElimina;

    @Column(name = "ant_Profesion_Cod_Profesion", length = 100)
    private String antProfesionCodProfesion;

    @OneToMany(mappedBy = "nIdProfesion", cascade = CascadeType.ALL)
    private List<Persona> personas;

    public String getAntProfesionCodProfesion() {
        return antProfesionCodProfesion;
    }

    public void setAntProfesionCodProfesion(String antProfesionCodProfesion) {
        this.antProfesionCodProfesion = antProfesionCodProfesion;
    }

    public String getSUsuarioElimina() {
        return sUsuarioElimina;
    }

    public void setSUsuarioElimina(String sUsuarioElimina) {
        this.sUsuarioElimina = sUsuarioElimina;
    }

    public Timestamp getDFechaEliminado() {
        return dFechaEliminado;
    }

    public void setDFechaEliminado(Timestamp dFechaEliminado) {
        this.dFechaEliminado = dFechaEliminado;
    }

    public String getSUsuarioModifica() {
        return sUsuarioModifica;
    }

    public void setSUsuarioModifica(String sUsuarioModifica) {
        this.sUsuarioModifica = sUsuarioModifica;
    }

    public Timestamp getDFechaModificacion() {
        return dFechaModificacion;
    }

    public void setDFechaModificacion(Timestamp dFechaModificacion) {
        this.dFechaModificacion = dFechaModificacion;
    }

    public String getSUsuarioCreador() {
        return sUsuarioCreador;
    }

    public void setSUsuarioCreador(String sUsuarioCreador) {
        this.sUsuarioCreador = sUsuarioCreador;
    }

    public Timestamp getDFechaCreacion() {
        return dFechaCreacion;
    }

    public void setDFechaCreacion(Timestamp dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public String getSEstado() {
        return sEstado;
    }

    public void setSEstado(String sEstado) {
        this.sEstado = sEstado;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public Integer getnIdProfesion() {
        return nIdProfesion;
    }

    public void setnIdProfesion(Integer nIdProfesion) {
        this.nIdProfesion = nIdProfesion;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
