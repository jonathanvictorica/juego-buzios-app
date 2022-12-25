/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.investigacion;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.investigacion.Investigacion;
import com.jmg.buzios.model.investigacion.InvestigacionJugador;
import com.jmg.buzios.view.academia.VVerinvestigaciones;

import javax.swing.*;
import java.sql.SQLException;

/**
 * buscarpuntosinvestigacionjugador(): int	PUNTOSJUGADOR
 * verificarhabilitacionparainvestigar(puntosinvestjug: int,puntosnecesarios: int)	INVESTIGACION
 * almacenarinvestigaciondejugador(): void	INVESTIGACIONJUGADOR
 * descontarpuntosinvestigacion(puntosutilizados: int): void	PUNTOSJUGADOR
 */
public class InvestigarTema implements Actualizar {
    private Ciudad ciudadjugador;

    private Investigacion investigacion;

    private VVerinvestigaciones verinvestigaciones;

    public InvestigarTema(Ciudad ciudadjugador, Investigacion investigacion, VVerinvestigaciones verinvestigaciones) {
        this.ciudadjugador = ciudadjugador;
        this.investigacion = investigacion;
        this.verinvestigaciones = verinvestigaciones;
    }


    public void CUinvestigartema() throws SQLException {


        ciudadjugador.getJugador().getPuntosjugador().buscarpuntosinvestigacionjugador();
        if (investigacion.verificarhabilitacionparainvestigar(this.ciudadjugador.getJugador().getPuntosjugador().getPuntosinvestigacion(), this.investigacion.getPuntosinvestigacion())) {
            InvestigacionJugador investigacionjugador = new InvestigacionJugador();
            investigacionjugador.setJugador(this.ciudadjugador.getJugador());
            investigacionjugador.setInvestigacion(this.investigacion);

            investigacionjugador.almacenarinvestigaciondejugador();
            ciudadjugador.getJugador().getPuntosjugador().descontarpuntosinvestigacion( this.investigacion.getPuntosinvestigacion());

            ciudadjugador.getJugador().getPuntosjugador().buscarpuntosinvestigacionjugador();

            JOptionPane.showMessageDialog(verinvestigaciones, "El tema fue investigado exitosamente!!!.");
            this.actualizardatospantalla();
        } else {
            JOptionPane.showMessageDialog(verinvestigaciones, "No tiene suficientes puntos de investigación para descubrir este tema.");
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
