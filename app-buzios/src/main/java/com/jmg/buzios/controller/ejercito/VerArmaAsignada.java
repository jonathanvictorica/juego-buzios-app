/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ejercito.VDesasignarArma;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class VerArmaAsignada implements Actualizar {

    private VCiudad vciudad;
    private UnidadMilitar unidadmilitar;
    private List<Arma> arma = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();

    private VDesasignarArma vdesasignararma;

    public VerArmaAsignada(VCiudad vciudad, UnidadMilitar unidadmilitar, List<Arma> arma, List<Integer> cantidad) {
        this.vciudad = vciudad;
        this.unidadmilitar = unidadmilitar;
        this.arma = arma;
        this.cantidad = cantidad;
    }

    public void CUVerarmaasignada() {

        if (this.arma.isEmpty()) {
            JOptionPane.showMessageDialog(vciudad, "Esta unidad no tiene armas para poder quitarle.");
        } else {
            vdesasignararma = new VDesasignarArma(this.vciudad, this.unidadmilitar, this.arma, this.cantidad);
            this.actualizarinterfazgrafica();
            this.actualizardatospantalla();


            this.vdesasignararma.repaint();
        }

    }

    @Override
    public void actualizardatospantalla() {
        ImageIcon imagenarma;
        String direccion = " ";
        int i = 0;
        int tope = this.arma.size();

        this.vdesasignararma.getLblNombredeUnidadMilitar().setText(this.unidadmilitar.getNombre());

        if (i < tope) {
            this.vdesasignararma.getLblArma().setText(this.arma.get(i).getNombrearma());
            this.vdesasignararma.getLblCantidadarma().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdesasignararma.getImagenArma().setIcon(imagenarma);
            this.vdesasignararma.getTxtCantidadadesasignar().setText("");

            i++;
        }

        if (i < tope) {
            this.vdesasignararma.getLblArma1().setText(this.arma.get(i).getNombrearma());
            this.vdesasignararma.getLblCantidadarma1().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdesasignararma.getImagenArma1().setIcon(imagenarma);
            this.vdesasignararma.getTxtCantidadadesasignar1().setText("");

            i++;
        }

        if (i < tope) {
            this.vdesasignararma.getLblArma2().setText(this.arma.get(i).getNombrearma());
            this.vdesasignararma.getLblCantidadarma2().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdesasignararma.getImagenArma2().setIcon(imagenarma);
            this.vdesasignararma.getTxtCantidadadesasignar2().setText("");

            i++;
        }

        if (i < tope) {
            this.vdesasignararma.getLblArma3().setText(this.arma.get(i).getNombrearma());
            this.vdesasignararma.getLblCantidadarma3().setText(this.cantidad.get(i).intValue() + "");
            direccion = ("/IMAGEN/ARMA/" + this.arma.get(i).getImagenarma().getDireccion() + ".png");
            imagenarma = new ImageIcon(getClass().getResource(direccion));
            this.vdesasignararma.getImagenArma3().setIcon(imagenarma);
            this.vdesasignararma.getTxtCantidadadesasignar3().setText("");

            i++;
        }


    }

    @Override
    public void actualizarinterfazgrafica() {
        int i = 0;
        int tope = this.arma.size();

        if (i < tope) {
            this.vdesasignararma.getLblArma().setVisible(true);
            this.vdesasignararma.getLblCantidadarma().setVisible(true);
            this.vdesasignararma.getImagenArma().setVisible(true);
            this.vdesasignararma.getTxtCantidadadesasignar().setVisible(true);
            this.vdesasignararma.getCmdDesasignararma().setVisible(true);
            i++;
        } else {
            this.vdesasignararma.getLblArma().setVisible(false);
            this.vdesasignararma.getLblCantidadarma().setVisible(false);
            this.vdesasignararma.getImagenArma().setVisible(false);
            this.vdesasignararma.getTxtCantidadadesasignar().setVisible(false);
            this.vdesasignararma.getCmdDesasignararma().setVisible(false);

        }

        if (i < tope) {
            this.vdesasignararma.getLblArma1().setVisible(true);
            this.vdesasignararma.getLblCantidadarma1().setVisible(true);
            this.vdesasignararma.getImagenArma1().setVisible(true);
            this.vdesasignararma.getTxtCantidadadesasignar1().setVisible(true);
            this.vdesasignararma.getCmdDesasignararma1().setVisible(true);
            i++;
        } else {
            this.vdesasignararma.getLblArma1().setVisible(false);
            this.vdesasignararma.getLblCantidadarma1().setVisible(false);
            this.vdesasignararma.getImagenArma1().setVisible(false);
            this.vdesasignararma.getTxtCantidadadesasignar1().setVisible(false);
            this.vdesasignararma.getCmdDesasignararma1().setVisible(false);

        }

        if (i < tope) {
            this.vdesasignararma.getLblArma2().setVisible(true);
            this.vdesasignararma.getLblCantidadarma2().setVisible(true);
            this.vdesasignararma.getImagenArma2().setVisible(true);
            this.vdesasignararma.getTxtCantidadadesasignar2().setVisible(true);
            this.vdesasignararma.getCmdDesasignararma2().setVisible(true);
            i++;
        } else {
            this.vdesasignararma.getLblArma2().setVisible(false);
            this.vdesasignararma.getLblCantidadarma2().setVisible(false);
            this.vdesasignararma.getImagenArma2().setVisible(false);
            this.vdesasignararma.getTxtCantidadadesasignar2().setVisible(false);
            this.vdesasignararma.getCmdDesasignararma2().setVisible(false);

        }


        if (i < tope) {
            this.vdesasignararma.getLblArma3().setVisible(true);
            this.vdesasignararma.getLblCantidadarma3().setVisible(true);
            this.vdesasignararma.getImagenArma3().setVisible(true);
            this.vdesasignararma.getTxtCantidadadesasignar3().setVisible(true);
            this.vdesasignararma.getCmdDesasignararma3().setVisible(true);
            i++;
        } else {
            this.vdesasignararma.getLblArma3().setVisible(false);
            this.vdesasignararma.getLblCantidadarma3().setVisible(false);
            this.vdesasignararma.getImagenArma3().setVisible(false);
            this.vdesasignararma.getTxtCantidadadesasignar3().setVisible(false);
            this.vdesasignararma.getCmdDesasignararma3().setVisible(false);

        }
    }

}
