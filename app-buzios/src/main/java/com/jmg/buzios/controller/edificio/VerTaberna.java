/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerTaberna;

/**
 * @author Alumno
 */
public class VerTaberna extends ConfigurarEdificio implements Actualizar {




    public VerTaberna(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerTaberna(this);
    }

    public void CUAsignarvino() {

    }


    @Override
    public void actualizardatospantalla() {
        int maximo = 0;
        maximo = this.edificionivel.getNivel() * 30;
        this.ciudadjugador.getCiudadtaberna().setCiudad(ciudadjugador);
        this.ciudadjugador.getCiudadtaberna().inicializar_taberna();
        ((VVerTaberna) this.vedificio).getBarraVino().setMaximum(maximo);
        if (this.ciudadjugador.getCiudadtaberna().getVinoaservir() != 0) {
            ((VVerTaberna) this.vedificio).getBarraVino().setValue(this.ciudadjugador.getCiudadtaberna().getVinoaservir());
            ((VVerTaberna) this.vedificio).getLblServirvinoporhora().setText("Servir " + ((VVerTaberna) this.vedificio).getBarraVino().getValue() + " litros de vino por hora.");

        } else {

            ((VVerTaberna) this.vedificio).getBarraVino().setValue(0);
            ((VVerTaberna) this.vedificio).getLblServirvinoporhora().setText("Servir " + 0 + " litros de vino por hora.");


        }
        ((VVerTaberna) this.vedificio).repaint();
    }

    @Override
    public void actualizarinterfazgrafica() {

    }


}
