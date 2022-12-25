/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.*;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class ConfigurarEdificio {

    public VCiudad vciudad;
    public Ciudad ciudadjugador;
    public EdificioNivel edificionivel;//se considera que guarda los recursos para el siguiente nivel
    public int lugarciudad;
    public JFrame vedificio;

    public ConfigurarEdificio(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        this.vciudad = vciudad;
        this.ciudadjugador = ciudadjugador;
        this.edificionivel = edificionivel;
        this.lugarciudad = lugarciudad;


    }

    public VCiudad getVciudad() {
        return vciudad;
    }

    public EdificioNivel getEdificionivel() {
        return edificionivel;
    }


    public void destruiredificio() throws SQLException {
        DestruirEdificio destruiredificio = new DestruirEdificio(this.ciudadjugador, this.edificionivel, this.vciudad, this.lugarciudad, this.vedificio);
        destruiredificio.CUdestruiredificio();
    }

    public void elevarniveledificio() throws SQLException {
        ElevarEdificioNivel elevaredificio = new ElevarEdificioNivel(this.vedificio, this.ciudadjugador, this.edificionivel, this.vciudad);
        elevaredificio.CUelevaredificionivel();
    }

    public void actualizar_datospantalla() throws SQLException {
        ImageIcon a;
        String direccionimagen;
        switch (this.vedificio.getClass().getSimpleName()) {
            case "VVerTaberna":
                this.vedificio.setTitle("TABERNA");

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());

                VVerTaberna VentanaEdificio = (VVerTaberna) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaEdificio.getImagenMadera().setIcon(a);
                            VentanaEdificio.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaEdificio.getImagenMarmol().setIcon(a);
                            VentanaEdificio.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaEdificio.getImagenCristal().setIcon(a);
                            VentanaEdificio.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaEdificio.getImagenAzufre().setIcon(a);
                            VentanaEdificio.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios

                //Para actualizar el nivel en la pantalla
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    VentanaEdificio.getLblNivel().setText(asignarnivel);

                } else {
                    String asignarnivel = "" + this.edificionivel.getNivel();
                    VentanaEdificio.getLblNivel().setText(asignarnivel);
                }


                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);
                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                VentanaEdificio.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                VentanaEdificio.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                VentanaEdificio.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                VentanaEdificio.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        VentanaEdificio.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        VentanaEdificio.getCmdElevarniveledificio().setEnabled(false);
                    }

                } else {
                    VentanaEdificio.getCmdElevarniveledificio().setEnabled(false);

                }


                VentanaEdificio.repaint();
                break;
            case "VVerAcademia":
                this.vedificio.setTitle("ACADEMIA");

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerAcademia VentanaAcademia = (VVerAcademia) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                VentanaAcademia.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    VentanaAcademia.getLblNivel().setText(asignarnivel);

                }

                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaAcademia.getImagenMadera().setIcon(a);
                            VentanaAcademia.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaAcademia.getImagenMarmol().setIcon(a);
                            VentanaAcademia.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaAcademia.getImagenCristal().setIcon(a);
                            VentanaAcademia.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaAcademia.getImagenAzufre().setIcon(a);
                            VentanaAcademia.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                VentanaAcademia.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                VentanaAcademia.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                VentanaAcademia.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                VentanaAcademia.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        VentanaAcademia.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        VentanaAcademia.getCmdElevarniveledificio().setEnabled(false);
                    }
                    VentanaAcademia.getLblNivelMaximo().setVisible(false);
                } else {
                    VentanaAcademia.getCmdElevarniveledificio().setEnabled(false);
                    VentanaAcademia.getLblNivelMaximo().setVisible(true);
                }


                VentanaAcademia.repaint();
                break;

            case "VVerEdificioReduccion":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerEdificioReduccion VentanaReduccion = (VVerEdificioReduccion) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaReduccion.getImagenMadera().setIcon(a);
                            VentanaReduccion.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaReduccion.getImagenMarmol().setIcon(a);
                            VentanaReduccion.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaReduccion.getImagenCristal().setIcon(a);
                            VentanaReduccion.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaReduccion.getImagenAzufre().setIcon(a);
                            VentanaReduccion.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                VentanaReduccion.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                VentanaReduccion.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                VentanaReduccion.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                VentanaReduccion.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        VentanaReduccion.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        VentanaReduccion.getCmdElevarniveledificio().setEnabled(false);
                    }
                    VentanaReduccion.getLblNivelMaximo().setVisible(false);
                } else {
                    VentanaReduccion.getCmdElevarniveledificio().setEnabled(false);
                    VentanaReduccion.getLblNivelMaximo().setVisible(true);
                }

                VentanaReduccion.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    VentanaReduccion.getLblNivel().setText(asignarnivel);

                }

                VentanaReduccion.repaint();
                break;
            case "VVerPuerto":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerPuerto VentanaPuerto = (VVerPuerto) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaPuerto.getImagenMadera().setIcon(a);
                            VentanaPuerto.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaPuerto.getImagenMarmol().setIcon(a);
                            VentanaPuerto.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaPuerto.getImagenCristal().setIcon(a);
                            VentanaPuerto.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaPuerto.getImagenAzufre().setIcon(a);
                            VentanaPuerto.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                VentanaPuerto.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                VentanaPuerto.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                VentanaPuerto.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                VentanaPuerto.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        VentanaPuerto.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        VentanaPuerto.getCmdElevarniveledificio().setEnabled(false);
                    }
                    VentanaPuerto.getLblNivelMaximo().setVisible(false);
                } else {
                    VentanaPuerto.getCmdElevarniveledificio().setEnabled(false);
                    VentanaPuerto.getLblNivelMaximo().setVisible(true);
                }

                VentanaPuerto.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    VentanaPuerto.getLblNivel().setText(asignarnivel);

                }
                VentanaPuerto.repaint();
                break;
            case "VVerIntendencia":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerIntendencia VentanaIntendencia = (VVerIntendencia) this.vedificio;
                //Actualizar las imagenes de los recursos. 

                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaIntendencia.getImagenMadera().setIcon(a);
                            VentanaIntendencia.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaIntendencia.getImagenMarmol().setIcon(a);
                            VentanaIntendencia.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaIntendencia.getImagenCristal().setIcon(a);
                            VentanaIntendencia.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            VentanaIntendencia.getImagenAzufre().setIcon(a);
                            VentanaIntendencia.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                VentanaIntendencia.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    VentanaIntendencia.getLblNivel().setText(asignarnivel);

                }
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                VentanaIntendencia.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                VentanaIntendencia.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                VentanaIntendencia.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                VentanaIntendencia.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        VentanaIntendencia.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        VentanaIntendencia.getCmdElevarniveledificio().setEnabled(false);
                    }
                    VentanaIntendencia.getLblNivelMaximo().setVisible(false);

                } else {
                    VentanaIntendencia.getCmdElevarniveledificio().setEnabled(false);
                    VentanaIntendencia.getLblNivelMaximo().setVisible(true);

                }

                //Para actualizar el nivel en la pantalla

                VentanaIntendencia.repaint();
                break;
            case "VVerCuartel":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerCuartel Ventanacuartel = (VVerCuartel) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanacuartel.getImagenMadera().setIcon(a);
                            Ventanacuartel.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanacuartel.getImagenMarmol().setIcon(a);
                            Ventanacuartel.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanacuartel.getImagenCristal().setIcon(a);
                            Ventanacuartel.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanacuartel.getImagenAzufre().setIcon(a);
                            Ventanacuartel.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                Ventanacuartel.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                Ventanacuartel.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                Ventanacuartel.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                Ventanacuartel.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        Ventanacuartel.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        Ventanacuartel.getCmdElevarniveledificio().setEnabled(false);
                    }
                    Ventanacuartel.getLblNivelMaximo().setVisible(false);
                } else {
                    Ventanacuartel.getCmdElevarniveledificio().setEnabled(false);
                    Ventanacuartel.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                Ventanacuartel.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    Ventanacuartel.getLblNivel().setText(asignarnivel);

                }
                Ventanacuartel.repaint();
                break;
            case "VVerAstilerodeGuerra":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerAstilerodeGuerra Ventanastillerodeguerra = (VVerAstilerodeGuerra) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanastillerodeguerra.getImagenMadera().setIcon(a);
                            Ventanastillerodeguerra.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanastillerodeguerra.getImagenMarmol().setIcon(a);
                            Ventanastillerodeguerra.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanastillerodeguerra.getImagenCristal().setIcon(a);
                            Ventanastillerodeguerra.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanastillerodeguerra.getImagenAzufre().setIcon(a);
                            Ventanastillerodeguerra.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                Ventanastillerodeguerra.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                Ventanastillerodeguerra.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                Ventanastillerodeguerra.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                Ventanastillerodeguerra.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        Ventanastillerodeguerra.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        Ventanastillerodeguerra.getCmdElevarniveledificio().setEnabled(false);
                    }
                    Ventanastillerodeguerra.getLblNivelMaximo().setVisible(false);
                } else {
                    Ventanastillerodeguerra.getCmdElevarniveledificio().setEnabled(false);
                    Ventanastillerodeguerra.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                Ventanastillerodeguerra.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    Ventanastillerodeguerra.getLblNivel().setText(asignarnivel);

                }
                Ventanastillerodeguerra.repaint();
                break;
            case "VVerEdificioProduccion":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerEdificioProduccion Ventanaedificioproduccion = (VVerEdificioProduccion) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanaedificioproduccion.getImagenMadera().setIcon(a);
                            Ventanaedificioproduccion.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanaedificioproduccion.getImagenMarmol().setIcon(a);
                            Ventanaedificioproduccion.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanaedificioproduccion.getImagenCristal().setIcon(a);
                            Ventanaedificioproduccion.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanaedificioproduccion.getImagenAzufre().setIcon(a);
                            Ventanaedificioproduccion.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                Ventanaedificioproduccion.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                Ventanaedificioproduccion.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                Ventanaedificioproduccion.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                Ventanaedificioproduccion.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        Ventanaedificioproduccion.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        Ventanaedificioproduccion.getCmdElevarniveledificio().setEnabled(false);
                    }
                    Ventanaedificioproduccion.getLblNivelMaximo().setVisible(false);
                } else {
                    Ventanaedificioproduccion.getCmdElevarniveledificio().setEnabled(false);
                    Ventanaedificioproduccion.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                Ventanaedificioproduccion.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    Ventanaedificioproduccion.getLblNivel().setText(asignarnivel);

                }
                Ventanaedificioproduccion.repaint();
                break;
            case "VVerMercado":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerMercado Ventanamercado = (VVerMercado) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanamercado.getImagenMadera().setIcon(a);
                            Ventanamercado.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanamercado.getImagenMarmol().setIcon(a);
                            Ventanamercado.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanamercado.getImagenCristal().setIcon(a);
                            Ventanamercado.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanamercado.getImagenAzufre().setIcon(a);
                            Ventanamercado.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                Ventanamercado.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                Ventanamercado.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                Ventanamercado.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                Ventanamercado.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        Ventanamercado.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        Ventanamercado.getCmdElevarniveledificio().setEnabled(false);
                    }
                    Ventanamercado.getLblNivelMaximo().setVisible(false);
                } else {
                    Ventanamercado.getCmdElevarniveledificio().setEnabled(false);
                    Ventanamercado.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                Ventanamercado.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    Ventanamercado.getLblNivel().setText(asignarnivel);

                }
                Ventanamercado.repaint();
                break;
            case "VVerPalaciooResidencia":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerPalaciooResidencia Ventanapalacio = (VVerPalaciooResidencia) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanapalacio.getImagenMadera().setIcon(a);
                            Ventanapalacio.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanapalacio.getImagenMarmol().setIcon(a);
                            Ventanapalacio.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanapalacio.getImagenCristal().setIcon(a);
                            Ventanapalacio.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanapalacio.getImagenAzufre().setIcon(a);
                            Ventanapalacio.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                Ventanapalacio.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                Ventanapalacio.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                Ventanapalacio.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                Ventanapalacio.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        Ventanapalacio.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        Ventanapalacio.getCmdElevarniveledificio().setEnabled(false);
                    }
                    Ventanapalacio.getLblNivelMaximo().setVisible(false);
                } else {
                    Ventanapalacio.getCmdElevarniveledificio().setEnabled(false);
                    Ventanapalacio.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                Ventanapalacio.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    Ventanapalacio.getLblNivel().setText(asignarnivel);

                }
                Ventanapalacio.repaint();
                break;
            case "VVerDepositooAlmacen":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerDepositooAlmacen Ventanadeposito = (VVerDepositooAlmacen) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanadeposito.getImagenMadera().setIcon(a);
                            Ventanadeposito.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanadeposito.getImagenMarmol().setIcon(a);
                            Ventanadeposito.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanadeposito.getImagenCristal().setIcon(a);
                            Ventanadeposito.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            Ventanadeposito.getImagenAzufre().setIcon(a);
                            Ventanadeposito.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                Ventanadeposito.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                Ventanadeposito.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                Ventanadeposito.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                Ventanadeposito.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        Ventanadeposito.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        Ventanadeposito.getCmdElevarniveledificio().setEnabled(false);
                    }
                    Ventanadeposito.getLblNivelMaximo().setVisible(false);
                } else {
                    Ventanadeposito.getCmdElevarniveledificio().setEnabled(false);
                    Ventanadeposito.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                Ventanadeposito.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    Ventanadeposito.getLblNivel().setText(asignarnivel);

                }
                Ventanadeposito.repaint();
                break;
            case "VVerMuralla":
                this.vedificio.setTitle(this.edificionivel.getEdificio().getNombre());

                direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                this.vedificio.setIconImage(a.getImage());
                VVerMuralla ventanamuralla = (VVerMuralla) this.vedificio;
                //Actualizar las imagenes de los recursos. 
                for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
                    switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                        case "Madera":
                            direccionimagen = ("/IMAGEN/" + "Maderadeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            ventanamuralla.getImagenMadera().setIcon(a);
                            ventanamuralla.getLblMadera().setText("0");
                            break;
                        case "Marmol":
                            direccionimagen = ("/IMAGEN/" + "Marmoldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            ventanamuralla.getImagenMarmol().setIcon(a);
                            ventanamuralla.getLblMarmol().setText("0");
                            break;
                        case "Cristal":
                            direccionimagen = ("/IMAGEN/" + "Cristaldeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            ventanamuralla.getImagenCristal().setIcon(a);
                            ventanamuralla.getLblCristal().setText("0");
                            break;
                        case "Azufre":
                            direccionimagen = ("/IMAGEN/" + "Azufredeedificionivel" + ".jpg");
                            a = new ImageIcon(getClass().getResource(direccionimagen));
                            ventanamuralla.getImagenAzufre().setIcon(a);
                            ventanamuralla.getLblAzufre().setText("0");
                            break;
                    }
                }
                //actualiza la cantidad de recursos necesarios
                if (this.edificionivel.verificarposibleampliacionedificio()) {
                    //Inicializar datos de edificio nivel +1;
                    this.edificionivel.buscarlistarecursosconstruccion( this.edificionivel.getNivel() + 1, this.ciudadjugador);

                    for (int i = 0; i < this.edificionivel.getEdificiorecurso().getRecurso().size(); i++) {
                        switch (this.edificionivel.getEdificiorecurso().getRecurso().get(i).getNombrerecurso()) {
                            case "Madera":
                                ventanamuralla.getLblMadera().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Marmol":
                                ventanamuralla.getLblMarmol().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Cristal":
                                ventanamuralla.getLblCristal().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                            case "Azufre":
                                ventanamuralla.getLblAzufre().setText("" + this.edificionivel.getEdificiorecurso().getCantidad().get(i).intValue());
                                break;
                        }
                    }
                    //Para activar o deasctivar el boton elevaredificionivel si el jugador tiene o no
                    //recursos suficientes en la ciudad
                    if (this.verificarrecursos()) {
                        ventanamuralla.getCmdElevarniveledificio().setEnabled(true);
                    } else {
                        ventanamuralla.getCmdElevarniveledificio().setEnabled(false);
                    }
                    ventanamuralla.getLblNivelMaximo().setVisible(true);
                } else {
                    ventanamuralla.getCmdElevarniveledificio().setEnabled(false);
                    ventanamuralla.getLblNivelMaximo().setVisible(true);
                }

                //Para actualizar el nivel en la pantalla
                ventanamuralla.getLblNivel().setText(this.edificionivel.getNivel() + "");
                if (this.edificionivel.getNivel() >= 1 && this.edificionivel.getNivel() <= 9) {
                    String asignarnivel = "0" + this.edificionivel.getNivel();
                    ventanamuralla.getLblNivel().setText(asignarnivel);

                }
                ventanamuralla.repaint();
                break;


        }
    }

    public void actualizar_interfazgrafica() {

    }

    private boolean verificarrecursos() {
        boolean control = true;

        return control;
    }

}
