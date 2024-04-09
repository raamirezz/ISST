package com.isst.demo.dto;

import java.time.LocalDateTime;

public class ComentariosDTO {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private Long temaId;

    // Constructor vacío (obligatorio para JPA)
    public ComentariosDTO() {
    }

    // Constructor con todos los campos
    public ComentariosDTO(Long id, String descripcion, LocalDateTime fechaCreacion, Long temaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.temaId = temaId;
    }

    // Constructor sin ID
    public ComentariosDTO(String descripcion, LocalDateTime fechaCreacion, Long temaId) {
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.temaId = temaId;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }



    // Método toString()

    @Override
    public String toString() {
        return "ComentariosDTO{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", temaId=" + temaId +
                '}';
    }
}
