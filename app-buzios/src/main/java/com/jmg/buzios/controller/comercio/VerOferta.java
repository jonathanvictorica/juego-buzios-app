/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.comercio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.comercio.Oferta;
import com.jmg.buzios.model.comercio.OfertaJugador;
import com.jmg.buzios.model.jugador.Jugador;
import com.jmg.buzios.view.comercio.VVerOferta;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class VerOferta implements Actualizar {

    private Jugador jugador;
    private List<Oferta> ofertas = new ArrayList<>();
    private String recursofiltro;
    private VVerOferta pantallaofertas;

    private Oferta ofertabuscada;

    public VerOferta(List<Oferta> ofertas, String recursofiltro, VVerOferta pantalla, Jugador jugador) {
        this.recursofiltro = recursofiltro;
        this.pantallaofertas = pantalla;
        this.jugador = jugador;
        this.ofertas = ofertas;
    }

    public VerOferta(Jugador jugador, VVerOferta pantallaofertas, Oferta ofertabuscada) {
        this.jugador = jugador;
        this.pantallaofertas = pantallaofertas;
        this.ofertabuscada = ofertabuscada;
    }


    public void CUInicializarOfertas() {
        if (this.recursofiltro.equals("Todos")) {
            Oferta.buscarOfertas(this.ofertas, this.jugador);
        } else {
            Oferta.buscarOfertas(this.ofertas, recursofiltro, this.jugador);
        }
        this.actualizarinterfazgrafica();
    }


    @Override
    public void actualizarinterfazgrafica() {
        DefaultListModel modelo = new DefaultListModel();
        modelo.add(0, "");
        for (int i = 0; i < this.ofertas.size(); i++) {
            modelo.add(i, this.ofertas.get(i).getCodigooferta());
        }
        this.pantallaofertas.getLstOfertas().setModel(modelo);
        this.pantallaofertas.repaint();
    }

    public void MostrarOferta() throws SQLException {

        if (this.ofertabuscada.isJugador()) {
            this.ofertabuscada.inicializarOfertaJugador(((OfertaJugador) this.ofertabuscada));


        } else {

            this.ofertabuscada.inicializarOferta();
        }
        this.actualizardatospantalla();
    }


    @Override
    public void actualizardatospantalla() {
        this.pantallaofertas.getPantallaDetalleOferta().setVisible(true);


        this.pantallaofertas.getLblJugadorOferente().setVisible(false);

        this.pantallaofertas.getLblNumeroOferta().setText("" + this.ofertabuscada.getCodigooferta());
        this.pantallaofertas.getLblRecursoavender().setText("" + this.ofertabuscada.getRecurso().getNombrerecurso());

        this.pantallaofertas.getLblCantidadOfertada().setText("" + this.ofertabuscada.getCantidad());

        if (this.ofertabuscada.isOrobuscado()) {
            this.pantallaofertas.getLblRecursoBuscado().setText("Oro");
        } else {
            if (this.ofertabuscada.getRecursobuscado() != null) {
                this.pantallaofertas.getLblRecursoBuscado().setText(this.ofertabuscada.getRecursobuscado().getNombrerecurso());
            }
        }


        if (this.ofertabuscada.isJugador()) {
            if (((OfertaJugador) this.ofertabuscada).getJugador() != null) {
                this.pantallaofertas.getLblJugadorOferente().setVisible(true);

                this.pantallaofertas.getLblJugadorOferente().setText(((OfertaJugador) this.ofertabuscada).getJugador().getNick());
            }
        }

        this.pantallaofertas.repaint();

    }
}
