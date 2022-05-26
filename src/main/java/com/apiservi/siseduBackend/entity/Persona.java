package com.apiservi.siseduBackend.entity;

import com.apiservi.siseduBackend.security.entity.Usuario;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Table(name = "persona")
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nIdPersona", nullable = false)
    private Integer nIdPersona;

    @Column(name = "nSexo", nullable = false, length = 2)
    private String nSexo;

    @Column(name = "sApellidoPaterno", nullable = false, length = 100)
    private String sApellidoPaterno;

    @Column(name = "sApellidoMaterno", nullable = false, length = 100)
    private String sApellidoMaterno;

    @Column(name = "sNombres", nullable = false, length = 100)
    private String sNombres;

    @Column(name = "sNombreCompleto", nullable = false, length = 100)
    private String sNombreCompleto;

    @Column(name = "sNumeroDocumento", length = 100)
    private String sNumeroDocumento;

    @Column(name = "nIdEstadoCivil")
    private Integer nIdEstadoCivil;

    @Column(name = "nIdGradoInstruccion")
    private Integer nIdGradoInstruccion;

    @ManyToOne
    private Profesion nIdProfesion;

    @OneToMany(mappedBy = "nIdPersona", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @Column(name = "dFechaNac")
    private Date dFechaNac;

    @Column(name = "sTelefono", length = 100)
    private String sTelefono;

    @Column(name = "sCorreoPersonal", length = 100)
    private String sCorreoPersonal;

    @Column(name = "sCorreoTrabajo", length = 100)
    private String sCorreoTrabajo;

    @Column(name = "sEstado", nullable = false, length = 2)
    private String sEstado;

    @Column(name = "nIdPersonaM")
    private Long nIdPersonaM;

    @Column(name = "sUsuarioCreador", length = 100)
    private String sUsuarioCreador;

    @Column(name = "dFechaCreacion")
    private Timestamp dFechaCreacion;

    @Column(name = "sUsuarioModifica", length = 100)
    private String sUsuarioModifica;

    @Column(name = "dFechaModificacion")
    private Timestamp dFechaModificacion;

    @Column(name = "sUsuarioElimina", length = 100)
    private String sUsuarioElimina;

    @Column(name = "dFechaEliminado")
    private Timestamp dFechaEliminado;

    public Persona(){}

    public Persona(String sApellidoPaterno, String sApellidoMaterno, String sNombres) {
        this.sApellidoPaterno = sApellidoPaterno;
        this.sApellidoMaterno = sApellidoMaterno;
        this.sNombres = sNombres;
    }

    public Timestamp getDFechaEliminado() {
        return dFechaEliminado;
    }

    public void setDFechaEliminado(Timestamp dFechaEliminado) {
        this.dFechaEliminado = dFechaEliminado;
    }

    public String getSUsuarioElimina() {
        return sUsuarioElimina;
    }

    public void setSUsuarioElimina(String sUsuarioElimina) {
        this.sUsuarioElimina = sUsuarioElimina;
    }

    public Timestamp getDFechaModificacion() {
        return dFechaModificacion;
    }

    public void setDFechaModificacion(Timestamp dFechaModificacion) {
        this.dFechaModificacion = dFechaModificacion;
    }

    public String getSUsuarioModifica() {
        return sUsuarioModifica;
    }

    public void setSUsuarioModifica(String sUsuarioModifica) {
        this.sUsuarioModifica = sUsuarioModifica;
    }

    public Timestamp getDFechaCreacion() {
        return dFechaCreacion;
    }

    public void setDFechaCreacion(Timestamp dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public String getSUsuarioCreador() {
        return sUsuarioCreador;
    }

    public void setSUsuarioCreador(String sUsuarioCreador) {
        this.sUsuarioCreador = sUsuarioCreador;
    }

    public Long getNIdPersonaM() {
        return nIdPersonaM;
    }

    public void setNIdPersonaM(Long nIdPersonaM) {
        this.nIdPersonaM = nIdPersonaM;
    }

    public String getSEstado() {
        return sEstado;
    }

    public void setSEstado(String sEstado) {
        this.sEstado = sEstado;
    }

    public String getSCorreoTrabajo() {
        return sCorreoTrabajo;
    }

    public void setSCorreoTrabajo(String sCorreoTrabajo) {
        this.sCorreoTrabajo = sCorreoTrabajo;
    }

    public String getSCorreoPersonal() {
        return sCorreoPersonal;
    }

    public void setSCorreoPersonal(String sCorreoPersonal) {
        this.sCorreoPersonal = sCorreoPersonal;
    }

    public String getSTelefono() {
        return sTelefono;
    }

    public void setSTelefono(String sTelefono) {
        this.sTelefono = sTelefono;
    }

    public Date getDFechaNac() {
        return dFechaNac;
    }

    public void setDFechaNac(Date dFechaNac) {
        this.dFechaNac = dFechaNac;
    }

    public Profesion getNIdProfesion() {
        return nIdProfesion;
    }

    public void setNIdProfesion(Profesion nIdProfesion) {
        this.nIdProfesion = nIdProfesion;
    }

    public Integer getNIdGradoInstruccion() {
        return nIdGradoInstruccion;
    }

    public void setNIdGradoInstruccion(Integer nIdGradoInstruccion) {
        this.nIdGradoInstruccion = nIdGradoInstruccion;
    }

    public Integer getNIdEstadoCivil() {
        return nIdEstadoCivil;
    }

    public void setNIdEstadoCivil(Integer nIdEstadoCivil) {
        this.nIdEstadoCivil = nIdEstadoCivil;
    }

    public String getSNumeroDocumento() {
        return sNumeroDocumento;
    }

    public void setSNumeroDocumento(String sNumeroDocumento) {
        this.sNumeroDocumento = sNumeroDocumento;
    }

    public String getSNombreCompleto() {
        return sNombreCompleto;
    }

    public void setSNombreCompleto(String sNombreCompleto) {
        this.sNombreCompleto = sNombreCompleto;
    }

    public String getSNombres() {
        return sNombres;
    }

    public void setSNombres(String sNombres) {
        this.sNombres = sNombres;
    }

    public String getSApellidoMaterno() {
        return sApellidoMaterno;
    }

    public void setSApellidoMaterno(String sApellidoMaterno) {
        this.sApellidoMaterno = sApellidoMaterno;
    }

    public String getSApellidoPaterno() {
        return sApellidoPaterno;
    }

    public void setSApellidoPaterno(String sApellidoPaterno) {
        this.sApellidoPaterno = sApellidoPaterno;
    }

    public String getNSexo() {
        return nSexo;
    }

    public void setNSexo(String nSexo) {
        this.nSexo = nSexo;
    }

    public Integer getnIdPersona() {
        return nIdPersona;
    }

    public void setnIdPersona(Integer nIdPersona) {
        this.nIdPersona = nIdPersona;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}