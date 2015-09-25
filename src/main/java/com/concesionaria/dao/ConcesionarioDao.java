/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Concesionario;
import java.util.List;

/**
 *
 * @author mariano
 */
public interface ConcesionarioDao {

    
    public void agregar(Concesionario concesionario);

    public void actualizar(Concesionario concesionario);

    public void eliminar(Concesionario concesionario);

    public Concesionario findById(Long id);

    public List<Concesionario> getAllConcesionarios();

    public Long getMaxId();
    
    public Concesionario informarAutos(Long idConcesionario);
    
    public void eliminar(Long idConcesionario);
}
