package com.isst.demo.dto;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

public class RegistroDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private Long communityCode;
    private String usuario;
    private String contraseña;

    // Constructor vacío (obligatorio para JPA)
    public RegistroDTO() {
    }

    // Constructor con todos los campos
    public RegistroDTO(Long id, String nombre, String apellidos, String email, Long communityCode, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.communityCode = communityCode;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Constructor sin ID
    public RegistroDTO(String nombre, String apellidos, String email, Long communityCode, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.communityCode = communityCode;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Constructor sin apellidos y communityCode
    public RegistroDTO(Long id, String nombre, String email, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(Long communityCode) {
        this.communityCode = communityCode;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Método toString()

    @Override
    public String toString() {
        return "RegistroDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", communityCode=" + communityCode +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}