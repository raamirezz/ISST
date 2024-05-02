package com.isst.demo.dto;

public class ReservaDTO {

    private String fecha;
    private String hora;
    private String tipoInstalacion;
    private String usuario;
    private boolean disponible;

    // Constructores, getters y setters

    public ReservaDTO() {
    }

    public ReservaDTO(String fecha, String hora, String tipoInstalacion, String usuario, boolean disponible) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoInstalacion = tipoInstalacion;
        this.usuario = usuario;
        this.disponible = disponible;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
