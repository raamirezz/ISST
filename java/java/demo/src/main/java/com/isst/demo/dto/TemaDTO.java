package com.isst.demo.dto;

import java.time.LocalDateTime;
import java.util.List;



public class TemaDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private Boolean isImportant;
    private List<ComentariosDTO> comentarios;

    // Constructor vacío (obligatorio para JPA)
    public TemaDTO() {
    }

    // Constructor con todos los campos
    public TemaDTO(Long id, String titulo, String descripcion, LocalDateTime fechaCreacion, Boolean isImportant, List<ComentariosDTO> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.isImportant = isImportant;
        this.comentarios = comentarios;
    }

    // Constructor sin ID
    public TemaDTO(String titulo, String descripcion, LocalDateTime fechaCreacion, Boolean isImportant, List<ComentariosDTO> comentarios) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.isImportant = isImportant;
        this.comentarios = comentarios;
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

    public Boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
    }

    public List<ComentariosDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentariosDTO> comentarios) {
        this.comentarios = comentarios;
    }


    // Método toString()

    @Override
    public String toString() {
        return "TemaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", isImportant=" + isImportant +
                '}';
    }
}
