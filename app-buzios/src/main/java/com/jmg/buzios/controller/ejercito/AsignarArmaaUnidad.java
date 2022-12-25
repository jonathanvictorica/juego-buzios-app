/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.edificio.ConstruirEdificio;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * retornarcantidadunidadmilitar(unidadmilitar: UNIDADMILITAR): int	CIUDADEJERCITO
 * calcularcantidadunidadmilitarsinarma(unidadmilitar: UNIDADMILITAR): int	EJERCITOJUGADORARMA
 * verificarcantidaddeasignamientosdearma(cantidadunidad: int, cantidadsinarma: int): boolean	EJERCITOJUGADORARMA
 * buscarrecursosconstruccionarma(): ARMACONSTRUCCION	ARMA
 * calcularrecursosdecantidaddearma(cantidad: int): void	ARMACONSTRUCCION
 * verificarrecursosciudad(listarecursos: List<RECURSO>, cantidad: List<Integer>):boolean	CIUDAD
 * descontarrecursosciudad(listarecursos: List<RECURSO>,cantidad: List<Integer>): void	CIUDAD
 * construiryasignararmas(cantidad: int,unidadmilitar: UNIDADMILITAR): void	ARMA
 */
public class AsignarArmaaUnidad {

    private UnidadMilitar unidadmilitar;
    private Arma armaasignar;
    private Integer cantidad;
    private VCiudad vciudad;

    public AsignarArmaaUnidad(UnidadMilitar unidadmilitar, Arma armaasignar, Integer cantidad, VCiudad vciudad) {
        this.unidadmilitar = unidadmilitar;
        this.armaasignar = armaasignar;
        this.cantidad = cantidad;
        this.vciudad = vciudad;
    }

    public void CUAsignararmaaunidad() throws SQLException {
        if (this.vciudad.getCiudad().getCiudadejercito().calcularcantidadunidadmilitarsinarma( this.unidadmilitar) < this.cantidad) {
            JOptionPane.showMessageDialog(vciudad, "No tienes suficientes " + this.unidadmilitar.getNombre() + " sin arma para poder asignarles armas.");
        } else {
            this.armaasignar.calcularrecursosdecantidaddearma(cantidad);
            if (this.vciudad.getCiudad().getCiudadrecurso().verificarrecursosciudad( this.armaasignar.getArmaconstruccion().getRecursos(), this.armaasignar.getArmaconstruccion().getCantidad())) {
                AsignarArmaaUnidadThread asignararmas = new AsignarArmaaUnidadThread( this.unidadmilitar, this.armaasignar, 2, this.vciudad, this.cantidad);
                Thread hasignararmas = new Thread(asignararmas);
                hasignararmas.start();

                AsignarArmaaUnidadThread descontarrecursos = new AsignarArmaaUnidadThread( this.armaasignar, 1, this.vciudad);
                Thread hdescontarrecursos = new Thread(descontarrecursos);
                hdescontarrecursos.start();

                while (hdescontarrecursos.isAlive() || hasignararmas.isAlive()) {
                    if ((hdescontarrecursos.isInterrupted()) || (hasignararmas.isInterrupted())) {

                    }
                }
                this.vciudad.getCiudad().getCiudadejercito().inicializarejercitodeciudad();
                ConstruirEdificio.actualizarinterfazgrafica(vciudad);
                JOptionPane.showMessageDialog(vciudad, "Las armas fueron asignadas.");

            } else {
                JOptionPane.showMessageDialog(vciudad, "No tienes suficientes recursos para construir las armas que deseas asignar");
            }
        }

    }
}

class AsignarArmaaUnidadThread extends Thread {

    private UnidadMilitar unidadmilitar;
    private Arma arma;
    private Integer hilo;
    private VCiudad ciudad;
    private Integer cantidad;

    public AsignarArmaaUnidadThread( Arma arma, Integer hilo, VCiudad ciudad) {

        this.arma = arma;
        this.hilo = hilo;
        this.ciudad = ciudad;
    }

    public AsignarArmaaUnidadThread(  UnidadMilitar unidadmilitar, Arma arma, Integer hilo, VCiudad ciudad, Integer cantidad) {

        this.unidadmilitar = unidadmilitar;
        this.arma = arma;
        this.hilo = hilo;
        this.ciudad = ciudad;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    this.ciudad.getCiudad().getCiudadrecurso().descontarrecursosciudad( this.arma.getArmaconstruccion().getRecursos(), this.arma.getArmaconstruccion().getCantidad());

                } catch (SQLException ex) {

                }
                break;
            case 2:
                try {
                    this.arma.construiryasignararmas( this.cantidad, this.unidadmilitar, this.ciudad);
                    this.ciudad.getCiudad().getCiudadejercito().inicializarejercitodeciudad();

                } catch (SQLException ex) {

                }
                break;

        }
    }


}