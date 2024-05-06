package com.isst.demo.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDTO {
    private Long id;
    private boolean disponible;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private String hora;
    private String tipo_instalacion;
    private String usuario;

    // Constructor, getters y setters
    public ReservaDTO() {
    }

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
