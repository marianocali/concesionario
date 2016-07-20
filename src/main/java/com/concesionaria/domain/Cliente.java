package com.concesionaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class Cliente extends Persona {

    
    private int idCliente;
    
    @Column(name="tipo")
    private String tipo;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Cliente() {

    }
    
    public Cliente( String nombre, String apellido, String direccion, String tipo) {
        super(nombre, apellido, direccion);
        this.tipo = tipo;
    }

}
