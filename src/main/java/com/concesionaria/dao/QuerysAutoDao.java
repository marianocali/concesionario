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
public interface QuerysAutoDao {

    public List<Auto> getAutosOrdenadosFechaDesc();

    public List<Auto> getAutosFechaVenta(Calendar fechaDesde, Calendar fechaHasta);

    public List<Auto> getAutosPorAnio(Integer anio);

    public List<Auto> getAutosPorMarcaLetraInicial(Character letra);

    public List<Auto> getAutosPorPrecioMayorA(Long precio);

    public Long getCantidadTotalAutos();

    public Long getCantidadMarcasDiferentes();

    public Auto getAutoConPrecioMayor();

    public Double promedioPrecios();

    public List<AutoMarcaPrecioDto> ventaTotalPorMarca();
}
