/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author mariano
 */
@Entity
@Table(name="Vendedores")
@PrimaryKeyJoinColumn(name ="id_vendedor")
public class Vendedor extends Persona{
    
    @Column(name="fecha_ingreso")
    private Date fechaIngreso;
    
    @Column(name="LEGAJO")
    private String legajo;
    
    @Column(name="SUELDO")
    private double sueldo;

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
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
    
    public Vendedor(){
        
    }

    public Vendedor(String nombre, String apellido, String direccion, Date fechaIngreso, String legajo, double sueldo) {
        super(nombre, apellido, direccion);
        this.fechaIngreso = fechaIngreso;
        this.legajo = legajo;
        this.sueldo = sueldo;
    }
    
    
}
