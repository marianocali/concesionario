package com.educacionit.jpa;

import com.concesionaria.dao.AutoDaoImpl;
import org.junit.Assert;
import org.junit.Test;

import com.concesionaria.dao.ConcesionarioDao;
import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Auto;
import com.concesionaria.domain.Concesionario;
import com.concesionaria.dto.ConcesionariaSueldosDto;
import com.concesionaria.service.ConcesionarioService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author mariano
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConcesionarioDaoTest {

    private static Long idInsertado = null;
    private static Long idAutoInsertado = null;

    private final String direccion;
    private final String nombre;
    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

    public ConcesionarioDaoTest() {
        this.nombre = "Toyota";
        this.direccion = "Av San Juan 6450";
    }

    public Long getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(Long id) {
        idInsertado = id;
    }

    public Long getIdAutoInsertado() {
        return idAutoInsertado;
    }

    public void setIdAutoInsertado(Long idAutoInsertado) {
        this.idAutoInsertado = idAutoInsertado;
    }

    public ConcesionarioDao getConcesionarioDao() {
        ConcesionarioDao concesionarioDao = null;
        if (concesionarioDao == null) {
            concesionarioDao = DaoFactory.getConcesionarioDao();
        }
        return concesionarioDao;
    }

    @Test
    public void test1Insertar() {
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

    @Test
    public void test2FindById() {
        Log.log(Level.INFO, "testFindById");

        Concesionario concesionario;
        concesionario = getConcesionarioDao().findById(getIdInsertado());
        Assert.assertEquals(direccion, concesionario.getDireccion());
        Assert.assertEquals(nombre, concesionario.getNombre());
    }

    @Test
    public void test3GetAllConcesionario() {

        Log.info("testGetAllConcesionario");

        List<Concesionario> listaConcesionarios;

        listaConcesionarios = getConcesionarioDao().getAllConcesionarios();

        for (Concesionario concesionario : listaConcesionarios) {
            concesionario.mostrarConcesionario();
        }

    }

    @Test
    public void test4GetMaxId() {

        ConcesionarioDao concesionarioDao = DaoFactory.getConcesionarioDao();

        Long maxId = concesionarioDao.getMaxId();

        Log.log(Level.INFO, "maxId:" + maxId);
        Assert.assertNotNull(maxId);
    }

    @Test
    public void test5AgregarAutos() {

        String modelo = "Honda";
        String marca = "Accord";
        Integer anio = 2008;
        Calendar fechaVenta = Calendar.getInstance();
        Long precio = 250000l;

        //Primero se agrega un auto nuevo
        fechaVenta.set(2012, 12, 20);

        Auto auto = new Auto(marca, modelo, fechaVenta, anio, precio);    //crea instancia del auto
        ConcesionarioDao concesionarioDao = DaoFactory.getConcesionarioDao();

        Concesionario concesionario = concesionarioDao.findById(concesionarioDao.getMaxId());

        auto.setConcesionario(concesionario);
        AutoDaoImpl autoDao = DaoFactory.getAutoDao();
        autoDao.guardar(auto);             //lo guarda en BD

        setIdAutoInsertado(autoDao.getMaxId());

        Auto autoNuevo = autoDao.buscarAutoPorId(getIdAutoInsertado()); //busca el auto insertado

        ArrayList<Auto> autos = new ArrayList<Auto>();

        autos.add(autoNuevo);

        ConcesionarioService.agregarAutos(getIdInsertado(), autos);
    }

    @Test
    public void test6Modificar() {
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

    @Test
    public void test7informarAutos() {
        Log.log(Level.INFO, "test informarAutos");
        Long idConcesionario = getIdInsertado();
        ConcesionarioService.informarAutos(idConcesionario);
    }

    @Test
    public void test8InformarSueldos() {
        Log.log(Level.INFO, "test informarAutos");
        ConcesionarioService.informarSueldosPorConcesionario();
    }

//    @Test se comento porque abajo se elimina nuevamente
    public void test8Eliminar() {
        Log.log(Level.INFO, "testEliminar");

        Concesionario concesionario;
        concesionario = getConcesionarioDao().findById(getIdInsertado());
        getConcesionarioDao().eliminar(concesionario);
        concesionario = getConcesionarioDao().findById(getIdInsertado());
        Assert.assertNull(concesionario);

    }

    @Test
    public void test9EliminarConcesionarioYSusAutos() {
        Log.log(Level.INFO, "testEliminarConcesionarioYSusAutos");
        Concesionario concesionario;
        Long idConcesionario = getIdInsertado();

        ConcesionarioService.eliminar(idConcesionario);

        concesionario = DaoFactory.getConcesionarioDao().findById(getIdInsertado());
        Assert.assertNull(concesionario);

    }
}
