/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import java.util.List;

/**
 *
 * @author mariano
 */
public interface QuerysParametrizadasDao {

    public List obtenerAutosSegunCriterio(String marca, String modelo);

    public List obtenerAutosConPaginacion(int registroInicial, int cantidad);

}
