/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacionit.jpa;

import com.concesionaria.dao.ClienteDaoImpl;
import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mariano
 */
public class ClienteDaoTest {

    private static Long idInsertado;    //se usa para saber que idSe inserto, modificarlo, borrarlo

    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

    private ClienteDaoImpl clienteDao = DaoFactory.getClienteDao();

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    @Test
    public void testGuardar() {

        Cliente cliente = new Cliente("Juan", "Gonzalez", "Pichincha  1031", "RESIDENCIAL");

        clienteDao.guardar(cliente);             //lo guarda en BD
        setIdInsertado(cliente.getIdPersona());

        Assert.assertEquals(getIdInsertado(), Long.valueOf(clienteDao.findById(idInsertado).getIdPersona()));
    }

    @Test
    public void testFindById() {

        Cliente cliente = clienteDao.findById(getIdInsertado());

        Assert.assertEquals(getIdInsertado(), Long.valueOf(cliente.getIdPersona())); //se agrega el Long.valueOf porque sino no compila el test
    }

}
