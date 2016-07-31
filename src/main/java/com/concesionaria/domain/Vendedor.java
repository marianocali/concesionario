    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.domain;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author mariano
 */
@Entity
@Table(name = "VENDEDORES")
@PrimaryKeyJoinColumn(name = "ID_PERSONA")
public class Vendedor extends Persona {

    @Column(name = "FECHA_INGRESO")
    private Calendar fechaIngreso;

    @Column(name = "LEGAJO")
    private String legajo;

    @Column(name = "SUELDO")
    private double sueldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConcesionario", nullable = true)
    private Concesionario concesionario;

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Vendedor() {

    }

    public Vendedor(String nombre, String apellido, String direccion, Calendar fechaIngreso, String legajo, double sueldo, Concesionario concesionario) {
        super(nombre, apellido, direccion);
        this.fechaIngreso = fechaIngreso;
        this.legajo = legajo;
        this.sueldo = sueldo;
        this.concesionario = concesionario;
    }

}
