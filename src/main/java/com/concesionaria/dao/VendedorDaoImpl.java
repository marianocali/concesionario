/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

/**
 *
 * @author mariano
 */
public class VendedorDaoImpl extends PersonaDaoImpl implements VendedorDao {

    private static final VendedorDaoImpl instance = new VendedorDaoImpl();

    private VendedorDaoImpl() {
        //constructor privado para usar Singleton
    }

    public static VendedorDaoImpl getInstance() {
        return instance;
    }

}
