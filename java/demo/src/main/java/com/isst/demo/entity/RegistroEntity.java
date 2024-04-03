package com.isst.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RegistroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private Long communityCode;
    private String calle;
    private String provincia;
    private String telefono;
    private String dni;

    // Constructores

    // Constructor vacío (obligatorio para JPA)
    public RegistroEntity() {
    }

    // Constructor con todos los campos
    public RegistroEntity(Long id, String nombre, String apellidos, String email, Long communityCode, String calle, String provincia, String telefono, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.communityCode = communityCode;
        this.calle = calle;
        this.provincia = provincia;
        this.telefono = telefono;
        this.dni = dni;
    }

    // Constructor sin ID
    public RegistroEntity(String nombre, String apellidos, String email, Long communityCode, String calle, String provincia, String telefono, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.communityCode = communityCode;
        this.calle = calle;
        this.provincia = provincia;
        this.telefono = telefono;
        this.dni = dni;
    }

    // Constructor sin apellidos, communityCode, calle, provincia, telefono y dni
    public RegistroEntity(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método toString()

    @Override
    public String toString() {
        return "RegistroEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", communityCode=" + communityCode +
                ", calle='" + calle + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
