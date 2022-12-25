/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.comercio.DepositoMercado;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerMercado;

/**
 * @author Alumno
 */
public class VerMercado extends ConfigurarEdificio implements Actualizar {

    public VerMercado(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerMercado(this);
    }


    @Override
    public void actualizardatospantalla() {
        DepositoMercado deposito = new DepositoMercado(this.ciudadjugador.getJugador());
        deposito.inicializar_recursos_mercado();
        for (int i = 0; i < deposito.getRecursos().size(); i++) {
            switch (deposito.getRecursos().get(i).getNombrerecurso()) {
                case "Madera":
                    ((VVerMercado) this.vedificio).getLblMaderaMercado().setText("" + deposito.getCantidad().get(i));
                    break;
                case "Vino":
                    ((VVerMercado) this.vedificio).getLblVinoMercado().setText("" + deposito.getCantidad().get(i));
                    break;
                case "Cristal":
                    ((VVerMercado) this.vedificio).getLblCristalMercado().setText("" + deposito.getCantidad().get(i));
                    break;
                case "Azufre":
                    ((VVerMercado) this.vedificio).getLblAzufreMercado().setText("" + deposito.getCantidad().get(i));
                    break;
                case "Marmol":
                    ((VVerMercado) this.vedificio).getLblMarmolMercado().setText("" + deposito.getCantidad().get(i));
                    break;
            }

        }
        this.vedificio.repaint();
    }

    @Override
    public void actualizarinterfazgrafica() {

    }

}
