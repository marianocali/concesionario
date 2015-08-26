/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacionit.jpa;

import com.concesionaria.dao.QuerysAutoDao;
import com.concesionaria.dao.QuerysAutoDaoImpl;
import com.concesionaria.domain.Auto;
import com.concesionaria.domain.AutoMarcaPrecioDto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mariano
 */
public class QuerysAutoTest {

    //Retorna una instancia del DAO
    public QuerysAutoDao getQuerysAutoDao() {
        QuerysAutoDao querysAutoDao = null;
        if (querysAutoDao == null) {
            querysAutoDao = new QuerysAutoDaoImpl();
        }
        return querysAutoDao;
    }

//    @Test
    public void testGetAutosOrdenadosFechaDesc() {

        System.out.println(" testGetAllAutos ");

        List<Auto> listaAutos = new ArrayList<Auto>();
        listaAutos = getQuerysAutoDao().getAutosOrdenadosFechaDesc();

        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }
    }

//    @Test
    public void testGetAutosFechaVenta() {

        System.out.println(" testGetAutosFechaVenta ");

        List<Auto> listaAutos;
        Calendar fechaDesde = Calendar.getInstance();
        fechaDesde.set(2002, 1, 1);
        Calendar fechaHasta = Calendar.getInstance();
        fechaHasta.set(2005, 1, 1);

        listaAutos = getQuerysAutoDao().getAutosFechaVenta(fechaDesde, fechaHasta);

        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }
    }

//    @Test
    public void testGetAutosPorAnio() {

        System.out.println(" testGetAutosPorAnio ");

        List<Auto> listaAutos;
        Integer anioFabricacion = 2002;

        listaAutos = getQuerysAutoDao().getAutosPorAnio(anioFabricacion);

        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }
    }

//    @Test
    public void testGetAutosPorLetraInicia() {

        System.out.println(" testGetAutosPorLetraInicia ");

        List<Auto> listaAutos;
        Character letra = 'c';

        listaAutos = getQuerysAutoDao().getAutosPorMarcaLetraInicial(letra);

        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }
    }

//    @Test
    public void testGetAutosPorPrecioMayorA() {

        System.out.println(" testGetAutosPorPrecioMayorA ");

        List<Auto> listaAutos;
        Long precioBase = 150000l;

        listaAutos = getQuerysAutoDao().getAutosPorPrecioMayorA(precioBase);

        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }
    }

//    @Test
    public void testGetCantidadAutos() {

        System.out.println(" testGetCantidadAutos ");

        Long cantidad = null;

        cantidad = getQuerysAutoDao().getCantidadTotalAutos();

        System.out.println("cantidad:" + cantidad);
        Assert.assertNotNull(cantidad);
    }

//    @Test
    public void testGetCantidadMarcasDistintas() {

        System.out.println(" testGetCantidadMarcasDistintas ");

        Long cantidad = null;

        cantidad = getQuerysAutoDao().getCantidadMarcasDiferentes();

        System.out.println("cantidad Marcas distintas:" + cantidad);
        Assert.assertNotNull(cantidad);
    }

//    @Test
    public void testGetAutoMasCaro() {
        System.out.println("testGetAutoMasCaro ");

        Auto auto = getQuerysAutoDao().getAutoConPrecioMayor();

        auto.mostrarAuto(auto);

        Assert.assertNotNull(auto);
    }

//    @Test
    public void testPromedio() {
        System.out.println("testPromedio ");

        Double promedio = getQuerysAutoDao().promedioPrecios();

        System.out.println("promedio: " + promedio);

        Assert.assertNotNull(promedio);
    }

    @Test
    public void testVentaTotalPorMarca() {

        System.out.println(" testVentaTotalPorMarca");

        List<AutoMarcaPrecioDto> listaMarcasYVentas;

        listaMarcasYVentas = getQuerysAutoDao().ventaTotalPorMarca();

        for (AutoMarcaPrecioDto marcaYVenta : listaMarcasYVentas) {
            System.out.print("marca " + marcaYVenta.getMarca());
            System.out.println("  ventas " + marcaYVenta.getVentas());
        }
    }

}
