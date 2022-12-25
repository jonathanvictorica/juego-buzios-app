/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.controller.ciudad.MostrarCiudad;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * verificarunlugarmasenisla(): boolean	ISLA
 * buscarcantidadciudades(): int	JUGADOR
 * verificarpalacioyciudades(cantidadciudades: int): boolean	CIUDAD
 * verificaroro(cantidadoro: int): boolean	JUGADOR
 * construirciudadenisla(jugador: JUGADOR): void	ISLA
 * pagaroro(oro: int): void	JUGADOR
 * descontarcapacidadciudadisla(): void	ISLA
 */
public class FundarCiudad {

    private Ciudad ciudadjugador;
    private Isla isla;
    private Integer lugarisla;
    private JFrame visla;

    public FundarCiudad(JFrame visla, Ciudad ciudadjugador, Isla isla, Integer lugarisla) {
        this.ciudadjugador = ciudadjugador;
        this.isla = isla;
        this.lugarisla = lugarisla;
        this.visla = visla;
    }


    public void CUFundarCiudad() throws SQLException {
        if (this.isla.verificarUnLugarMasEnIsla()) {
            int cantidadciudades = this.ciudadjugador.getJugador().getCiudades().size();
            if (this.ciudadjugador.getJugador().verificarpalacioyciudades( cantidadciudades)) {
                if (this.ciudadjugador.getJugador().verificaroro( 10000)) {
                    FundarCiudadThread construirciudadenisla = new FundarCiudadThread( ciudadjugador, isla, 1, this.lugarisla);
                    Thread hconstruirciudadenisla = new Thread(construirciudadenisla);
                    hconstruirciudadenisla.start();

                    FundarCiudadThread pagaroro = new FundarCiudadThread( ciudadjugador, isla, 2);
                    Thread hpagaroro = new Thread(pagaroro);
                    hpagaroro.start();

                    FundarCiudadThread descontarcapacidaddeciudades = new FundarCiudadThread( ciudadjugador, isla, 3);
                    Thread hdescontarcapacidaddeciudades = new Thread(descontarcapacidaddeciudades);
                    hdescontarcapacidaddeciudades.start();

                    while (hconstruirciudadenisla.isAlive() || hpagaroro.isAlive() || hdescontarcapacidaddeciudades.isAlive()) {

                    }

                    FundarCiudadThread mensajeciudadfundada = new FundarCiudadThread(4);
                    Thread hmensajeciudadfundada = new Thread(mensajeciudadfundada);
                    hmensajeciudadfundada.start();

                    this.ciudadjugador.getJugador().buscarultimaciudadfundada();
                    Ciudad ciudadfundada = null;
                    int maximo = this.ciudadjugador.getJugador().getCiudades().get(0).getCodigociudad();
                    int indice = 0;
                    for (int i = 0; i < this.ciudadjugador.getJugador().getCiudades().size(); i++) {
                        if (maximo < this.ciudadjugador.getJugador().getCiudades().get(i).getCodigociudad()) {
                            maximo = this.ciudadjugador.getJugador().getCiudades().get(i).getCodigociudad();
                            indice = i;
                        }
                    }
                    ciudadfundada = this.ciudadjugador.getJugador().getCiudades().get(indice);


                    this.visla.hide();
                    MostrarCiudad mostrarciudad = new MostrarCiudad(ciudadfundada);
                    mostrarciudad.CUmostrarciudad();


                } else {
                    JOptionPane.showMessageDialog(null, "No tienes suficiente oro para fundar una ciudad.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes elevar tu palacio un nivel más para fundar una nueva ciudad.");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta isla no tiene un lugar disponible para fundar una ciudad.");

        }
    }

}

class FundarCiudadThread extends Thread {

    private Ciudad ciudadjugador;
    private Isla isla;
    private Integer hilo;
    private Integer lugarisla;

    public FundarCiudadThread( Ciudad ciudadjugador, Isla isla, Integer hilo) {

        this.ciudadjugador = ciudadjugador;
        this.isla = isla;
        this.hilo = hilo;
    }

    public FundarCiudadThread( Ciudad ciudadjugador, Isla isla, Integer hilo, Integer lugarisla) {

        this.ciudadjugador = ciudadjugador;
        this.isla = isla;
        this.hilo = hilo;
        this.lugarisla = lugarisla;
    }


    public FundarCiudadThread(int i) {
        this.hilo = i;
    }

    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    this.isla.construirciudadenisla( this.ciudadjugador.getJugador(), this.lugarisla);
                } catch (SQLException ex) {
                }
                break;
            case 2:
                try {
                    this.ciudadjugador.getJugador().pagaroro( 10000);
                } catch (SQLException ex) {

                }
                break;

            case 3:
                try {
                    this.isla.descontarcapacidadciudadisla();
                } catch (SQLException ex) {
                    Logger.getLogger(FundarCiudadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Ciudad Fundada.");
                break;
        }
    }

}