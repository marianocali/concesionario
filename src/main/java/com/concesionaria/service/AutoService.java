/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.service;

import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Auto;
import java.util.List;

/**
 *
 * @author mariano
 */
public class AutoService {
    
    
    public static void informarAutosMayorAPrecio(Double precio){
        
        List <Auto> listaAutos;
        listaAutos = DaoFactory.getAutoDao().informarAutosMayorAPrecio(precio);
        
        System.out.println("Datos de los autos");
        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }

        System.out.println("\n\n");
        
    }
}
