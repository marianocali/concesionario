/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Cliente;

/**
 *
 * @author mariano
 */
public interface ClienteDao extends PersonaDao {

    public Cliente findById(Long id);
}
