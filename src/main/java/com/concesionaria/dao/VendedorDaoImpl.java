/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

/**
 *
 * @author mariano
 */
public class VendedorDaoImpl extends PersonaDaoImpl implements VendedorDao {

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    private static VendedorDaoImpl instance = new VendedorDaoImpl();

    private VendedorDaoImpl() {
        //constructor privado para usar Singleton
    }

    public static VendedorDaoImpl getInstance() {
        return instance;
    }

//    @Override
//    public void guardar(Persona persona) {
//        System.out.println("llega a guardar de AutoDaoImpl");
//        EntityManager em = null;
//        try {
//            em = emf.createEntityManager();
//            em.getTransaction().begin();
//            em.persist(persona);     //lo graba en la sesion de Hibernate
//
//            em.getTransaction().commit();   //lo graba en la BD
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (em != null) {
//                    em.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//    }
//
//    @Override
//    public Persona buscarPorId(Long id) {
//        EntityManager em = null;
//        Vendedor vendedor = new Vendedor();
//        try {
//            em = emf.createEntityManager();
//            em.getTransaction().begin();
//            vendedor = em.find(Vendedor.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//        return vendedor;
//    }
//
//    @Override
//    public void modificar(Persona persona) {
//        System.out.println("llega a modificar de VendedorDaoImpl");
//
//        EntityManager em = null;
//        try {
//            em = emf.createEntityManager();
//            em.getTransaction().begin();
//            em.merge(persona); //lo graba en la sesion de Hibernate 
//
//            em.getTransaction().commit();   //lo graba en la BD
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (em != null) {
//                    em.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//    }
//
//    @Override
//    public void eliminar(long idPersona) {
//        System.out.println("llega a eliminar de VendedorDaoImpl");
//
//        EntityManager em = null;
//        try {
//            em = emf.createEntityManager();
//            em.getTransaction().begin();
//            Persona persona = buscarPorId(idPersona);
//            
//            em.remove(persona); //lo elimina en la sesion de Hibernate 
//
//            em.getTransaction().commit();   //lo elimina en la BD
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (em != null) {
//                    em.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//    }

}
