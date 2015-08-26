package com.concesionaria.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author mariano
 */
@Entity
public class Concesionario implements Serializable {

    private Long id;
    private String nombre;
    private String direccion;

    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

    private Set<Auto> autos;

    public Concesionario() {
        this.autos = new HashSet<Auto>();

    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_co")
    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set <Auto> autos) {
        this.autos = autos;
    }

    @Id
    @GeneratedValue
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void mostrarConcesionario() {
        System.out.println(" ");
        System.out.println(" id: " + this.getId());
        System.out.println(" nombre: " + this.getNombre());
        System.out.println(" direccion: " + this.getDireccion());
    }

}
