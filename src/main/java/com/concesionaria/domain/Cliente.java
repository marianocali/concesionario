package com.concesionaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
@PrimaryKeyJoinColumn(name = "ID_PERSONA")
public class Cliente extends Persona {

    @Column(name = "TIPO")
    private String tipo;

    public Cliente() {

    }

    public Cliente(String nombre, String apellido, String direccion, String tipo) {
        super(nombre, apellido, direccion);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
