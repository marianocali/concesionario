package com.concesionaria.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPERSONA")
    private long idPersona;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DIRECCION")
    private String direccion;

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public Persona(){
        
    }
    
    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }
}
