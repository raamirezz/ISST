package com.isst.demo.entity;



//import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "votaciones")
public class Votaciones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;
    private int votosFavor;
    private int votosContra;
    private LocalDateTime fechaCreacion;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "votacion_usuarios_votantes", joinColumns = @JoinColumn(name = "votacion_id"))
    @Column(name = "usuario")
    private Set<String> usuariosVotantes = new HashSet<>();

    public Votaciones() {}

    public Votaciones(String descripcion, int votosFavor, int votosContra, LocalDateTime fechaCreacion,
            Set<String> usuariosVotantes) {
        this.descripcion = descripcion;
        this.votosFavor = votosFavor;
        this.votosContra = votosContra;
        this.fechaCreacion = fechaCreacion;
        this.usuariosVotantes = usuariosVotantes;
    }

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

    public int getVotosFavor() {
        return votosFavor;
    }

    public void setVotosFavor(int votosFavor) {
        this.votosFavor = votosFavor;
    }

    public int getVotosContra() {
        return votosContra;
    }

    public void setVotosContra(int votosContra) {
        this.votosContra = votosContra;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set<String> getUsuariosVotantes() {
        return usuariosVotantes;
    }

    public void setUsuariosVotantes(Set<String> usuariosVotantes) {
        this.usuariosVotantes = usuariosVotantes;
    }

    @Override
    public String toString() {
        return "Votaciones [id=" + id + ", descripcion=" + descripcion + ", votosFavor=" + votosFavor + ", votosContra="
                + votosContra + ", fechaCreacion=" + fechaCreacion + ", usuariosVotantes=" + usuariosVotantes + "]";
    }

    


    
    
}