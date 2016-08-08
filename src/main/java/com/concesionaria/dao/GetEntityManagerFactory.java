/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mariano
 */
public class GetEntityManagerFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    private GetEntityManagerFactory() {
        //constructor privado para hacer Singleton
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static EntityManagerFactory getInstance(){
        return emf;
    }

   

}
