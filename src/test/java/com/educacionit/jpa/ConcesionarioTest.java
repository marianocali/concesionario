package com.educacionit.jpa;

import com.concesionaria.dao.AutoDao;
import org.junit.Assert;
import org.junit.Test;

import com.concesionaria.dao.ConcesionarioDao;
import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Auto;
import com.concesionaria.domain.Concesionario;
import com.concesionaria.service.ConcesionarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author mariano
 */
public class ConcesionarioTest {

    private static Long idInsertado = null;

    private final String direccion;
    private final String nombre;
    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

    public ConcesionarioTest() {
        this.nombre = "Toyota";
        this.direccion = "Av Montes de Oca 720";
    }

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    public ConcesionarioDao getConcesionarioDao() {
        ConcesionarioDao concesionarioDao = null;
        if (concesionarioDao == null) {
            concesionarioDao = DaoFactory.getConcesionarioDao();
        }
        return concesionarioDao;
    }

//    @Test
    public void testInsertar() {
        Log.log(Level.INFO, "testInsertar");
        Concesionario concesionario = new Concesionario();
        concesionario.setDireccion(direccion);
        concesionario.setNombre(nombre);

        getConcesionarioDao().agregar(concesionario);

        setIdInsertado(getConcesionarioDao().getMaxId());

        Concesionario concesionario2 = getConcesionarioDao().findById(getIdInsertado());
        Assert.assertEquals(concesionario2.getDireccion(), direccion);
        Assert.assertEquals(concesionario2.getNombre(), nombre);

    }

//    @Test
    public void testFindById() {
        Log.log(Level.INFO, "testFindById");

        Concesionario concesionario;
        concesionario = getConcesionarioDao().findById(getIdInsertado());
        Assert.assertEquals(direccion, concesionario.getDireccion());
        Assert.assertEquals(nombre, concesionario.getNombre());
    }

//    @Test
    public void testModificar() {
        Log.info("testModificar");

        Concesionario concesionario = getConcesionarioDao().findById(getIdInsertado());
        String nuevoNombre = "Saab";
        String nuevaDireccion = "Moreno 2350";
        concesionario.setNombre(nuevoNombre);
        concesionario.setDireccion(nuevaDireccion);

        getConcesionarioDao().actualizar(concesionario);

        Concesionario concesionario2 = getConcesionarioDao().findById(getIdInsertado());

        Assert.assertEquals(nuevoNombre, concesionario2.getNombre());
        Assert.assertEquals(nuevaDireccion, concesionario2.getDireccion());

    }

//    @Test
    public void testGetAllConcesionario() {

        Log.info("testGetAllConcesionario");

        List<Concesionario> listaConcesionarios;

        listaConcesionarios = getConcesionarioDao().getAllConcesionarios();
        
        for (Concesionario concesionario : listaConcesionarios) {
            concesionario.mostrarConcesionario();
        }

    }

//    @Test
    public void testGetMaxId() {

        ConcesionarioDao concesionarioDao = DaoFactory.getConcesionarioDao();

        Long maxId = concesionarioDao.getMaxId();

        Log.log(Level.INFO, "maxId:" + maxId);
        Assert.assertNotNull(maxId);
    }

//    @Test
    public void testEliminar() {
        Log.log(Level.INFO, "testEliminar");

        Concesionario concesionario;
        concesionario = getConcesionarioDao().findById(getIdInsertado());
        getConcesionarioDao().eliminar(concesionario);
        concesionario = getConcesionarioDao().findById(getIdInsertado());
        Assert.assertNull(concesionario);

    }
    
//    @Test
    public void testAgregarAutos(){
        
        AutoDao autoDao = DaoFactory.getAutoDao();
        Auto auto1 = autoDao.buscarAutoPorId(2l);
        ArrayList<Auto> autos = new ArrayList<Auto>();
        autos.add(auto1);
        ConcesionarioService.agregarAutos(2l, autos);
    }
    
    @Test
    public void informarAutos(){
        Log.log(Level.INFO, "test informarAutos");
        Long idConcesionario = 4l;
        ConcesionarioService.informarAutos(idConcesionario);
    }
    
}
