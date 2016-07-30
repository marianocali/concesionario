/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacionit.jpa;

import com.concesionaria.dao.DaoFactory;
import com.concesionaria.dao.PersonaDao;
import com.concesionaria.dao.PersonaDaoImpl;
import com.concesionaria.domain.Persona;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author mariano
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonaDaoTest {
    
    private static Long idInsertado;    //se usa para saber que idSe inserto, modificarlo, borrarlo
    private final String nombre = "Julian";
    private final String apellido = "Saldivia";
    private final String direccion = "San Juan 2013";
    private final Calendar fechaVenta = Calendar.getInstance();
    private final Long precio = 120000l;
    
    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

//    private AutoDaoImpl autoDao = DaoFactory.getAutoDao();
    
    private PersonaDaoImpl personaDao = DaoFactory.getPersonaDao();

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    public PersonaDaoTest() {
    }

    @Test
    public void test1Guardar() {

        fechaVenta.set(2007, 2, 6);

        Persona persona = new Persona(nombre, apellido, direccion);    //crea instancia del auto
        PersonaDao personaDao = DaoFactory.getPersonaDao();
        
        personaDao.guardar(persona);
        setIdInsertado(persona.getIdPersona());
        
        Persona persona2 = personaDao.buscarPorId(getIdInsertado());
        
        Assert.assertEquals(persona2.getNombre(), nombre);
        Assert.assertEquals(persona2.getApellido(), apellido);
        Assert.assertEquals(persona2.getDireccion(), direccion);
        
    }

    @Test
    public void test2Modificar() {
        Persona persona;
        persona = personaDao.buscarPorId(getIdInsertado());
        
        //le actualiza marca y modelo
        String nuevoNombre = "Ricardo";
        String nuevoApellido = "Perez";
        String nuevaDireccion = "Guardia Vieja 311";
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setDireccion(nuevaDireccion);

        //lo salva en la BD
        personaDao.modificar(persona);

        //lo busca en la BD 
        Persona persona2;
        persona2 = personaDao.buscarPorId(getIdInsertado());
        
        //compara para ver si se actualizó
        Assert.assertEquals(persona2.getNombre(), nuevoNombre);
        Assert.assertEquals(persona2.getApellido(), nuevoApellido);
        Assert.assertEquals(persona2.getDireccion(), nuevaDireccion);
    }

    
    @Test
    public void test4Find() {
        Assert.assertTrue(true);
    }

    @Test
    public void test5Delete() {
        System.out.println("testDelete " + getIdInsertado());
        
//        personaDao.
//        Long nroRegistrosInicio = autoDao.getMaxId();
//        //elimina el auto ingresado
//        autoDao.eliminarAutoPorId(autoDao.getMaxId());
//
//        //busca el auto con el idEliminado, debe retornar null
//        Auto auto = autoDao.buscarAutoPorId(getIdInsertado());
//
//        Long nroRegistrosFinal = autoDao.getMaxId();
//        System.out.println("autoDao.getMaxId(): " + autoDao.getMaxId());

//        Assert.assertNull(auto);
//        Assert.assertTrue(nroRegistrosInicio > nroRegistrosFinal);

    }

    
    
    
}
