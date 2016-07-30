/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Persona;

/**
 *
 * @author mariano
 */
public interface PersonaDao {
    
    public void guardar(Persona persona);

    public Persona buscarPorId(Long id);

    public void modificar(Persona persona);
    
}
