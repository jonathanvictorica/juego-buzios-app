/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.CiudadEjercito;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ejercito.VUnidadMilitarCiudad;
import com.jmg.buzios.view.ejercito.VUnidadNavalCiudad;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class VerUnidadCiudad implements Actualizar {


    private VCiudad vciudad;
    private boolean verbarcos;
    private CiudadEjercito ciudadejercito;


    private VUnidadMilitarCiudad vunidadmilitarciudad;
    private VUnidadNavalCiudad vunidadnavalciudad;

    public VerUnidadCiudad(VCiudad vciudad, boolean verbarcos, CiudadEjercito ciudadejercito) {
        this.vciudad = vciudad;

        this.verbarcos = verbarcos;
        this.ciudadejercito = ciudadejercito;
    }


    public void CUVerUnidadCiudad() {
        this.ciudadejercito.inicializarejercitodeciudad();
        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();

    }

    @Override
    public void actualizardatospantalla() {
        if (verbarcos) {
            List<String> nombrebarcos = new ArrayList<>();

            for (int i = 0; i < this.ciudadejercito.getUnidad().size(); i++) {
                if (this.ciudadejercito.getUnidad().get(i).isBarco()) {
                    nombrebarcos.add(this.ciudadejercito.getUnidad().get(i).getNombre());
                }
            }

            for (int i = 0; i < nombrebarcos.size(); i++) {
                switch (nombrebarcos.get(i)) {
                    case "Barco Espolon":

                        this.vunidadnavalciudad.getLblCantidad().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));

                        break;
                    case "Barco Ballesta":
                        this.vunidadnavalciudad.getLblCantidad1().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));
                        break;
                    case "Barco Lanzallamas":
                        this.vunidadnavalciudad.getLblCantidad2().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));
                        break;
                    case "Barco Catapulta":
                        this.vunidadnavalciudad.getLblCantidad3().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));

                        break;
                    case "Barco Espolon a vapor":
                        this.vunidadnavalciudad.getLblCantidad4().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));

                        break;
                    case "barco Mortero":
                        this.vunidadnavalciudad.getLblCantidad5().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));

                        break;
                    case "Submarino":
                        this.vunidadnavalciudad.getLblCantidad6().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));

                        break;
                    case "Barco LanzaMisiles":
                        this.vunidadnavalciudad.getLblCantidad7().setText("" + this.retornar_cantidad(nombrebarcos.get(i)));

                        break;
                }
            }
            this.vunidadnavalciudad.repaint();
        }


    }

    @Override
    public void actualizarinterfazgrafica() {
        if (verbarcos) {
            List<String> nombrebarcos = new ArrayList<>();

            for (int i = 0; i < this.ciudadejercito.getUnidad().size(); i++) {
                if (this.ciudadejercito.getUnidad().get(i).isBarco()) {
                    nombrebarcos.add(this.ciudadejercito.getUnidad().get(i).getNombre());
                }
            }
            this.vunidadnavalciudad = new VUnidadNavalCiudad(this.vciudad, this.ciudadejercito);

            for (int i = 0; i < nombrebarcos.size(); i++) {
                switch (nombrebarcos.get(i)) {
                    case "Barco Espolon":
                        this.vunidadnavalciudad.getCmdUnidadmilitarEspolon1().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad().setEnabled(true);

                        break;
                    case "Barco Ballesta":
                        this.vunidadnavalciudad.getCmdUnidadmilitarBallesta2().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar1().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad1().setEnabled(true);
                        break;
                    case "Barco Lanzallamas":
                        this.vunidadnavalciudad.getCmdUnidadmilitarLanzaLlamas3().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar2().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad2().setEnabled(true);
                        break;
                    case "Barco Catapulta":
                        this.vunidadnavalciudad.getCmdUnidadmilitarCatapulta4().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar3().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad3().setEnabled(true);
                        break;
                    case "Barco Espolon a vapor":
                        this.vunidadnavalciudad.getCmdUnidadmilitarEspolonaVapor5().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar4().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad4().setEnabled(true);
                        break;
                    case "barco Mortero":
                        this.vunidadnavalciudad.getCmdUnidadmilitarMortero6().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar5().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad5().setEnabled(true);
                        break;
                    case "Submarino":
                        this.vunidadnavalciudad.getCmdUnidadmilitarSubmarino7().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar6().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad6().setEnabled(true);
                        break;
                    case "Barco LanzaMisiles":
                        this.vunidadnavalciudad.getCmdUnidadmilitar7().setEnabled(true);
                        this.vunidadnavalciudad.getLblUnidadmilitar7().setEnabled(true);
                        this.vunidadnavalciudad.getLblCantidad7().setEnabled(true);
                        break;
                }
            }
            vunidadnavalciudad.repaint();
        } else {
            List<String> nombreunidades = new ArrayList<>();

            for (int i = 0; i < this.ciudadejercito.getUnidad().size(); i++) {
                if (!this.ciudadejercito.getUnidad().get(i).isBarco()) {
                    nombreunidades.add(this.ciudadejercito.getUnidad().get(i).getNombre());
                }
            }
            this.vunidadmilitarciudad = new VUnidadMilitarCiudad(this.vciudad, this.ciudadejercito);

            for (int i = 0; i < nombreunidades.size(); i++) {
                switch (nombreunidades.get(i)) {
                    case "Ariete":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar().setEnabled(true);
                        break;
                    case "Arquero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar1().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar1().setEnabled(true);
                        break;
                    case "Catapulta":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar2().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar2().setEnabled(true);
                        break;
                    case "Espadachin":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar3().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar3().setEnabled(true);
                        break;
                    case "Fusilero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar4().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar4().setEnabled(true);
                        break;
                    case "Gigante a Vapor":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar5().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar5().setEnabled(true);
                        break;
                    case "Girocoptero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar6().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar6().setEnabled(true);
                        break;
                    case "Globo Bombardero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar7().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar7().setEnabled(true);
                        break;
                    case "Hondero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar8().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar8().setEnabled(true);
                        break;
                    case "Hoplita":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar9().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar9().setEnabled(true);
                        break;
                    case "Lancero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar10().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar10().setEnabled(true);
                        break;
                    case "Mortero":
                        this.vunidadmilitarciudad.getCmdUnidadmilitar11().setEnabled(true);
                        this.vunidadmilitarciudad.getLblUnidadmilitar11().setEnabled(true);
                        break;
                }
            }

            vunidadmilitarciudad.repaint();
        }
    }

    private String retornar_cantidad(String unidad_militar) {
        String cantidad = "";
        for (int i = 0; i < this.ciudadejercito.getUnidad().size(); i++) {
            if (this.ciudadejercito.getUnidad().get(i).getNombre().equals(unidad_militar)) {
                cantidad = cantidad + this.ciudadejercito.getUnidadesinarma().get(i).intValue();
                return cantidad;
            }
        }
        return cantidad;
    }


}
