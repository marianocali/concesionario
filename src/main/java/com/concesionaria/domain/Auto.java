package com.concesionaria.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mariano
 */
@Entity
public class Auto implements Serializable {

    @Id
    @GeneratedValue
    private Long idAuto;

    private String marca;
    private String modelo;
    private Long precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConcesionario", nullable = true)
    private Concesionario concesionario;

    @Temporal(TemporalType.DATE)
    private Calendar fechaVenta;

    private Integer anio;

    public Long getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Long idAuto) {
        this.idAuto = idAuto;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Auto() {
    }

    public Auto(String marca, String modelo, Calendar fechaVenta, Integer anio, Long precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.fechaVenta = fechaVenta;
        this.anio = anio;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Calendar getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Calendar fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void mostrarAuto(Auto auto) {
        System.out.println("");
        System.out.println("Id:" + auto.getIdAuto());
        System.out.println("Marca:" + auto.getMarca());
        System.out.println("Modelo: " + auto.getModelo());
        System.out.println("Año: " + auto.getAnio());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
        System.out.println("Fecha Venta: " + sdf.format(auto.getFechaVenta().getTime()));
        System.out.println("Precio : " + auto.getPrecio());
    }

    @Override
    public String toString() {
        return "Auto{" + "idAuto=" + idAuto + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", concesionario=" + concesionario + ", fechaVenta=" + fechaVenta + ", anio=" + anio + '}';
    }

}
