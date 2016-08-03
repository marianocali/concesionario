/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dto;

import com.concesionaria.domain.Concesionario;

/**
 *
 * @author mariano
 */
public class ConcesionariaSueldosDto {

    private double count;

    private String strConcesionario;

    public ConcesionariaSueldosDto() {

    }
    
    public ConcesionariaSueldosDto(String strConcesionario, double totalSueldos) {
        this.strConcesionario = strConcesionario;
        this.count = totalSueldos;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getStrConcesionario() {
        return strConcesionario;
    }

    public void setStrConcesionario(String strConcesionario) {
        this.strConcesionario = strConcesionario;
    }

    public void mostrar(ConcesionariaSueldosDto concesionariaSueldosDto) {
        System.out.println("");
        System.out.print("Concesionario: " + concesionariaSueldosDto.getStrConcesionario() + " ");
        System.out.println("Total Sueldos: " + concesionariaSueldosDto.getCount());
    }
}
