package com.educacionit.jpa;


import com.concesionaria.dao.AutoDao;
import com.concesionaria.dao.AutoDaoImpl;
import com.concesionaria.dao.ConcesionarioDao;
import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Auto;
import com.concesionaria.domain.Concesionario;
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
    private final String marca = "Honda";
    private final String modelo = "City";
    private final Integer anio = 2007;
    private final Calendar fechaVenta = Calendar.getInstance();
    private final Long precio = 170000l;
    
    private AutoDaoImpl autoDao = DaoFactory.getAutoDao();

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    public AutoTest() {
    }



    @Test
    public void testGuardar() {

        fechaVenta.set(2007, 2, 6);

        Auto auto = new Auto(marca, modelo, fechaVenta, anio, precio);    //crea instancia del auto
        ConcesionarioDao concesionarioDao = DaoFactory.getConcesionarioDao();
        
        Concesionario concesionario = concesionarioDao.findById(concesionarioDao.getMaxId());
        
        auto.setConcesionario(concesionario);
       
        autoDao.guardar(auto);             //lo guarda en BD
        setIdInsertado(autoDao.getMaxId());

        Auto auto2 = autoDao.buscarAutoPorId(getIdInsertado()); //busca el auto insertado

        Assert.assertEquals(marca, auto2.getMarca());
        Assert.assertEquals(modelo, auto2.getModelo());
    }

//    @Test
    public void testModificar() {
        Auto auto;
       
        auto = autoDao.buscarAutoPorId(autoDao.getMaxId()); //obtiene el auto ingresao

        //le actualiza marca y modelo
        String nuevaMarca = "Fiat";
        String nuevoModelo = "Palio";
        auto.setMarca(nuevaMarca);
        auto.setModelo(nuevoModelo);

        //lo salva en la BD
        autoDao.modificar(auto);

        //lo busca en la BD 
        Auto auto2;
        auto2 = autoDao.buscarAutoPorId(autoDao.getMaxId());

        //compara para ver si se actualizó
        Assert.assertEquals(auto2.getMarca(), nuevaMarca);
        Assert.assertEquals(auto2.getModelo(), nuevoModelo);
    }

//    @Test
    public void testGetAllAutos() {
        System.out.println(" testGetAllAutos ");

        List<Auto> listaAutos = new ArrayList<Auto>();
        listaAutos = autoDao.getAllAutos();

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
        System.out.println("autoDao.getMaxId(): " + autoDao.getMaxId());
        Long nroRegistrosInicio = autoDao.getMaxId();
        //elimina el auto ingresado
        autoDao.eliminarAutoPorId(autoDao.getMaxId());

        //busca el auto con el idEliminado, debe retornar null
        Auto auto = autoDao.buscarAutoPorId(getIdInsertado());

        Long nroRegistrosFinal = autoDao.getMaxId();
        System.out.println("autoDao.getMaxId(): " + autoDao.getMaxId());

        Assert.assertNull(auto);
        Assert.assertTrue(nroRegistrosInicio > nroRegistrosFinal);

    }
}