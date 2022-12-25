/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ejercito.VDestruirUnidad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class VerDestruirUnidad implements Actualizar {
    private UnidadMilitar unidadmilitar;
    private List<Arma> arma = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();
    private VCiudad vciudad;


    private VDestruirUnidad vdestruirunidad;


    public VerDestruirUnidad(UnidadMilitar unidadmilitar, List<Arma> arma, List<Integer> cantidad, VCiudad vciudad) {
        this.unidadmilitar = unidadmilitar;

        this.vciudad = vciudad;


        for (int i = 0; i < this.vciudad.getCiudad().getCiudadejercito().getUnidad().size(); i++) {
            if (this.vciudad.getCiudad().getCiudadejercito().getUnidad().get(i).getNombre().equals(unidadmilitar.getNombre())) {
                this.cantidad.add(this.vciudad.getCiudad().getCiudadejercito().getUnidadesinarma().get(i));
                this.arma.add(null);
                for (int j = 0; j < this.vciudad.getCiudad().getCiudadejercito().getArmasdeunidad().get(i).getArma().size(); j++) {
                    this.arma.add(this.vciudad.getCiudad().getCiudadejercito().getArmasdeunidad().get(i).getArma().get(j));
                    this.cantidad.add(this.vciudad.getCiudad().getCiudadejercito().getArmasdeunidad().get(i).getCantidad().get(j));


                }
            }
        }
        this.vdestruirunidad = new VDestruirUnidad(this.unidadmilitar, this.arma, this.cantidad, this.vciudad);


    }

    public VerDestruirUnidad(List<UnidadMilitar> unidadesdejugador, List<Arma> armasunidad, List<Integer> cantidaddisponible, List<Integer> cantidadaenviar, UnidadMilitar unidadelegida) {
        this.unidadmilitar = unidadelegida;

        for (int i = 0; i < unidadesdejugador.size(); i++) {
            if (unidadesdejugador.get(i).getNombre().equals(unidadmilitar.getNombre())) {
                this.cantidad.add(cantidaddisponible.get(i));
                this.arma.add(armasunidad.get(i));

            }
        }


        this.vdestruirunidad = new VDestruirUnidad(unidadesdejugador, armasunidad, cantidaddisponible, cantidadaenviar, unidadelegida);
        this.vdestruirunidad.setDestruir(false);
        this.CUVerDestruirUnidad();
    }

    public void CUVerDestruirUnidad() {

        this.actualizardatospantalla();
        this.actualizarinterfazgrafica();

    }

    @Override
    public void actualizardatospantalla() {
        ImageIcon imagenarma;
        String direccion = " ";
        int i = 1;
        int tope = this.arma.size();
        this.vdestruirunidad.getLblUnidadsinarma().setText(this.unidadmilitar.getNombre());
        this.vdestruirunidad.getLblCantidadSinArma().setText(this.cantidad.get(0) + "");
        if (this.cantidad.get(0) == 0) {
            this.vdestruirunidad.getTxtCantidadsinarma().setEnabled(false);
        }

        if (i < tope) {
            this.vdestruirunidad.getLblArma().setText(this.arma.get(i).getNombrearma());
            this.vdestruirunidad.getLblCantidadarma().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdestruirunidad.getImagenArma().setIcon(imagenarma);
            this.vdestruirunidad.getTxtCantidadadesasignar().setText("");

            i++;
        }

        if (i < tope) {
            this.vdestruirunidad.getLblArma1().setText(this.arma.get(i).getNombrearma());
            this.vdestruirunidad.getLblCantidadarma1().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdestruirunidad.getImagenArma1().setIcon(imagenarma);
            this.vdestruirunidad.getTxtCantidadadesasignar1().setText("");

            i++;
        }

        if (i < tope) {
            this.vdestruirunidad.getLblArma2().setText(this.arma.get(i).getNombrearma());
            this.vdestruirunidad.getLblCantidadarma2().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdestruirunidad.getImagenArma2().setIcon(imagenarma);
            this.vdestruirunidad.getTxtCantidadadesasignar2().setText("");

            i++;
        }

        if (i < tope) {
            this.vdestruirunidad.getLblArma3().setText(this.arma.get(i).getNombrearma());
            this.vdestruirunidad.getLblCantidadarma3().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdestruirunidad.getImagenArma3().setIcon(imagenarma);
            this.vdestruirunidad.getTxtCantidadadesasignar3().setText("");

            i++;
        }


    }

    @Override
    public void actualizarinterfazgrafica() {
        int i = 1;
        int tope = this.arma.size();

        if (i < tope) {
            this.vdestruirunidad.getLblArma().setVisible(true);
            this.vdestruirunidad.getLblCantidadarma().setVisible(true);
            this.vdestruirunidad.getImagenArma().setVisible(true);
            this.vdestruirunidad.getTxtCantidadadesasignar().setVisible(true);
            this.vdestruirunidad.getCmdDestruirUnidad1().setVisible(true);
            i++;
        } else {
            this.vdestruirunidad.getLblArma().setVisible(false);
            this.vdestruirunidad.getLblCantidadarma().setVisible(false);
            this.vdestruirunidad.getImagenArma().setVisible(false);
            this.vdestruirunidad.getTxtCantidadadesasignar().setVisible(false);
            this.vdestruirunidad.getCmdDestruirUnidad1().setVisible(false);
            i++;
        }

        if (i < tope) {
            this.vdestruirunidad.getLblArma1().setVisible(true);
            this.vdestruirunidad.getLblCantidadarma1().setVisible(true);
            this.vdestruirunidad.getImagenArma1().setVisible(true);
            this.vdestruirunidad.getTxtCantidadadesasignar1().setVisible(true);
            this.vdestruirunidad.getCmdDestruirUnidad2().setVisible(true);
            i++;
        } else {
            this.vdestruirunidad.getLblArma1().setVisible(false);
            this.vdestruirunidad.getLblCantidadarma1().setVisible(false);
            this.vdestruirunidad.getImagenArma1().setVisible(false);
            this.vdestruirunidad.getTxtCantidadadesasignar1().setVisible(false);
            this.vdestruirunidad.getCmdDestruirUnidad2().setVisible(false);
            i++;
        }

        if (i < tope) {
            this.vdestruirunidad.getLblArma2().setVisible(true);
            this.vdestruirunidad.getLblCantidadarma2().setVisible(true);
            this.vdestruirunidad.getImagenArma2().setVisible(true);
            this.vdestruirunidad.getTxtCantidadadesasignar2().setVisible(true);
            this.vdestruirunidad.getCmdDestruirUnidad3().setVisible(true);
            i++;
        } else {
            this.vdestruirunidad.getLblArma2().setVisible(false);
            this.vdestruirunidad.getLblCantidadarma2().setVisible(false);
            this.vdestruirunidad.getImagenArma2().setVisible(false);
            this.vdestruirunidad.getTxtCantidadadesasignar2().setVisible(false);
            this.vdestruirunidad.getCmdDestruirUnidad3().setVisible(false);
            i++;
        }


        if (i < tope) {
            this.vdestruirunidad.getLblArma3().setVisible(true);
            this.vdestruirunidad.getLblCantidadarma3().setVisible(true);
            this.vdestruirunidad.getImagenArma3().setVisible(true);
            this.vdestruirunidad.getTxtCantidadadesasignar3().setVisible(true);
            this.vdestruirunidad.getCmdDestruirUnidad4().setVisible(true);
            i++;
        } else {
            this.vdestruirunidad.getLblArma3().setVisible(false);
            this.vdestruirunidad.getLblCantidadarma3().setVisible(false);
            this.vdestruirunidad.getImagenArma3().setVisible(false);
            this.vdestruirunidad.getTxtCantidadadesasignar3().setVisible(false);
            this.vdestruirunidad.getCmdDestruirUnidad4().setVisible(false);
            i++;
        }
    }


}
