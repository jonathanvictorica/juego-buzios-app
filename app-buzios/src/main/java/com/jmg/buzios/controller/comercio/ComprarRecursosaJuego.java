/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.comercio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.comercio.DepositoMercado;
import com.jmg.buzios.model.comercio.Oferta;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * verificarofertaexista(codigooferta: Int): 	OFERTA
 * inicializaroferta(codigooferta: Int): void	OFERTA
 * verificarcantidadacomprar(cantidad: int): boolean	OFERTA
 * verificaroro(cantidadoro: int): boolean	JUGADOR
 * verificarrecursosciudad(listarecursos: List<RECURSO>, cantidad: List<Integer>):boolean	CIUDAD
 * almacenarrecursomercado(nickjugador: String, recurso: RECURSO,cantidad: int)	DEPOSITOMERCADO
 * pagaroro(oro: int)	JUGADOR
 * descontarrecursooferta(recurso: RECURSO,cantidad: int): void	OFERTA
 */
public class ComprarRecursosaJuego implements Actualizar {


    private VCiudad ciudadjugador;
    private Oferta ofertajuego;

    private Integer cantidadacomprar;

    public ComprarRecursosaJuego(VCiudad ciudadjugador, Oferta ofertajuego, Integer cantidadacomprar) {
        this.ciudadjugador = ciudadjugador;
        this.ofertajuego = ofertajuego;
        this.cantidadacomprar = cantidadacomprar;
    }


    public void CUcomprarrecursosajuego() throws SQLException {

        if (this.ofertajuego.verificarcantidadacomprar( cantidadacomprar)) {
            if (this.ofertajuego.isOrobuscado()) {
                if (this.ciudadjugador.getCiudad().getJugador().verificaroro( this.cantidadacomprar)) {
                    DepositoMercado depositomercado = new DepositoMercado(this.ciudadjugador.getCiudad().getJugador());
                    depositomercado.almacenarrecursomercado( this.ofertajuego.getRecurso(), cantidadacomprar);

                    ciudadjugador.getCiudad().getJugador().pagaroro( cantidadacomprar);


                    this.ofertajuego.descontarrecursooferta( cantidadacomprar);
                } else {
                    JOptionPane.showMessageDialog(null, "No tienes suficiente oro para comprar esta oferta");
                }
            } else {
                if (this.ciudadjugador.getCiudad().getCiudadrecurso().verificarrecursosciudad( this.ofertajuego.getRecursobuscado(), this.cantidadacomprar)) {
                    DepositoMercado depositomercado = new DepositoMercado(this.ciudadjugador.getCiudad().getJugador());
                    depositomercado.almacenarrecursomercado( this.ofertajuego.getRecurso(), cantidadacomprar);

                    this.ofertajuego.descontarrecursooferta( cantidadacomprar);

                } else {
                    JOptionPane.showMessageDialog(null, "NO tienes sufiente " + this.ofertajuego.getRecursobuscado().getNombrerecurso() + " para comprar esta oferta");
                }
            }
            this.actualizarinterfazgrafica();

        } else {
            JOptionPane.showMessageDialog(null, "La cantidad que quieres comprar supera a la cantidad ofertada.");
        }


    }

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        this.ciudadjugador.getCiudad().inicializarciudad();
        this.ciudadjugador.getLblOro().setText("" + this.ciudadjugador.getCiudad().getJugador().getOro());
        try {
            this.ciudadjugador.getCiudad().getCiudadrecurso().inicializarrecursosciudad();
        } catch (SQLException ex) {

        }

        for (int i = 0; i < this.ciudadjugador.getCiudad().getCiudadrecurso().getRecurso().size(); i++) {
            switch (this.ciudadjugador.getCiudad().getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                case "Madera":
                    this.ciudadjugador.getLblMadera().setText("" + this.ciudadjugador.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Marmol":
                    this.ciudadjugador.getLblMarmol().setText("" + this.ciudadjugador.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Cristal":
                    this.ciudadjugador.getLblCristal().setText("" + this.ciudadjugador.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Vino":
                    this.ciudadjugador.getLblVino().setText("" + this.ciudadjugador.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
                case "Azufre":
                    this.ciudadjugador.getLblAzufre().setText("" + this.ciudadjugador.getCiudad().getCiudadrecurso().getCantidad().get(i).intValue());
                    break;
            }
        }
        ciudadjugador.repaint();
    }
}
