/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.model.investigacion.InvestigacionJugador;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ciudad.VVerEdificiosaConstruir;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * buscaredificioshabilitados(): List<String>	INVESTIGACIONJUGADOR
 * buscaredificioreal(): String	CIUDAD
 * buscaredificiosconstruidos(): List<String>	CIUDADEDIFICIONIVEL
 * buscaredificioproduccion(): String	CIUDAD
 * buscaredificioreduccion(): String	CIUDAD
 * generarlistadeedificiosaconstruir(edificiosconstruidos: List<String>,edificioshabilitados List<String>, edificioproduccion: String, edificioreduccion: String,edificioreal: String): List<String>	CIUDADEDIFICIONIVEL
 * inicializardatosdeedificio(): void	Edificionivel
 */
public class VerEdificiosDisponible implements Actualizar {

    private Ciudad ciudadjugador;
    private VCiudad vciudad;
    private int lugarciudad;


    private VVerEdificiosaConstruir veredificiosaconstruir;

    private List<EdificioNivel> edificionivel = new ArrayList<>();

    public VerEdificiosDisponible(Ciudad ciudadjugador, VCiudad vciudad, int lugarciudad) {
        this.ciudadjugador = ciudadjugador;
        this.vciudad = vciudad;
        this.lugarciudad = lugarciudad;
        this.veredificiosaconstruir = new VVerEdificiosaConstruir(lugarciudad, edificionivel, vciudad);

    }


    @Override
    public void actualizardatospantalla() {


        if (this.lugarciudad <= 4) {
            switch (this.lugarciudad) {
                case 1:
                    veredificiosaconstruir.getCmdConstruiredificio5().setEnabled(true);
                    veredificiosaconstruir.getLblEdificio5().setEnabled(true);
                    break;
                case 2:
                    for (int i = 0; i < this.edificionivel.size(); i++) {
                        switch (this.edificionivel.get(i).getEdificio().getNombre()) {
                            case "Puerto":
                                veredificiosaconstruir.getLblEdificio9().setText(this.edificionivel.get(i).getEdificio().getNombre());
                                veredificiosaconstruir.getCmdConstruiredificio9().setEnabled(true);
                                veredificiosaconstruir.getLblEdificio9().setEnabled(true);
                                break;
                            case "Astillero de Guerra":
                                veredificiosaconstruir.getLblEdificio2().setText(this.edificionivel.get(i).getEdificio().getNombre());
                                veredificiosaconstruir.getCmdConstruiredificio2().setEnabled(true);
                                veredificiosaconstruir.getLblEdificio2().setEnabled(true);

                                break;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < this.edificionivel.size(); i++) {
                        switch (this.edificionivel.get(i).getEdificio().getNombre()) {
                            case "Puerto":
                                veredificiosaconstruir.getLblEdificio9().setText(this.edificionivel.get(i).getEdificio().getNombre());
                                veredificiosaconstruir.getCmdConstruiredificio9().setEnabled(true);
                                veredificiosaconstruir.getLblEdificio9().setEnabled(true);
                                break;
                            case "Astillero de Guerra":
                                veredificiosaconstruir.getLblEdificio2().setText(this.edificionivel.get(i).getEdificio().getNombre());
                                veredificiosaconstruir.getCmdConstruiredificio2().setEnabled(true);
                                veredificiosaconstruir.getLblEdificio2().setEnabled(true);

                                break;
                        }
                    }
                    break;

            }


        } else {


            for (int i = 0; i < this.edificionivel.size(); i++) {
                switch (this.edificionivel.get(i).getEdificio().getNombre()) {
                    case "Academia":
                        veredificiosaconstruir.getLblEdificio().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio().setEnabled(true);

                        break;
                    case "Almacen":
                        veredificiosaconstruir.getLblEdificio1().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio1().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio1().setEnabled(true);

                        break;

                    case "Cuartel":
                        veredificiosaconstruir.getLblEdificio3().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio3().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio3().setEnabled(true);

                        break;
                    case "Deposito":
                        veredificiosaconstruir.getLblEdificio4().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio4().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio4().setEnabled(true);
                        break;

                    case "Taberna":
                        veredificiosaconstruir.getLblEdificio6().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio6().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio6().setEnabled(true);
                        break;
                    case "Mercado":
                        veredificiosaconstruir.getLblEdificio7().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio7().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio7().setEnabled(true);
                        break;
                    case "Palacio":
                        veredificiosaconstruir.getLblEdificio8().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio8().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio8().setEnabled(true);
                        break;

                    case "Area de Pruebas Pirotecnicas":
                        veredificiosaconstruir.getCmdConstruiredificio14().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio14().setEnabled(true);

                        break;
                    case "Carpinteria":
                        veredificiosaconstruir.getLblEdificio11().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio11().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio11().setEnabled(true);

                        break;
                    case "Oficina del Arquitecto":
                        veredificiosaconstruir.getLblEdificio13().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio13().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio13().setEnabled(true);

                        break;
                    case "Prensa de Vino":
                        veredificiosaconstruir.getLblEdificio12().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio12().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio12().setEnabled(true);

                        break;
                    case "Optico":
                        veredificiosaconstruir.getLblEdificio15().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio15().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio15().setEnabled(true);

                        break;
                    case "Cabaña del guarda Bosque":
                        veredificiosaconstruir.getLblEdificio16().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio16().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio16().setEnabled(true);
                        break;
                    case "Cantero":
                        veredificiosaconstruir.getLblEdificio10().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio10().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio10().setEnabled(true);
                        break;
                    case "Soplador de Vidrio":
                        veredificiosaconstruir.getLblEdificio10().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio10().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio10().setEnabled(true);
                        break;
                    case "Torre del Alquimista":
                        veredificiosaconstruir.getLblEdificio10().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio10().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio10().setEnabled(true);
                        break;
                    case "Vinicultor":
                        veredificiosaconstruir.getLblEdificio10().setText(this.edificionivel.get(i).getEdificio().getNombre());
                        veredificiosaconstruir.getCmdConstruiredificio10().setEnabled(true);
                        veredificiosaconstruir.getLblEdificio10().setEnabled(true);
                        break;


                }
            }
        }


        veredificiosaconstruir.repaint();
        veredificiosaconstruir.show();


    }

    @Override
    public void actualizarinterfazgrafica() {
        String direccionimagen = "";
        ImageIcon a = null;
        for (int i = 0; i < this.edificionivel.size(); i++) {
            if (this.edificionivel.get(i).getEdificio().getNombre().equals("Palacio")) {
                direccionimagen = ("/IMAGEN/EDIFICIOS/" + this.edificionivel.get(i).getEdificio().getImagen().getDireccion() + ".png");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                veredificiosaconstruir.getLblEdificio8().setText("Palacio");
                veredificiosaconstruir.getCmdConstruiredificio8().setIcon(a);
            }
            if (this.edificionivel.get(i).getEdificio().getNombre().equals("Residencia del Gobernador")) {
                direccionimagen = ("/IMAGEN/EDIFICIOS/" + this.edificionivel.get(i).getEdificio().getImagen().getDireccion() + ".png");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                veredificiosaconstruir.getLblEdificio8().setText("Residencia del Gobernador");
                veredificiosaconstruir.getCmdConstruiredificio8().setIcon(a);
            }

            if (this.edificionivel.get(i).getEdificio().getNombre().equals("Cantero")) {
                direccionimagen = ("/IMAGEN/EDIFICIOS/" + this.edificionivel.get(i).getEdificio().getImagen().getDireccion() + ".png");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                veredificiosaconstruir.getLblEdificio10().setText("Cantero");
                veredificiosaconstruir.getCmdConstruiredificio10().setIcon(a);


            }
            if (this.edificionivel.get(i).getEdificio().getNombre().equals("Soplador de Vidrio")) {
                direccionimagen = ("/IMAGEN/EDIFICIOS/" + this.edificionivel.get(i).getEdificio().getImagen().getDireccion() + ".png");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                veredificiosaconstruir.getLblEdificio10().setText("Soplador de Vidrio");
                veredificiosaconstruir.getCmdConstruiredificio10().setIcon(a);
            }
            if (this.edificionivel.get(i).getEdificio().getNombre().equals("Torre del Alquimista")) {
                direccionimagen = ("/IMAGEN/EDIFICIOS/" + this.edificionivel.get(i).getEdificio().getImagen().getDireccion() + ".png");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                veredificiosaconstruir.getLblEdificio10().setText("Torre del Alquimista");
                veredificiosaconstruir.getCmdConstruiredificio10().setIcon(a);

            }
            if (this.edificionivel.get(i).getEdificio().getNombre().equals("Vinicultor")) {
                direccionimagen = ("/IMAGEN/EDIFICIOS/" + this.edificionivel.get(i).getEdificio().getImagen().getDireccion() + ".png");
                a = new ImageIcon(getClass().getResource(direccionimagen));
                veredificiosaconstruir.getLblEdificio10().setText("Vinicultor");
                veredificiosaconstruir.getCmdConstruiredificio10().setIcon(a);

            }
            veredificiosaconstruir.repaint();


        }

    }


    public void CUveredificiosconstruccion() {
        InvestigacionJugador investigaciondejugador = new InvestigacionJugador();
        investigaciondejugador.setJugador(this.ciudadjugador.getJugador());

        List<String> edificiosaconstruir = this.ciudadjugador.getCiudadedificios().generarlistadeedificiosaconstruir(this.ciudadjugador.getCiudadedificios().buscaredificiosconstruidos(), investigaciondejugador.buscaredificioshabilitados(), this.ciudadjugador.buscaredificioproduccion(), this.ciudadjugador.buscaredificioreal());

        for (int i = 0; i < edificiosaconstruir.size(); i++) {
            EdificioNivel edificio = new EdificioNivel();
            edificio.getEdificio().setNombre(edificiosaconstruir.get(i));
            edificio.setNivel(1);

            edificio.inicializardatosdeedificio( this.ciudadjugador);

            this.edificionivel.add(edificio);

        }
        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();
    }
}
