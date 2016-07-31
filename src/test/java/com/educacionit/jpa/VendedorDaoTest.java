/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacionit.jpa;

import com.concesionaria.dao.DaoFactory;
import com.concesionaria.dao.VendedorDaoImpl;
import com.concesionaria.domain.Concesionario;
import com.concesionaria.domain.Vendedor;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mariano
 */
public class VendedorDaoTest {

    private static Long idInsertado;    //se usa para saber que idSe inserto, modificarlo, borrarlo
    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");
    private VendedorDaoImpl vendedorDao = DaoFactory.getVendedorDao();
    private final Calendar fechaIngreso = Calendar.getInstance();

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    @Test
    public void testGuardar() {
        fechaIngreso.set(2010, 02, 21);
        
        String legajo = "2105";
        double sueldo = 25000;
        long maxIdConcesionario = DaoFactory.getConcesionarioDao().getMaxId();
        
        Concesionario concesionario = DaoFactory.getConcesionarioDao().findById(maxIdConcesionario);
        Vendedor vendedor = new Vendedor("Hector", "Saldinger", "Burruchaga 357", fechaIngreso, legajo, sueldo, concesionario);

        vendedorDao.guardar(vendedor);             //lo guarda en BD
        setIdInsertado(vendedor.getIdPersona());

        Assert.assertEquals(getIdInsertado(), Long.valueOf(vendedorDao.buscarPorId(idInsertado).getIdPersona()));
    }

    @Test
    public void testFindById() {

        Vendedor vendedor = (Vendedor) vendedorDao.buscarPorId(getIdInsertado());

        Assert.assertEquals(getIdInsertado(), Long.valueOf(vendedor.getIdPersona())); //se agrega el Long.valueOf porque sino no compila el test
    }
    
    
    
}
