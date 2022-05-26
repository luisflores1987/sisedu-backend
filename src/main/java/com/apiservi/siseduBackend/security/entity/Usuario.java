package com.apiservi.siseduBackend.security.entity;

import com.apiservi.siseduBackend.entity.Persona;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nIdUsuario", nullable = false)
    private Integer id;

    @ManyToOne
    private Persona nIdPersona;

    @Column(name = "sUsername", nullable = false, length = 100)
    private String sUsername;

    @Column(name = "sPassword", length = 8000)
    private String sPassword;

    @Column(name = "sEstado", nullable = false, length = 2)
    private String sEstado;

    @Column(name = "nIdPregunta")
    private Integer nIdPregunta;

    @Column(name = "sRespuesta", length = 1000)
    private String sRespuesta;

    @Column(name = "sCorreo")
    private String sCorreo;

    @Column(name = "dFechaCreacion", nullable = false)
    private Timestamp dFechaCreacion;

    @Column(name = "sUsuarioCreador", nullable = false, length = 100)
    private String sUsuarioCreador;

    @Column(name = "nIdCliente")
    private Integer nIdCliente;

    @Column(name = "nIdProveedor")
    private Integer nIdProveedor;

    @Column(name = "dFechaModificacion")
    private Timestamp dFechaModificacion;

    @Column(name = "sUsuarioModifica", length = 100)
    private String sUsuarioModifica;

    @Column(name = "dFechaEliminado")
    private Timestamp dFechaEliminado;

    @Column(name = "sUsuarioElimina", length = 100)
    private String sUsuarioElimina;

    @Column(name = "nIdTipoAcceso")
    private Integer nIdTipoAcceso;

    @Column(name = "sAplicativo", length = 100)
    private String sAplicativo;

    public String getSAplicativo() {
        return sAplicativo;
    }

    public void setSAplicativo(String sAplicativo) {
        this.sAplicativo = sAplicativo;
    }

    public Integer getNIdTipoAcceso() {
        return nIdTipoAcceso;
    }

    public void setNIdTipoAcceso(Integer nIdTipoAcceso) {
        this.nIdTipoAcceso = nIdTipoAcceso;
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

    public Integer getNIdProveedor() {
        return nIdProveedor;
    }

    public void setNIdProveedor(Integer nIdProveedor) {
        this.nIdProveedor = nIdProveedor;
    }

    public Integer getNIdCliente() {
        return nIdCliente;
    }

    public void setNIdCliente(Integer nIdCliente) {
        this.nIdCliente = nIdCliente;
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

    public String getSCorreo() {
        return sCorreo;
    }

    public void setSCorreo(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public String getSRespuesta() {
        return sRespuesta;
    }

    public void setSRespuesta(String sRespuesta) {
        this.sRespuesta = sRespuesta;
    }

    public Integer getNIdPregunta() {
        return nIdPregunta;
    }

    public void setNIdPregunta(Integer nIdPregunta) {
        this.nIdPregunta = nIdPregunta;
    }

    public String getSEstado() {
        return sEstado;
    }

    public void setSEstado(String sEstado) {
        this.sEstado = sEstado;
    }

    public String getSPassword() {
        return sPassword;
    }

    public void setSPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getSUsername() {
        return sUsername;
    }

    public void setSUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public Persona getNIdPersona() {
        return nIdPersona;
    }

    public void setNIdPersona(Persona nIdPersona) {
        this.nIdPersona = nIdPersona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}