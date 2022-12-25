/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.investigacion.InvestigacionJugador;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ejercito.VVerBarcosGuerraaConstruir;
import com.jmg.buzios.view.ejercito.VVerUnidadesaConstruir;

import java.util.List;

/**
 * @author Alumno
 */
public class VerUnidadesConstruccion implements Actualizar {


    private VCiudad vciudad;
    private boolean tipounidadbarco;

    private int niveledificio;

    private VVerBarcosGuerraaConstruir verbarcosguerra;
    private VVerUnidadesaConstruir verunidades;
    private List<UnidadMilitar> unidadmilitar;

    public VerUnidadesConstruccion(VCiudad vciudad, boolean tipounidadbarco, int niveledificio) {
        this.vciudad = vciudad;
        this.tipounidadbarco = tipounidadbarco;
        this.niveledificio = niveledificio;
    }


    public void CUverunidadesconstruccion() {
        InvestigacionJugador investigacionjugador = new InvestigacionJugador();
        investigacionjugador.setJugador(vciudad.getCiudad().getJugador());
        List<String> nombredeunidades_descubiertas = investigacionjugador.buscarunidadesmilitaresinvestigadas( this.tipounidadbarco);


        this.unidadmilitar = UnidadMilitar.inicializarlistadeunidadesmilitares( nombredeunidades_descubiertas);

        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();
    }

    @Override
    public void actualizardatospantalla() {
        if (this.tipounidadbarco) {
            verbarcosguerra.setUnidadmilitar(this.unidadmilitar);
            for (int i = 0; i < this.unidadmilitar.size(); i++) {
                switch (this.unidadmilitar.get(i).getNombre()) {
                    case "Barco Espolon":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarespolón().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarespolón().setEnabled(true);
                        }
                        break;
                    case "Barco Lanzallamas":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarLanzallamas().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarLanzallamas().setEnabled(true);

                        }
                        break;
                    case "Barco Espolon a vapor":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarEspolonavapor().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarEspolonavapor().setEnabled(true);

                        }
                        break;
                    case "Barco Ballesta":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarBallesta().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarBallesta().setEnabled(true);

                        }
                        break;
                    case "Barco Catapulta":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarCatapulta().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarCatapulta().setEnabled(true);

                        }
                        break;
                    case "barco Mortero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarMortero().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarMortero().setEnabled(true);

                        }
                        break;
                    case "Submarino":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarSubmarino().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarSubmarino().setEnabled(true);

                        }
                        break;
                    case "Barco LanzaMisiles":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            this.verbarcosguerra.getCmdUnidadmilitarLanzamisiles().setEnabled(true);
                            this.verbarcosguerra.getLblUnidadmilitarLanzamisiles().setEnabled(true);

                        }
                        break;

                }
            }
            this.verbarcosguerra.repaint();
        } else {
            verunidades.setUnidadmilitar(this.unidadmilitar);
            for (int i = 0; i < this.unidadmilitar.size(); i++) {
                switch (this.unidadmilitar.get(i).getNombre()) {
                    case "Gigante a Vapor":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {
                            verunidades.getCmdUnidadmilitarGiganteaVapor().setEnabled(true);
                            verunidades.getLblUnidadmilitarGiganteavapor().setEnabled(true);
                        }
                        break;
                    case "Hoplita":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getLblHoplita().setEnabled(true);
                            verunidades.getCmdUnidadmilitarHoplita().setEnabled(true);
                        }
                        break;
                    case "Espadachin":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarEspadachin().setEnabled(true);
                            verunidades.getLblUnidadmilitarEspadachin().setEnabled(true);
                        }
                        break;
                    case "Lancero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarLancero().setEnabled(true);
                            verunidades.getLblUnidadmilitarLancero().setEnabled(true);
                        }
                        break;
                    case "Arquero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarArquero().setEnabled(true);
                            verunidades.getLblUnidadmilitarArquero().setEnabled(true);
                        }
                        break;
                    case "Fusilero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getLblUnidadmilitarFusilero().setEnabled(true);
                            verunidades.getCmdUnidadmilitarFusilero().setEnabled(true);
                        }
                        break;
                    case "Hondero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarHondero().setEnabled(true);
                            verunidades.getLblUnidadmilitarHondero().setEnabled(true);
                        }
                        break;
                    case "Ariete":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarAriete().setEnabled(true);
                            verunidades.getLblUnidadmilitarAriete().setEnabled(true);
                        }
                        break;
                    case "Mortero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarMortero().setEnabled(true);
                            verunidades.getLblUnidadmilitarMortero().setEnabled(true);
                        }
                        break;
                    case "Catapulta":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getLblUnidadmilitarCatapulta().setEnabled(true);
                            verunidades.getCmdUnidadmilitarCatapulta().setEnabled(true);
                        }
                        break;
                    case "Globo Bombardero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarBombarderoabalon().setEnabled(true);
                            verunidades.getLblUnidadmilitarBombarderoabalon().setEnabled(true);
                        }
                        break;
                    case "Girocoptero":
                        if (this.niveledificio >= this.unidadmilitar.get(i).getNivelnecesario()) {

                            verunidades.getCmdUnidadmilitarGirocoptero().setEnabled(true);
                            verunidades.getLblUnidadmilitarGirocoptero().setEnabled(true);
                        }
                        break;


                }
            }
            this.verunidades.repaint();
        }
    }

    @Override
    public void actualizarinterfazgrafica() {
        if (this.tipounidadbarco == true) {
            verbarcosguerra = new VVerBarcosGuerraaConstruir(this.vciudad);


        } else {
            verunidades = new VVerUnidadesaConstruir(this.vciudad);


        }
    }

}
