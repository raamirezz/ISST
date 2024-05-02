package com.isst.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDTO {

    private Long id;
    private boolean disponible;
    private Date fecha;
    private String hora;
    private String tipo_instalacion;
    private String usuario;

    // Constructor
    public ReservaDTO() {
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    @JsonProperty("tipo_instalacion")
    public String getTipoInstalacion() {
        return tipo_instalacion;
    }

    public void setTipoInstalacion(String tipo_instalacion) {
        this.tipo_instalacion = tipo_instalacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
