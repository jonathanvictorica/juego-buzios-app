/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerPuerto;

import javax.swing.*;

/**
 * @author Alumno
 */
public class VerPuerto extends ConfigurarEdificio implements Actualizar {

    public VerPuerto(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerPuerto(this);
    }


    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        ImageIcon imagenedificio;
        String direccion = "";
        String islacoordenada = "";
        int indice = 1;
        this.ciudadjugador.getJugador().buscarciudadesdejugador();
        for (int i = 0; i < this.ciudadjugador.getJugador().getCiudades().size(); i++) {
            if (!this.ciudadjugador.getNombre().equals(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre())) {
                direccion = ("/IMAGEN/ISLA/" + this.ciudadjugador.getJugador().getCiudades().get(i).getNivel().getImagennivel().getDireccion() + ".png");
                imagenedificio = new ImageIcon(getClass().getResource(direccion));
                switch (indice) {
                    case 1:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas().setText(islacoordenada);
                        break;
                    case 2:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad1().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad1().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad1().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas1().setText(islacoordenada);
                        break;
                    case 3:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad2().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad2().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad2().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas2().setText(islacoordenada);
                        break;
                    case 4:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad3().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad3().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad3().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas3().setText(islacoordenada);
                        break;
                    case 5:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad4().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad4().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad4().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas4().setText(islacoordenada);
                        break;
                    case 6:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad5().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad5().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad5().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas5().setText(islacoordenada);
                        break;
                    case 7:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad6().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad6().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad6().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas6().setText(islacoordenada);
                        break;
                    case 8:
                        ((VVerPuerto) this.vedificio).getImagenCCiudad7().setVisible(true);
                        ((VVerPuerto) this.vedificio).getImagenCiudad7().setIcon(imagenedificio);
                        ((VVerPuerto) this.vedificio).getLblNombreCiudad7().setText(this.ciudadjugador.getJugador().getCiudades().get(i).getNombre());
                        islacoordenada = this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenadax() + ":" + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getCoordenaday() + " - " + this.ciudadjugador.getJugador().getCiudades().get(i).getIsla().getNombre();
                        ((VVerPuerto) this.vedificio).getLblCoordenadas7().setText(islacoordenada);
                        break;
                }
                indice = indice + 1;
            }
        }
    }

}
