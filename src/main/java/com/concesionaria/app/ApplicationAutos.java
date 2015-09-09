/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionaria.app;

import com.concesionaria.dao.AutoDao;
import com.concesionaria.dao.AutoDaoImpl;
import com.concesionaria.dao.DaoFactory;
import com.concesionaria.domain.Auto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author mariano
 */
public class ApplicationAutos {

    public static void main(String[] args) {

        probarAuto();

    }

    public static void probarAuto() {
        AutoDao autoDao = DaoFactory.getAutoDao();
        try {
//            Auto auto1 = new Auto("Renault", "Megane");
//            Auto auto2 = new Auto("Toyota", "Corolla");

//            Auto autoABorrar = autoDao.buscarAutoPorId(4l);
            String marca = "o";
            String modelo = "c";
            List<Auto> autos = new ArrayList<Auto>();
            autos = autoDao.buscarPorMarcaYModelo(marca, modelo);
            System.out.println("autos obtenidos: " + autos.size());
            for (Auto auto : autos) {
                mostrarAuto(auto);
            }
//            mostrarAuto(auto2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                autoDao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void fechas() {
        Calendar fecha = Calendar.getInstance();
        fecha.set(2000, Calendar.FEBRUARY, 4);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
        System.out.println("Fecha Formateada: " + sdf.format(fecha.getTime()));

        System.out.println("dia " + fecha.get(Calendar.DATE));
        System.out.println("mes" + fecha.get(Calendar.MONTH));
        System.out.println("año " + fecha.get(Calendar.YEAR));
        System.out.println("fecha " + fecha.get(Calendar.LONG_FORMAT));
    }

    public static void mostrarAuto(Auto auto) {
        System.out.println("");
        System.out.println("Marca:" + auto.getMarca());
        System.out.println("Modelo: " + auto.getModelo());
        System.out.println("");
    }

}
