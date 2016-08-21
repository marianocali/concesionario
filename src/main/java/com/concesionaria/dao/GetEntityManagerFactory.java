/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Crea el EntityManagerFactory que es la fabrica de Sesione para trabajar con la BD
 * se crea solo uno porque su costo de creación es altísimo. Puede ser hasta de 1 minuto o mas
 * A partir del la instancia de EntityManagerFactory se van a crear los EntityManager que se usan
 * para cada una de las operaciones de CRUD con la BD.
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

    
     public void shutDown() {
        emf.close();
    }

    
    public void close() throws Exception {
        if (emf.isOpen()) {
            emf.close();
        }
    }
    
   

}
