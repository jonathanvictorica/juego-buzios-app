/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.comercio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.comercio.DepositoMercado;
import com.jmg.buzios.model.comercio.Oferta;
import com.jmg.buzios.model.comercio.OfertaJugador;
import com.jmg.buzios.model.jugador.MensajePrivado;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * verificarofertaexista(codigooferta: Int): OFERTAJUGADOR	OFERTA
 * inicializarofertajugador(codigooferta: Int): void	OFERTAJUGADOR
 * verificarcantidadacomprar(cantidad: int): boolean	OFERTA
 * verificaroro(cantidadoro: int): boolean	JUGADOR
 * verificarrecursosciudad(listarecursos: List<RECURSO>, cantidad: List<Integer>):boolean	CIUDAD
 * almacenarrecursomercado(nickjugador: String,recurso: RECURSO,cantidad: int)	DEPOSITOMERCADO
 * recibiroro(oro: int)	JUGADOR
 * <p>
 * <p>
 * almacenarrecursomercado(nickjugador: String, recurso: RECURSO,cantidad: int)	DEPOSITOMERCADO
 * pagaroro(oro: int)	JUGADOR
 * descontarrecursooferta(recurso: RECURSO,cantidad: int): void	OFERTA
 * enviarmensaje(nickjugador: String, nickreceptor: String, mensaje: String, titulo: String)	JUGADOR
 */
public class ComprarRecursosdeJugador implements Actualizar {


    private VCiudad ciudadjugador;
    private OfertaJugador ofertajugador;
    private int cantidadacomprar;

    public ComprarRecursosdeJugador(VCiudad ciudadjugador, OfertaJugador ofertajugador, int cantidadacomprar) {

        this.ciudadjugador = ciudadjugador;
        this.ofertajugador = ofertajugador;
        this.cantidadacomprar = cantidadacomprar;
    }


    public void CUcomprarrecursosdejugador() throws SQLException {


        if (ofertajugador.verificarcantidadacomprar( cantidadacomprar)) {
            if (ofertajugador.isOrobuscado() == false) {
                if (this.ciudadjugador.getCiudad().getCiudadrecurso().verificarrecursosciudad( ofertajugador.getRecursobuscado(), ofertajugador.getCantidad())) {
                    DepositoMercado depositomercado_jugadorcomprador = new DepositoMercado();
                    depositomercado_jugadorcomprador.setJugador(ciudadjugador.getCiudad().getJugador());

                    CompararRecursosdeJugadorThread almacenardepositocomprador = new CompararRecursosdeJugadorThread(1, ofertajugador, cantidadacomprar, depositomercado_jugadorcomprador);
                    Thread halmacenardepositocomprador = new Thread(almacenardepositocomprador);
                    halmacenardepositocomprador.start();

                    DepositoMercado depositomercado_jugadorofertante = new DepositoMercado();
                    depositomercado_jugadorofertante.setJugador(((OfertaJugador) ofertajugador).getJugador());

                    CompararRecursosdeJugadorThread almacenardepositovendedor = new CompararRecursosdeJugadorThread(2, ofertajugador, cantidadacomprar, depositomercado_jugadorofertante);
                    Thread halmacenardepositovendedor = new Thread(almacenardepositovendedor);
                    halmacenardepositovendedor.start();

                    CompararRecursosdeJugadorThread descontarrecursopagar = new CompararRecursosdeJugadorThread(6, ofertajugador, cantidadacomprar, this.ciudadjugador);
                    Thread hdescontarrecursopagar = new Thread(descontarrecursopagar);
                    hdescontarrecursopagar.start();

                    CompararRecursosdeJugadorThread descontarrecursosoferta = new CompararRecursosdeJugadorThread(4, ofertajugador, cantidadacomprar);
                    Thread hdescontarrecursosoferta = new Thread(descontarrecursosoferta);
                    hdescontarrecursosoferta.start();

                    MensajePrivado mensajeprivado = new MensajePrivado(this.ciudadjugador.getCiudad().getJugador(), ((OfertaJugador) ofertajugador).getJugador(), "Felicidades, un jugador ha comprado algo o el total de tu oferta en el mercado", "HAZ HECHO NEGOCIO");

                    CompararRecursosdeJugadorThread enviarmensajeavendedor = new CompararRecursosdeJugadorThread(5, mensajeprivado);
                    Thread henviarmensajeavendedor = new Thread(enviarmensajeavendedor);
                    henviarmensajeavendedor.start();

                    while (halmacenardepositocomprador.isAlive() || halmacenardepositovendedor.isAlive() || hdescontarrecursopagar.isAlive() || henviarmensajeavendedor.isAlive() || hdescontarrecursosoferta.isAlive()) {

                    }


                    JOptionPane.showMessageDialog(null, "Buen Negocio. Has adquirido " + this.cantidadacomprar + " unidades de " + ofertajugador.getRecurso().getNombrerecurso() + " que ya fueron depositados en los almacenes de tu Deposito de Mercado, puedes retirarlo cuando desees");

                } else {
                    JOptionPane.showMessageDialog(null, "No tiene sufieciente ." + ofertajugador.getRecursobuscado().getNombrerecurso() + " para comprar esta oferta.");
                }
            } else {
                if (ciudadjugador.getCiudad().getJugador().verificaroro( this.ofertajugador.getCodigooferta())) {
                    DepositoMercado depositomercadojugadorcomprador = new DepositoMercado();
                    depositomercadojugadorcomprador.setJugador(ciudadjugador.getCiudad().getJugador());

                    CompararRecursosdeJugadorThread almacenardepositocomprador = new CompararRecursosdeJugadorThread(1, ofertajugador, cantidadacomprar, depositomercadojugadorcomprador);
                    Thread halmacenardepositocomprador = new Thread(almacenardepositocomprador);
                    halmacenardepositocomprador.start();

                    CompararRecursosdeJugadorThread pagaroro = new CompararRecursosdeJugadorThread(3, this.ciudadjugador, cantidadacomprar);
                    Thread hpagaroro = new Thread(pagaroro);
                    hpagaroro.start();

                    CompararRecursosdeJugadorThread descontarrecursosoferta = new CompararRecursosdeJugadorThread(4, ofertajugador, cantidadacomprar);
                    Thread hdescontarrecursosoferta = new Thread(descontarrecursosoferta);
                    hdescontarrecursosoferta.start();

                    CompararRecursosdeJugadorThread recibiroro = new CompararRecursosdeJugadorThread(7, ofertajugador, cantidadacomprar);
                    Thread hrecibiroro = new Thread(recibiroro);
                    hrecibiroro.start();

                    MensajePrivado mensajeprivado = new MensajePrivado(this.ciudadjugador.getCiudad().getJugador(), ((OfertaJugador) ofertajugador).getJugador(), "Felicidades, un jugador ha comprado algo o el total de tu oferta en el mercado", "HAZ HECHO NEGOCIO");

                    CompararRecursosdeJugadorThread enviarmensajeavendedor = new CompararRecursosdeJugadorThread(5, mensajeprivado);
                    Thread henviarmensajeavendedor = new Thread(enviarmensajeavendedor);
                    henviarmensajeavendedor.start();

                    JOptionPane.showMessageDialog(null, "Buen Negocio. Has adquirido " + ofertajugador.getCantidad() + " unidades de " + ofertajugador.getRecurso().getNombrerecurso() + " que ya fueron depositados en los almacenes de tu Deposito de Mercado, puedes retirarlo cuando desees");

                } else {
                    JOptionPane.showMessageDialog(null, "No tienes suficiente oro para comprar esta oferta.");
                }
            }
            this.actualizarinterfazgrafica();

        } else {
            JOptionPane.showMessageDialog(null, "La cantidad que quiere comprar supera la cantidad ofertada por el jugador.");
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

class CompararRecursosdeJugadorThread extends Thread {

    private DepositoMercado deposito;
    private VCiudad vciudad;
    private Oferta ofertajugador;
    private int hilo;
    private Integer cantidadacomprar;
    private MensajePrivado mensajeprivado;


    public CompararRecursosdeJugadorThread(int hilo, Oferta ofertajugador, Integer cantidadacomprar, DepositoMercado deposito) {

        this.ofertajugador = ofertajugador;
        this.hilo = hilo;
        this.cantidadacomprar = cantidadacomprar;
        this.deposito = deposito;
    }

    public CompararRecursosdeJugadorThread(int hilo, Oferta ofertajugador, Integer cantidadacomprar, VCiudad vciudad) {

        this.ofertajugador = ofertajugador;
        this.hilo = hilo;
        this.cantidadacomprar = cantidadacomprar;
        this.vciudad = vciudad;
    }

    public CompararRecursosdeJugadorThread(int hilo, MensajePrivado mensajeprivado) {

        this.hilo = hilo;
        this.mensajeprivado = mensajeprivado;
    }

    public CompararRecursosdeJugadorThread(int hilo, Oferta ofertajugador, Integer cantidadacomprar) {

        this.ofertajugador = ofertajugador;
        this.hilo = hilo;
        this.cantidadacomprar = cantidadacomprar;

    }

    public CompararRecursosdeJugadorThread(int hilo, VCiudad vciudad, Integer cantidadacomprar) {

        this.vciudad = vciudad;
        this.hilo = hilo;
        this.cantidadacomprar = cantidadacomprar;
    }


    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    this.deposito.almacenarrecursomercado( ofertajugador.getRecurso(), cantidadacomprar);
                } catch (SQLException ex) {
                }
                break;
            case 2:
                try {
                    this.deposito.almacenarrecursomercado( ofertajugador.getRecursobuscado(), cantidadacomprar);
                } catch (SQLException ex) {
                }
                break;
            case 3:
                try {
                    vciudad.getCiudad().getJugador().pagaroro( cantidadacomprar);
                } catch (SQLException ex) {
                }
                break;
            case 4:
                try {
                    ofertajugador.descontarrecursooferta( cantidadacomprar);
                } catch (SQLException ex) {

                }
                break;
            case 5:
                mensajeprivado.enviarmensaje();
                break;
            case 6:
                try {
                    this.vciudad.getCiudad().getCiudadrecurso().descontarrecursosciudad( ofertajugador.getRecursobuscado(), cantidadacomprar);
                } catch (SQLException ex) {

                }

                break;
            case 7:
                try {
                    ((OfertaJugador) this.ofertajugador).getJugador().recibiroro( cantidadacomprar);
                } catch (SQLException ex) {

                }

                break;


        }
    }


}