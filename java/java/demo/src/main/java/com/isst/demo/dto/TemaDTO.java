package com.isst.demo.dto;

import java.time.LocalDateTime;

public class TemaDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    // Constructor vacío (obligatorio para JPA)
    public TemaDTO() {
    }

    // Constructor con todos los campos
    public TemaDTO(Long id, String titulo, String descripcion, LocalDateTime fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    // Constructor sin ID
    public TemaDTO(String titulo, String descripcion, LocalDateTime fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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



    // Método toString()

    @Override
    public String toString() {
        return "TemaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
