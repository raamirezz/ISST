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
    private String authority;
    private Long communityCode;
    private String usuario;
    private String contraseña;
    private Boolean enabled;

    // Constructor vacío (obligatorio para JPA)
    public RegistroDTO() {
    }

    // Constructor con todos los campos
    public RegistroDTO(Long id, String nombre, String apellidos, String email, String authority, Long communityCode, String usuario, String contraseña, Boolean enabled) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.authority = authority;
        this.communityCode = communityCode;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.enabled = enabled;
    }

    // Constructor sin ID
    public RegistroDTO(String nombre, String apellidos, String email, String authority, Long communityCode, String usuario, String contraseña, Boolean enabled) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.authority = authority;
        this.communityCode = communityCode;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.enabled = enabled;
    }

    // Constructor sin apellidos y communityCode
    public RegistroDTO(Long id, String nombre, String email, String authority, String usuario, String contraseña, Boolean enabled) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.authority = authority;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.enabled = enabled;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // Método toString()

    @Override
    public String toString() {
        return "RegistroDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", authority='" + authority + '\'' +
                ", communityCode=" + communityCode +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", enabled='" + enabled + '\'' +
                '}';
    }
}