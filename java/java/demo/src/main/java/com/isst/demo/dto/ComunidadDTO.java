package com.isst.demo.dto;

import java.util.List;

public class ComunidadDTO {

    private String community_code;
    private String calle;
    private String provincia;
    private boolean hasPiscina;
    private boolean hasTenis;
    private boolean hasPadel;
    private boolean hasGym;
    private boolean hasLocalEventos;

    // Constructores, getters y setters

    public ComunidadDTO() {
    }

    public ComunidadDTO(String community_code, String calle, String provincia,
                        boolean hasPiscina, boolean hasTenis, boolean hasPadel,
                        boolean hasGym, boolean hasLocalEventos) {
        this.community_code = community_code;
        this.calle = calle;
        this.provincia = provincia;
        this.hasPiscina = hasPiscina;
        this.hasTenis = hasTenis;
        this.hasPadel = hasPadel;
        this.hasGym = hasGym;
        this.hasLocalEventos = hasLocalEventos;
    }

    public String getCommunityCode() {
        return community_code;
    }

    public void setCommunityCode(String community_code) {
        this.community_code = community_code;
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
