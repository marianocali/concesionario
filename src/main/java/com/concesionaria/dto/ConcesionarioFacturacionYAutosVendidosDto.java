/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dto;

/**
 * Este dto se usa para Informar facturación por concesionario junto con la
 * cantidad de autos vendidos
 *
 * @author mariano
 */
public class ConcesionarioFacturacionYAutosVendidosDto {

    private String strConcesionario;
    private long facturacion;
    private long autosVendidos;

    public ConcesionarioFacturacionYAutosVendidosDto() {

    }

    public ConcesionarioFacturacionYAutosVendidosDto(String strConcesionario, long facturacion, long autosVendidos) {
        this.strConcesionario = strConcesionario;
        this.facturacion = facturacion;
        this.autosVendidos = autosVendidos;
    }

    public String getStrConcecionario() {
        return strConcesionario;
    }

    public void setStrConcesionario(String strConcesionario) {
        this.strConcesionario = strConcesionario;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(long facturacion) {
        this.facturacion = facturacion;
    }

    public long getAutosVendidos() {
        return autosVendidos;
    }

    public void setAutosVendidos(long autosVendidos) {
        this.autosVendidos = autosVendidos;
    }

    @Override
    public String toString() {
        return "ConcesionarioFacturacionYAutosVendidosDto{" + "strConcesionario=" + strConcesionario + ", facturacion=" + facturacion + ", autosVendidos=" + autosVendidos + '}';
    }

}
