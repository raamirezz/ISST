package com.isst.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import java.util.List;

@Entity
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int codigo;
    private String calle;
    private String provincia;

    @ElementCollection
    private List<String> instalaciones;

    // Constructor, getters y setters

    public Comunidad() {
    }

    public Comunidad(int codigo, String calle, String provincia, List<String> instalaciones) {
        this.codigo = codigo;
        this.calle = calle;
        this.provincia = provincia;
        this.instalaciones = instalaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public List<String> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<String> instalaciones) {
        this.instalaciones = instalaciones;
    }
}
