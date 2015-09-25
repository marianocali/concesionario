/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.service;

import com.concesionaria.dao.AutoDao;
import com.concesionaria.dao.ConcesionarioDaoImpl;
import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Auto;
import com.concesionaria.domain.Concesionario;
import java.util.ArrayList;

/**
 *
 * @author mariano
 */
public class ConcesionarioService {

    /**
     * agregar los autos que están contenidos en el ArrayList de autos al
     * concesionario identificado por idConcesionario
     *
     * @param idConcesionario
     * @param autos
     */
    public static void agregarAutos(Long idConcesionario, ArrayList<Auto> autos) {
        ConcesionarioDaoImpl.agregarAutos(idConcesionario, autos);
    }

    /**
     * Informar los datos del concesionario junto con un listado de los autos
     * que contiene. Deberá informar el valor de todos los campos de los autos.
     *
     * @param idConcesionario
     */
    public static void informarAutos(Long idConcesionario) {

        Concesionario concesionario = DaoFactory.getConcesionarioDao().informarAutos(idConcesionario);

        System.out.println("\n\n" + "Datos del Concesionario");
        System.out.println(concesionario.toString());
        System.out.println("Datos de los autos");
        for (Auto auto : concesionario.getAutos()) {
            auto.mostrarAuto(auto);
        }

        System.out.println("\n\n");
    }

}
