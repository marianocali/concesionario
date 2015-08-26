package com.educacionit.jpa;

import static com.concesionaria.app.ApplicationAutos.mostrarAuto;
import com.concesionaria.dao.QuerysParametrizadasDao;
import com.concesionaria.dao.QuerysParametrizadasDaoImpl;
import com.concesionaria.domain.Auto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author mariano
 */
public class QuerysParametrizadasTest {

    //Retorna una instancia del DAO
    public QuerysParametrizadasDao getQuerysAutoDao() {
        QuerysParametrizadasDao querysParametrizadasDao = null;
        if (querysParametrizadasDao == null) {
            querysParametrizadasDao = new QuerysParametrizadasDaoImpl();
        }
        return querysParametrizadasDao;
    }

//    @Test
    public void TestObtenerAutosSegunCriterio() {
        System.out.println("TestObtenerAutosSegunCriterio ");

        String marca = "";
        String modelo = "";
        List<Auto> autos = new ArrayList<Auto>();
        autos = getQuerysAutoDao().obtenerAutosSegunCriterio(marca, modelo);
        System.out.println("autos obtenidos: " + autos.size());

        for (Auto auto : autos) {
            mostrarAuto(auto);
        }
    }

    @Test 
    public void TestObtenerAutosConPaginacion() {
        System.out.println("TestObtenerAutosConPaginacion");

        int registroInicial = 3;
        int cantidad = 3;
;        List<Auto> autos = new ArrayList<Auto>();
        autos = getQuerysAutoDao().obtenerAutosConPaginacion(registroInicial, cantidad);
        
        System.out.println("autos obtenidos con paginacion : " + autos.size());

        for (Auto auto : autos) {
            mostrarAuto(auto);
        }
    }
}
