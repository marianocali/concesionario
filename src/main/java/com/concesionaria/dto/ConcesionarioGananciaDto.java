/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dto;

/**
 *
 * @author mariano
 */
public class ConcesionarioGananciaDto {

    private String strConcesionario;
    private double facturacion;

    public ConcesionarioGananciaDto() {
    }

    public ConcesionarioGananciaDto(String strConcesionario, double facturacion) {
        this.strConcesionario = strConcesionario;
        this.facturacion = facturacion;
    }

    public String getStrConcesionario() {
        return strConcesionario;
    }

    public void setStrConcesionario(String strConcesionario) {
        this.strConcesionario = strConcesionario;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }

    @Override
    public String toString() {
        return "ConcesionarioGananciaDto{" + "strConcesionario=" + strConcesionario + ", facturacion=" + facturacion + '}';
    }

}
