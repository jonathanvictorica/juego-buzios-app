/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ejercito.VAsignarArma;

import javax.swing.*;

/**
 * @author Alumno
 */
public class VerUnidadArma implements Actualizar {


    private Ciudad ciudadjugador;
    private UnidadMilitar unidad;

    private VCiudad vciudad;
    private VAsignarArma vasignararma;

    public VerUnidadArma(Ciudad ciudadjugador, UnidadMilitar unidad, VCiudad vciudad) {
        this.ciudadjugador = ciudadjugador;
        this.unidad = unidad;
        this.vciudad = vciudad;

    }

    public void CUVerunidadarma() {
        ciudadjugador.getCiudadacademia().buscarlistadearmasdeunidad( this.unidad);
        //inicializa la lista de armas de unidadarma con el nombre nada mas.//
        if (this.unidad.getArmaunidad().getListarmas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes asignar armas.");
        } else {
            this.vasignararma = new VAsignarArma(this.ciudadjugador, this.unidad, this.vciudad);
            for (int i = 0; i < this.unidad.getArmaunidad().getListarmas().size(); i++) {
                this.unidad.getArmaunidad().getListarmas().get(i).inicializardatosdearma();
                this.unidad.getArmaunidad().getListarmas().get(i).buscarRecursosArma();

            }

            this.actualizarinterfazgrafica();
            this.actualizardatospantalla();


            this.vasignararma.repaint();
        }
    }

    @Override
    public void actualizardatospantalla() {
        ImageIcon imagenedificio;
        String direccion = " ";
        int i = 0;

        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            direccion = ("/IMAGEN/ARMA/" + this.unidad.getArmaunidad().getListarmas().get(i).getImagenarma().getDireccion() + ".png");
            imagenedificio = new ImageIcon(getClass().getResource(direccion));

            this.vasignararma.getImagenArmaasignar().setIcon(imagenedificio);
            this.vasignararma.getLblArmaaasignar().setText(this.unidad.getArmaunidad().getListarmas().get(i).getNombrearma());

            this.vasignararma.getLblAzufre().setText("0");
            this.vasignararma.getLblCristal().setText("0");
            this.vasignararma.getLblMadera().setText("0");
            for (int j = 0; j < this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().size(); j++) {
                switch (this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().get(j).getNombrerecurso()) {
                    case "Madera":
                        this.vasignararma.getLblMadera().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Cristal":
                        this.vasignararma.getLblCristal().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Azufre":
                        this.vasignararma.getLblAzufre().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                }
            }
            this.vasignararma.getLblPuntosataque().setText("Ataque: " + this.unidad.getPuntosataque());
            this.vasignararma.getLblPuntosdefensivos().setText("Defensivos: " + this.unidad.getPuntosdefensivos());
            i++;
        }

        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            direccion = ("/IMAGEN/ARMA/" + this.unidad.getArmaunidad().getListarmas().get(i).getImagenarma().getDireccion() + ".png");
            imagenedificio = new ImageIcon(getClass().getResource(direccion));

            this.vasignararma.getImagenArmaasignar1().setIcon(imagenedificio);
            this.vasignararma.getLblArmaaasignar1().setText(this.unidad.getArmaunidad().getListarmas().get(i).getNombrearma());

            this.vasignararma.getLblAzufre1().setText("0");
            this.vasignararma.getLblCristal1().setText("0");
            this.vasignararma.getLblMadera1().setText("0");
            for (int j = 0; j < this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().size(); j++) {
                switch (this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().get(j).getNombrerecurso()) {
                    case "Madera":
                        this.vasignararma.getLblMadera1().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Cristal":
                        this.vasignararma.getLblCristal1().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Azufre":
                        this.vasignararma.getLblAzufre1().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                }
            }
            this.vasignararma.getLblPuntosataque1().setText("Ataque: " + this.unidad.getPuntosataque());
            this.vasignararma.getLblPuntosdefensivos1().setText("Defensivos: " + this.unidad.getPuntosdefensivos());
            i++;
        }

        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            direccion = ("/IMAGEN/ARMA/" + this.unidad.getArmaunidad().getListarmas().get(i).getImagenarma().getDireccion() + ".png");
            imagenedificio = new ImageIcon(getClass().getResource(direccion));

            this.vasignararma.getImagenArmaasignar2().setIcon(imagenedificio);
            this.vasignararma.getLblArmaaasignar2().setText(this.unidad.getArmaunidad().getListarmas().get(i).getNombrearma());

            this.vasignararma.getLblAzufre2().setText("0");
            this.vasignararma.getLblCristal2().setText("0");
            this.vasignararma.getLblMadera2().setText("0");
            for (int j = 0; j < this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().size(); j++) {
                switch (this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().get(j).getNombrerecurso()) {
                    case "Madera":
                        this.vasignararma.getLblMadera2().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Cristal":
                        this.vasignararma.getLblCristal2().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Azufre":
                        this.vasignararma.getLblAzufre2().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                }
            }
            this.vasignararma.getLblPuntosataque2().setText("Ataque: " + this.unidad.getPuntosataque());
            this.vasignararma.getLblPuntosdefensivos2().setText("Defensivos: " + this.unidad.getPuntosdefensivos());
            i++;
        }

        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            direccion = ("/IMAGEN/ARMA/" + this.unidad.getArmaunidad().getListarmas().get(i).getImagenarma().getDireccion() + ".png");
            imagenedificio = new ImageIcon(getClass().getResource(direccion));

            this.vasignararma.getImagenArmaasignar3().setIcon(imagenedificio);
            this.vasignararma.getLblArmaaasignar3().setText(this.unidad.getArmaunidad().getListarmas().get(i).getNombrearma());

            this.vasignararma.getLblAzufre3().setText("0");
            this.vasignararma.getLblCristal3().setText("0");
            this.vasignararma.getLblMadera3().setText("0");
            for (int j = 0; j < this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().size(); j++) {
                switch (this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getRecursos().get(j).getNombrerecurso()) {
                    case "Madera":
                        this.vasignararma.getLblMadera3().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Cristal":
                        this.vasignararma.getLblCristal3().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                    case "Azufre":
                        this.vasignararma.getLblAzufre3().setText(this.unidad.getArmaunidad().getListarmas().get(i).getArmaconstruccion().getCantidad().get(j).intValue() + "");
                        break;
                }
            }
            this.vasignararma.getLblPuntosataque3().setText("Ataque: " + this.unidad.getPuntosataque());
            this.vasignararma.getLblPuntosdefensivos3().setText("Defensivos: " + this.unidad.getPuntosdefensivos());

        }
    }

    @Override
    public void actualizarinterfazgrafica() {

        int i = 0;
        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            this.vasignararma.getImagenArmaasignar().setVisible(true);
            this.vasignararma.getLblArmaaasignar().setVisible(true);
            this.vasignararma.getLblAzufre().setVisible(true);
            this.vasignararma.getLblCristal().setVisible(true);
            this.vasignararma.getLblMadera().setVisible(true);
            this.vasignararma.getTxtCantidadaasignar().setVisible(true);
            this.vasignararma.getImagenAzufre().setVisible(true);
            this.vasignararma.getImagenCristal().setVisible(true);
            this.vasignararma.getImagenMadera().setVisible(true);
            this.vasignararma.getLblPuntosataque().setVisible(true);
            this.vasignararma.getLblPuntosdefensivos().setVisible(true);
            this.vasignararma.getCmdAsasignararma().setVisible(true);
            i++;
        } else {
            this.vasignararma.getImagenArmaasignar().setVisible(false);
            this.vasignararma.getLblArmaaasignar().setVisible(false);
            this.vasignararma.getLblAzufre().setVisible(false);
            this.vasignararma.getLblCristal().setVisible(false);
            this.vasignararma.getLblMadera().setVisible(false);
            this.vasignararma.getTxtCantidadaasignar().setVisible(false);
            this.vasignararma.getImagenAzufre().setVisible(false);
            this.vasignararma.getImagenCristal().setVisible(false);
            this.vasignararma.getImagenMadera().setVisible(false);
            this.vasignararma.getLblPuntosataque().setVisible(false);
            this.vasignararma.getLblPuntosdefensivos().setVisible(false);
            this.vasignararma.getCmdAsasignararma().setVisible(false);
            i++;
        }

        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            this.vasignararma.getImagenArmaasignar1().setVisible(true);
            this.vasignararma.getLblArmaaasignar1().setVisible(true);
            this.vasignararma.getLblAzufre1().setVisible(true);
            this.vasignararma.getLblCristal1().setVisible(true);
            this.vasignararma.getLblMadera1().setVisible(true);
            this.vasignararma.getTxtCantidadaasignar1().setVisible(true);
            this.vasignararma.getImagenAzufre1().setVisible(true);
            this.vasignararma.getImagenCristal1().setVisible(true);
            this.vasignararma.getImagenMadera1().setVisible(true);
            this.vasignararma.getLblPuntosataque1().setVisible(true);
            this.vasignararma.getLblPuntosdefensivos1().setVisible(true);
            this.vasignararma.getCmdAsasignararma1().setVisible(true);
            i++;
        } else {
            this.vasignararma.getImagenArmaasignar1().setVisible(false);
            this.vasignararma.getLblArmaaasignar1().setVisible(false);
            this.vasignararma.getLblAzufre1().setVisible(false);
            this.vasignararma.getLblCristal1().setVisible(false);
            this.vasignararma.getLblMadera1().setVisible(false);
            this.vasignararma.getTxtCantidadaasignar1().setVisible(false);
            this.vasignararma.getImagenAzufre1().setVisible(false);
            this.vasignararma.getImagenCristal1().setVisible(false);
            this.vasignararma.getImagenMadera1().setVisible(false);
            this.vasignararma.getLblPuntosataque1().setVisible(false);
            this.vasignararma.getLblPuntosdefensivos1().setVisible(false);
            this.vasignararma.getCmdAsasignararma1().setVisible(false);
            i++;
        }
        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            this.vasignararma.getImagenArmaasignar2().setVisible(true);
            this.vasignararma.getLblArmaaasignar2().setVisible(true);
            this.vasignararma.getLblAzufre2().setVisible(true);
            this.vasignararma.getLblCristal2().setVisible(true);
            this.vasignararma.getLblMadera2().setVisible(true);
            this.vasignararma.getTxtCantidadaasignar2().setVisible(true);
            this.vasignararma.getImagenAzufre2().setVisible(true);
            this.vasignararma.getImagenCristal2().setVisible(true);
            this.vasignararma.getImagenMadera2().setVisible(true);
            this.vasignararma.getLblPuntosataque2().setVisible(true);
            this.vasignararma.getLblPuntosdefensivos2().setVisible(true);
            this.vasignararma.getCmdAsasignararma2().setVisible(true);
            i++;
        } else {
            this.vasignararma.getImagenArmaasignar2().setVisible(false);
            this.vasignararma.getLblArmaaasignar2().setVisible(false);
            this.vasignararma.getLblAzufre2().setVisible(false);
            this.vasignararma.getLblCristal2().setVisible(false);
            this.vasignararma.getLblMadera2().setVisible(false);
            this.vasignararma.getTxtCantidadaasignar2().setVisible(false);
            this.vasignararma.getImagenAzufre2().setVisible(false);
            this.vasignararma.getImagenCristal2().setVisible(false);
            this.vasignararma.getImagenMadera2().setVisible(false);
            this.vasignararma.getLblPuntosataque2().setVisible(false);
            this.vasignararma.getLblPuntosdefensivos2().setVisible(false);
            this.vasignararma.getCmdAsasignararma2().setVisible(false);
            i++;
        }

        if (i < this.unidad.getArmaunidad().getListarmas().size()) {
            this.vasignararma.getImagenArmaasignar3().setVisible(true);
            this.vasignararma.getLblArmaaasignar3().setVisible(true);
            this.vasignararma.getLblAzufre3().setVisible(true);
            this.vasignararma.getLblCristal3().setVisible(true);
            this.vasignararma.getLblMadera3().setVisible(true);
            this.vasignararma.getTxtCantidadaasignar3().setVisible(true);
            this.vasignararma.getImagenAzufre3().setVisible(true);
            this.vasignararma.getImagenCristal3().setVisible(true);
            this.vasignararma.getImagenMadera3().setVisible(true);
            this.vasignararma.getLblPuntosataque3().setVisible(true);
            this.vasignararma.getLblPuntosdefensivos3().setVisible(true);
            this.vasignararma.getCmdAsasignararma3().setVisible(true);
            i++;
        } else {
            this.vasignararma.getImagenArmaasignar3().setVisible(false);
            this.vasignararma.getLblArmaaasignar3().setVisible(false);
            this.vasignararma.getLblAzufre3().setVisible(false);
            this.vasignararma.getLblCristal3().setVisible(false);
            this.vasignararma.getLblMadera3().setVisible(false);
            this.vasignararma.getTxtCantidadaasignar3().setVisible(false);
            this.vasignararma.getImagenAzufre3().setVisible(false);
            this.vasignararma.getImagenCristal3().setVisible(false);
            this.vasignararma.getImagenMadera3().setVisible(false);
            this.vasignararma.getLblPuntosataque3().setVisible(false);
            this.vasignararma.getLblPuntosdefensivos3().setVisible(false);
            this.vasignararma.getCmdAsasignararma3().setVisible(false);
            i++;
        }


    }

}
