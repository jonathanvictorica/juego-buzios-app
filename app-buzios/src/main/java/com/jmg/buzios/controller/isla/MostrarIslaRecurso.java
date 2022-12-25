/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;
import com.jmg.buzios.view.islas.VRecolectarRecurso;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class MostrarIslaRecurso implements Actualizar {


    private Ciudad ciudadjugador;
    private String recursoaver;
    private VRecolectarRecurso vrecolectarrecurso;
    private Isla isla;

    public MostrarIslaRecurso(Isla isla, Ciudad ciudadjugador, String recursoaver) {

        this.ciudadjugador = ciudadjugador;
        this.recursoaver = recursoaver;
        this.isla = isla;
    }


    public void CUmostrarislarecurso() throws SQLException {

        if (this.ciudadjugador.getIsla().getNombre().equals(this.isla.getNombre())) {
            this.ciudadjugador.getCiudadproduccion().inicializarproduccionciudad();

            this.actualizarinterfazgrafica();
            this.actualizardatospantalla();
        } else {
            JOptionPane.showMessageDialog(vrecolectarrecurso, "Tu ciudad no esta en esta isla y no puedes acceder a esta parte de ella.");
        }


    }

    @Override
    public void actualizardatospantalla() {
        ImageIcon imagen;
        String direccionimagen = "";
        /*Busca cuantos trabajadores y habitantes tiene la ciudad del jugador*/

        //  direccionimagen  = ("/IMAGEN/ISLA/"+ "imagen_trabajador_" + this.recursoaver+".png");
        // imagen = new ImageIcon(getClass().getResource(direccionimagen));


        //  this.vrecolectarrecurso.getImagenTrabajador().setIcon(imagen);


        this.vrecolectarrecurso.getLblCantidadhabitante().setText(this.ciudadjugador.getCantidadhabitantesdisponibles() + "");


        if (!this.recursoaver.equals("Madera")) {
            this.vrecolectarrecurso.getLblCantidadtrabajdor().setText(this.ciudadjugador.getCiudadproduccion().getCantidadporhora() + "");
            this.vrecolectarrecurso.getBarraTrabajadores().setMaximum(this.ciudadjugador.getNivel().getCantidadproduccionbienes());

            this.vrecolectarrecurso.getBarraTrabajadores().setValue(this.ciudadjugador.getCiudadproduccion().getCantidadporhora());
        } else {
            this.vrecolectarrecurso.getLblCantidadtrabajdor().setText(this.ciudadjugador.getCiudadproduccion().getCantidadmaderaporhora() + "");
            this.vrecolectarrecurso.getBarraTrabajadores().setMaximum(this.ciudadjugador.getNivel().getCantidadproduccionmadera());

            this.vrecolectarrecurso.getBarraTrabajadores().setValue(this.ciudadjugador.getCiudadproduccion().getCantidadmaderaporhora());


        }
        Integer tope = 0;


        this.vrecolectarrecurso.repaint();
    }

    @Override
    public void actualizarinterfazgrafica() {


        this.vrecolectarrecurso = new VRecolectarRecurso(this.isla, this.recursoaver, this.ciudadjugador);

    }


}
