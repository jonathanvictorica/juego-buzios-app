/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerDepositooAlmacen;

import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VerDepositooAlmacen extends ConfigurarEdificio implements Actualizar {

    public VerDepositooAlmacen(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerDepositooAlmacen(this);
    }


    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        try {
            this.ciudadjugador.getCiudadrecurso().inicializarrecursosciudad();
            this.ciudadjugador.inicializarciudad();
            for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                    case "Madera":
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecurso().setText(this.ciudadjugador.getCiudadrecurso().getCantidad().get(i) + "");
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecursoasegurado().setText(this.ciudadjugador.getCapacidadrecurso() + "");

                        break;
                    case "Marmol":
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecurso2().setText(this.ciudadjugador.getCiudadrecurso().getCantidad().get(i) + "");
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecursoasegurado2().setText(this.ciudadjugador.getCapacidadrecurso() + "");

                        break;
                    case "Cristal":
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecurso3().setText(this.ciudadjugador.getCiudadrecurso().getCantidad().get(i) + "");
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecursoasegurado3().setText(this.ciudadjugador.getCapacidadrecurso() + "");


                        break;
                    case "Azufre":
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecurso4().setText(this.ciudadjugador.getCiudadrecurso().getCantidad().get(i) + "");
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecursoasegurado4().setText(this.ciudadjugador.getCapacidadrecurso() + "");

                        break;
                    case "Vino":
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecurso1().setText(this.ciudadjugador.getCiudadrecurso().getCantidad().get(i) + "");
                        ((VVerDepositooAlmacen) this.vedificio).getLblCantidadrecursoasegurado1().setText(this.ciudadjugador.getCapacidadrecurso() + "");

                        break;
                }
            }
            ((VVerDepositooAlmacen) this.vedificio).repaint();
        } catch (SQLException ex) {

        }

    }


}
