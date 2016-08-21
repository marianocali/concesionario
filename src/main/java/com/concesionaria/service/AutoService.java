/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.service;

import com.concesionaria.dao.DaoFactory;
import com.concesionaria.dao.GetEntityManagerFactory;
import com.concesionaria.domain.Auto;
import java.util.List;

/**
 *
 * @author mariano
 */
public class AutoService {

    public static void informarAutosMayorAPrecio(Double precio) {

        List<Auto> listaAutos;
        listaAutos = DaoFactory.getAutoDao().informarAutosMayorAPrecio(precio);

        System.out.println("Datos de los autos");
        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }

        System.out.println("\n\n");

    }

    public static void informarAutosOrdenadosPorPrecio() {

        List<Auto> listaAutos;
        listaAutos = DaoFactory.getAutoDao().informarAutosOrdenadosPorPrecio();

        System.out.println();
        System.out.println("Autos de todos los concesionarios ordenados por precio de mayor a menor");
        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }

        System.out.println("\n\n");
    }
    
    public static void main(String[] args) {
        AutoService.informarAutosOrdenadosPorPrecio();
        GetEntityManagerFactory.getInstance().close();
    }
}
