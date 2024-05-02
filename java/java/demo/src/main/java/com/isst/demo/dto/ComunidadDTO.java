package com.isst.demo.dto;

import java.util.List;

public class ComunidadDTO {

    private int codigo;
    private String calle;
    private String provincia;
    private List<String> instalaciones;

    // Constructores, getters y setters

    public ComunidadDTO() {
    }

    public ComunidadDTO(int codigo, String calle, String provincia, List<String> instalaciones) {
        this.codigo = codigo;
        this.calle = calle;
        this.provincia = provincia;
        this.instalaciones = instalaciones;
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
