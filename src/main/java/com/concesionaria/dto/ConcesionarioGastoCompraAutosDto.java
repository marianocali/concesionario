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
public class ConcesionarioGastoCompraAutosDto {

    private double gasto;
    private String strConcesionario;
    
    public ConcesionarioGastoCompraAutosDto(){
        
    }
    
    public ConcesionarioGastoCompraAutosDto(String strConcesionario, double gasto){
        this.gasto = gasto;
        this.strConcesionario = strConcesionario;
    }
    
    public double getGasto(){
        return gasto;
    }
    
    public void setGasto(double gasto){
        this.gasto = gasto;
    }
    
    public String getStrConcesionario(){
        return strConcesionario;
    }
    
    public void setStrnConcesionario(String concesionario){
        this.strConcesionario = concesionario;
    }

    public void mostrar(ConcesionarioGastoCompraAutosDto concesionarioGastos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "ConcesionarioGastoCompraAutosDto{" + "gasto=" + gasto + ", strConcesionario=" + strConcesionario + '}';
    }
    
    
    
}
