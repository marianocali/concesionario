/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

/**
 *  Se agrega el DaoFactory para insertar los Dao usando un DaoFactory en lugar de un new.
    La idea es tener un único Factory para todos los DaoFactory
 * @author mariano
 */
public class DaoFactory {
    
    public static ConcesionarioDaoImpl getConcesionarioDao() {
        return ConcesionarioDaoImpl.getInstance();
    }
    
    public static AutoDaoImpl getAutoDao() {
        return AutoDaoImpl.getInstance();
    }
}
