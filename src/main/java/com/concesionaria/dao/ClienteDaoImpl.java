/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mariano
 */
public class ClienteDaoImpl implements ClienteDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    private static ClienteDaoImpl instance = new ClienteDaoImpl();

    //Constructor privado para usar patron Singleton
    private ClienteDaoImpl() {

    }

    public static ClienteDaoImpl getInstance() {
        return instance;
    }

    public void guardar(Cliente cliente) {
        System.out.println("llega a guardar de AutoDaoImpl");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);     //lo graba en la sesion de Hibernate

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
    public Cliente findById(Long id) {
        EntityManager em = null;
        Cliente cliente = new Cliente();
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return cliente;
    }

}
