package com.isst.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Column; // Importamos la anotación @Column

import java.util.List;

@Entity
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "community_code") // Mapeamos el nombre de la columna en la base de datos
    private String communityCode; // Cambiamos el nombre del atributo

    private String calle;
    private String provincia;
    private boolean hasPiscina;
    private boolean hasTenis;
    private boolean hasPadel;
    private boolean hasGym;
    private boolean hasLocalEventos;

    // Constructor, getters y setters

    public Comunidad() {
    }

    public Comunidad(String communityCode, String calle, String provincia,
                     boolean hasPiscina, boolean hasTenis, boolean hasPadel,
                     boolean hasGym, boolean hasLocalEventos) {
        this.communityCode = communityCode;
        this.calle = calle;
        this.provincia = provincia;
        this.hasPiscina = hasPiscina;
        this.hasTenis = hasTenis;
        this.hasPadel = hasPadel;
        this.hasGym = hasGym;
        this.hasLocalEventos = hasLocalEventos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean isHasPiscina() {
        return hasPiscina;
    }

    public void setHasPiscina(boolean hasPiscina) {
        this.hasPiscina = hasPiscina;
    }

    public boolean isHasTenis() {
        return hasTenis;
    }

    public void setHasTenis(boolean hasTenis) {
        this.hasTenis = hasTenis;
    }

    public boolean isHasPadel() {
        return hasPadel;
    }

    public void setHasPadel(boolean hasPadel) {
        this.hasPadel = hasPadel;
    }

    public boolean isHasGym() {
        return hasGym;
    }

    public void setHasGym(boolean hasGym) {
        this.hasGym = hasGym;
    }

    public boolean isHasLocalEventos() {
        return hasLocalEventos;
    }

    public void setHasLocalEventos(boolean hasLocalEventos) {
        this.hasLocalEventos = hasLocalEventos;
    }
}
