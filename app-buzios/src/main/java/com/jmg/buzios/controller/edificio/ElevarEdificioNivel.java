/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class ElevarEdificioNivel implements Actualizar {


    private JFrame veredificio;
    private Ciudad ciudadjugador;
    private EdificioNivel edificionivel;

    private VCiudad vciudad;


    public ElevarEdificioNivel(JFrame veredificio, Ciudad ciudadjugador, EdificioNivel edificionivel, VCiudad vciudad) {
        this.veredificio = veredificio;
        this.ciudadjugador = ciudadjugador;
        this.edificionivel = edificionivel;
        this.vciudad = vciudad;
    }

    public void CUelevaredificionivel() throws SQLException {

        int indice = ciudadjugador.verificaredificioenciudad(edificionivel.getEdificio().getNombre());
        if (indice != -1) {
            if (ciudadjugador.getCiudadedificios().getEdificionivel().get(indice).verificarposibleampliacionedificio()) {

                if (this.ciudadjugador.getCiudadrecurso().verificarrecursosciudad( ciudadjugador.getCiudadedificios().getEdificionivel().get(indice).getEdificiorecurso().getRecurso(), ciudadjugador.getCiudadedificios().getEdificionivel().get(indice).getEdificiorecurso().getCantidad())) {

                    ElevarEdificioNivelThread elevaredificio = new ElevarEdificioNivelThread( 1, this.ciudadjugador.getCiudadedificios().getEdificionivel().get(indice), ciudadjugador);
                    Thread helevaredificio = new Thread(elevaredificio);
                    helevaredificio.start();

                    ElevarEdificioNivelThread descontarrecursos = new ElevarEdificioNivelThread( 2, this.ciudadjugador.getCiudadedificios().getEdificionivel().get(indice), ciudadjugador);
                    Thread hdescontarrecursos = new Thread(descontarrecursos);
                    hdescontarrecursos.start();


                    while (helevaredificio.isAlive() || hdescontarrecursos.isAlive()) {
                        if ((helevaredificio.isInterrupted()) || (hdescontarrecursos.isInterrupted())) {
                            JOptionPane.showMessageDialog(null, "Lo sentimos pero la operacion no pudo ser realizada");
                            return;
                        }
                    }
                    this.veredificio.hide();
                    this.vciudad.getCiudad().getCiudadrecurso().inicializarrecursosciudad();
                    this.vciudad.getCiudad().getCiudadedificios().inicializaredificiosdeciudad();
                    if (this.edificionivel.getEdificio().getNombre().equals("Intendencia")) {
                        this.vciudad.getCiudad().inicializarciudad();
                    }
                    JOptionPane.showMessageDialog(veredificio, "El edificio ha sido elevado de nivel.");

                } else {
                    JOptionPane.showMessageDialog(null, "La ciudad no tiene los recursos suficientes para elevar el edificio de nivel.");

                }
            } else {
                JOptionPane.showMessageDialog(null, "El edificio no se puede ampliar más");
            }
        }
        this.actualizarinterfazgrafica();
    }


    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
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


class ElevarEdificioNivelThread extends Thread {
    private int hilo;


    private EdificioNivel edificionivel;
    private Ciudad ciudadjugador;

    public ElevarEdificioNivelThread(  int hilo, EdificioNivel edificionivel, Ciudad ciudadjugador) {
        this.hilo = hilo;

        this.edificionivel = edificionivel;
        this.ciudadjugador = ciudadjugador;
    }


    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    (this.edificionivel).elevaredificio( ciudadjugador);
                } catch (SQLException ex) {
                }

                break;
            case 2:
                try {
                    this.ciudadjugador.getCiudadrecurso().descontarrecursosciudad( edificionivel.getEdificiorecurso().getRecurso(), edificionivel.getEdificiorecurso().getCantidad());
                } catch (SQLException ex) {

                }

                break;

        }

    }

}