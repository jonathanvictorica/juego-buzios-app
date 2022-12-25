package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.controller.ciudad.MostrarCiudad;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

public class ConstruirEdificio implements Actualizar {

    private VCiudad vciudad;
    private Ciudad ciudadjugador;
    private EdificioNivel edificionivel;
    private int lugarciudad;


    public ConstruirEdificio(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        this.vciudad = vciudad;
        this.ciudadjugador = ciudadjugador;
        this.edificionivel = edificionivel;
        this.lugarciudad = lugarciudad;
    }

    public static void actualizarinterfazgrafica(VCiudad vciudad) {
        try {

            vciudad.getCiudad().getCiudadedificios().inicializaredificiosdeciudad();
            vciudad.getCiudad().getCiudadrecurso().inicializarrecursosciudad();
            vciudad.getCiudad().inicializarciudad();
            MostrarCiudad mostrarciudadcapital = new MostrarCiudad(vciudad.getCiudad());
            vciudad.getCiudad().getJugador().inicializarciudadesdejugador();

            mostrarciudadcapital.setVciudad(vciudad);
            mostrarciudadcapital.actualizarinterfazgrafica();
            mostrarciudadcapital.actualizardatospantalla();
            vciudad.repaint();

        } catch (SQLException ex) {

        }


    }

    public void CUconstruiredificio() throws SQLException {

        int indice = ciudadjugador.verificaredificioenciudad(edificionivel.getEdificio().getNombre());
        if (indice == -1) {
            if (this.ciudadjugador.getCiudadrecurso().verificarrecursosciudad(edificionivel.getEdificiorecurso().getRecurso(), edificionivel.getEdificiorecurso().getCantidad())) {
                if (ciudadjugador.getJugador().verificaroro(this.edificionivel.getEdificio().getCosto())) {
                    ConstruirEdificioThread construiredificio = new ConstruirEdificioThread(1, this.ciudadjugador, this.edificionivel, lugarciudad);
                    Thread hconstruiredificio = new Thread(construiredificio);
                    hconstruiredificio.start();

                    ConstruirEdificioThread descontarrecursos = new ConstruirEdificioThread(2, this.ciudadjugador, this.edificionivel);
                    Thread hdescontarrecursos = new Thread(descontarrecursos);
                    hdescontarrecursos.start();

                    ConstruirEdificioThread pagaroro = new ConstruirEdificioThread( 3, this.ciudadjugador, this.edificionivel);
                    Thread hpagaroro = new Thread(pagaroro);
                    hpagaroro.start();

                    while (hconstruiredificio.isAlive() || hdescontarrecursos.isAlive() || hpagaroro.isAlive()) {
                        if ((hconstruiredificio.isInterrupted()) || (hconstruiredificio.isInterrupted()) || (hpagaroro.isInterrupted())) {
                            JOptionPane.showMessageDialog(null, "Lo sentimos pero la operacion no pudo ser realizada");

                            return;
                        }
                    }
                    this.ciudadjugador.getCiudadedificios().inicializaredificiosdeciudad();
                    this.ciudadjugador.getCiudadrecurso().inicializarrecursosciudad();

                    ConstruirEdificio.actualizarinterfazgrafica(vciudad);

                    JOptionPane.showMessageDialog(null, "El edificio se construyó existosamente.");

                } else {
                    JOptionPane.showMessageDialog(null, "No tienes suficiente oro en tus arcas para construir este edificio.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tienes suficientes recursos para construir este edificio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede construir este edificio porque ya existe en la ciudad.");

        }


    }

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}

class ConstruirEdificioThread extends Thread {


    public int hilo;
    private Object objeto;
    private EdificioNivel edificionivel;
    private int lugarciudad;

    public ConstruirEdificioThread(int hilo, Object objeto,  EdificioNivel edificionivel) {
        this.hilo = hilo;
        this.objeto = objeto;
        this.edificionivel = edificionivel;
    }

    public ConstruirEdificioThread(int hilo, Object objeto, EdificioNivel edificionivel, int lugarciudad) {
        this.hilo = hilo;
        this.objeto = objeto;
        this.edificionivel = edificionivel;
        this.lugarciudad = lugarciudad;
    }


    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    ((Ciudad) this.objeto).construiredificio( this.lugarciudad, this.edificionivel);
                } catch (SQLException ex) {

                }
                break;
            case 2:
                try {
                    ((Ciudad) this.objeto).getCiudadrecurso().descontarrecursosciudad( edificionivel.getEdificiorecurso().getRecurso(), edificionivel.getEdificiorecurso().getCantidad());
                } catch (SQLException ex) {
                }
                break;
            case 3:
                try {
                    ((Ciudad) this.objeto).getJugador().pagaroro( edificionivel.getEdificio().getCosto());
                } catch (SQLException ex) {

                }
                break;
        }
    }
}