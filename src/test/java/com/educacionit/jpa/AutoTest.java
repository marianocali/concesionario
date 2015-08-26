package com.educacionit.jpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.concesionaria.dao.AutoDao;
import com.concesionaria.dao.AutoDaoImpl;
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
public class AutoTest {

    private static Long idInsertado;    //se usa para saber que idSe inserto, modificarlo, borrarlo
    private final String marca = "Ford";
    private final String modelo = "Mondeo";
    private final Integer anio = 2004;
    private final Calendar fechaVenta = Calendar.getInstance();
    private Long precio = 160000l;

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    public AutoTest() {
    }

    //Retorna una instancia del DAO
    public AutoDao getAutoDao() {
        AutoDao autoDao = null;
        if (autoDao == null) {
            autoDao = new AutoDaoImpl();
        }
        return autoDao;
    }

//    @Test
    public void testGuardar() {

        fechaVenta.set(2005, 6, 4);

        Auto auto = new Auto(marca, modelo, fechaVenta, anio, precio);    //crea instancia del auto

        getAutoDao().guardar(auto);             //lo guarda en BD
        setIdInsertado(getAutoDao().getMaxId());

        Auto auto2 = getAutoDao().buscarAutoPorId(getIdInsertado()); //busca el auto insertado

        Assert.assertEquals(marca, auto2.getMarca());
        Assert.assertEquals(modelo, auto2.getModelo());
    }

//    @Test
    public void testModificar() {
        Auto auto;
        auto = getAutoDao().buscarAutoPorId(getAutoDao().getMaxId()); //obtiene el auto ingresao

        //le actualiza marca y modelo
        String nuevaMarca = "Fiat";
        String nuevoModelo = "Palio";
        auto.setMarca(nuevaMarca);
        auto.setModelo(nuevoModelo);

        //lo salva en la BD
        getAutoDao().modificar(auto);

        //lo busca en la BD 
        Auto auto2;
        auto2 = getAutoDao().buscarAutoPorId(getAutoDao().getMaxId());

        //compara para ver si se actualizó
        Assert.assertEquals(auto2.getMarca(), nuevaMarca);
        Assert.assertEquals(auto2.getModelo(), nuevoModelo);
    }

//    @Test
    public void testGetAllAutos() {
        System.out.println(" testGetAllAutos ");

        List<Auto> listaAutos = new ArrayList<Auto>();
        listaAutos = getAutoDao().getAllAutos();

        for (Auto auto : listaAutos) {
            auto.mostrarAuto(auto);
        }

    }

//    @Test
    public void testFind() {
        Assert.assertTrue(true);
    }

//    @Test
    public void testDelete() {
        System.out.println("getAutoDao().getMaxId(): " + getAutoDao().getMaxId());
        Long nroRegistrosInicio = getAutoDao().getMaxId();
        //elimina el auto ingresado
        getAutoDao().eliminarAutoPorId(getAutoDao().getMaxId());

        //busca el auto con el idEliminado, debe retornar null
        Auto auto = getAutoDao().buscarAutoPorId(getIdInsertado());

        Long nroRegistrosFinal = getAutoDao().getMaxId();
        System.out.println("getAutoDao().getMaxId(): " + getAutoDao().getMaxId());

        Assert.assertNull(auto);
        Assert.assertTrue(nroRegistrosInicio > nroRegistrosFinal);

    }
}