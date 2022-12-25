/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.comercio;

import com.jmg.buzios.model.comercio.OfertaJugador;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * verificarrecursosciudad(listarecursos: List<RECURSO>, cantidad: List<Integer>):boolean	CIUDAD
 * reservaroferta(jugador: JUGADOR,recursovender: RECURSO, cantidad: Integer, recursoacambio: RECURSO, oro: boolean): void	OFERTAJUGADOR
 * descontarrecursosciudad(listarecursos: List<RECURSO>,cantidad: List<Integer>): void	CIUDAD
 */
public class VenderRecurso {

    private VCiudad jugador;
    private Recurso recursoavender;
    private Recurso recursoacambio;
    private Integer cantidad;
    private boolean oroacambio;


    public VenderRecurso(VCiudad jugador, Recurso recursoavender, Recurso recursoacambio, Integer cantidad, boolean oroacambio) {
        this.jugador = jugador;
        this.recursoavender = recursoavender;
        this.recursoacambio = recursoacambio;
        this.cantidad = cantidad;
        this.oroacambio = oroacambio;
    }

    public void CUVenderRecurso() throws SQLException {
        if (jugador.getCiudad().getCiudadrecurso().verificarrecursosciudad(recursoacambio, cantidad)) {
            OfertaJugador ofertajugador = new OfertaJugador(this.jugador.getCiudad().getJugador(), recursoavender, cantidad, oroacambio, recursoacambio, true);

            VenderRecursoThread reservaroferta = new VenderRecursoThread( 1, ofertajugador, this.jugador);
            Thread hreservaroferta = new Thread(reservaroferta);
            hreservaroferta.start();

            VenderRecursoThread descontarrecursosciudad = new VenderRecursoThread( 2, ofertajugador, this.jugador);
            Thread hdescontarrecursosciudad = new Thread(descontarrecursosciudad);
            hdescontarrecursosciudad.start();

            while (hdescontarrecursosciudad.isAlive() || hreservaroferta.isAlive()) {
                if ((hdescontarrecursosciudad.isInterrupted()) || (hreservaroferta.isInterrupted())) {

                }
            }

            //actualizar los recursos de la ciudad

            JOptionPane.showMessageDialog(jugador, "Oferta Realizada!!!");

        } else {
            JOptionPane.showMessageDialog(jugador, "No tienes " + this.cantidad + " unidades de " + this.recursoavender.getNombrerecurso() + " para vender en el mercado.");

        }

    }
}

class VenderRecursoThread extends Thread {

    private OfertaJugador ofertajugador;
    private VCiudad vciudad;
    private int hilo;

    public VenderRecursoThread(int hilo, OfertaJugador ofertajugador, VCiudad vciudad) {

        this.ofertajugador = ofertajugador;
        this.hilo = hilo;
        this.vciudad = vciudad;
    }


    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    ofertajugador.reservaroferta();
                } catch (SQLException ex) {

                }
                break;

            case 2:
                try {
                    vciudad.getCiudad().getCiudadrecurso().descontarrecursosciudad(ofertajugador.getRecurso(), ofertajugador.getCantidad());
                } catch (SQLException ex) {

                }

                break;
        }

    }

}