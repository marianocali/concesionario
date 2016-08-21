/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Auto;
import com.concesionaria.domain.Concesionario;
import com.concesionaria.dto.ConcesionariaSueldosDto;
import com.concesionaria.dto.ConcesionarioFacturacionYAutosVendidosDto;
import com.concesionaria.dto.ConcesionarioGananciaDto;
import com.concesionaria.dto.ConcesionarioGastoCompraAutosDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mariano
 */
public class ConcesionarioDaoImpl implements ConcesionarioDao {

    private static final java.util.logging.Logger Log = java.util.logging.Logger.getLogger("Log4j.class");

    private static ConcesionarioDaoImpl instance = new ConcesionarioDaoImpl();

    //constructor privado para usar Singleton
    private ConcesionarioDaoImpl() {

    }

    public static ConcesionarioDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void agregar(Concesionario concesionario) {
        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();
            em.persist(concesionario);
            em.getTransaction().commit();

            Log.log(Level.FINEST, "se agrego concesionario " + concesionario.getNombre() + concesionario.getDireccion());
        } catch (Exception e) {
            Log.log(Level.SEVERE, "error al insertar concesionario");

        } finally {
            em.close();
        }

    }

    @Override
    public void actualizar(Concesionario concesionario) {

        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();
            em.merge(concesionario);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("error al actualizar concesionario");
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Concesionario concesionario) {

        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();

            em.getTransaction().begin();
            concesionario = em.find(Concesionario.class, concesionario.getIdConcesionario());
            em.remove(concesionario);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Concesionario findById(Long id) {

        EntityManager em = null;
        Concesionario concesionario = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();
            concesionario = em.find(Concesionario.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return concesionario;
    }

    @Override
    public Long getMaxId() {
        EntityManager em = null;

        Long id = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();

            String query = ("select max(c.idConcesionario) from Concesionario c");
            Query q = em.createQuery(query);

            id = (Long) q.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return id;
    }

    public List<Concesionario> getAllConcesionarios() {

        Log.info("getAllConcesionarios");

        List<Concesionario> listaConcesionarios = new ArrayList<Concesionario>();

        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();
            String consulta = "from Concesionario";
            Query query = em.createQuery(consulta);

            listaConcesionarios = query.getResultList();

        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }
        return listaConcesionarios;
    }

    public static void agregarAutos(Long idConcesionario, ArrayList<Auto> autos) {

        Log.info("agregarAutos");

        EntityManager em = null;
        ConcesionarioDaoImpl concesionarioDaoImpl = DaoFactory.getConcesionarioDao();
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();
            Concesionario concesionario = concesionarioDaoImpl.findById(idConcesionario);

            for (Auto auto : autos) {
                auto.setConcesionario(concesionario);
                em.merge(auto);             //lo actualiza en la cache de Hibernate
            }
            em.getTransaction().commit();   //lo graba en la BD

        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * Retorna un concesionario junto con sus autos
     *
     * @param idConcesionario
     * @return
     */
    @Override
    public Concesionario informarAutos(Long idConcesionario) {

        Log.info("informarAutos");

        EntityManager em = null;
        Concesionario concesionario = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Concesionario c join c.autos"
                    + " where c.idConcesionario like :param");
            query.setParameter("param", idConcesionario);

            concesionario = (Concesionario) query.getSingleResult();

        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }
        return concesionario;
    }

    @Override
    public void eliminar(Long idConcesionario) {

        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            Concesionario concesionario = null;

            em.getTransaction().begin();
            concesionario = em.find(Concesionario.class, idConcesionario);
            em.remove(concesionario);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Informar de cada concesionario el gasto en sueldos.
     *
     * @return listado con el nombre del concesionario y el total de sueldos
     */
    @Override
    public List<ConcesionariaSueldosDto> informarSueldos() {

        EntityManager em = null;
        List sueldosPorConcesionario = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            String querysueldos = "select new com.concesionaria.dto.ConcesionariaSueldosDto "
                    + "(concesionario.nombre, sum  (sueldo)) "
                    + "from Vendedor v "
                    + "group by v.concesionario";
            Query q1 = em.createQuery(querysueldos);
            sueldosPorConcesionario = q1.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }
        return sueldosPorConcesionario;
    }

    public List<ConcesionarioGastoCompraAutosDto> informarGastoEnCompraDeAutos() {
        EntityManager em = null;
        List gastosPorCompras = null;

        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            String queryGastosComprasAutos = "select new com.concesionaria.dto.ConcesionarioGastoCompraAutosDto "
                    + "(concesionario.nombre, (sum(precio) * 0.6)) "
                    + " from Auto as a"
                    + " group by a.concesionario";
            Query query = em.createQuery(queryGastosComprasAutos);
            gastosPorCompras = query.getResultList();

        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
            return gastosPorCompras;
        }
    }

    /**
     * Informar facturación por concesionario junto con la cantidad de autos
     * vendidos
     *
     * @return Lista con cada concesionario, su facturación y total de autos
     * vendidos Query que ejecuta:
     *
     * Select C.nombre , count(A.IDAUTO) AS " autos vendidos" , sum(A.precio)
     * FROM AUTOS AS A JOIN CONCESIONARIO AS C ON A.IDCONCESIONARIO =
     * C.IDCONCESIONARIO group by A.IDCONCESIONARIO;
     */
    public List<ConcesionarioFacturacionYAutosVendidosDto> informarFacturacionYNroAutosVendiddos() {

        EntityManager em = null;
        List facturacionYAutosVendidos = null;

        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            String queryFacturacionYAutosVendidos = "select new com.concesionaria.dto.ConcesionarioFacturacionYAutosVendidosDto "
                    + "(concesionario.nombre, sum(precio), count( idAuto)) "
                    + " from Auto AS A "
                    + " group by A.concesionario";
            Query query = em.createQuery(queryFacturacionYAutosVendidos);
            facturacionYAutosVendidos = query.getResultList();
        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }
        return facturacionYAutosVendidos;
    }

    /**
     * Informar la ganancia de cada concesionario durante el año 2002 La
     * ganancia es el 40% del total de la ventas del año
     *
     * @return
     */
    public List<ConcesionarioGananciaDto> informarGanancia() {
        EntityManager em = null;
        List gananciaPorConcesionario = null;

        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            String queryFacturacionYAutosVendidos = "select new com.concesionaria.dto.ConcesionarioGananciaDto "
                    + "(concesionario.nombre, sum(precio) * 0.4) "
                    + " from Auto AS A "
                    + " where A.anio = 2014 "
                    + " group by A.concesionario";
            Query query = em.createQuery(queryFacturacionYAutosVendidos);
            gananciaPorConcesionario = query.getResultList();
        } catch (Exception e) {

        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }
        return gananciaPorConcesionario;
    }

    /**
     * Actualizar en las tablas correspondientes: el sueldo fijo con un
     * incremento de 13% UPDATE estudio.VENDEDORES SET SUELDO = SUELDO / 1.13
     * WHERE IDCONCESIONARIO = 24;S
     */
    /**
     * Actualiza el sueldo de los empleados del concesionario dado en base al
     * porcentaje ingresado
     *
     * @param aumento porcentaje de aumento
     * @param idConcesionario concesionario en el que se aplica el aumento
     */
    public void aumentarSueldos(double aumento, long idConcesionario) {
        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            //abro transacción
            em.getTransaction().begin();
            //armo el query con los parametros
            String queryUpdateSueldos = " UPDATE Vendedor AS V "
                    + " SET sueldo = (sueldo * :aumento) "
                    + " WHERE V.concesionario = :id";

            //busco el concesionario a partir del idConcesionario ingresado
            Concesionario concesionario = findById(idConcesionario);

            //reemplaza los parametros del query por los parametros de entrada
            int sueldosActualizados = em.createQuery(queryUpdateSueldos)
                    .setParameter("aumento", aumento)
                    .setParameter("id", concesionario)
                    .executeUpdate();
            //comiteo los cambios
            em.getTransaction().commit();

            Log.log(Level.INFO, "sueldos actualizados : " + sueldosActualizados);
        } catch (Exception e) {
            Log.log(Level.SEVERE, "Error al aumentar sueldos " + e.getMessage());
        } finally {
            if (em != null) {
                try {
                    em.close();
                } catch (Exception e) {
                    Log.log(Level.SEVERE, "Error al intentar cerrar el EntityManager " + e.getMessage());
                }
            }
        }

    }

    /**
     * La concesionaria número 2 es declarada en quiebra, y cierra. 8. Dar de
     * baja la concesionaria junto con sus autos no vendidos y sus vendedores.
     * Los autos vendidos pasan a formar parte de la concesionaria 5.
     *
     * @param idConcesionarioQuiebra id de la concesionaria que quierba
     * @param idConcesionarioReemplaza id de la concesionaria que recibe los
     * autos
     */
    @Override
    public void quiebraConcesionario(Long idConcesionarioQuiebra, Long idConcesionarioReemplaza) {
        Concesionario concesionarioQuiebra = findById(idConcesionarioQuiebra);
        Concesionario concesionarioReemplaza = findById(idConcesionarioReemplaza);

        EntityManager em = null;
        try {
            em = GetEntityManagerFactory.getInstance().createEntityManager();
            
            //Obtengo la lista de autos de la concesinaria a remover y los agrego a la otra concesionaria
            Set<Auto> autosSet = concesionarioQuiebra.getAutos();
            if (autosSet != null) {
                ArrayList<Auto> autos = new ArrayList<Auto>(autosSet);
                agregarAutos(idConcesionarioReemplaza, autos);
            }
            
            //eliminar la concesionaria
            eliminar(concesionarioQuiebra);
            
       
        } catch (Exception e) {
            Log.log(Level.SEVERE, "Error en quieba de concesionario " + e.getMessage());
        } finally {
            if (em != null) {
                try {
                    em.close();
                } catch (Exception e) {
                    Log.log(Level.SEVERE, "Error al intentar cerrar el EntityManager " + e.getMessage());
                }
            }
        }

    }
}
