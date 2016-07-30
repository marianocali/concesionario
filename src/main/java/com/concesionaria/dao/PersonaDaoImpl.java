/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mariano
 */
public class PersonaDaoImpl implements PersonaDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    private static PersonaDaoImpl instance = new PersonaDaoImpl();
    
    private PersonaDaoImpl(){
        //constructor privado para usar Singleton
    }
    
    public static PersonaDaoImpl getInstance(){
        return instance;
    }
    
    @Override
    public void guardar(Persona persona) {
        System.out.println("llega a guardar de AutoDaoImpl");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(persona);     //lo graba en la sesion de Hibernate

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
    public Persona buscarPorId(Long id) {
        EntityManager em = null;
        Persona persona = new Persona();
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            persona = em.find(Persona.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return persona;
    }

    @Override
    public void modificar(Persona persona) {
       System.out.println("llega a modificar de AutoDaoImpl");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(persona); //lo 

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

}
