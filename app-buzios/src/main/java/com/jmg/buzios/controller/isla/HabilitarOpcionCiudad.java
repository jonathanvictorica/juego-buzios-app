/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.view.islas.VerIsla1;
import com.jmg.buzios.view.islas.VerIsla2;
import com.jmg.buzios.view.islas.VerIsla3;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class HabilitarOpcionCiudad implements Actualizar {

    private JFrame vistaisla;
    private Ciudad ciudadelegida;
    private Ciudad ciudadjugador;


    private List<Integer> accionespermitidas = new ArrayList<>();

    public HabilitarOpcionCiudad(JFrame vistaisla, Ciudad ciudadjugador, Ciudad ciudadelegida) {
        this.vistaisla = vistaisla;
        this.ciudadelegida = ciudadelegida;
        this.ciudadjugador = ciudadjugador;
    }

    public void CUhabilitaropcionesciudad() throws SQLException {
        this.accionespermitidas.add(1);
        if (!this.ciudadjugador.verificarPuertoBloqueado()) {
            this.accionespermitidas.add(3);
            if (this.ciudadjugador.getCiudadacademia().verificartemainvestigado( "Bloqueo de Puerto")) {
                if (!this.ciudadjugador.getJugador().getNick().equals(this.ciudadelegida.getJugador().getNick())) {
                    this.accionespermitidas.add(4);
                }


            }

            if ((this.ciudadjugador.getCiudadacademia().verificartemainvestigado( "Apostamiento de Tropa")) && (this.ciudadjugador.getJugador().getNick().equals(this.ciudadelegida.getJugador().getNick()))) {
                this.accionespermitidas.add(7);
                this.accionespermitidas.add(6);
            }


            if (this.ciudadjugador.getCiudadacademia().verificartemainvestigado( "Saqueo")) {
                if (!this.ciudadjugador.getJugador().getNick().equals(this.ciudadelegida.getJugador().getNick())) {
                    this.accionespermitidas.add(2);
                }
            }


        }

        if (this.ciudadjugador.getCiudadacademia().verificartemainvestigado( "Guerra")) {
            if (!this.ciudadjugador.getJugador().getNick().equals(this.ciudadelegida.getJugador().getNick())) {
                this.accionespermitidas.add(5);
            }
        }
        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();
        this.vistaisla.repaint();

    }

    @Override
    public void actualizardatospantalla() {
        switch (this.vistaisla.getClass().getSimpleName()) {
            case "VerIsla1":
                VerIsla1 verisla = ((VerIsla1) this.vistaisla);
                for (int i = 0; i < this.accionespermitidas.size(); i++) {
                    switch (this.accionespermitidas.get(i)) {
                        case 1:
                            verisla.getCmdEnviarMensaje2().setEnabled(true);
                            verisla.getLblEnviarMensaje2().setEnabled(true);
                            break;
                        case 2:

                            break;
                        case 3:
                            verisla.getCmdEnviarRecursos2().setEnabled(true);
                            verisla.getLblEnviarRecurso2().setEnabled(true);
                            break;
                        case 4:

                            break;
                        case 5:
                            verisla.getCmdDeclararGuerra2().setEnabled(true);
                            verisla.getLblDeclararGuerra2().setEnabled(true);
                            break;
                        case 6:
                            // verisla.getCmdEnviarBarcosGuerra().setEnabled(true);
                            //  verisla.getLblEnviarBarcos().setEnabled(true);
                            break;
                        case 7:
                            // verisla.getCmdEnviarUnidades().setEnabled(true);
                            //verisla.getLblEnviarUnidades().setEnabled(true);
                            break;

                    }
                }

                break;
            case "VerIsla2":
                VerIsla2 verisla2 = ((VerIsla2) this.vistaisla);
                for (int i = 0; i < this.accionespermitidas.size(); i++) {
                    switch (this.accionespermitidas.get(i)) {
                        case 1:
                            verisla2.getCmdEnviarMensaje2().setEnabled(true);
                            verisla2.getLblEnviarMensaje2().setEnabled(true);
                            break;
                        case 2:

                            break;
                        case 3:
                            verisla2.getCmdEnviarRecursos2().setEnabled(true);
                            verisla2.getLblEnviarRecurso2().setEnabled(true);
                            break;
                        case 4:

                            break;
                        case 5:
                            verisla2.getCmdDeclararGuerra2().setEnabled(true);
                            verisla2.getLblDeclararGuerra2().setEnabled(true);
                            break;
                        case 6:
                            //  verisla2.getCmdEnviarBarcosGuerra().setEnabled(true);
                            // verisla2.getLblEnviarBarcos().setEnabled(true);
                            break;
                        case 7:
                            // verisla2.getCmdEnviarUnidades().setEnabled(true);
                            // verisla2.getLblEnviarUnidades().setEnabled(true);
                            break;

                    }
                }
                break;
            case "VerIsla3":
                VerIsla3 verisla3 = ((VerIsla3) this.vistaisla);
                for (int i = 0; i < this.accionespermitidas.size(); i++) {
                    switch (this.accionespermitidas.get(i)) {
                        case 1:
                            verisla3.getCmdEnviarMensaje2().setEnabled(true);
                            verisla3.getLblEnviarMensaje2().setEnabled(true);
                            break;
                        case 2:

                            break;
                        case 3:
                            verisla3.getCmdEnviarRecursos2().setEnabled(true);
                            verisla3.getLblEnviarRecurso2().setEnabled(true);
                            break;
                        case 4:

                            break;
                        case 5:
                            verisla3.getCmdDeclararGuerra2().setEnabled(true);
                            verisla3.getLblDeclararGuerra2().setEnabled(true);
                            break;
                        case 6:
                            // verisla3.getCmdEnviarBarcosGuerra().setEnabled(true);
                            // verisla3.getLblEnviarBarcos().setEnabled(true);
                            break;
                        case 7:
                            // verisla3.getCmdEnviarUnidades().setEnabled(true);
                            // verisla3.getLblEnviarUnidades().setEnabled(true);
                            break;

                    }
                }

                break;

        }
    }

    @Override
    public void actualizarinterfazgrafica() {
        switch (this.vistaisla.getClass().getSimpleName()) {
            case "VerIsla1":
                VerIsla1 verisla = ((VerIsla1) this.vistaisla);
                for (int i = 0; i < 7; i++) {
                    switch (i + 1) {
                        case 1:
                            verisla.getCmdEnviarMensaje2().setEnabled(false);
                            verisla.getLblEnviarMensaje2().setEnabled(false);
                            break;
                        case 2:

                            break;
                        case 3:
                            verisla.getCmdEnviarRecursos2().setEnabled(false);
                            verisla.getLblEnviarRecurso2().setEnabled(false);
                            break;
                        case 4:

                            break;
                        case 5:
                            verisla.getCmdDeclararGuerra2().setEnabled(false);
                            verisla.getLblDeclararGuerra2().setEnabled(false);
                            break;
                        case 6:
                            //  verisla.getCmdEnviarBarcosGuerra().setEnabled(false);
                            //  verisla.getLblEnviarBarcos().setEnabled(false);
                            break;
                        case 7:
                            //  verisla.getCmdEnviarUnidades().setEnabled(false);
                            //  verisla.getLblEnviarUnidades().setEnabled(false);
                            break;

                    }
                }

                break;
            case "VerIsla2":
                VerIsla2 verisla2 = ((VerIsla2) this.vistaisla);
                for (int i = 0; i < 7; i++) {
                    switch (i + 1) {
                        case 1:
                            verisla2.getCmdEnviarMensaje2().setEnabled(false);
                            verisla2.getLblEnviarMensaje2().setEnabled(false);
                            break;
                        case 2:

                            break;
                        case 3:
                            verisla2.getCmdEnviarRecursos2().setEnabled(false);
                            verisla2.getLblEnviarRecurso2().setEnabled(false);
                            break;
                        case 4:

                            break;
                        case 5:
                            verisla2.getCmdDeclararGuerra2().setEnabled(false);
                            verisla2.getLblDeclararGuerra2().setEnabled(false);
                            break;
                        case 6:
                            // verisla2.getCmdEnviarBarcosGuerra().setEnabled(false);
                            // verisla2.getLblEnviarBarcos().setEnabled(false);
                            break;
                        case 7:
                            // verisla2.getCmdEnviarUnidades().setEnabled(false);
                            // verisla2.getLblEnviarUnidades().setEnabled(false);
                            break;

                    }
                }
                break;
            case "VerIsla3":
                VerIsla3 verisla3 = ((VerIsla3) this.vistaisla);
                for (int i = 0; i < 7; i++) {
                    switch (i + 1) {
                        case 1:
                            verisla3.getCmdEnviarMensaje2().setEnabled(false);
                            verisla3.getLblEnviarMensaje2().setEnabled(false);
                            break;
                        case 2:

                            break;
                        case 3:
                            verisla3.getCmdEnviarRecursos2().setEnabled(false);
                            verisla3.getLblEnviarRecurso2().setEnabled(false);
                            break;
                        case 4:

                            break;
                        case 5:
                            verisla3.getCmdDeclararGuerra2().setEnabled(false);
                            verisla3.getLblDeclararGuerra2().setEnabled(false);
                            break;
                        case 6:
                            // verisla3.getCmdEnviarBarcosGuerra().setEnabled(false);
                            // verisla3.getLblEnviarBarcos().setEnabled(false);
                            break;
                        case 7:
                            // verisla3.getCmdEnviarUnidades().setEnabled(false);
                            // verisla3.getLblEnviarUnidades().setEnabled(false);
                            break;

                    }
                }

                break;

        }
    }

}
