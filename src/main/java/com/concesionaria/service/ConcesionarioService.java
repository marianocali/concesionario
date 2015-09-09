/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.service;

import com.concesionaria.dao.AutoDao;
import com.concesionaria.dao.AutoDaoImpl;
import com.concesionaria.dao.ConcesionarioDaoImpl;
import com.concesionaria.domain.Auto;
import java.util.ArrayList;

/**
 *
 * @author mariano
 */
public class ConcesionarioService {
    public static void agregarAutos(Long idConcesionario, ArrayList<Auto> autos){
        ConcesionarioDaoImpl.agregarAutos(idConcesionario, autos);
    }
    
//    public static void informarAutos(Long idConcesionario){
//        AutoDao autoDao = new AutoDaoImpl();
//        ConcesionarioDaoImpl.
//        ConcesionarioDao autoDao = new AutoDaoImautopl();
//        ArrayList<Auto> autos = autoDao.
//        Concesioario concesionario =        
//        ConcesionarioDaoImpl.
//                
//    }
}
