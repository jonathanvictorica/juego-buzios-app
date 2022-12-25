/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ciudad.VVerEdificiosaConstruir;
import com.jmg.buzios.view.edificios.VEdificio;

import javax.swing.*;

/**
 * @author Alumno
 */
public class VerDetalleEdificio implements Actualizar {

    private VCiudad vciudad;
    private int lugarciudad;

    private EdificioNivel edificionivel;
    private VVerEdificiosaConstruir veredificiosaconstruir;

    private VEdificio vedificio;

    public VerDetalleEdificio(VCiudad vciudad, int lugarciudad, EdificioNivel edificionivel, VVerEdificiosaConstruir veredificiosaconstruir) {
        this.vciudad = vciudad;
        this.lugarciudad = lugarciudad;

        this.edificionivel = edificionivel;
        this.veredificiosaconstruir = veredificiosaconstruir;
    }


    public void CUverdetalleedificio() {
        vedificio = new VEdificio(vciudad, edificionivel, lugarciudad, veredificiosaconstruir);

        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();

    }

    @Override
    public void actualizardatospantalla() {
        vedificio.setTitle("CONSTRUIR " + this.edificionivel.getEdificio().getNombre());
        vedificio.getLblNombreedificio().setText(edificionivel.getEdificio().getNombre());
        vedificio.getLblCosto().setText(edificionivel.getEdificio().getCosto() + "");

        vedificio.getTxtdescripciones().setText(edificionivel.getEdificio().getDescripcion());

        String ii = ("/IMAGEN/EDIFICIOS/" + edificionivel.getEdificio().getImagen().getDireccion() + ".png");
        ImageIcon a = new ImageIcon(getClass().getResource(ii));

        vedificio.getImagenedificio().setIcon(a);


        vedificio.getImagenMadera().setVisible(false);
        vedificio.getLblMadera().setVisible(false);
        vedificio.getImagenMarmol().setVisible(false);
        vedificio.getLblMarmol().setVisible(false);
        vedificio.getImagenCristal().setVisible(false);
        vedificio.getLblCristal().setVisible(false);
        vedificio.getImagenAzufre().setVisible(false);
        vedificio.getLblAzufre().setVisible(false);

        for (int i = 0; i < edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
            switch (edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                case "Madera":
                    vedificio.getImagenMadera().setVisible(true);
                    vedificio.getLblMadera().setVisible(true);
                    vedificio.getLblMadera().setText(edificionivel.getEdificiorecurso().getCantidad().get(i) + "");
                    break;
                case "Marmol":
                    vedificio.getImagenMarmol().setVisible(true);
                    vedificio.getLblMarmol().setVisible(true);
                    vedificio.getLblMarmol().setText(edificionivel.getEdificiorecurso().getCantidad().get(i) + "");

                    break;
                case "Cristal":
                    vedificio.getImagenCristal().setVisible(true);
                    vedificio.getLblCristal().setVisible(true);
                    vedificio.getLblCristal().setText(edificionivel.getEdificiorecurso().getCantidad().get(i) + "");

                    break;
                case "Azufre":
                    vedificio.getImagenAzufre().setVisible(true);
                    vedificio.getLblAzufre().setVisible(true);
                    vedificio.getLblAzufre().setText(edificionivel.getEdificiorecurso().getCantidad().get(i) + "");

                    break;
            }
        }
        vedificio.show();
        vedificio.repaint();
    }

    @Override
    public void actualizarinterfazgrafica() {
        String direccionimagen;
        ImageIcon a;
        for (int i = 0; i < this.vciudad.getCiudad().getCiudadrecurso().getRecurso().size(); i++) {
            switch (this.vciudad.getCiudad().getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                case "Madera":
                    direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                    a = new ImageIcon(getClass().getResource(direccionimagen));
                    vedificio.getImagenMadera().setIcon(a);
                    vedificio.getLblMadera().setText("0");
                    break;
                case "Marmol":
                    direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                    a = new ImageIcon(getClass().getResource(direccionimagen));
                    vedificio.getImagenMarmol().setIcon(a);
                    vedificio.getLblMarmol().setText("0");
                    break;
                case "Cristal":
                    direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                    a = new ImageIcon(getClass().getResource(direccionimagen));
                    vedificio.getImagenCristal().setIcon(a);
                    vedificio.getLblCristal().setText("0");
                    break;
                case "Azufre":
                    direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                    a = new ImageIcon(getClass().getResource(direccionimagen));
                    vedificio.getImagenAzufre().setIcon(a);
                    vedificio.getLblAzufre().setText("0");
                    break;
            }
        }
    }


}
