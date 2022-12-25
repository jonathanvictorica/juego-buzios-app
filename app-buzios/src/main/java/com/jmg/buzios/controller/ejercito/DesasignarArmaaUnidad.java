/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * calcularcantidadunidadmilitarconarma(unidadmilitar: UNIDADMILITAR, arma: ARMA): int	EJERCITOJUGADORARMA
 * verificarcantidaddeasignamientosdearma(cantidadunidad: int, cantidadsinarma: int): boolean	EJERCITOJUGADORARMA
 * descontararmasunidadmilitar(unidadmilitar: UNIDADMILITAR, cantidad: int): void	EJERCITOJUGADORARMA
 */
public class DesasignarArmaaUnidad {

    private UnidadMilitar unidadmilitar;
    private Arma arma;
    private Integer cantidad;
    private VCiudad vciudad;

    public DesasignarArmaaUnidad(UnidadMilitar unidadmilitar, Arma arma, Integer cantidad, VCiudad vciudad) {
        this.unidadmilitar = unidadmilitar;
        this.arma = arma;
        this.cantidad = cantidad;
        this.vciudad = vciudad;
    }

    public void CUDesasignarArmaaUnidad() {
        try {
            if (this.vciudad.getCiudad().getCiudadejercito().verificarcantidadasignamientoarma( this.unidadmilitar, this.arma, this.cantidad)) {
                this.vciudad.getCiudad().getCiudadejercito().descontararmasunidadmilitar( this.unidadmilitar, this.arma, this.cantidad);
                this.vciudad.getCiudad().getCiudadejercito().aumentarunidadesinarma( this.unidadmilitar, this.cantidad);
                this.vciudad.getCiudad().getCiudadejercito().inicializarejercitodeciudad();

                JOptionPane.showMessageDialog(vciudad, "Las armas fueron eliminadas.");
            } else {
                JOptionPane.showMessageDialog(vciudad, "No dispone de " + this.cantidad + " unidades de " + this.unidadmilitar.getNombre() + " que tengan el arma " + this.arma.getNombrearma());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
