package com.apiservi.siseduBackend.dto;

public class ErrorDTO extends Exception{

    private Integer codError;
    private String mensajeError;

    public ErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public ErrorDTO(Throwable cause) {
        super(cause);
    }

    public Integer getCodError() {
        return codError;
    }

    public void setCodError(Integer codError) {
        this.codError = codError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
