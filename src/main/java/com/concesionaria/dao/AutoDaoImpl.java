package com.concesionaria.dao;

//import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import com.concesionaria.domain.Auto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mariano
 */
public class AutoDaoImpl implements AutoDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    private static AutoDaoImpl instance = new AutoDaoImpl();

    //Constructor privado para usar patron Singleton
    private AutoDaoImpl() {

    }

    public static AutoDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void guardar(Auto auto) {
        System.out.println("llega a guardar de AutoDaoImpl");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(auto);     //lo graba en la sesion de Hibernate

            em.getTransaction().commit();   //lo graba en la BD
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

    }

    @Override
    public void modificar(Auto auto) {
        System.out.println("llega a modificar de AutoDaoImpl");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(auto); //lo 

            em.getTransaction().commit();   //lo graba en la BD
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

    }

    public void shutDown() {
        emf.close();
    }

    @Override
    public void close() throws Exception {
        if (emf.isOpen()) {
            emf.close();
        }
    }

    @Override
    public Auto buscarAutoPorId(Long id) {
        EntityManager em = null;
        Auto auto = new Auto();
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            auto = em.find(Auto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return auto;
    }

    @Override
    public void eliminarAuto(Auto auto) {
        EntityManager em = null;

        Session session = null;
        Transaction transaction;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            auto = em.find(Auto.class, auto.getIdAuto());

            em.remove(auto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public List<Auto> buscarPorMarcaYModelo(String marca, String modelo) {

        EntityManager em = emf.createEntityManager();
        List<Auto> us = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select a from Auto a where a.marca like :param and a.modelo like :param2");
            q.setParameter("param", "%" + marca + "%");
            q.setParameter("param2", "%" + modelo + "%");
            us = q.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception ex) {

            }
        }
        return us;

    }

    @Override
    public void eliminarAutoPorId(Long id) {
        EntityManager em = null;

        Session session = null;
        Transaction transaction;
        try {

            em = emf.createEntityManager();
            em.getTransaction().begin();

            Auto auto = em.find(Auto.class, id);    //lo carga en el contexto de Hibernate para que no este detachado
            em.remove(auto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public List<Auto> getAllAutos() {

        EntityManager em = null;
        List<Auto> listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String consulta = "from Auto";
            Query query = em.createQuery(consulta);

            listaAutos = query.getResultList();

        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }

        return listaAutos;
    }

    @Override
    public Long getMaxId() {

        Long id = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String select = "select max(a.id) from Auto a";
            Query query = em.createQuery(select);
            id = (Long) query.getSingleResult();

        } catch (Exception e) {
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
            }
        }

        return id;
    }

    //Obtiene una lista de todos los Autos de un concesionario dado.
    @Override
    public List<Auto> findByConcesionarioId(Long idConcesionario) {

        EntityManager em = emf.createEntityManager();
        List<Auto> autos = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select a from Auto a where a.idConcesionario like :param");
            q.setParameter("param", "%" + idConcesionario + "%");
            autos = q.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception ex) {

            }
        }
        return autos;
    }
    
    /**
     * Retorna todos los autos cuyo precio supera el precio minimo indicado
     * @param precio
     * @return 
     */
    @Override
    public List<Auto> informarAutosMayorAPrecio(Double precioMinimo) {

        EntityManager em = emf.createEntityManager();
        List<Auto> listaAutos = null;
        try {
            em.getTransaction().begin();
            long precioLong = Math.round(precioMinimo);
            
            Query q = em.createQuery("select a from Auto a where a.precio > :param");
            q.setParameter("param",  precioLong );
            listaAutos = q.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception ex) {

            }
        }
        return listaAutos;

    }
}
