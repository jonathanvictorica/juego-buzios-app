/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.cuenta;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.controller.ciudad.MostrarCiudad;
import com.jmg.buzios.model.isla.Isla;
import com.jmg.buzios.model.jugador.Jugador;
import com.jmg.buzios.view.login.VCREARJUGADOR;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * almacenarjugador(): void	JUGADOR
 */
public class CrearJugador implements Actualizar {

    private VCREARJUGADOR vcrearjugador;
    private boolean crearjugadoraceptado = false;


    public CrearJugador(VCREARJUGADOR vcrearjugador) {
        this.vcrearjugador = vcrearjugador;
    }


    public void CUcrearjugador() throws SQLException {

        Jugador jugadornuevo = new Jugador();
        jugadornuevo.setNick(this.vcrearjugador.getTxtNickdejugador().getText());
        jugadornuevo.setClave(this.vcrearjugador.getTxtConfirmarconstraseña().getText());

        if (jugadornuevo.verificarnickdisponible( jugadornuevo.getNick())) {

            Isla islavacia = null;
            islavacia = Isla.buscarislavacia();

            List<Integer> posicionesocupadas = new ArrayList<>();

            Isla.buscar_posiciones_ocupadas( posicionesocupadas, islavacia);
            if (islavacia != null) {

                this.crearjugadoraceptado = true;
                jugadornuevo.almacenarjugador();


                boolean controlvacio = true;
                int lugarisla = 0;

                for (int j = 1; j <= islavacia.getCapacidadciudades(); j++) {
                    controlvacio = true;
                    for (int i = 0; i < posicionesocupadas.size(); i++) {
                        if (posicionesocupadas.get(i) == j) {
                            controlvacio = false;
                        }


                    }
                    if (controlvacio == true) {
                        lugarisla = j;
                        j = 50;
                    }
                }


                islavacia.construirciudadenisla( jugadornuevo, lugarisla);

                islavacia.descontarcapacidadciudadisla();

                jugadornuevo.inicializarciudadesdejugador();


                MostrarCiudad mostrarciudadcapital = new MostrarCiudad(jugadornuevo.getCiudades().get(0));
                mostrarciudadcapital.CUmostrarciudad();
            } else {
                JOptionPane.showMessageDialog(vcrearjugador, "Lo sentimos. Este mundo esta lleno de ciudades. No puedes crear tu cuenta.");
                System.exit(0);
            }

        } else {
            JOptionPane.showMessageDialog(vcrearjugador, "El nick " + jugadornuevo.getNick() + " ya esta siendo utilizado en el juego, por favor escoja otro. ");
        }
        this.actualizarinterfazgrafica();
    }


    @Override
    public void actualizarinterfazgrafica() {
        if (crearjugadoraceptado) {
            vcrearjugador.hide();
        } else {
            vcrearjugador.getTxtConfirmarconstraseña().setText("");
            vcrearjugador.getTxtConstraseña().setText("");
            vcrearjugador.getTxtNickdejugador().setText("");
        }
    }

    @Override
    public void actualizardatospantalla() {

    }
}
