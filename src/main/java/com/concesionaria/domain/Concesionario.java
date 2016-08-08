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
import javax.persistence.Table;

/**
 *
 * @author mariano
 */
@Entity
@Table(name = "CONCESIONARIO")
public class Concesionario implements Serializable {

    private Long idConcesionario;
    private String nombre;
    private String direccion;

    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

    private Set<Auto> autos;

    private Set<Vendedor> vendedores;

    public Concesionario() {
        this.autos = new HashSet<Auto>();

    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idConcesionario")
    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }

    @Id
    @GeneratedValue
    public Long getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(Long idConcesionario) {
        this.idConcesionario = idConcesionario;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idConcesionario")
    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public void mostrarConcesionario() {
        System.out.println(" ");
        System.out.println(" id: " + this.getIdConcesionario());
        System.out.println(" nombre: " + this.getNombre());
        System.out.println(" direccion: " + this.getDireccion());
    }

    @Override
    public String toString() {
        return "Concesionario{" + "idConcesionario=" + idConcesionario
                + ", nombre=" + nombre
                + ", direccion=" + direccion;
    }

}
