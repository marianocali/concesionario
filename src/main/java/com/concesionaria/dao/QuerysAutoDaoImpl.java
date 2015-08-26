/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.dao;

import com.concesionaria.domain.Auto;
import com.concesionaria.domain.AutoMarcaPrecioDto;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mariano
 */
public class QuerysAutoDaoImpl implements QuerysAutoDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clase2PU");

    @Override
    public List<Auto> getAutosOrdenadosFechaDesc() {

        EntityManager em = null;
        List<Auto> listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String consultaAutosOrdenadosFechaDes = "from Auto a order by a.fechaVenta desc";

            Query query = em.createQuery(consultaAutosOrdenadosFechaDes);

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
    public List<Auto> getAutosFechaVenta(Calendar fechaDesde, Calendar fechaHasta) {

        EntityManager em = null;
        List<Auto> listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String autosFechabetween = "from Auto a where fechaVenta between :desde and :hasta ";
            Query query = em.createQuery(autosFechabetween);
            query.setParameter("desde", fechaDesde);
            query.setParameter("hasta", fechaHasta);

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
    public List<Auto> getAutosPorAnio(Integer anio) {

        EntityManager em = null;
        List<Auto> listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String autosPorAnio = "from Auto a where anio like :anio";
            Query query = em.createQuery(autosPorAnio);
            query.setParameter("anio", anio);

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
    public List<Auto> getAutosPorMarcaLetraInicial(Character letra) {

        EntityManager em = null;
        List<Auto> listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String autosPorLetra = "from Auto a where marca like :letra";
            Query query = em.createQuery(autosPorLetra);
            query.setParameter("letra", letra + "%");

            listaAutos = query.getResultList();

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
        return listaAutos;
    }

    //Autos con un precio superior al recibido por parametro
    @Override
    public List<Auto> getAutosPorPrecioMayorA(Long precio) {

        EntityManager em = null;
        List<Auto> listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String autosPorPrecioMayorA = "from Auto a where precio > :precio";
            Query query = em.createQuery(autosPorPrecioMayorA);
            query.setParameter("precio", precio);

            listaAutos = query.getResultList();

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
        return listaAutos;
    }

    @Override
    public Long getCantidadTotalAutos() {

        EntityManager em = null;
        Long cantidad = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String cantidadAutos = "select count(id) from Auto a";
            Query query = em.createQuery(cantidadAutos);

            cantidad = (Long) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cantidad;
    }

    @Override
    public Long getCantidadMarcasDiferentes() {

        EntityManager em = null;
        Long cantidad = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String selectCantidadMarcas = "select count (distinct a.marca) from Auto a";
            Query query = em.createQuery(selectCantidadMarcas);

            cantidad = (Long) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cantidad;
    }

    @Override
    public Auto getAutoConPrecioMayor() {

        EntityManager em = null;
        Auto auto = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String selectAutoMasCaro = "from Auto where precio = (select max(precio) from Auto)";
            Query query = em.createQuery(selectAutoMasCaro);

            auto = (Auto) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return auto;
    }

    @Override
    public Double promedioPrecios() {

        EntityManager em = null;
        Double promedio = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String selectPromedio = "select avg (precio) from Auto";
            Query query = em.createQuery(selectPromedio);

            promedio = (Double) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return promedio;
    }

    @Override
    public List<AutoMarcaPrecioDto> ventaTotalPorMarca() {

        EntityManager em = null;
        List listaAutos = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String selectTotalPorMarca = "select new com.concesionaria.domain.AutoMarcaPrecioDto (a.marca, sum (a.precio)) from Auto a group by a.marca";
            Query query = em.createQuery(selectTotalPorMarca);
            listaAutos = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (em != null) {
                    em.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaAutos;
    }
}
