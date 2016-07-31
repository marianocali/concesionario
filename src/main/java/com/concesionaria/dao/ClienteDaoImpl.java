/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Cliente;
import com.concesionaria.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mariano
 */
public class ClienteDaoImpl extends PersonaDaoImpl implements ClienteDao {

    private static ClienteDaoImpl instance = new ClienteDaoImpl();

    //Constructor privado para usar patron Singleton
    private ClienteDaoImpl() {

    }

    public static ClienteDaoImpl getInstance() {
        return instance;
    }

}
