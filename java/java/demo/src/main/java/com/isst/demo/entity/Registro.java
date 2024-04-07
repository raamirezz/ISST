package com.isst.demo.entity;

import com.isst.demo.dto.RegistroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private Long communityCode;
    private String usuario;
    private String contraseña;

    // Constructores

    // Constructor vacío (obligatorio para JPA)
    public Registro() {
    }

    // Constructor con todos los campos
    public Registro(Long id, String nombre, String apellidos, String email, Long communityCode, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.communityCode = communityCode;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Registro(RegistroDTO registroDTO) {
        this.nombre = registroDTO.getNombre();
        this.apellidos = registroDTO.getApellidos();
        this.email = registroDTO.getEmail();
        this.communityCode = registroDTO.getCommunityCode();
        this.usuario = registroDTO.getUsuario();
        this.contraseña = registroDTO.getContraseña();
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
        return "Registro{" +
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
