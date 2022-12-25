/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;
import com.jmg.buzios.view.mundo.VMundo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class MostrarMundo implements Actualizar {
    public Integer parteMundo = 1;

    private Ciudad ciudadjugador;
    private List<Isla> islasmundo = new ArrayList<>();

    public MostrarMundo(Ciudad ciudadjugador) {
        this.ciudadjugador = ciudadjugador;


    }

    public void CUMostrarmundo() {
        this.islasmundo.clear();

        Isla.inicializar_todas_las_islas( this.islasmundo, parteMundo);
        for (int i = 0; i < this.islasmundo.size(); i++) {
            this.islasmundo.get(i).inicializar_isla();

        }
        this.actualizarinterfazgrafica();

    }


    @Override
    public void actualizarinterfazgrafica() {
        VMundo1 vmundo = new VMundo1(this.ciudadjugador, this.islasmundo);
        vmundo.numeroMundo = parteMundo;

    }

    @Override
    public void actualizardatospantalla() {

    }

}
