/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Auto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mariano
 */
public class QuerysParametrizadasDaoImpl implements QuerysParametrizadasDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    @Override
    public List obtenerAutosSegunCriterio(String marca, String modelo) {

        EntityManager em = emf.createEntityManager();
        List<Auto> us = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select a "
                                    + "from Auto a where a.marca like :param "
                                    + "and a.modelo like :param2");
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
    public List obtenerAutosConPaginacion(int registroInicial, int cantidad) {

        EntityManager em = emf.createEntityManager();
        List<Auto> us = null;
        try {
            int tamanioPagina = cantidad;
            em.getTransaction().begin();
            Query query = em.createQuery("from Auto a order by id asc");
            query.setFirstResult(registroInicial);
            query.setMaxResults(tamanioPagina);
            
            us = query.getResultList();

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
    
}
