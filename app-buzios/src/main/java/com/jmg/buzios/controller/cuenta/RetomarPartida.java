/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.cuenta;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.controller.ciudad.MostrarCiudad;
import com.jmg.buzios.model.jugador.Jugador;
import com.jmg.buzios.view.login.VLOGIN;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class RetomarPartida implements Actualizar {
    private VLOGIN vlogin;
    private boolean entrada = false;

    public RetomarPartida(VLOGIN vlogin) {
        this.vlogin = vlogin;
    }

    public void CUretomarpartida() throws SQLException {
        Jugador jugadornuevo = new Jugador();
        jugadornuevo.setNick(this.vlogin.getTxtNickdejugador().getText());
        jugadornuevo.setClave(this.vlogin.getTxtConstraseña().getText());

        if (!jugadornuevo.verificarnickdisponible( jugadornuevo.getNick())) {
            if (jugadornuevo.verificarcontraseñadistintaalaantigua( jugadornuevo.getClave())) {
                this.entrada = true;
                jugadornuevo.inicializarciudadesdejugador();


                int indicecapital = 0;
                for (int i = 0; i < jugadornuevo.getCiudades().size(); i++) {
                    if (jugadornuevo.getCiudades().get(i).isCapital()) {
                        indicecapital = i;
                        i = jugadornuevo.getCiudades().size();
                    }
                }
                this.actualizarinterfazgrafica();
                MostrarCiudad mostrarciudadcapital = new MostrarCiudad(jugadornuevo.getCiudades().get(indicecapital));
                mostrarciudadcapital.CUmostrarciudad();
            } else {
                JOptionPane.showMessageDialog(vlogin, "La contraseña es incorrecta, ingresela nuevamente. ");

            }
        } else {
            JOptionPane.showMessageDialog(vlogin, "El nick " + jugadornuevo.getNick() + " no existen en el juego. ");
        }

        this.actualizarinterfazgrafica();
    }

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        if (entrada) {
            vlogin.hide();

        } else {
            vlogin.getTxtNickdejugador().setText("");
            vlogin.getTxtConstraseña().setText("");

        }
    }
}
