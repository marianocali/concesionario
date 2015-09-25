/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Auto;
import com.concesionaria.domain.Concesionario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mariano
 */
public class ConcesionarioDaoImpl implements ConcesionarioDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");
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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();

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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String query = ("select max(c.id) from Concesionario c");
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
            em = emf.createEntityManager();
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

        EntityManagerFactory emfstatic = Persistence.createEntityManagerFactory("clase2PU");
        EntityManager em = null;
        ConcesionarioDaoImpl concesionarioDaoImpl = DaoFactory.getConcesionarioDao();
        try {
            em = emfstatic.createEntityManager();
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
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Concesionario c join c.autos"
                    + " where c.idConcesionario like :param");
            query.setParameter("param", idConcesionario );

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

//    String query1="select u from Usuario u join u.auto ";
}
