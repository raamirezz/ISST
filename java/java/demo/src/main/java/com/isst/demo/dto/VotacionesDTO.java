package com.isst.demo.dto;

import java.time.LocalDateTime;

public class VotacionesDTO {

    private Long id;
    private String descripcion;
    private int votosFavor;
    private int votosContra;
    private LocalDateTime fechaCreacion;
    private boolean puedeVotar;
    
    public VotacionesDTO(){}
    
    public VotacionesDTO(Long id, String descripcion, int votosFavor, int votosContra, LocalDateTime fechaCreacion,
            boolean puedeVotar) {
        this.id = id;
        this.descripcion = descripcion;
        this.votosFavor = votosFavor;
        this.votosContra = votosContra;
        this.fechaCreacion = fechaCreacion;
        this.puedeVotar = puedeVotar;
    }

    public VotacionesDTO(String descripcion, int votosFavor, int votosContra, LocalDateTime fechaCreacion,
            boolean puedeVotar) {
        this.descripcion = descripcion;
        this.votosFavor = votosFavor;
        this.votosContra = votosContra;
        this.fechaCreacion = fechaCreacion;
        this.puedeVotar = puedeVotar;
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

    public boolean isPuedeVotar() {
        return puedeVotar;
    }

    public void setPuedeVotar(boolean puedeVotar) {
        this.puedeVotar = puedeVotar;
    }

    @Override
    public String toString() {
        return "VotacionesDTO [id=" + id + ", descripcion=" + descripcion + ", votosFavor=" + votosFavor
                + ", votosContra=" + votosContra + ", fechaCreacion=" + fechaCreacion + ", puedeVotar=" + puedeVotar
                + "]";
    }

    


    

}
