/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ciudad;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Alumno
 */
public class MostrarCiudad implements Actualizar {

    private Ciudad ciudadjugador;

    private VCiudad vciudad;

    public MostrarCiudad(Ciudad ciudadjugador) {
        this.ciudadjugador = ciudadjugador;
        this.ciudadjugador.getCiudadacademia().setCiudad(this.ciudadjugador);
        this.ciudadjugador.getCiudadbarco().setCiudad(this.ciudadjugador);
        this.ciudadjugador.getCiudadedificios().setCiudad(this.ciudadjugador);
        this.ciudadjugador.getCiudadejercito().setCiudad(this.ciudadjugador);
        this.ciudadjugador.getCiudadproduccion().setCiudad(this.ciudadjugador);
        this.ciudadjugador.getCiudadrecurso().setCiudad(this.ciudadjugador);
        this.ciudadjugador.getCiudadtaberna().setCiudad(this.ciudadjugador);


    }

    public MostrarCiudad(Ciudad ciudadjugador, int i) {
        this.ciudadjugador = ciudadjugador;
    }

    public void setVciudad(VCiudad vciudad) {
        this.vciudad = vciudad;
    }

    public void CUmostrarciudad() throws SQLException {
        this.ciudadjugador.inicializarciudad();

        this.ciudadjugador.getIsla().inicializar_isla();

//        MostrarCiudadThread inicializaracademia = new MostrarCiudadThread(ciudadjugador, 1 );
//        Thread iniciaracademia = new Thread(inicializaracademia);
//        iniciaracademia.start();
       new  MostrarCiudadThread(ciudadjugador, 1 ).run();

//        MostrarCiudadThread inicializarciudadesdejugador = new MostrarCiudadThread(ciudadjugador, 8 );
//        Thread hinicializarciudadesdejugador = new Thread(inicializarciudadesdejugador);
//        hinicializarciudadesdejugador.start();
        new MostrarCiudadThread(ciudadjugador, 8 ).run();

//        MostrarCiudadThread inicializaredificios = new MostrarCiudadThread(ciudadjugador, 2 );
//        Thread iniciaredificios = new Thread(inicializaredificios);
//        inicializaredificios.start();
        new MostrarCiudadThread(ciudadjugador, 2 ).run();

//        MostrarCiudadThread inicializarproduccion = new MostrarCiudadThread(ciudadjugador, 3 );
//        Thread iniciarproduccion = new Thread(inicializarproduccion);
//        iniciarproduccion.start();
        new MostrarCiudadThread(ciudadjugador, 3 ).run();

//        MostrarCiudadThread inicializarrecurso = new MostrarCiudadThread(ciudadjugador, 4 );
//        Thread iniciarrecurso = new Thread(inicializarrecurso);
//        iniciarrecurso.start();
        new MostrarCiudadThread(ciudadjugador, 4 ).run();

//        MostrarCiudadThread inicializarejercito = new MostrarCiudadThread(ciudadjugador, 5 );
//        Thread iniciarejercito = new Thread(inicializarejercito);
//        iniciarejercito.start();
        new MostrarCiudadThread(ciudadjugador, 5 ).run();

//        MostrarCiudadThread inicializarestado = new MostrarCiudadThread(ciudadjugador, 6 );
//        Thread iniciarestado = new Thread(inicializarestado);
//        iniciarestado.start();
        new MostrarCiudadThread(ciudadjugador, 6 ).run();

//        MostrarCiudadThread inicializarbarcos = new MostrarCiudadThread(ciudadjugador, 7 );
//        Thread iniciarbarco = new Thread(inicializarbarcos);
//        iniciarbarco.start();

        new MostrarCiudadThread(ciudadjugador, 7 ).run();

//        while (iniciarbarco.isAlive() || iniciaracademia.isAlive() || iniciaredificios.isAlive() || iniciarproduccion.isAlive() || iniciarrecurso.isAlive() || iniciarejercito.isAlive() || iniciarestado.isAlive()) {
//
//        }
        this.vciudad = new VCiudad(this.ciudadjugador);
        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();

        vciudad.getCiudad().getJugador().buscarciudadesdejugador();
        this.vciudad.getCboCiudades().addItem("   ");

        for (int i = 0; i < this.vciudad.getCiudad().getJugador().getCiudades().size(); i++) {
            if (!this.ciudadjugador.getNombre().equals(this.vciudad.getCiudad().getJugador().getCiudades().get(i).getNombre())) {
                this.vciudad.getCboCiudades().addItem(this.vciudad.getCiudad().getJugador().getCiudades().get(i).getNombre());
            }
        }
        vciudad.setControl(true);


        vciudad.repaint();


    }

    @Override
    public void actualizardatospantalla() {
        ImageIcon imagenedificio;
        String direccion = "";
        for (int i = 0; i < this.ciudadjugador.getCiudadedificios().getEdificionivel().size(); i++) {
            direccion = ("/IMAGEN/EDIFICIOSCIUDAD/" + this.ciudadjugador.getCiudadedificios().getEdificionivel().get(i).getEdificio().getImagen().getDireccion() + ".png");
            imagenedificio = new ImageIcon(getClass().getResource(direccion));
            switch (this.ciudadjugador.getCiudadedificios().getLugarciudad().get(i).intValue()) {
                case 1:
                    this.vciudad.getCmdMuro().setIcon(imagenedificio);
                    break;
                case 2:
                    this.vciudad.getCmdEdificioNaval().setIcon(imagenedificio);
                    break;
                case 3:
                    this.vciudad.getCmdEdificioNaval1().setIcon(imagenedificio);
                    break;
                case 4:
                    this.vciudad.getCmdEdificioIntendencia().setIcon(imagenedificio);
                    break;
                case 5:
                    this.vciudad.getCmdEdificio2().setIcon(imagenedificio);
                    break;
                case 6:
                    this.vciudad.getCmdEdificio3().setIcon(imagenedificio);
                    break;
                case 7:
                    this.vciudad.getCmdEdificio4().setIcon(imagenedificio);
                    break;
                case 8:
                    this.vciudad.getCmdEdificio5().setIcon(imagenedificio);
                    break;
                case 9:
                    this.vciudad.getCmdEdificio6().setIcon(imagenedificio);
                    break;
                case 10:
                    this.vciudad.getCmdEdificio7().setIcon(imagenedificio);
                    break;
                case 11:
                    this.vciudad.getCmdEdificio8().setIcon(imagenedificio);
                    break;
                case 12:
                    this.vciudad.getCmdEdificio9().setIcon(imagenedificio);
                    break;
                case 13:
                    this.vciudad.getCmdEdificio10().setIcon(imagenedificio);
                    break;
                case 14:
                    this.vciudad.getCmdEdificio11().setIcon(imagenedificio);
                    break;
                case 15:
                    this.vciudad.getCmdEdificio12().setIcon(imagenedificio);
                    break;


            }
        }
        vciudad.repaint();


    }


    @Override
    public void actualizarinterfazgrafica() {

        this.vciudad.setTitle(this.ciudadjugador.getNombre() + " [" + this.ciudadjugador.getIsla().getCoordenadax() + ":" + this.ciudadjugador.getIsla().getCoordenaday() + "]");

        String direccion = ("/IMAGEN/EDIFICIOSCIUDAD/" + "parcelavacia" + ".png");
        ImageIcon imagenedificio = new ImageIcon(getClass().getResource(direccion));
        for (int i = 0; i < 16; i++) {
            switch (i + 1) {
                case 1:
                    this.vciudad.getCmdMuro().setIcon(imagenedificio);
                    break;
                case 2:
                    this.vciudad.getCmdEdificioNaval().setIcon(imagenedificio);
                    break;
                case 3:
                    this.vciudad.getCmdEdificioNaval1().setIcon(imagenedificio);
                    break;
                case 4:
                    this.vciudad.getCmdEdificioIntendencia().setIcon(imagenedificio);
                    break;
                case 5:
                    this.vciudad.getCmdEdificio2().setIcon(imagenedificio);
                    break;
                case 6:
                    this.vciudad.getCmdEdificio3().setIcon(imagenedificio);
                    break;
                case 7:
                    this.vciudad.getCmdEdificio4().setIcon(imagenedificio);
                    break;
                case 8:
                    this.vciudad.getCmdEdificio5().setIcon(imagenedificio);
                    break;
                case 9:
                    this.vciudad.getCmdEdificio6().setIcon(imagenedificio);
                    break;
                case 10:
                    this.vciudad.getCmdEdificio7().setIcon(imagenedificio);
                    break;
                case 11:
                    this.vciudad.getCmdEdificio8().setIcon(imagenedificio);
                    break;
                case 12:
                    this.vciudad.getCmdEdificio9().setIcon(imagenedificio);
                    break;
                case 13:
                    this.vciudad.getCmdEdificio10().setIcon(imagenedificio);
                    break;
                case 14:
                    this.vciudad.getCmdEdificio11().setIcon(imagenedificio);
                    break;
                case 15:
                    this.vciudad.getCmdEdificio12().setIcon(imagenedificio);
                    break;


            }
        }

        this.vciudad.getLblMadera().setText("0");
        this.vciudad.getLblVino().setText("0");
        this.vciudad.getLblMarmol().setText("0");
        this.vciudad.getLblAzufre().setText("0");
        this.vciudad.getLblCristal().setText("0");
        this.vciudad.getLblOro().setText("0");

        if (this.vciudad.getCiudad().getJugador().getOro() != 0) {
            this.vciudad.getLblOro().setText("" + this.vciudad.getCiudad().getJugador().getOro());
        }

        for (int i = 0; i < this.vciudad.getCiudad().getCiudadrecurso().getRecurso().size(); i++) {
            switch (this.vciudad.getCiudad().getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                case "Madera":
                    this.vciudad.getLblMadera().setText("" + this.vciudad.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Marmol":
                    this.vciudad.getLblMarmol().setText("" + this.vciudad.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Cristal":
                    this.vciudad.getLblCristal().setText("" + this.vciudad.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Vino":
                    this.vciudad.getLblVino().setText("" + this.vciudad.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Azufre":
                    this.vciudad.getLblAzufre().setText("" + this.vciudad.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
            }
        }
        vciudad.repaint();
    }


}

class MostrarCiudadThread extends Thread {
    private Ciudad ciudadjugador;
    private Integer hilo;

    public MostrarCiudadThread(Ciudad ciudadjugador, Integer hilo ) {
        this.ciudadjugador = ciudadjugador;
        this.hilo = hilo;
    }

    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    ciudadjugador.getCiudadacademia().inicializaracademiadeciudad();
                } catch (SQLException ex) {
                    Logger.getLogger(MostrarCiudadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                try {
                    ciudadjugador.getCiudadedificios().inicializaredificiosdeciudad();
                } catch (SQLException ex) {
                    Logger.getLogger(MostrarCiudadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                try {
                    ciudadjugador.getCiudadproduccion().inicializarproduccionciudad();
                } catch (SQLException ex) {
                    Logger.getLogger(MostrarCiudadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                try {
                    ciudadjugador.getCiudadrecurso().inicializarrecursosciudad();
                } catch (SQLException ex) {
                    Logger.getLogger(MostrarCiudadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 5:
                ciudadjugador.getCiudadejercito().inicializarejercitodeciudad();
                break;
            case 6:
                try {
                    ciudadjugador.getEstado().inicializarestadociudad(ciudadjugador);
                } catch (SQLException ex) {
                    Logger.getLogger(MostrarCiudadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 7:
                ciudadjugador.getCiudadbarco().inicializarbarcosdeciudad();
                break;
            case 8:
                //this.ciudadjugador.getJugador().inicializarciudadesdejugador();
                break;
        }
    }


}