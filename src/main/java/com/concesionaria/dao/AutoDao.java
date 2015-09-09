/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Auto;
import com.concesionaria.domain.AutoMarcaPrecioDto;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author mariano
 */
public interface AutoDao {

    public void guardar(Auto auto);

    public Auto buscarAutoPorId(Long id);

    public void modificar(Auto auto);

    public void eliminarAuto(Auto auto);

    public void eliminarAutoPorId(Long id);

    public List<Auto> buscarPorMarcaYModelo(String marca, String modelo);

    public Long getMaxId();

    public void shutDown();

    public void close() throws Exception;

    public List<Auto> getAllAutos();

    public List<Auto> findByConcesionarioId(Long idConcesionario);

}
